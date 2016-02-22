package es.uniovi.asw.webapp.service.voter;

import es.uniovi.asw.webapp.model.VoterDTO;

public interface VoterService {
    VoterDTO find(VoterDTO voter);
    VoterDTO changePassword(VoterDTO voter);
}
