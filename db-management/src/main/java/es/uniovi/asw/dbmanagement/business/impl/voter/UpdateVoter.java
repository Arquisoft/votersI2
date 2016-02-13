package es.uniovi.asw.dbmanagement.business.impl.voter;

import es.uniovi.asw.dbmanagement.business.exception.BusinessException;
import es.uniovi.asw.dbmanagement.business.impl.Command;
import es.uniovi.asw.dbmanagement.domain.Voter;
import es.uniovi.asw.dbmanagement.persistence.util.Jpa;

public class UpdateVoter implements Command<Voter> {
    private Voter voter;

    public UpdateVoter(Voter voter) {
        this.voter = voter;
    }

    @Override
    public Voter execute() throws BusinessException {
        try {
            return Jpa.getManager().merge(voter);
        } catch (Exception e) {
            throw new BusinessException();
        }
    }
}
