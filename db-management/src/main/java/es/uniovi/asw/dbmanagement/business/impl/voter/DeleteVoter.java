package es.uniovi.asw.dbmanagement.business.impl.voter;

import es.uniovi.asw.dbmanagement.business.exception.BusinessException;
import es.uniovi.asw.dbmanagement.business.exception.VoterNotFoundException;
import es.uniovi.asw.dbmanagement.business.impl.Command;
import es.uniovi.asw.dbmanagement.domain.Voter;
import es.uniovi.asw.dbmanagement.persistence.VoterFinder;
import es.uniovi.asw.dbmanagement.persistence.util.Jpa;

import javax.persistence.NoResultException;

public class DeleteVoter implements Command<Voter> {
    private Voter voter;

    public DeleteVoter(Voter voter) {
        this.voter = voter;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            Jpa.getManager().remove(VoterFinder.findByEmail(voter.getEmail()));
            return voter;
        } catch (NoResultException e) {
            throw new VoterNotFoundException();
        }
    }
}
