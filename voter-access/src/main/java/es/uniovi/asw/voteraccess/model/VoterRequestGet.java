package es.uniovi.asw.voteraccess.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Fabio on 20/02/2016.
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
