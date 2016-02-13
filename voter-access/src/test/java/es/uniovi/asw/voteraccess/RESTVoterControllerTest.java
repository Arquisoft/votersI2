package es.uniovi.asw.voteraccess;

import org.apache.tomcat.util.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

public class RESTVoterControllerTest {

    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;


    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/rest");
        template = new TestRestTemplate();
    }

    @Test
    public void getUser() throws Exception {
    }
}