/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "tblEmployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByFolio", query = "SELECT e FROM Employee e WHERE e.folio = :folio")
    , @NamedQuery(name = "Employee.findByNoEmployee", query = "SELECT e FROM Employee e WHERE e.noEmployee = :noEmployee")
    , @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name")
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address")
    , @NamedQuery(name = "Employee.findByDepartment", query = "SELECT e FROM Employee e WHERE e.department = :department")})
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "folio")
    private Long folio;
    
    @Column(name = "noEmployee")
    private Long noEmployee;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "department")
    private String department;
    
    @OneToOne(mappedBy = "idEmployee", targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;
    
    @JoinColumn(name = "idAttentionPoint", referencedColumnName = "id")
    @ManyToOne
    private AttentionPoint idAttentionPoint;
    
    @JoinColumn(name = "idBranch", referencedColumnName = "id")
    @ManyToOne
    private Branch idBranch;

    // Constructores
    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }

    public Employee(Long id, Long folio, Long noEmployee, String name, String address, String department, User user, AttentionPoint idAttentionPoint, Branch idBranch) {
        this.id = id;
        this.folio = folio;
        this.noEmployee = noEmployee;
        this.name = name;
        this.address = address;
        this.department = department;
        this.user = user;
        this.idAttentionPoint = idAttentionPoint;
        this.idBranch = idBranch;
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

    public Long getNoEmployee() {
        return noEmployee;
    }

    public void setNoEmployee(Long noEmployee) {
        this.noEmployee = noEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AttentionPoint getIdAttentionPoint() {
        return idAttentionPoint;
    }

    public void setIdAttentionPoint(AttentionPoint idAttentionPoint) {
        this.idAttentionPoint = idAttentionPoint;
    }

    public Branch getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Branch idBranch) {
        this.idBranch = idBranch;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Employee[ id=" + id + " ]";
    }
    
}
