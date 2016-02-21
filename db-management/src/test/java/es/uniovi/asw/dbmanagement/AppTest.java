package es.uniovi.asw.dbmanagement;

import es.uniovi.asw.dbmanagement.business.VoterService;
import es.uniovi.asw.dbmanagement.business.exception.VoterNotFoundException;
import es.uniovi.asw.dbmanagement.domain.Voter;
import es.uniovi.asw.dbmanagement.infrastructure.ServicesFactory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testRetrieve() {
        String email = "test@test.es";
        String password = "test";
        Voter voter = new Voter("Test", "71866423B", email);
        voter.setPassword(password);

        VoterService vs = ServicesFactory.createVoterService();
        vs.updateVoter(voter);

        assertEquals(voter, vs.getVoter(email, password));

        vs.deleteVoter(voter);
    }

    @Test
    public void testUpdatePassword() {
        String email = "test@test.es";
        String password = "old";
        Voter voter = new Voter("Test", "71866423B", email);
        voter.setPassword(password);

        VoterService vs = ServicesFactory.createVoterService();
        vs.updateVoter(voter);

        assertEquals(voter, vs.getVoter(email, password));

        String newPassword = "new";
        vs.updatePassword(voter, newPassword);

        assertEquals(voter, vs.getVoter(email, newPassword));

        vs.deleteVoter(voter);
    }

    @Test(expected = VoterNotFoundException.class)
    public void testNotFound() throws Exception {
        VoterService vs = ServicesFactory.createVoterService();
        vs.getVoter("thisemaildoesnotexist@never.org", "thispassneither");
    }
}
