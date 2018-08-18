/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengolahandataproduksi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agungnotfound
 */
@Entity
@Table(name = "tbl_produksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProduksi.findAll", query = "SELECT t FROM TblProduksi t")
    , @NamedQuery(name = "TblProduksi.findByKodeProduksi", query = "SELECT t FROM TblProduksi t WHERE t.kodeProduksi = :kodeProduksi")
    , @NamedQuery(name = "TblProduksi.findByTujuan", query = "SELECT t FROM TblProduksi t WHERE t.tujuan = :tujuan")
    , @NamedQuery(name = "TblProduksi.findByTglProduksi", query = "SELECT t FROM TblProduksi t WHERE t.tglProduksi = :tglProduksi")
    , @NamedQuery(name = "TblProduksi.findByIdPegawai", query = "SELECT t FROM TblProduksi t WHERE t.idPegawai = :idPegawai")})
public class TblProduksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode_produksi")
    private String kodeProduksi;
    @Basic(optional = false)
    @Column(name = "tujuan")
    private String tujuan;
    @Basic(optional = false)
    @Column(name = "tgl_produksi")
    @Temporal(TemporalType.DATE)
    private Date tglProduksi;
    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private String idPegawai;

    public TblProduksi() {
    }

    public TblProduksi(String kodeProduksi) {
        this.kodeProduksi = kodeProduksi;
    }

    public TblProduksi(String kodeProduksi, String tujuan, Date tglProduksi, String idPegawai) {
        this.kodeProduksi = kodeProduksi;
        this.tujuan = tujuan;
        this.tglProduksi = tglProduksi;
        this.idPegawai = idPegawai;
    }

    public String getKodeProduksi() {
        return kodeProduksi;
    }

    public void setKodeProduksi(String kodeProduksi) {
        this.kodeProduksi = kodeProduksi;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Date getTglProduksi() {
        return tglProduksi;
    }

    public void setTglProduksi(Date tglProduksi) {
        this.tglProduksi = tglProduksi;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeProduksi != null ? kodeProduksi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProduksi)) {
            return false;
        }
        TblProduksi other = (TblProduksi) object;
        if ((this.kodeProduksi == null && other.kodeProduksi != null) || (this.kodeProduksi != null && !this.kodeProduksi.equals(other.kodeProduksi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pengolahandataproduksi.model.TblProduksi[ kodeProduksi=" + kodeProduksi + " ]";
    }
    
}
