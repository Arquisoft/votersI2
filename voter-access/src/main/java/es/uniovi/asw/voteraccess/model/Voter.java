package es.uniovi.asw.voteraccess.model;

public class Voter {
    private es.uniovi.asw.dbmanagement.domain.Voter voter = null;

    public Voter(es.uniovi.asw.dbmanagement.domain.Voter voter) {
        this.voter = voter;
    }

    public String getName() {
        return voter.getName();
    }

    public void setName(String name) {
        voter.setName(name);
    }

    public String getNif() {
        return voter.getNif();
    }

    public void setNif(String nif) {
        voter.setNif(nif);
    }

    public String getEmail() {
        return voter.getEmail();
    }

    public void setEmail(String email) {
        voter.setName(email);
    }

    public String getPollingStationCode() {
        return voter.getPollingStationCode();
    }

    public void setPollingStationCode(String pollingStationCode) {
        voter.setPollingStationCode(pollingStationCode);
    }

    public String getPassword() {
        return voter.getPassword();
    }

    public void setPassword(String password) {
        voter.setPassword(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voter localVoter = (Voter) o;

        return voter.getNif().equals(localVoter.getNif());
    }

    @Override
    public int hashCode() {
        return voter.getNif().hashCode();
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + voter.getId() +
                ", name='" + voter.getName() + '\'' +
                ", nif='" + voter.getNif() + '\'' +
                ", email='" + voter.getEmail() + '\'' +
                ", pollingStationCode='" + voter.getPollingStationCode() + '\'' +
                ", password='" + voter.getPassword() + '\'' +
                '}';
    }
}
