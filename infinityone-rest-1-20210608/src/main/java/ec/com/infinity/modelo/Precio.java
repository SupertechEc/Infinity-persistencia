/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "precio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precio.findAll", query = "SELECT p FROM Precio p"),
    @NamedQuery(name = "Precio.findForFactura", query = "SELECT p FROM Precio p WHERE p.precioPK.codigocomercializadora = :codigocomercializadora"
            + " and p.precioPK.codigoterminal = :codigoterminal"
            + " and p.precioPK.codigoproducto = :codigoproducto "
            + " and p.precioPK.codigomedida = :codigomedida"
            + " and p.precioPK.codigolistaprecio = :codigolistaprecio"
            + " and p.precioPK.fechainicio <= :fechainicio"
            //+ " and p.precioPK.secuencial = :secuencial"
            + " and p.activo = true"
            + " and p.fechafin = NULL"),
    @NamedQuery(name = "Precio.findByCodigocomercializadora", query = "SELECT p FROM Precio p WHERE p.precioPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Precio.findByCodigoterminal", query = "SELECT p FROM Precio p WHERE p.precioPK.codigoterminal = :codigoterminal"),
    @NamedQuery(name = "Precio.findByCodigoproducto", query = "SELECT p FROM Precio p WHERE p.precioPK.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Precio.findByCodigomedida", query = "SELECT p FROM Precio p WHERE p.precioPK.codigomedida = :codigomedida"),
    @NamedQuery(name = "Precio.findByCodigolistaprecio", query = "SELECT p FROM Precio p WHERE p.precioPK.codigolistaprecio = :codigolistaprecio"),
    @NamedQuery(name = "Precio.findByFechainicio", query = "SELECT p FROM Precio p WHERE p.precioPK.fechainicio = :fechainicio"),
    @NamedQuery(name = "Precio.findBySecuencial", query = "SELECT p FROM Precio p WHERE p.precioPK.secuencial = :secuencial"),
    @NamedQuery(name = "Precio.findByCodigoPrecio", query = "SELECT p FROM Precio p WHERE p.precioPK.codigoPrecio = :codigoPrecio"),
    @NamedQuery(name = "Precio.findByFechafin", query = "SELECT p FROM Precio p WHERE p.fechafin = :fechafin"),
    @NamedQuery(name = "Precio.findByActivo", query = "SELECT p FROM Precio p WHERE p.activo = :activo"),
    @NamedQuery(name = "Precio.findByObservacion", query = "SELECT p FROM Precio p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Precio.findByPrecioproducto", query = "SELECT p FROM Precio p WHERE p.precioproducto = :precioproducto"),
    @NamedQuery(name = "Precio.findByUsuarioactual", query = "SELECT p FROM Precio p WHERE p.usuarioactual = :usuarioactual")})
public class Precio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrecioPK precioPK;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioproducto")
    private BigDecimal precioproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumns({
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "codigoproducto", referencedColumnName = "codigoproducto", insertable = false, updatable = false),
        @JoinColumn(name = "codigomedida", referencedColumnName = "codigomedida", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Comercializadoraproducto comercializadoraproducto;
    @JoinColumns({
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "codigolistaprecio", referencedColumnName = "codigo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Listaprecio listaprecio;
    @JoinColumn(name = "codigoterminal", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Terminal terminal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "precio")
    private List<Detalleprecio> detalleprecioList;

    public Precio() {
    }

    public Precio(PrecioPK precioPK) {
        this.precioPK = precioPK;
    }

    public Precio(PrecioPK precioPK, boolean activo, BigDecimal precioproducto, String usuarioactual) {
        this.precioPK = precioPK;
        this.activo = activo;
        this.precioproducto = precioproducto;
        this.usuarioactual = usuarioactual;
    }

    public Precio(String codigocomercializadora, String codigoterminal, String codigoproducto, String codigomedida, String codigolistaprecio, Date fechainicio, int secuencial, String codigoPrecio) {
        this.precioPK = new PrecioPK(codigocomercializadora, codigoterminal, codigoproducto, codigomedida, codigolistaprecio, fechainicio, secuencial, codigoPrecio);
    }

    public PrecioPK getPrecioPK() {
        return precioPK;
    }

    public void setPrecioPK(PrecioPK precioPK) {
        this.precioPK = precioPK;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigDecimal getPrecioproducto() {
        return precioproducto;
    }

    public void setPrecioproducto(BigDecimal precioproducto) {
        this.precioproducto = precioproducto;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Comercializadoraproducto getComercializadoraproducto() {
        return comercializadoraproducto;
    }

    public void setComercializadoraproducto(Comercializadoraproducto comercializadoraproducto) {
        this.comercializadoraproducto = comercializadoraproducto;
    }

    public Listaprecio getListaprecio() {
        return listaprecio;
    }

    public void setListaprecio(Listaprecio listaprecio) {
        this.listaprecio = listaprecio;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    @XmlTransient
    public List<Detalleprecio> getDetalleprecioList() {
        return detalleprecioList;
    }

    public void setDetalleprecioList(List<Detalleprecio> detalleprecioList) {
        this.detalleprecioList = detalleprecioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (precioPK != null ? precioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precio)) {
            return false;
        }
        Precio other = (Precio) object;
        if ((this.precioPK == null && other.precioPK != null) || (this.precioPK != null && !this.precioPK.equals(other.precioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Precio[ precioPK=" + precioPK + " ]";
    }
    
}
