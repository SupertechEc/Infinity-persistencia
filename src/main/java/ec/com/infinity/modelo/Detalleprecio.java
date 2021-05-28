/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "detalleprecio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleprecio.findAll", query = "SELECT d FROM Detalleprecio d"),
    @NamedQuery(name = "Detalleprecio.findByCodigocomercializadora", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Detalleprecio.findByCodigoterminal", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.codigoterminal = :codigoterminal"),
    @NamedQuery(name = "Detalleprecio.findByCodigoproducto", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Detalleprecio.findByCodigomedida", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.codigomedida = :codigomedida"),
    @NamedQuery(name = "Detalleprecio.findByCodigolistaprecio", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.codigolistaprecio = :codigolistaprecio"),
    @NamedQuery(name = "Detalleprecio.findByFechainicio", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.fechainicio = :fechainicio"),
    @NamedQuery(name = "Detalleprecio.findBySecuencial", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.secuencial = :secuencial"),
    @NamedQuery(name = "Detalleprecio.findByCodigo", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.codigo = :codigo"),
    @NamedQuery(name = "Detalleprecio.findByCodigogravamen", query = "SELECT d FROM Detalleprecio d WHERE d.detalleprecioPK.codigogravamen = :codigogravamen"),
    @NamedQuery(name = "Detalleprecio.findByValor", query = "SELECT d FROM Detalleprecio d WHERE d.valor = :valor"),
    @NamedQuery(name = "Detalleprecio.findByUsuarioactual", query = "SELECT d FROM Detalleprecio d WHERE d.usuarioactual = :usuarioactual")})
public class Detalleprecio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleprecioPK detalleprecioPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumns({
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "codigogravamen", referencedColumnName = "codigo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Gravamen gravamen;
    @JoinColumns({
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "codigoterminal", referencedColumnName = "codigoterminal", insertable = false, updatable = false),
        @JoinColumn(name = "codigoproducto", referencedColumnName = "codigoproducto", insertable = false, updatable = false),
        @JoinColumn(name = "codigomedida", referencedColumnName = "codigomedida", insertable = false, updatable = false),
        @JoinColumn(name = "codigolistaprecio", referencedColumnName = "codigolistaprecio", insertable = false, updatable = false),
        @JoinColumn(name = "fechainicio", referencedColumnName = "fechainicio", insertable = false, updatable = false),
        @JoinColumn(name = "secuencial", referencedColumnName = "secuencial", insertable = false, updatable = false),
        @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Precio precio;

    public Detalleprecio() {
    }

    public Detalleprecio(DetalleprecioPK detalleprecioPK) {
        this.detalleprecioPK = detalleprecioPK;
    }

    public Detalleprecio(DetalleprecioPK detalleprecioPK, BigDecimal valor, String usuarioactual) {
        this.detalleprecioPK = detalleprecioPK;
        this.valor = valor;
        this.usuarioactual = usuarioactual;
    }

    public Detalleprecio(String codigocomercializadora, String codigoterminal, String codigoproducto, String codigomedida, String codigolistaprecio, Date fechainicio, int secuencial, String codigo, String codigogravamen) {
        this.detalleprecioPK = new DetalleprecioPK(codigocomercializadora, codigoterminal, codigoproducto, codigomedida, codigolistaprecio, fechainicio, secuencial, codigo, codigogravamen);
    }

    public DetalleprecioPK getDetalleprecioPK() {
        return detalleprecioPK;
    }

    public void setDetalleprecioPK(DetalleprecioPK detalleprecioPK) {
        this.detalleprecioPK = detalleprecioPK;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Gravamen getGravamen() {
        return gravamen;
    }

    public void setGravamen(Gravamen gravamen) {
        this.gravamen = gravamen;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleprecioPK != null ? detalleprecioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleprecio)) {
            return false;
        }
        Detalleprecio other = (Detalleprecio) object;
        if ((this.detalleprecioPK == null && other.detalleprecioPK != null) || (this.detalleprecioPK != null && !this.detalleprecioPK.equals(other.detalleprecioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Detalleprecio[ detalleprecioPK=" + detalleprecioPK + " ]";
    }
    
}
