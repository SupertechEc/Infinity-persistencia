/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Paul
 */
@Entity
@Table(name = "totalgarantizado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Totalgarantizado.findAll", query = "SELECT t FROM Totalgarantizado t"),
    @NamedQuery(name = "Totalgarantizado.findByCodigocomercializadora", query = "SELECT t FROM Totalgarantizado t WHERE t.totalgarantizadoPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Totalgarantizado.findByCodigocliente", query = "SELECT t FROM Totalgarantizado t WHERE t.totalgarantizadoPK.codigocliente = :codigocliente"),
    @NamedQuery(name = "Totalgarantizado.findByTotaldeuda", query = "SELECT t FROM Totalgarantizado t WHERE t.totaldeuda = :totaldeuda"),
    @NamedQuery(name = "Totalgarantizado.findByTotalgarantizado", query = "SELECT t FROM Totalgarantizado t WHERE t.totalgarantizado = :totalgarantizado"),
    @NamedQuery(name = "Totalgarantizado.findByUsuarioactual", query = "SELECT t FROM Totalgarantizado t WHERE t.usuarioactual = :usuarioactual")})
public class Totalgarantizado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TotalgarantizadoPK totalgarantizadoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totaldeuda")
    private BigDecimal totaldeuda;
    @Column(name = "totalgarantizado")
    private BigDecimal totalgarantizado;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente_1 cliente;
    @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comercializadora_1 comercializadora;

    public Totalgarantizado() {
    }

    public Totalgarantizado(TotalgarantizadoPK totalgarantizadoPK) {
        this.totalgarantizadoPK = totalgarantizadoPK;
    }

    public Totalgarantizado(String codigocomercializadora, String codigocliente) {
        this.totalgarantizadoPK = new TotalgarantizadoPK(codigocomercializadora, codigocliente);
    }

    public TotalgarantizadoPK getTotalgarantizadoPK() {
        return totalgarantizadoPK;
    }

    public void setTotalgarantizadoPK(TotalgarantizadoPK totalgarantizadoPK) {
        this.totalgarantizadoPK = totalgarantizadoPK;
    }

    public BigDecimal getTotaldeuda() {
        return totaldeuda;
    }

    public void setTotaldeuda(BigDecimal totaldeuda) {
        this.totaldeuda = totaldeuda;
    }

    public BigDecimal getTotalgarantizado() {
        return totalgarantizado;
    }

    public void setTotalgarantizado(BigDecimal totalgarantizado) {
        this.totalgarantizado = totalgarantizado;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Cliente_1 getCliente() {
        return cliente;
    }

    public void setCliente(Cliente_1 cliente) {
        this.cliente = cliente;
    }

    public Comercializadora_1 getComercializadora() {
        return comercializadora;
    }

    public void setComercializadora(Comercializadora_1 comercializadora) {
        this.comercializadora = comercializadora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (totalgarantizadoPK != null ? totalgarantizadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Totalgarantizado)) {
            return false;
        }
        Totalgarantizado other = (Totalgarantizado) object;
        if ((this.totalgarantizadoPK == null && other.totalgarantizadoPK != null) || (this.totalgarantizadoPK != null && !this.totalgarantizadoPK.equals(other.totalgarantizadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Totalgarantizado[ totalgarantizadoPK=" + totalgarantizadoPK + " ]";
    }
    
}
