package dominio;

import java.io.Serializable;
import java.util.Objects;

public class Profile implements Serializable {
    private long id;
    private long folio;
    private String profileName;

    public Profile() {
    }

    public Profile(long id) {
        this.id = id;
    }

    public Profile(long id, long folio, String profileName) {
        this.id = id;
        this.folio = folio;
        this.profileName = profileName;
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

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return folio == profile.folio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", folio=" + folio +
                ", profileName='" + profileName + '\'' +
                '}';
    }
}
