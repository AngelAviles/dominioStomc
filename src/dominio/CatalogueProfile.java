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
@Table(name = "tblCatalogueProfile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogueProfile.findAll", query = "SELECT p FROM CatalogueProfile p")
    , @NamedQuery(name = "CatalogueProfile.findById", query = "SELECT p FROM CatalogueProfile p WHERE p.id = :id")
    , @NamedQuery(name = "CatalogueProfile.findByFolio", query = "SELECT p FROM CatalogueProfile p WHERE p.folio = :folio")
    , @NamedQuery(name = "CatalogueProfile.findByProfileName", query = "SELECT p FROM CatalogueProfile p WHERE p.profileName = :profileName")})
public class CatalogueProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_idCatalogueProfile")
    @TableGenerator(name = "generator_idCatalogueProfile", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "folio", columnDefinition = "BIGINT IDENTITY", insertable = false)
    private Long folio;
    
    @Column(name = "profileName")
    private String profileName;

    // Contructores
    public CatalogueProfile() {
    }
    
    public CatalogueProfile(Long id) {
        this.id = id;
    }

    public CatalogueProfile(String profileName) {
        this.profileName = profileName;
    }

    public CatalogueProfile(Long id, Long folio, String profileName) {
        this.id = id;
        this.folio = folio;
        this.profileName = profileName;
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

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
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
        if (!(object instanceof CatalogueProfile)) {
            return false;
        }
        CatalogueProfile other = (CatalogueProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.CatalogueProfile[ id=" + id + " ]";
    }
    
    public Profile toProfile() {
        return new Profile(profileName);
    }
    
}
