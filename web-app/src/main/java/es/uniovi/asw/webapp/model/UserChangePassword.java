package es.uniovi.asw.webapp.model;

public class UserChangePassword {
    private String login;
    private String newPassword;
    private String oldPassword;

    public UserChangePassword(){

    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String old_password) {
        this.oldPassword = old_password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String new_password) {
        this.newPassword = new_password;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}