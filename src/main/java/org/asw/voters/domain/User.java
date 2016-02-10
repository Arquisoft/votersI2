package org.asw.voters.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	
	private static final Logger log = LoggerFactory.getLogger(User.class);

    private final String name;
    private final String nif;
    private final String email;
    private final String pollingStationCode;


    public User(String email) {
    	log.info("Obtaining user with email" + email);
        this.name = "Random";
        this.nif = "71866139A";
        this.email = email;
        this.pollingStationCode = "31323";
    }

    public String getName() {
        return name;
    }

    public String getNif() {
        return nif;
    }

    public String getEmail() {
        return email;
    }

    public String getPollingStationCode() {
        return pollingStationCode;
    }
}