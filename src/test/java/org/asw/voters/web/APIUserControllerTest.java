package org.asw.voters.web;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.asw.voters.Application;
import org.asw.voters.domain.User;
import org.asw.voters.service.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class APIUserControllerTest {

    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/rest");
        template = new TestRestTemplate();
    }

    @Test
    public void getUser() throws Exception {
        String email = "example@example.org";
        User expected = new User("Frank", "71869923B", email);
        userRepository.save(expected);

        String userURI = base.toString() + "/user";
        MultiValueMap<String, Object> data = new LinkedMultiValueMap<>();
        data.add("email", email);
        data.add("password", "pass");

        ResponseEntity<String> response = template.postForEntity(userURI,
                                                                 data,
                                                                 String.class);
    }

}