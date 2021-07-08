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
@Table(name = "detallenotapedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallenotapedido.findAll", query = "SELECT d FROM Detallenotapedido d"),
    @NamedQuery(name = "Detallenotapedido.findConCabecera", query = "SELECT d FROM Detallenotapedido d"),
    @NamedQuery(name = "Detallenotapedido.findByCodigoabastecedora", query = "SELECT d FROM Detallenotapedido d WHERE d.detallenotapedidoPK.codigoabastecedora = :codigoabastecedora"),
    @NamedQuery(name = "Detallenotapedido.findByCodigocomercializadora", query = "SELECT d FROM Detallenotapedido d WHERE d.detallenotapedidoPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Detallenotapedido.findByNumero", query = "SELECT d FROM Detallenotapedido d WHERE d.detallenotapedidoPK.numero = :numero"),
    @NamedQuery(name = "Detallenotapedido.findByCodigoproducto", query = "SELECT d FROM Detallenotapedido d WHERE d.detallenotapedidoPK.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Detallenotapedido.findByCodigomedida", query = "SELECT d FROM Detallenotapedido d WHERE d.detallenotapedidoPK.codigomedida = :codigomedida"),
    @NamedQuery(name = "Detallenotapedido.findByVolumennaturalrequerido", query = "SELECT d FROM Detallenotapedido d WHERE d.volumennaturalrequerido = :volumennaturalrequerido"),
    @NamedQuery(name = "Detallenotapedido.findByVolumennaturalautorizado", query = "SELECT d FROM Detallenotapedido d WHERE d.volumennaturalautorizado = :volumennaturalautorizado"),
    @NamedQuery(name = "Detallenotapedido.findByUsuarioactual", query = "SELECT d FROM Detallenotapedido d WHERE d.usuarioactual = :usuarioactual")})
public class Detallenotapedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallenotapedidoPK detallenotapedidoPK;
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
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    
    
    @JoinColumn(name = "codigomedida", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medida medida;
    @JoinColumn(name = "codigoproducto", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    
    
    @JoinColumns({
        @JoinColumn(name = "codigoabastecedora", referencedColumnName = "codigoabastecedora", insertable = false, updatable = false),
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "numero", referencedColumnName = "numero", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Notapedido notapedido;

    
    public Detallenotapedido() {
    }

    public Detallenotapedido(DetallenotapedidoPK detallenotapedidoPK) {
        this.detallenotapedidoPK = detallenotapedidoPK;
    }

    public Detallenotapedido(DetallenotapedidoPK detallenotapedidoPK, BigDecimal volumennaturalrequerido, BigDecimal volumennaturalautorizado, String usuarioactual) {
        this.detallenotapedidoPK = detallenotapedidoPK;
        this.volumennaturalrequerido = volumennaturalrequerido;
        this.volumennaturalautorizado = volumennaturalautorizado;
        this.usuarioactual = usuarioactual;
    }

    public Detallenotapedido(String codigoabastecedora, String codigocomercializadora, String numero, String codigoproducto, String codigomedida) {
        this.detallenotapedidoPK = new DetallenotapedidoPK(codigoabastecedora, codigocomercializadora, numero, codigoproducto, codigomedida);
    }

    public DetallenotapedidoPK getDetallenotapedidoPK() {
        return detallenotapedidoPK;
    }

    public void setDetallenotapedidoPK(DetallenotapedidoPK detallenotapedidoPK) {
        this.detallenotapedidoPK = detallenotapedidoPK;
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

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    
    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
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
        hash += (detallenotapedidoPK != null ? detallenotapedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallenotapedido)) {
            return false;
        }
        Detallenotapedido other = (Detallenotapedido) object;
        if ((this.detallenotapedidoPK == null && other.detallenotapedidoPK != null) || (this.detallenotapedidoPK != null && !this.detallenotapedidoPK.equals(other.detallenotapedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Detallenotapedido[ detallenotapedidoPK=" + detallenotapedidoPK + " ]";
    }
     
    /*
    public Notapedido getNotapedido() {
        return notapedido;
    }

    public void setNotapedido(Notapedido notapedido) {
        this.notapedido = notapedido;
    }
    */
}
