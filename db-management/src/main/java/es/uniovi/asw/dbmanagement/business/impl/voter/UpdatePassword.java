package es.uniovi.asw.dbmanagement.business.impl.voter;

import es.uniovi.asw.dbmanagement.business.exception.BusinessException;
import es.uniovi.asw.dbmanagement.business.exception.VoterNotFoundException;
import es.uniovi.asw.dbmanagement.business.impl.Command;
import es.uniovi.asw.dbmanagement.domain.Voter;
import es.uniovi.asw.dbmanagement.persistence.VoterFinder;
import es.uniovi.asw.dbmanagement.persistence.util.Jpa;

import javax.persistence.NoResultException;

public class UpdatePassword implements Command<Voter> {
    private Voter voter;
    private String password;

    public UpdatePassword(Voter voter, String password) {
        this.voter = voter;
        this.password = password;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            voter = VoterFinder.findByEmail(voter.getEmail());
            voter.setPassword(password);
            return Jpa.getManager().merge(voter);
        } catch (NoResultException e) {
            throw new VoterNotFoundException();
        }
    }
}
