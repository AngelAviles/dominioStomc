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
@Table(name = "tblLysingInformation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LysingInformation.findAll", query = "SELECT l FROM LysingInformation l")
    , @NamedQuery(name = "LysingInformation.findById", query = "SELECT l FROM LysingInformation l WHERE l.id = :id")
    , @NamedQuery(name = "LysingInformation.findByFolio", query = "SELECT l FROM LysingInformation l WHERE l.folio = :folio")
    , @NamedQuery(name = "LysingInformation.findByProcess", query = "SELECT l FROM LysingInformation l WHERE l.process = :process")})
public class LysingInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_idLysingInformation")
    @TableGenerator(name = "generator_idLysingInformation", allocationSize = 1)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "folio", columnDefinition = "BIGINT IDENTITY", insertable = false)
    private Long folio;

    @Column(name = "process")
    private String process;

    public LysingInformation() {
    }

    public LysingInformation(Long id) {
        this.id = id;
    }

    public LysingInformation(String process) {
        this.process = process;
    }

    public LysingInformation(Long id, Long folio, String process) {
        this.id = id;
        this.folio = folio;
        this.process = process;
    }

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

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
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
        if (!(object instanceof LysingInformation)) {
            return false;
        }
        LysingInformation other = (LysingInformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.LysingInformation[ id=" + id + " ]";
    }

}
