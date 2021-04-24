/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "tblProfile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findById", query = "SELECT p FROM Profile p WHERE p.id = :id")
    , @NamedQuery(name = "Profile.findByFolio", query = "SELECT p FROM Profile p WHERE p.folio = :folio")
    , @NamedQuery(name = "Profile.findByProfileName", query = "SELECT p FROM Profile p WHERE p.profileName = :profileName")})
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_idProfile")
    @TableGenerator(name = "generator_idProfile", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "folio", columnDefinition = "BIGINT IDENTITY", insertable = false)
    private Long folio;
    
    @Column(name = "profileName")
    private String profileName;
    
    @OneToOne(mappedBy = "idProfile", targetEntity = Employee.class, cascade = CascadeType.ALL)
    private Employee employee;

    // Contructores
    public Profile() {
    }
    
    public Profile(Long id) {
        this.id = id;
    }

    public Profile(String profileName) {
        this.profileName = profileName;
    }

    public Profile(String profileName, Employee employee) {
        this.profileName = profileName;
        this.employee = employee;
    }

    public Profile(Long id, Long folio, String profileName, Employee employee) {
        this.id = id;
        this.folio = folio;
        this.profileName = profileName;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Profile[ id=" + id + " ]";
    }
    
    public CatalogueProfile toCatalogueProfile() {
        return new CatalogueProfile(id, folio, profileName);
    }
}
