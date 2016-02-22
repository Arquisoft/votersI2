package es.uniovi.asw.voteraccess.service.voter.impl;

import es.uniovi.asw.dbmanagement.infrastructure.ServicesFactory;
import es.uniovi.asw.voteraccess.model.Voter;
import es.uniovi.asw.voteraccess.service.exception.VoterNotFoundException;
import es.uniovi.asw.voteraccess.service.voter.VoterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("voterService")
@Transactional
public class VoterServiceImpl implements VoterService {
    @Override
    public Voter findByEmailAndPassword(String email, String password) {
        try {
            return new Voter(ServicesFactory
                    .createVoterService()
                    .getVoter(email, password));
        } catch (es.uniovi.asw.dbmanagement.business
                .exception.VoterNotFoundException e) {
            throw new VoterNotFoundException();
        }
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        Voter voter = findByEmailAndPassword(email, oldPassword);
        voter.changePassword(newPassword);
    }

    @Override
    public Voter updateVoter(Voter voter) {
        return new Voter(ServicesFactory
                .createVoterService()
                .updateVoter(voter.getBaseVoter()));
    }

    @Override
    public Voter deleteVoter(Voter voter) {
        voter = findByEmailAndPassword(voter.getEmail(), voter.getPassword());
        ServicesFactory.createVoterService().deleteVoter(voter.getBaseVoter());
        return voter;
    }
}
