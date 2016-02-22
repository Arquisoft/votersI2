package es.uniovi.asw.voteraccess.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model used to pass the login, oldpassword and new password to the changepassword function
 */

@XmlRootElement(name = "/user")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoterRequestChangePassword {

    @XmlElement
    private String login;
    @XmlElement
    private String oldPassword;
    @XmlElement
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
