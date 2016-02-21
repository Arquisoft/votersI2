package es.uniovi.asw.voteraccess.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model used to pass the login and password to the get user function
 */
public class VoterRequestGet {

    private String login;
    private String password;

    public VoterRequestGet()
    {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
