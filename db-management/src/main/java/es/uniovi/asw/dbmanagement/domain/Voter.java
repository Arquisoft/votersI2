package es.uniovi.asw.dbmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class Voter implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Column(unique = true, length = 9, nullable = false)
    private String nif;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "polling_station_code")
    private String pollingStationCode;
    private String password;

    public Voter() {
    }

    public Voter(String name, String nif, String email) {
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.pollingStationCode = "31323";
        this.password = "plain";
    }

    public long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPollingStationCode() {
        return pollingStationCode;
    }

    public void setPollingStationCode(String pollingStationCode) {
        this.pollingStationCode = pollingStationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voter voter = (Voter) o;

        return nif.equals(voter.nif);
    }

    @Override
    public int hashCode() {
        return nif.hashCode();
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                ", pollingStationCode='" + pollingStationCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
