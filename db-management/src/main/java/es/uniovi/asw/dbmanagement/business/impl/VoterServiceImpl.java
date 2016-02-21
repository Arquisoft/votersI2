package es.uniovi.asw.dbmanagement.business.impl;

import es.uniovi.asw.dbmanagement.business.VoterService;
import es.uniovi.asw.dbmanagement.business.exception.VoterNotFoundException;
import es.uniovi.asw.dbmanagement.business.impl.voter.DeleteVoter;
import es.uniovi.asw.dbmanagement.business.impl.voter.GetVoter;
import es.uniovi.asw.dbmanagement.business.impl.voter.UpdatePassword;
import es.uniovi.asw.dbmanagement.business.impl.voter.UpdateVoter;
import es.uniovi.asw.dbmanagement.domain.Voter;

public class VoterServiceImpl implements VoterService {
    @Override
    public Voter getVoter(String email, String password)
            throws VoterNotFoundException {
        return CommandExecutor.execute(new GetVoter(email, password));
    }

    @Override
    public Voter updatePassword(Voter voter, String password) {
        return CommandExecutor.execute(new UpdatePassword(voter, password));
    }

    @Override
    public Voter updateVoter(Voter voter) {
        return CommandExecutor.execute(new UpdateVoter(voter));
    }

    @Override
    public Voter deleteVoter(Voter voter) {
        return CommandExecutor.execute(new DeleteVoter(voter));
    }
}
