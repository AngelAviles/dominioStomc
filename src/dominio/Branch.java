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
@Table(name = "tblBranch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b")
    , @NamedQuery(name = "Branch.findById", query = "SELECT b FROM Branch b WHERE b.id = :id")
    , @NamedQuery(name = "Branch.findByFolio", query = "SELECT b FROM Branch b WHERE b.folio = :folio")
    , @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName")})
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_idBranch")
    @TableGenerator(name = "generator_idBranch", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "folio", columnDefinition = "BIGINT IDENTITY", insertable = false)
    private Long folio;
    
    @Column(name = "branchName")
    private String branchName;
    
    @OneToOne(mappedBy = "idBranch", targetEntity = Employee.class, cascade = CascadeType.ALL)
    private Employee employee;

    // Contructores
    public Branch() {
    }

    public Branch(Long id) {
        this.id = id;
    }

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public Branch(String branchName, Employee employee) {
        this.branchName = branchName;
        this.employee = employee;
    }

    public Branch(Long id, Long folio, String branchName, Employee employee) {
        this.id = id;
        this.folio = folio;
        this.branchName = branchName;
        this.employee = employee;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Branch[ id=" + id + " ]";
    }
    
    public CatalogueBranch toCatalogueBranch() {
        return new CatalogueBranch(id, folio, branchName);
    }
    
}
