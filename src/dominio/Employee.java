/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    , @NamedQuery(name = "Employee.findByDepartment", query = "SELECT e FROM Employee e WHERE e.department = :department")
    , @NamedQuery(name = "Employee.findByAccount", query = "SELECT e FROM Employee e WHERE e.account = :account")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.comprobarValoresUnicos", query = "SELECT e FROM Employee e WHERE e.noEmployee = :noEmployee OR e.account = :account")
    , @NamedQuery(name = "findAccount_NotId", query = "SELECT e FROM Employee e WHERE NOT e.id = :id AND e.account = :account")
    , @NamedQuery(name = "Employee.login", query = "SELECT e FROM Employee e WHERE e.account = :account AND e.password = :password")})
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_idEmployee")
    @TableGenerator(name = "generator_idEmployee", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "folio", columnDefinition = "BIGINT IDENTITY", insertable = false)
    private Long folio;

    @Column(name = "noEmployee", columnDefinition = "BIGINT")
    private Long noEmployee;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "department")
    private String department;

    @JoinColumn(name = "idAttentionPoint", referencedColumnName = "id", columnDefinition = "BIGINT")
    @OneToOne
    private AttentionPoint idAttentionPoint;

    @JoinColumn(name = "idBranch", referencedColumnName = "id", columnDefinition = "BIGINT")
    @OneToOne
    private Branch idBranch;

    // Informacion de cuenta de usuario
    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @JoinColumn(name = "idProfile", referencedColumnName = "id", columnDefinition = "BIGINT")
    @OneToOne
    private Profile idProfile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmployee")
    private List<Turn> turnList;

    // Constructores
    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }

    public Employee(Long noEmployee, String name, String address, String department, AttentionPoint idAttentionPoint, Branch idBranch, String account, String password, Profile idProfile, List<Turn> turnList) {
        this.noEmployee = noEmployee;
        this.name = name;
        this.address = address;
        this.department = department;
        this.idAttentionPoint = idAttentionPoint;
        this.idBranch = idBranch;
        this.account = account;
        this.password = password;
        this.idProfile = idProfile;
        this.turnList = turnList;
    }

    public Employee(Long id, Long folio, Long noEmployee, String name, String address, String department, AttentionPoint idAttentionPoint, Branch idBranch, String account, String password, Profile idProfile, List<Turn> turnList) {
        this.id = id;
        this.folio = folio;
        this.noEmployee = noEmployee;
        this.name = name;
        this.address = address;
        this.department = department;
        this.idAttentionPoint = idAttentionPoint;
        this.idBranch = idBranch;
        this.account = account;
        this.password = password;
        this.idProfile = idProfile;
        this.turnList = turnList;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Profile idProfile) {
        this.idProfile = idProfile;
    }

    @XmlTransient
    public List<Turn> getTurnList() {
        return turnList;
    }

    public void setTurnList(List<Turn> turnList) {
        this.turnList = turnList;
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
