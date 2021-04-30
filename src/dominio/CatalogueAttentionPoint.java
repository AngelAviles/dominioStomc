/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "tblCatalogueAttentionPoint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogueAttentionPoint.findAll", query = "SELECT a FROM CatalogueAttentionPoint a")
    , @NamedQuery(name = "FindPoint_NotID", query = "SELECT a FROM CatalogueAttentionPoint a WHERE NOT a.id = :id AND a.point = :point")
    , @NamedQuery(name = "CatalogueAttentionPoint.findById", query = "SELECT a FROM CatalogueAttentionPoint a WHERE a.id = :id")
    , @NamedQuery(name = "CatalogueAttentionPoint.findByFolio", query = "SELECT a FROM CatalogueAttentionPoint a WHERE a.folio = :folio")
    , @NamedQuery(name = "CatalogueAttentionPoint.findByPoint", query = "SELECT a FROM CatalogueAttentionPoint a WHERE a.point = :point")})
public class CatalogueAttentionPoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_idCatalogueAttentionPoint")
    @TableGenerator(name = "generator_idCatalogueAttentionPoint", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "folio", columnDefinition = "BIGINT IDENTITY", insertable = false)
    private Long folio;
    
    @Column(name = "point")
    private String point;

    // Contructores
    public CatalogueAttentionPoint() {
    }

    public CatalogueAttentionPoint(Long id) {
        this.id = id;
    }

    public CatalogueAttentionPoint(String point) {
        this.point = point;
    }

    public CatalogueAttentionPoint(Long id, Long folio, String point) {
        this.id = id;
        this.folio = folio;
        this.point = point;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFolio() {
        return folio;
    }

    public void setFolio(Long folio) {
        this.folio = folio;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogueAttentionPoint)) {
            return false;
        }
        CatalogueAttentionPoint other = (CatalogueAttentionPoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.CatalogueAttentionPoint[ id=" + id + " ]";
    }
    
    public AttentionPoint toCatalogueAttentionPoint() {
        return new AttentionPoint(point);
    }
    
}
