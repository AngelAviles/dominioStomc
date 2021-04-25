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
@Table(name = "tblCatalogueBranch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogueBranch.findAll", query = "SELECT b FROM CatalogueBranch b")
    , @NamedQuery(name = "CatalogueBranch.findById", query = "SELECT b FROM CatalogueBranch b WHERE b.id = :id")
    , @NamedQuery(name = "CatalogueBranch.findByFolio", query = "SELECT b FROM CatalogueBranch b WHERE b.folio = :folio")
    , @NamedQuery(name = "CatalogueBranch.findByBranchName", query = "SELECT b FROM CatalogueBranch b WHERE b.branchName = :branchName")})
public class CatalogueBranch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_idCatalogueBranch")
    @TableGenerator(name = "generator_idCatalogueBranch", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "folio", columnDefinition = "BIGINT IDENTITY", insertable = false)
    private Long folio;
    
    @Column(name = "branchName")
    private String branchName;

    // Contructores
    public CatalogueBranch() {
    }

    public CatalogueBranch(Long id) {
        this.id = id;
    }

    public CatalogueBranch(String branchName) {
        this.branchName = branchName;
    }

    public CatalogueBranch(Long id, Long folio, String branchName) {
        this.id = id;
        this.folio = folio;
        this.branchName = branchName;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogueBranch)) {
            return false;
        }
        CatalogueBranch other = (CatalogueBranch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.CatalogueBranch[ id=" + id + " ]";
    }
    
    public Branch toCatalogueBranch() {
        return new Branch(branchName);
    }
    
}