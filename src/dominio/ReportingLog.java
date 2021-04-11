/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "tblReportingLog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportingLog.findAll", query = "SELECT r FROM ReportingLog r")
    , @NamedQuery(name = "ReportingLog.findById", query = "SELECT r FROM ReportingLog r WHERE r.id = :id")
    , @NamedQuery(name = "ReportingLog.findByFolio", query = "SELECT r FROM ReportingLog r WHERE r.folio = :folio")
    , @NamedQuery(name = "ReportingLog.findByRequestedReport", query = "SELECT r FROM ReportingLog r WHERE r.requestedReport = :requestedReport")
    , @NamedQuery(name = "ReportingLog.findByUserAccount", query = "SELECT r FROM ReportingLog r WHERE r.userAccount = :userAccount")
    , @NamedQuery(name = "ReportingLog.findByDateReport", query = "SELECT r FROM ReportingLog r WHERE r.dateReport = :dateReport")})
public class ReportingLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "folio")
    private Long folio;
    
    @Column(name = "requestedReport")
    private String requestedReport;
    
    @Column(name = "userAccount")
    private String userAccount;
    
    @Column(name = "dateReport")
    @Temporal(TemporalType.DATE)
    private Date dateReport;
    
    @Lob
    @Column(name = "observations")
    private String observations;

    // Constructores
    public ReportingLog() {
    }

    public ReportingLog(Long id) {
        this.id = id;
    }

    public ReportingLog(Long id, Long folio, String requestedReport, String userAccount, Date dateReport, String observations) {
        this.id = id;
        this.folio = folio;
        this.requestedReport = requestedReport;
        this.userAccount = userAccount;
        this.dateReport = dateReport;
        this.observations = observations;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFolio(Long folio) {
        this.folio = folio;
    }
    
    public Long getFolio() {
        return folio;
    }

    public String getRequestedReport() {
        return requestedReport;
    }

    public void setRequestedReport(String requestedReport) {
        this.requestedReport = requestedReport;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Date getDateReport() {
        return dateReport;
    }

    public void setDateReport(Date dateReport) {
        this.dateReport = dateReport;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
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
        if (!(object instanceof ReportingLog)) {
            return false;
        }
        ReportingLog other = (ReportingLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.ReportingLog[ id=" + id + " ]";
    }
    
}
