package es.uniovi.asw.voteraccess.model;

import es.uniovi.asw.dbmanagement.business.VoterService;
import es.uniovi.asw.dbmanagement.infrastructure.ServicesFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "voter")
@XmlAccessorType(XmlAccessType.FIELD)
public class Voter {

    @XmlElement
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

    public void changePassword(String newPassword){
        VoterService v = ServicesFactory.createVoterService();
        v.updatePassword(voter,newPassword);
    }

    public es.uniovi.asw.dbmanagement.domain.Voter getBaseVoter() {
        return voter;
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
