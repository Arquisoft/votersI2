package es.uniovi.asw.voteraccess.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by Fabio on 20/02/2016.
 */
public class VoterRequestChangePassword {

    private String login;
    private String oldPassword;
    private String newPassword;

    public VoterRequestChangePassword()
    {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



}