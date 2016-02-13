package es.uniovi.asw.dbmanagement.infrastructure;

import es.uniovi.asw.dbmanagement.business.VoterService;
import es.uniovi.asw.dbmanagement.business.impl.VoterServiceImpl;

public class ServicesFactory {

    public static VoterService createVoterService() {
        return new VoterServiceImpl();
    }
}
