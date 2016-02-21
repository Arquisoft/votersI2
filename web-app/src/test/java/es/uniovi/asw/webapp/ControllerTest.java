package es.uniovi.asw.webapp;

import org.apache.tomcat.util.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

public class ControllerTest {

    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;


    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        template = new TestRestTemplate();
    }

    @Test
    public void getUser() throws Exception {
    }
}
