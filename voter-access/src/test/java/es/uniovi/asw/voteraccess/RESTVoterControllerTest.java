package es.uniovi.asw.voteraccess;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import es.uniovi.asw.dbmanagement.business.VoterService;
import es.uniovi.asw.dbmanagement.domain.Voter;
import es.uniovi.asw.dbmanagement.infrastructure.ServicesFactory;
import es.uniovi.asw.voteraccess.model.VoterRequestChangePassword;
import es.uniovi.asw.voteraccess.model.VoterRequestGet;
import org.apache.tomcat.util.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RESTVoterControllerTest {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    private Voter voter;

    private URL base;
    //private RestTemplate template;


    @Before
    public void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        this.base = new URL("http://localhost:" + port + "/rest"); //algo raro pasa con el port asi que pongo 8080 a mano
        //template = new TestRestTemplate();
        setUpDB();
    }

    @After
    public void cleanup() throws Exception {
        VoterService vs = ServicesFactory.createVoterService();
        vs.deleteVoter(voter);
    }

    private void setUpDB() {
        String email = "test@test.es";
        String password = "test";
        voter = new Voter("Test", "11111111A", email);
        voter.setPassword(password);

        VoterService vs = ServicesFactory.createVoterService();
        vs.updateVoter(voter);
    }

    @Test
    public void getExistingUser() throws Exception {
        VoterRequestGet voterRequestGet = new VoterRequestGet();
        voterRequestGet.setLogin("test@test.es");
        voterRequestGet.setPassword("test");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(voterRequestGet);

        mvc.perform(post("http://localhost:8080/rest/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk());
    }

    @Test
    public void getWrongUser() throws Exception {
        VoterRequestGet voterRequestGet = new VoterRequestGet();
        voterRequestGet.setLogin("test@test.es");
        voterRequestGet.setPassword("wrongPassword");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(voterRequestGet);

        mvc.perform(post("http://localhost:8080/rest/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword() throws Exception {
        //change password
        VoterRequestChangePassword voterRequestChangePassword = new VoterRequestChangePassword();
        voterRequestChangePassword.setLogin("test@test.es");
        voterRequestChangePassword.setOldPassword("test");
        voterRequestChangePassword.setNewPassword("changedpassword");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(voterRequestChangePassword);

        mvc.perform(post("http://localhost:8080/rest/changepassword").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk());

        //check that new password works properly
        VoterRequestGet voterRequestGet = new VoterRequestGet();
        voterRequestGet.setLogin("test@test.es");
        voterRequestGet.setPassword("changedpassword");
        requestJson=ow.writeValueAsString(voterRequestGet);
        mvc.perform(post("http://localhost:8080/rest/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk());

        //check that old password does not work
        voterRequestGet.setPassword("test"); //previous password
        requestJson=ow.writeValueAsString(voterRequestGet);

        mvc.perform(post("http://localhost:8080/rest/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().is4xxClientError());
    }

    @Test
    public void wrongChangePassword() throws Exception {
        //try to change password giving a wrong old password
        VoterRequestChangePassword voterRequestChangePassword = new VoterRequestChangePassword();
        voterRequestChangePassword.setLogin("test@test.es");
        voterRequestChangePassword.setOldPassword("wrongpassword");
        voterRequestChangePassword.setNewPassword("changedpassword");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(voterRequestChangePassword);

        mvc.perform(post("http://localhost:8080/rest/changepassword").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().is4xxClientError());

        //check that new password does not work
        VoterRequestGet voterRequestGet = new VoterRequestGet();
        voterRequestGet.setLogin("test@test.es");
        voterRequestGet.setPassword("changedpassword");
        requestJson=ow.writeValueAsString(voterRequestGet);
        mvc.perform(post("http://localhost:8080/rest/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().is4xxClientError());

        //check that old password works
        voterRequestGet.setPassword("test"); //previous password
        requestJson=ow.writeValueAsString(voterRequestGet);

        mvc.perform(post("http://localhost:8080/rest/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk());
    }
}
