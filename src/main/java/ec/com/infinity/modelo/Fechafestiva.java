/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Tapia
 */
@Entity
@Table(name = "fechafestiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fechafestiva.findAll", query = "SELECT f FROM Fechafestiva f"),
    @NamedQuery(name = "Fechafestiva.findByCodigocomercializadora", query = "SELECT f FROM Fechafestiva f WHERE f.fechafestivaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Fechafestiva.findByFestivo", query = "SELECT f FROM Fechafestiva f WHERE f.fechafestivaPK.festivo = :festivo"),
    @NamedQuery(name = "Fechafestiva.findByActivo", query = "SELECT f FROM Fechafestiva f WHERE f.activo = :activo"),
    @NamedQuery(name = "Fechafestiva.findByDescripcion", query = "SELECT f FROM Fechafestiva f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Fechafestiva.findByUsuarioactual", query = "SELECT f FROM Fechafestiva f WHERE f.usuarioactual = :usuarioactual")})
public class Fechafestiva implements Serializable {
    @Size(max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comercializadora_1 comercializadora1;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FechafestivaPK fechafestivaPK;
    @Column(name = "activo")
    private Boolean activo;

    public Fechafestiva() {
    }

    public Fechafestiva(FechafestivaPK fechafestivaPK) {
        this.fechafestivaPK = fechafestivaPK;
    }

    public Fechafestiva(String codigocomercializadora, Date festivo) {
        this.fechafestivaPK = new FechafestivaPK(codigocomercializadora, festivo);
    }

    public FechafestivaPK getFechafestivaPK() {
        return fechafestivaPK;
    }

    public void setFechafestivaPK(FechafestivaPK fechafestivaPK) {
        this.fechafestivaPK = fechafestivaPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechafestivaPK != null ? fechafestivaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fechafestiva)) {
            return false;
        }
        Fechafestiva other = (Fechafestiva) object;
        if ((this.fechafestivaPK == null && other.fechafestivaPK != null) || (this.fechafestivaPK != null && !this.fechafestivaPK.equals(other.fechafestivaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Fechafestiva[ fechafestivaPK=" + fechafestivaPK + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Comercializadora_1 getComercializadora1() {
        return comercializadora1;
    }

    public void setComercializadora1(Comercializadora_1 comercializadora1) {
        this.comercializadora1 = comercializadora1;
    }
    
}
