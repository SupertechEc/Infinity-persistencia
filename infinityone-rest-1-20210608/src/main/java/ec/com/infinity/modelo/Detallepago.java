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
@Table(name = "detallepago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallepago.findAll", query = "SELECT d FROM Detallepago d"),
    @NamedQuery(name = "Detallepago.findByCodigoabastecedora", query = "SELECT d FROM Detallepago d WHERE d.detallepagoPK.codigoabastecedora = :codigoabastecedora"),
    @NamedQuery(name = "Detallepago.findByCodigocomercializadora", query = "SELECT d FROM Detallepago d WHERE d.detallepagoPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Detallepago.findByNumeronotapedido", query = "SELECT d FROM Detallepago d WHERE d.detallepagoPK.numeronotapedido = :numeronotapedido"),
    @NamedQuery(name = "Detallepago.findByNumero", query = "SELECT d FROM Detallepago d WHERE d.detallepagoPK.numero = :numero"),
    @NamedQuery(name = "Detallepago.findByCodigobanco", query = "SELECT d FROM Detallepago d WHERE d.detallepagoPK.codigobanco = :codigobanco"),
    @NamedQuery(name = "Detallepago.findByNumerofactura", query = "SELECT d FROM Detallepago d WHERE d.detallepagoPK.numerofactura = :numerofactura"),
    @NamedQuery(name = "Detallepago.findByValor", query = "SELECT d FROM Detallepago d WHERE d.valor = :valor"),
    @NamedQuery(name = "Detallepago.findByActivo", query = "SELECT d FROM Detallepago d WHERE d.activo = :activo"),
    @NamedQuery(name = "Detallepago.findByUsuarioactual", query = "SELECT d FROM Detallepago d WHERE d.usuarioactual = :usuarioactual")})
public class Detallepago implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallepagoPK detallepagoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumns({
        @JoinColumn(name = "codigoabastecedora", referencedColumnName = "codigoabastecedora", insertable = false, updatable = false),
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "numeronotapedido", referencedColumnName = "numeronotapedido", insertable = false, updatable = false),
        @JoinColumn(name = "numerofactura", referencedColumnName = "numero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Factura factura;
    @JoinColumns({
        @JoinColumn(name = "codigoabastecedora", referencedColumnName = "codigoabastecedora", insertable = false, updatable = false),
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "numero", referencedColumnName = "numero", insertable = false, updatable = false),
        @JoinColumn(name = "codigobanco", referencedColumnName = "codigobanco", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pagofactura pagofactura;

    public Detallepago() {
    }

    public Detallepago(DetallepagoPK detallepagoPK) {
        this.detallepagoPK = detallepagoPK;
    }

    public Detallepago(DetallepagoPK detallepagoPK, BigDecimal valor, boolean activo, String usuarioactual) {
        this.detallepagoPK = detallepagoPK;
        this.valor = valor;
        this.activo = activo;
        this.usuarioactual = usuarioactual;
    }

    public Detallepago(String codigoabastecedora, String codigocomercializadora, String numeronotapedido, String numero, String codigobanco, String numerofactura) {
        this.detallepagoPK = new DetallepagoPK(codigoabastecedora, codigocomercializadora, numeronotapedido, numero, codigobanco, numerofactura);
    }

    public DetallepagoPK getDetallepagoPK() {
        return detallepagoPK;
    }

    public void setDetallepagoPK(DetallepagoPK detallepagoPK) {
        this.detallepagoPK = detallepagoPK;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public Pagofactura getPagofactura() {
        return pagofactura;
    }

    public void setPagofactura(Pagofactura pagofactura) {
        this.pagofactura = pagofactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallepagoPK != null ? detallepagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallepago)) {
            return false;
        }
        Detallepago other = (Detallepago) object;
        if ((this.detallepagoPK == null && other.detallepagoPK != null) || (this.detallepagoPK != null && !this.detallepagoPK.equals(other.detallepagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Detallepago[ detallepagoPK=" + detallepagoPK + " ]";
    }
    
}
