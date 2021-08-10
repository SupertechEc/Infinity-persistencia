/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "errorpetro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Errorpetro.findAll", query = "SELECT e FROM Errorpetro e"),
    @NamedQuery(name = "Errorpetro.findByProcesoCodigo", query = "SELECT c FROM Errorpetro c WHERE c.errorpetroPK.proceso = :proceso and c.errorpetroPK.codigo = :codigo"),
    @NamedQuery(name = "Errorpetro.findByProceso", query = "SELECT e FROM Errorpetro e WHERE e.errorpetroPK.proceso = :proceso"),
    @NamedQuery(name = "Errorpetro.findByCodigo", query = "SELECT e FROM Errorpetro e WHERE e.errorpetroPK.codigo = :codigo"),
    @NamedQuery(name = "Errorpetro.findByDescripcion", query = "SELECT e FROM Errorpetro e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Errorpetro.findByUsuarioactual", query = "SELECT e FROM Errorpetro e WHERE e.usuarioactual = :usuarioactual")})
public class Errorpetro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErrorpetroPK errorpetroPK;
    @Size(max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;

    public Errorpetro() {
    }

    public Errorpetro(ErrorpetroPK errorpetroPK) {
        this.errorpetroPK = errorpetroPK;
    }

    public Errorpetro(String proceso, String codigo) {
        this.errorpetroPK = new ErrorpetroPK(proceso, codigo);
    }

    public ErrorpetroPK getErrorpetroPK() {
        return errorpetroPK;
    }

    public void setErrorpetroPK(ErrorpetroPK errorpetroPK) {
        this.errorpetroPK = errorpetroPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorpetroPK != null ? errorpetroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Errorpetro)) {
            return false;
        }
        Errorpetro other = (Errorpetro) object;
        if ((this.errorpetroPK == null && other.errorpetroPK != null) || (this.errorpetroPK != null && !this.errorpetroPK.equals(other.errorpetroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Errorpetro[ errorpetroPK=" + errorpetroPK + " ]";
    }
    
}
