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
@Table(name = "tblAttentionPoint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttentionPoint.findAll", query = "SELECT a FROM AttentionPoint a")
    , @NamedQuery(name = "AttentionPoint.findById", query = "SELECT a FROM AttentionPoint a WHERE a.id = :id")
    , @NamedQuery(name = "AttentionPoint.findByFolio", query = "SELECT a FROM AttentionPoint a WHERE a.folio = :folio")
    , @NamedQuery(name = "AttentionPoint.findByPoint", query = "SELECT a FROM AttentionPoint a WHERE a.point = :point")})
public class AttentionPoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_idAttentionPoint")
    @TableGenerator(name = "generator_idAttentionPoint", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "folio", columnDefinition = "BIGINT IDENTITY", insertable = false)
    private Long folio;
    
    @Column(name = "point")
    private String point;
    
    @OneToOne(mappedBy = "idAttentionPoint", targetEntity = Employee.class, cascade = CascadeType.ALL)
    private Employee employee;

    // Contructores
    public AttentionPoint() {
    }

    public AttentionPoint(Long id) {
        this.id = id;
    }

    public AttentionPoint(String point) {
        this.point = point;
    }

    public AttentionPoint(String point, Employee employee) {
        this.point = point;
        this.employee = employee;
    }

    public AttentionPoint(Long id, Long folio, String point, Employee employeeList) {
        this.id = id;
        this.folio = folio;
        this.point = point;
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

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
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
    
    public CatalogueAttentionPoint toAttentionPoint() {
        return new CatalogueAttentionPoint(id, folio, point);
    }
}
