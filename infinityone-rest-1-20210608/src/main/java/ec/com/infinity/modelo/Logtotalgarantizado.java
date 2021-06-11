/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
 * @author Paul
 */
@Entity
@Table(name = "logtotalgarantizado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logtotalgarantizado.findAll", query = "SELECT l FROM Logtotalgarantizado l"),
    @NamedQuery(name = "Logtotalgarantizado.findByCodigocomercializadora", query = "SELECT l FROM Logtotalgarantizado l WHERE l.logtotalgarantizadoPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Logtotalgarantizado.findByCodigocliente", query = "SELECT l FROM Logtotalgarantizado l WHERE l.logtotalgarantizadoPK.codigocliente = :codigocliente"),
    @NamedQuery(name = "Logtotalgarantizado.findByFechaoperacion", query = "SELECT l FROM Logtotalgarantizado l WHERE l.logtotalgarantizadoPK.fechaoperacion = :fechaoperacion"),
    @NamedQuery(name = "Logtotalgarantizado.findByFactura", query = "SELECT l FROM Logtotalgarantizado l WHERE l.factura = :factura"),
    @NamedQuery(name = "Logtotalgarantizado.findByPago", query = "SELECT l FROM Logtotalgarantizado l WHERE l.pago = :pago"),
    @NamedQuery(name = "Logtotalgarantizado.findByGarantia", query = "SELECT l FROM Logtotalgarantizado l WHERE l.garantia = :garantia"),
    @NamedQuery(name = "Logtotalgarantizado.findByValordeuda", query = "SELECT l FROM Logtotalgarantizado l WHERE l.valordeuda = :valordeuda"),
    @NamedQuery(name = "Logtotalgarantizado.findByValorgarantizado", query = "SELECT l FROM Logtotalgarantizado l WHERE l.valorgarantizado = :valorgarantizado"),
    @NamedQuery(name = "Logtotalgarantizado.findBySecuencial", query = "SELECT l FROM Logtotalgarantizado l WHERE l.logtotalgarantizadoPK.secuencial = :secuencial"),
    @NamedQuery(name = "Logtotalgarantizado.findByUsuarioactual", query = "SELECT l FROM Logtotalgarantizado l WHERE l.usuarioactual = :usuarioactual")})
public class Logtotalgarantizado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LogtotalgarantizadoPK logtotalgarantizadoPK;
    @Size(max = 16)
    @Column(name = "factura")
    private String factura;
    @Size(max = 16)
    @Column(name = "pago")
    private String pago;
    @Size(max = 30)
    @Column(name = "garantia")
    private String garantia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valordeuda")
    private BigDecimal valordeuda;
    @Column(name = "valorgarantizado")
    private BigDecimal valorgarantizado;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;

    public Logtotalgarantizado() {
    }

    public Logtotalgarantizado(LogtotalgarantizadoPK logtotalgarantizadoPK) {
        this.logtotalgarantizadoPK = logtotalgarantizadoPK;
    }

    public Logtotalgarantizado(String codigocomercializadora, String codigocliente, Date fechaoperacion, int secuencial) {
        this.logtotalgarantizadoPK = new LogtotalgarantizadoPK(codigocomercializadora, codigocliente, fechaoperacion, secuencial);
    }

    public LogtotalgarantizadoPK getLogtotalgarantizadoPK() {
        return logtotalgarantizadoPK;
    }

    public void setLogtotalgarantizadoPK(LogtotalgarantizadoPK logtotalgarantizadoPK) {
        this.logtotalgarantizadoPK = logtotalgarantizadoPK;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public BigDecimal getValordeuda() {
        return valordeuda;
    }

    public void setValordeuda(BigDecimal valordeuda) {
        this.valordeuda = valordeuda;
    }

    public BigDecimal getValorgarantizado() {
        return valorgarantizado;
    }

    public void setValorgarantizado(BigDecimal valorgarantizado) {
        this.valorgarantizado = valorgarantizado;
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
        hash += (logtotalgarantizadoPK != null ? logtotalgarantizadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logtotalgarantizado)) {
            return false;
        }
        Logtotalgarantizado other = (Logtotalgarantizado) object;
        if ((this.logtotalgarantizadoPK == null && other.logtotalgarantizadoPK != null) || (this.logtotalgarantizadoPK != null && !this.logtotalgarantizadoPK.equals(other.logtotalgarantizadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Logtotalgarantizado[ logtotalgarantizadoPK=" + logtotalgarantizadoPK + " ]";
    }
    
}
