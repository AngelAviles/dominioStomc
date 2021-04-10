/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "tblAttentionPoint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttentionPoint.findAll", query = "SELECT a FROM AttentionPoint a")
    , @NamedQuery(name = "AttentionPoint.findById", query = "SELECT a FROM AttentionPoint a WHERE a.id = :id")
    , @NamedQuery(name = "AttentionPoint.findByFolio", query = "SELECT a FROM AttentionPoint a WHERE a.folio = :folio")
    , @NamedQuery(name = "AttentionPoint.findByPoint", query = "SELECT a FROM AttentionPoint a WHERE a.point = :point")})
public class AttentionPoint implements Serializable {

    @Basic(optional = false)
    @Column(name = "folio")
    private long folio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    
    @Column(name = "point")
    private String point;
    
    @OneToMany(mappedBy = "idAttentionPoint")
    private List<Employee> employeeList;

    // Contructores
    public AttentionPoint() {
    }

    public AttentionPoint(Long id) {
        this.id = id;
    }

    public AttentionPoint(Long id, Long folio, String point, List<Employee> employeeList) {
        this.id = id;
        this.folio = folio;
        this.point = point;
        this.employeeList = employeeList;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
        if (!(object instanceof AttentionPoint)) {
            return false;
        }
        AttentionPoint other = (AttentionPoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.AttentionPoint[ id=" + id + " ]";
    }

    public long getFolio() {
        return folio;
    }

    public void setFolio(long folio) {
        this.folio = folio;
    }
    
}
