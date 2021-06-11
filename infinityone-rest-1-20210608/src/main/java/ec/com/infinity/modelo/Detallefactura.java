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
@Table(name = "detallefactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d"),
    @NamedQuery(name = "Detallefactura.findByCodigoabastecedora", query = "SELECT d FROM Detallefactura d WHERE d.detallefacturaPK.codigoabastecedora = :codigoabastecedora"),
    @NamedQuery(name = "Detallefactura.findByCodigocomercializadora", query = "SELECT d FROM Detallefactura d WHERE d.detallefacturaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Detallefactura.findByNumeronotapedido", query = "SELECT d FROM Detallefactura d WHERE d.detallefacturaPK.numeronotapedido = :numeronotapedido"),
    @NamedQuery(name = "Detallefactura.findByNumero", query = "SELECT d FROM Detallefactura d WHERE d.detallefacturaPK.numero = :numero"),
    @NamedQuery(name = "Detallefactura.findByCodigoproducto", query = "SELECT d FROM Detallefactura d WHERE d.detallefacturaPK.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Detallefactura.findByVolumennaturalrequerido", query = "SELECT d FROM Detallefactura d WHERE d.volumennaturalrequerido = :volumennaturalrequerido"),
    @NamedQuery(name = "Detallefactura.findByVolumennaturalautorizado", query = "SELECT d FROM Detallefactura d WHERE d.volumennaturalautorizado = :volumennaturalautorizado"),
    @NamedQuery(name = "Detallefactura.findByPrecioproducto", query = "SELECT d FROM Detallefactura d WHERE d.precioproducto = :precioproducto"),
    @NamedQuery(name = "Detallefactura.findBySubtotal", query = "SELECT d FROM Detallefactura d WHERE d.subtotal = :subtotal"),
    @NamedQuery(name = "Detallefactura.findByUsuarioactual", query = "SELECT d FROM Detallefactura d WHERE d.usuarioactual = :usuarioactual")})
public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallefacturaPK detallefacturaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumennaturalrequerido")
    private BigDecimal volumennaturalrequerido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumennaturalautorizado")
    private BigDecimal volumennaturalautorizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioproducto")
    private BigDecimal precioproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumns({
        @JoinColumn(name = "codigoabastecedora", referencedColumnName = "codigoabastecedora", insertable = false, updatable = false),
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "numeronotapedido", referencedColumnName = "numeronotapedido", insertable = false, updatable = false),
        @JoinColumn(name = "numero", referencedColumnName = "numero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Factura factura;
    @JoinColumn(name = "codigomedida", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Medida codigomedida;
    @Column(name = "codigoprecio")
    private String codigoprecio;
    @JoinColumn(name = "codigoproducto", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Detallefactura() {
    }

    public Detallefactura(DetallefacturaPK detallefacturaPK) {
        this.detallefacturaPK = detallefacturaPK;
    }

    public Detallefactura(DetallefacturaPK detallefacturaPK, BigDecimal volumennaturalrequerido, BigDecimal volumennaturalautorizado, BigDecimal precioproducto, BigDecimal subtotal, String usuarioactual) {
        this.detallefacturaPK = detallefacturaPK;
        this.volumennaturalrequerido = volumennaturalrequerido;
        this.volumennaturalautorizado = volumennaturalautorizado;
        this.precioproducto = precioproducto;
        this.subtotal = subtotal;
        this.usuarioactual = usuarioactual;
    }

    public Detallefactura(String codigoabastecedora, String codigocomercializadora, String numeronotapedido, String numero, String codigoproducto) {
        this.detallefacturaPK = new DetallefacturaPK(codigoabastecedora, codigocomercializadora, numeronotapedido, numero, codigoproducto);
    }

    public DetallefacturaPK getDetallefacturaPK() {
        return detallefacturaPK;
    }

    public void setDetallefacturaPK(DetallefacturaPK detallefacturaPK) {
        this.detallefacturaPK = detallefacturaPK;
    }

    public BigDecimal getVolumennaturalrequerido() {
        return volumennaturalrequerido;
    }

    public void setVolumennaturalrequerido(BigDecimal volumennaturalrequerido) {
        this.volumennaturalrequerido = volumennaturalrequerido;
    }

    public BigDecimal getVolumennaturalautorizado() {
        return volumennaturalautorizado;
    }

    public void setVolumennaturalautorizado(BigDecimal volumennaturalautorizado) {
        this.volumennaturalautorizado = volumennaturalautorizado;
    }

    public BigDecimal getPrecioproducto() {
        return precioproducto;
    }

    public void setPrecioproducto(BigDecimal precioproducto) {
        this.precioproducto = precioproducto;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Medida getCodigomedida() {
        return codigomedida;
    }

    public void setCodigomedida(Medida codigomedida) {
        this.codigomedida = codigomedida;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallefacturaPK != null ? detallefacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefactura)) {
            return false;
        }
        Detallefactura other = (Detallefactura) object;
        if ((this.detallefacturaPK == null && other.detallefacturaPK != null) || (this.detallefacturaPK != null && !this.detallefacturaPK.equals(other.detallefacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Detallefactura[ detallefacturaPK=" + detallefacturaPK + " ]";
    }

}
