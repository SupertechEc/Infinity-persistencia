/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "logenviooeepp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logenviooeepp.findAll", query = "SELECT l FROM Logenviooeepp l"),
    @NamedQuery(name = "Logenviooeepp.findByCodigocomercializadora", query = "SELECT l FROM Logenviooeepp l WHERE l.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Logenviooeepp.findByNumeronp", query = "SELECT l FROM Logenviooeepp l WHERE l.numeronp = :numeronp"),
    @NamedQuery(name = "Logenviooeepp.findByNumerofactura", query = "SELECT l FROM Logenviooeepp l WHERE l.numerofactura = :numerofactura"),
    @NamedQuery(name = "Logenviooeepp.findBySecuencial", query = "SELECT l FROM Logenviooeepp l WHERE l.secuencial = :secuencial"),
    @NamedQuery(name = "Logenviooeepp.findByFechagestion", query = "SELECT l FROM Logenviooeepp l WHERE l.fechagestion = :fechagestion"),
    @NamedQuery(name = "Logenviooeepp.findByCodigorespuestapetro", query = "SELECT l FROM Logenviooeepp l WHERE l.codigorespuestapetro = :codigorespuestapetro"),
    @NamedQuery(name = "Logenviooeepp.findByProceso", query = "SELECT l FROM Logenviooeepp l WHERE l.proceso = :proceso"),
    @NamedQuery(name = "Logenviooeepp.findByUsuarioactual", query = "SELECT l FROM Logenviooeepp l WHERE l.usuarioactual = :usuarioactual"),
    @NamedQuery(name = "Logenviooeepp.findById", query = "SELECT l FROM Logenviooeepp l WHERE l.id = :id")})
public class Logenviooeepp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Size(max = 8)
    @Column(name = "numeronp")
    private String numeronp;
    @Size(max = 16)
    @Column(name = "numerofactura")
    private String numerofactura;
    @Basic(optional = false)
    @Column(name = "secuencial")
    private long secuencial;
    @Column(name = "fechagestion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechagestion;
    @Size(max = 5)
    @Column(name = "codigorespuestapetro")
    private String codigorespuestapetro;
    @Size(max = 3)
    @Column(name = "proceso")
    private String proceso;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    public Logenviooeepp() {
    }

    public Logenviooeepp(Long id) {
        this.id = id;
    }

    public Logenviooeepp(Long id, long secuencial) {
        this.id = id;
        this.secuencial = secuencial;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public String getNumeronp() {
        return numeronp;
    }

    public void setNumeronp(String numeronp) {
        this.numeronp = numeronp;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public long getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(long secuencial) {
        this.secuencial = secuencial;
    }

    public Date getFechagestion() {
        return fechagestion;
    }

    public void setFechagestion(Date fechagestion) {
        this.fechagestion = fechagestion;
    }

    public String getCodigorespuestapetro() {
        return codigorespuestapetro;
    }

    public void setCodigorespuestapetro(String codigorespuestapetro) {
        this.codigorespuestapetro = codigorespuestapetro;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Logenviooeepp)) {
            return false;
        }
        Logenviooeepp other = (Logenviooeepp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Logenviooeepp[ id=" + id + " ]";
    }
    
}
