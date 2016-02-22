package es.uniovi.asw.webapp.model;

public class VoterDTO {

    private String email;
    private String name;
    private String password;
    private String newPassword = null;
    private String nif;
    private String pollingStationCode;

    public VoterDTO() {
    }

    public VoterDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public VoterDTO(String email, String oldPassword, String newPassword) {
        this.email = email;
        this.password = oldPassword;
        this.newPassword = newPassword;
    }

    public VoterDTO(String email,
                    String name,
                    String password,
                    String nif,
                    String pollingStationCode) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nif = nif;
        this.pollingStationCode = pollingStationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPollingStationCode() {
        return pollingStationCode;
    }

    public void setPollingStationCode(String pollingStationCode) {
        this.pollingStationCode = pollingStationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getLogin() {
        return getEmail();
    }

    public void setLogin(String login) {
        setEmail(login);
    }

    public String getOldPassword() {
        return getPassword();
    }

    public void setOldPassword(String oldPassword) {
        setPassword(oldPassword);
    }
}
