package es.uniovi.asw.dbmanagement.business;

import es.uniovi.asw.dbmanagement.business.exception.VoterNotFoundException;
import es.uniovi.asw.dbmanagement.domain.Voter;

public interface VoterService {

    Voter getVoter(String email, String password) throws VoterNotFoundException;

    Voter updatePassword(Voter voter, String password);

    Voter updateVoter(Voter voter);

    Voter deleteVoter(Voter voter);
}
