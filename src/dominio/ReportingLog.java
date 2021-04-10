package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ReportingLog implements Serializable {
    private long id;
    private long folio;
    private String requestedReport;
    private String userAccount;
    private Date dateReport;
    private  String observations;

    public ReportingLog() {
    }

    public ReportingLog(long id) {
        this.id = id;
    }

    public ReportingLog(long id, long folio, String requestedReport, String userAccount, Date dateReport, String observations) {
        this.id = id;
        this.folio = folio;
        this.requestedReport = requestedReport;
        this.userAccount = userAccount;
        this.dateReport = dateReport;
        this.observations = observations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFolio() {
        return folio;
    }

    public void setFolio(long folio) {
        this.folio = folio;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportingLog)) return false;
        ReportingLog that = (ReportingLog) o;
        return folio == that.folio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }

    @Override
    public String toString() {
        return "ReportingLog{" +
                "id=" + id +
                ", folio=" + folio +
                ", requestedReport='" + requestedReport + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", dateReport=" + dateReport +
                ", observations='" + observations + '\'' +
                '}';
    }
}
