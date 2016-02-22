package es.uniovi.asw.webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ControllerTest {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    /*
        @Before
        public void setUp() throws Exception {
            this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
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
             voter = new Voter("Test", "71866423B", email);
             voter.setPassword(password);

             VoterService vs = ServicesFactory.createVoterService();
             vs.updateVoter(voter);
        }

        @Test
        public void getHome() throws Exception {
            mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().node(hasXPath("boolean(//div)", equalTo("false")))) //Error message is not shown
                .andExpect(content().node(hasXPath("//input[@id='id_usuario']")));
        }

        @Test
        public void getVoter() throws Exception {
             mvc.perform(post("/user")
                     .param("id", "test@test.es")
                     .param("password", "test"))
                 .andExpect(status().isOk())
                 .andExpect(content().node(hasXPath("//h3/text()", equalTo("Number: 31323"))));
        }

        @Test
        public void getWrongVoterRedirection() throws Exception {
             mvc.perform(post("/user")
                     .param("id", "test@test.es")
                     .param("password", "wrongPass"))
                 .andExpect(status().is3xxRedirection())
                 .andExpect(redirectedUrl("/?error=notFound"));
        }

        @Test
        public void getErrorHome() throws Exception {
            mvc.perform(get("/?error=notFound"))
                .andExpect(status().isOk())
                .andExpect(content().node(hasXPath("boolean(//div)", equalTo("true")))); //Error message is shown
        }

        @Test
        public void getWrongPassword() throws Exception {
            mvc.perform(post("/changePassword")
                    .param("login", "test@test.es")
                    .param("oldPassword", "wrongPass")
                    .param("newPassword", "newPass"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/changePassword?error=notFound"));
        }

        @Test
        public void getWrongUser() throws Exception {
            mvc.perform(post("/changePassword")
                    .param("login", "testinmalo@test.es")
                    .param("oldPassword", "test")
                    .param("newPassword", "newPass"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/changePassword?error=notFound"));
        }

        public void getCorrectPassword() throws Exception {
            mvc.perform(post("/changePassword")
                    .param("login", "test@test.es")
                    .param("oldPassword", "test")
                    .param("newPassword", "newPass"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/changePassword?success=true"));
        }
    */

    @Test
    public void testNothing() {

    }

}
