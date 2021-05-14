/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author angel
 */
@Entity
@Table(name = "tblTurn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turn.findAll", query = "SELECT t FROM Turn t")
    , @NamedQuery(name = "Query_EntreFechasYEstado", query = "SELECT t FROM Turn t WHERE t.dateTimeCreated BETWEEN :fechaInicio AND :fechaFin AND t.status = :status")
    , @NamedQuery(name = "Query_FechaInicioYEstado", query = "SELECT t FROM Turn t WHERE t.dateTimeCreated >= :fechaInicio AND t.status = :status")
    , @NamedQuery(name = "Query_FechaFinYEstado", query = "SELECT t FROM Turn t WHERE t.dateTimeCreated <= :fechaFin AND t.status = :status")
    , @NamedQuery(name = "Query_FechaInicio", query = "SELECT t FROM Turn t WHERE t.dateTimeCreated >= :fechaInicio")
    , @NamedQuery(name = "Query_FechaFin", query = "SELECT t FROM Turn t WHERE t.dateTimeCreated <= :fechaFin")
    , @NamedQuery(name = "Turn.findByIdEmployee", query = "SELECT t FROM Turn t WHERE t.idEmployee = :idEmployee")
    , @NamedQuery(name = "Turn.findByUuid", query = "SELECT t FROM Turn t WHERE t.uuid = :uuid")
    , @NamedQuery(name = "Turn.findByDateTimeCreated", query = "SELECT t FROM Turn t WHERE t.dateTimeCreated BETWEEN :fechaInicio AND :fechaFin")
    , @NamedQuery(name = "Turn.findByDateTimeAssigned", query = "SELECT t FROM Turn t WHERE t.dateTimeAssigned BETWEEN :fechaInicio AND :fechaFin")
    , @NamedQuery(name = "Turn.findByDateTimeFinished", query = "SELECT t FROM Turn t WHERE t.dateTimeFinished BETWEEN :fechaInicio AND :fechaFin")
    , @NamedQuery(name = "Turn.findByTurnNumber", query = "SELECT t FROM Turn t WHERE t.turnNumber = :turnNumber")
    , @NamedQuery(name = "Turn.findByStatus", query = "SELECT t FROM Turn t WHERE t.status = :status")
    , @NamedQuery(name = "Turn.findByIsActive", query = "SELECT t FROM Turn t WHERE t.isActive = :isActive")
    , @NamedQuery(name = "Turn.findByType", query = "SELECT t FROM Turn t WHERE t.type = :type")})
public class Turn implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "uuid", columnDefinition = "uniqueidentifier", updatable = false)
    private String uuid;

    @Column(name = "dateTimeCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeCreated;

    @Column(name = "dateTimeAssigned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeAssigned;

    @Column(name = "dateTimeFinished")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeFinished;

    @Column(name = "turnNumber")
    private Integer turnNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @JoinColumn(name = "idEmployee", referencedColumnName = "id", columnDefinition = "bigint")
    @ManyToOne
    private Employee idEmployee;

    public enum Type {
        CAJA,
        MODULO
    }

    // Constructores
    public Turn() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Turn(String uuid, Date dateTimeCreated, Date dateTimeAssigned, Date dateTimeFinished, Integer turnNumber, String status, Boolean isActive, Type type, Employee idEmployee) {
        this.uuid = uuid;
        this.dateTimeCreated = dateTimeCreated;
        this.dateTimeAssigned = dateTimeAssigned;
        this.dateTimeFinished = dateTimeFinished;
        this.turnNumber = turnNumber;
        this.status = status;
        this.isActive = isActive;
        this.type = type;
        this.idEmployee = idEmployee;
    }

    // Getters y Setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getDateTimeAssigned() {
        return dateTimeAssigned;
    }

    public void setDateTimeAssigned(Date dateTimeAssigned) {
        this.dateTimeAssigned = dateTimeAssigned;
    }

    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(Date dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public Date getDateTimeFinished() {
        return dateTimeFinished;
    }

    public void setDateTimeFinished(Date dateTimeFinished) {
        this.dateTimeFinished = dateTimeFinished;
    }

    public Integer getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(Integer turnNumber) {
        this.turnNumber = turnNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turn)) {
            return false;
        }
        Turn other = (Turn) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Turn[ uuid=" + uuid + " ]";
    }

}
