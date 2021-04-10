package dominio;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private long id;
    private long folio;
    private String account;
    private Profile profile;
    private long idProfile;
    private Employee employee;
    private long idEmployee;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(long id, long folio, String account, Profile profile, long idProfile, Employee employee, long idEmployee) {
        this.id = id;
        this.folio = folio;
        this.account = account;
        this.profile = profile;
        this.idProfile = idProfile;
        this.employee = employee;
        this.idEmployee = idEmployee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFolio() {
        return folio;
    }

    public void setFolio(long folio) {
        this.folio = folio;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(long idProfile) {
        this.idProfile = idProfile;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return folio == user.folio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", folio=" + folio +
                ", account='" + account + '\'' +
                ", profile=" + profile +
                ", idProfile=" + idProfile +
                ", employee=" + employee +
                ", idEmployee=" + idEmployee +
                '}';
    }
}
