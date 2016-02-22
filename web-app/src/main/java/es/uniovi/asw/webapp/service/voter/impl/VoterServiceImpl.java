package es.uniovi.asw.webapp.service.voter.impl;

import es.uniovi.asw.webapp.model.VoterDTO;
import es.uniovi.asw.webapp.service.exception.VoterNotFoundException;
import es.uniovi.asw.webapp.service.voter.VoterService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service("voterService")
public class VoterServiceImpl implements VoterService {

    @Override
    public VoterDTO find(VoterDTO voter) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String uri = "http://localhost:8080/rest/user";
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
            String uri = "http://localhost:8080/rest/changePassword";
            voter = restTemplate.postForObject(uri, voter, VoterDTO.class);
        } catch (HttpClientErrorException e) {
            throw new VoterNotFoundException();
        }
        return voter;
    }
}
