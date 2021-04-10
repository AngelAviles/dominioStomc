package dominio;

import java.io.Serializable;
import java.util.Objects;

public class Branch implements Serializable {
    private long id;
    private long folio;
    private String branchName;

    public Branch() {
    }

    public Branch(long id) {
        this.id = id;
    }

    public Branch(long id, long folio, String branchName) {
        this.id = id;
        this.folio = folio;
        this.branchName = branchName;
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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return folio == branch.folio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", folio=" + folio +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
