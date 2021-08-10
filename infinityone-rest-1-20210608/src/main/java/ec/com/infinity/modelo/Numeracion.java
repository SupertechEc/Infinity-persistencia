/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "numeracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Numeracion.findAll", query = "SELECT n FROM Numeracion n"),
    @NamedQuery(name = "Numeracion.findById", query = "SELECT n FROM Numeracion n WHERE n.id = :id"),
    @NamedQuery(name = "Numeracion.findByTipodocumento", query = "SELECT n FROM Numeracion n WHERE n.tipodocumento = :tipodocumento"),
    @NamedQuery(name = "Numeracion.findByActivo", query = "SELECT n FROM Numeracion n WHERE n.activo = :activo"),
    @NamedQuery(name = "Numeracion.findByUltimonumero", query = "SELECT n FROM Numeracion n WHERE n.ultimonumero = :ultimonumero"),
    @NamedQuery(name = "Numeracion.findByVersion", query = "SELECT n FROM Numeracion n WHERE n.version = :version")})
public class Numeracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipodocumento")
    private String tipodocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultimonumero")
    private int ultimonumero;
    @Version
    private Integer version;
    @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Comercializadora codigocomercializadora;
     @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;

    public Numeracion() {
    }

    public Numeracion(Long id) {
        this.id = id;
    }

    public Numeracion(Long id, String tipodocumento, boolean activo, int ultimonumero) {
        this.id = id;
        this.tipodocumento = tipodocumento;
        this.activo = activo;
        this.ultimonumero = ultimonumero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getUltimonumero() {
        return ultimonumero;
    }

    public void setUltimonumero(int ultimonumero) {
        this.ultimonumero = ultimonumero;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Comercializadora getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(Comercializadora codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
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
        if (!(object instanceof Numeracion)) {
            return false;
        }
        Numeracion other = (Numeracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Numeracion[ id=" + id + " ]";
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }
    
    
    
}
