package es.uniovi.asw.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Transient
    private static final Logger log = LoggerFactory.getLogger(User.class);
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String name;
    @NotNull
    @Column(unique = true, length = 9)
    private String nif;
    @NotNull
    @Column(unique = true)
    private String email;
    private String pollingStationCode;
    private String password;

    public User() {
    }

    public User(String name, String nif, String email) {
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.pollingStationCode = "31323";
        this.password = "plain";
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

        User user = (User) o;

        return nif.equals(user.nif);
    }

    @Override
    public int hashCode() {
        return nif.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                ", pollingStationCode='" + pollingStationCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}