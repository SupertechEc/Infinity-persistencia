/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "codigospetro")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Codigospetro.findAll", query = "SELECT c FROM Codigospetro c"),
//    @NamedQuery(name = "Codigospetro.findByProceso", query = "SELECT c FROM Codigospetro c WHERE c.proceso = :proceso"),
//    @NamedQuery(name = "Codigospetro.findByCodigo", query = "SELECT c FROM Codigospetro c WHERE c.codigo = :codigo"),
//    @NamedQuery(name = "Codigospetro.findByProcesoCodigo", query = "SELECT c FROM Codigospetro c WHERE c.proceso = :proceso and c.codigo = :codigo"),
//    @NamedQuery(name = "Codigospetro.findByDescripcion", query = "SELECT c FROM Codigospetro c WHERE c.descripcion = :descripcion"),
//    @NamedQuery(name = "Codigospetro.findByUsuarioactual", query = "SELECT c FROM Codigospetro c WHERE c.usuarioactual = :usuarioactual"),
//    @NamedQuery(name = "Codigospetro.findById", query = "SELECT c FROM Codigospetro c WHERE c.id = :id")})
public class Codigospetro implements Serializable {
    @EmbeddedId
    protected CodigospetroPK codigospetroPK;
    @Size(max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    private static final long serialVersionUID = 1L;
//    @Size(max = 5)
//    @Column(name = "proceso")
//    private String proceso;
//    @Size(max = 5)
//    @Column(name = "codigo")
//    private String codigo;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id")
//    private Long id;

    public Codigospetro() {
    }

    public Codigospetro(CodigospetroPK codigospetroPK) {
        this.codigospetroPK = codigospetroPK; 
    }

    public Codigospetro(CodigospetroPK codigospetroPK, String usuarioactual) {
        this.codigospetroPK = codigospetroPK;
        this.usuarioactual = usuarioactual;
    }

//    public String getProceso() {
//        return proceso;
//    }
//
//    public void setProceso(String proceso) {
//        this.proceso = proceso;
//    }
//
//    public String getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(String codigo) {
//        this.codigo = codigo;
//    }


    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigospetroPK != null ? codigospetroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codigospetro)) {
            return false;
        }
        Codigospetro other = (Codigospetro) object;
        if ((this.codigospetroPK == null && other.codigospetroPK != null) || (this.codigospetroPK != null && !this.codigospetroPK.equals(other.codigospetroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Codigospetro[ codigospetroPK=" + codigospetroPK + " ]";
    }

    public ec.com.infinity.modelo.CodigospetroPK getCodigospetroPK() {
        return codigospetroPK;
    }

    public void setCodigospetroPK(ec.com.infinity.modelo.CodigospetroPK codigospetroPK) {
        this.codigospetroPK = codigospetroPK;
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
    
}
