package es.uniovi.asw.voteraccess.service.voter;

import es.uniovi.asw.voteraccess.model.Voter;

public interface VoterService {

    Voter findByEmailAndPassword(String email, String password);
    void changePassword(String email, String oldPassword, String newPassword);
    Voter updateVoter(Voter voter);
}
