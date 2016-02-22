package es.uniovi.asw.webapp.service.voter.impl;

import es.uniovi.asw.webapp.model.VoterDTO;
import es.uniovi.asw.webapp.service.exception.VoterNotFoundException;
import es.uniovi.asw.webapp.service.voter.VoterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Service("voterService")
public class VoterServiceImpl implements VoterService {

    @Value("${voters.api}")
    private String API;

    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = (hostname, session) -> true;

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    @Override
    public VoterDTO find(VoterDTO voter) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String uri = API + "/user";
            voter = restTemplate.postForObject(uri, voter, VoterDTO.class);
        } catch (HttpClientErrorException e) {
            throw new VoterNotFoundException();
        }
        return voter;
    }

    @Override
    public VoterDTO changePassword(VoterDTO voter) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String uri = API + "/changePassword";
            voter = restTemplate.postForObject(uri, voter, VoterDTO.class);
        } catch (HttpClientErrorException e) {
            throw new VoterNotFoundException();
        }
        return voter;
    }
}
