/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "listaprecioterminalproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listaprecioterminalproducto.findAll", query = "SELECT l FROM Listaprecioterminalproducto l"),
    @NamedQuery(name = "Listaprecioterminalproducto.findByCodigocomercializadora", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.listaprecioterminalproductoPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Listaprecioterminalproducto.paraPreciodos", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.listaprecioterminalproductoPK.codigocomercializadora = :codigocomercializadora"
            + " and l.listaprecioterminalproductoPK.codigoproducto = :codigoproducto"
            + " and l.listaprecioterminalproductoPK.codigomedida = :codigomedida"),
    @NamedQuery(name = "Listaprecioterminalproducto.findByCodigolistaprecio", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.listaprecioterminalproductoPK.codigolistaprecio = :codigolistaprecio"),
    @NamedQuery(name = "Listaprecioterminalproducto.findByCodigoterminal", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.listaprecioterminalproductoPK.codigoterminal = :codigoterminal"),
    @NamedQuery(name = "Listaprecioterminalproducto.findByCodigoproducto", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.listaprecioterminalproductoPK.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Listaprecioterminalproducto.findByCodigomedida", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.listaprecioterminalproductoPK.codigomedida = :codigomedida"),
    @NamedQuery(name = "Listaprecioterminalproducto.findByMargenporcentaje", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.margenporcentaje = :margenporcentaje"),
    @NamedQuery(name = "Listaprecioterminalproducto.findByMargenvalorcomercializadora", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.margenvalorcomercializadora = :margenvalorcomercializadora"),
    @NamedQuery(name = "Listaprecioterminalproducto.findByUsuarioactual", query = "SELECT l FROM Listaprecioterminalproducto l WHERE l.usuarioactual = :usuarioactual")})
public class Listaprecioterminalproducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListaprecioterminalproductoPK listaprecioterminalproductoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "margenporcentaje")
    private BigDecimal margenporcentaje;
    @Column(name = "margenvalorcomercializadora")
    private BigDecimal margenvalorcomercializadora;
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

    public Listaprecioterminalproducto() {
    }

    public Listaprecioterminalproducto(ListaprecioterminalproductoPK listaprecioterminalproductoPK) {
        this.listaprecioterminalproductoPK = listaprecioterminalproductoPK;
    }

    public Listaprecioterminalproducto(ListaprecioterminalproductoPK listaprecioterminalproductoPK, String usuarioactual) {
        this.listaprecioterminalproductoPK = listaprecioterminalproductoPK;
        this.usuarioactual = usuarioactual;
    }

    public Listaprecioterminalproducto(String codigocomercializadora, String codigolistaprecio, String codigoterminal, String codigoproducto, String codigomedida) {
        this.listaprecioterminalproductoPK = new ListaprecioterminalproductoPK(codigocomercializadora, codigolistaprecio, codigoterminal, codigoproducto, codigomedida);
    }

    public ListaprecioterminalproductoPK getListaprecioterminalproductoPK() {
        return listaprecioterminalproductoPK;
    }

    public void setListaprecioterminalproductoPK(ListaprecioterminalproductoPK listaprecioterminalproductoPK) {
        this.listaprecioterminalproductoPK = listaprecioterminalproductoPK;
    }

    public BigDecimal getMargenporcentaje() {
        return margenporcentaje;
    }

    public void setMargenporcentaje(BigDecimal margenporcentaje) {
        this.margenporcentaje = margenporcentaje;
    }

    public BigDecimal getMargenvalorcomercializadora() {
        return margenvalorcomercializadora;
    }

    public void setMargenvalorcomercializadora(BigDecimal margenvalorcomercializadora) {
        this.margenvalorcomercializadora = margenvalorcomercializadora;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listaprecioterminalproductoPK != null ? listaprecioterminalproductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listaprecioterminalproducto)) {
            return false;
        }
        Listaprecioterminalproducto other = (Listaprecioterminalproducto) object;
        if ((this.listaprecioterminalproductoPK == null && other.listaprecioterminalproductoPK != null) || (this.listaprecioterminalproductoPK != null && !this.listaprecioterminalproductoPK.equals(other.listaprecioterminalproductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Listaprecioterminalproducto[ listaprecioterminalproductoPK=" + listaprecioterminalproductoPK + " ]";
    }
    
}
