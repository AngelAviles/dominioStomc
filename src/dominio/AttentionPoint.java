package dominio;

import java.io.Serializable;
import java.util.Objects;

public class AttentionPoint implements Serializable {
    private long id;
    private long folio;
    private String point;

    public AttentionPoint() {
    }

    public AttentionPoint(long id) {
        this.id = id;
    }

    public AttentionPoint(long id, long folio, String point) {
        this.id = id;
        this.folio = folio;
        this.point = point;
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

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttentionPoint)) return false;
        AttentionPoint that = (AttentionPoint) o;
        return folio == that.folio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }

    @Override
    public String toString() {
        return "AttentionPoint{" +
                "id=" + id +
                ", folio=" + folio +
                ", point='" + point + '\'' +
                '}';
    }
}
