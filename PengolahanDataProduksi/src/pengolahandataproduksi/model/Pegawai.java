/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengolahandataproduksi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agungnotfound
 */
@Entity
@Table(name = "pegawai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pegawai.findAll", query = "SELECT p FROM Pegawai p")
    , @NamedQuery(name = "Pegawai.findByIdPegawai", query = "SELECT p FROM Pegawai p WHERE p.idPegawai = :idPegawai")
    , @NamedQuery(name = "Pegawai.findByNama", query = "SELECT p FROM Pegawai p WHERE p.nama = :nama")})
public class Pegawai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private String idPegawai;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Lob
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @Lob
    @Column(name = "keterangan")
    private String keterangan;

    public Pegawai() {
    }

    public Pegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public Pegawai(String idPegawai, String nama, String alamat, String keterangan) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.alamat = alamat;
        this.keterangan = keterangan;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPegawai != null ? idPegawai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pegawai)) {
            return false;
        }
        Pegawai other = (Pegawai) object;
        if ((this.idPegawai == null && other.idPegawai != null) || (this.idPegawai != null && !this.idPegawai.equals(other.idPegawai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pengolahandataproduksi.model.Pegawai[ idPegawai=" + idPegawai + " ]";
    }
    
}
