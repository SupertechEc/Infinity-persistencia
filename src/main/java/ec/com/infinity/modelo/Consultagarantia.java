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
@Table(name = "consultagarantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultagarantia.findAll", query = "SELECT c FROM Consultagarantia c"),
    @NamedQuery(name = "Consultagarantia.findByCodigocomercializadora", query = "SELECT c FROM Consultagarantia c WHERE c.consultagarantiaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Consultagarantia.findByFecharecepcion", query = "SELECT c FROM Consultagarantia c WHERE c.consultagarantiaPK.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Consultagarantia.findByCodigomoneda", query = "SELECT c FROM Consultagarantia c WHERE c.codigomoneda = :codigomoneda"),
    @NamedQuery(name = "Consultagarantia.findByValorcomercializadora", query = "SELECT c FROM Consultagarantia c WHERE c.valorcomercializadora = :valorcomercializadora"),
    @NamedQuery(name = "Consultagarantia.findBySumaavalizada", query = "SELECT c FROM Consultagarantia c WHERE c.sumaavalizada = :sumaavalizada"),
    @NamedQuery(name = "Consultagarantia.findByGarantia98", query = "SELECT c FROM Consultagarantia c WHERE c.garantia98 = :garantia98"),
    @NamedQuery(name = "Consultagarantia.findBySaldo", query = "SELECT c FROM Consultagarantia c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "Consultagarantia.findBySaldodisponible", query = "SELECT c FROM Consultagarantia c WHERE c.saldodisponible = :saldodisponible"),
    @NamedQuery(name = "Consultagarantia.findByPorcentajeuso", query = "SELECT c FROM Consultagarantia c WHERE c.porcentajeuso = :porcentajeuso"),
    @NamedQuery(name = "Consultagarantia.findByUsuarioactual", query = "SELECT c FROM Consultagarantia c WHERE c.usuarioactual = :usuarioactual")})
public class Consultagarantia implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigomoneda")
    private String codigomoneda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorcomercializadora")
    private BigDecimal valorcomercializadora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sumaavalizada")
    private BigDecimal sumaavalizada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "garantia98")
    private BigDecimal garantia98;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldodisponible")
    private BigDecimal saldodisponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentajeuso")
    private BigDecimal porcentajeuso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultagarantiaPK consultagarantiaPK;

    public Consultagarantia() {
    }

    public Consultagarantia(ConsultagarantiaPK consultagarantiaPK) {
        this.consultagarantiaPK = consultagarantiaPK;
    }

    public Consultagarantia(ConsultagarantiaPK consultagarantiaPK, String codigomoneda, BigDecimal valorcomercializadora, BigDecimal sumaavalizada, BigDecimal garantia98, BigDecimal saldo, BigDecimal saldodisponible, BigDecimal porcentajeuso) {
        this.consultagarantiaPK = consultagarantiaPK;
        this.codigomoneda = codigomoneda;
        this.valorcomercializadora = valorcomercializadora;
        this.sumaavalizada = sumaavalizada;
        this.garantia98 = garantia98;
        this.saldo = saldo;
        this.saldodisponible = saldodisponible;
        this.porcentajeuso = porcentajeuso;
    }

    public Consultagarantia(String codigocomercializadora, Date fecharecepcion) {
        this.consultagarantiaPK = new ConsultagarantiaPK(codigocomercializadora, fecharecepcion);
    }

    public ConsultagarantiaPK getConsultagarantiaPK() {
        return consultagarantiaPK;
    }

    public void setConsultagarantiaPK(ConsultagarantiaPK consultagarantiaPK) {
        this.consultagarantiaPK = consultagarantiaPK;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultagarantiaPK != null ? consultagarantiaPK.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultagarantia)) {
            return false;
        }
        Consultagarantia other = (Consultagarantia) object;
        if ((this.consultagarantiaPK == null && other.consultagarantiaPK != null) || (this.consultagarantiaPK != null && !this.consultagarantiaPK.equals(other.consultagarantiaPK))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Consultagarantia[ consultagarantiaPK=" + consultagarantiaPK + " ]";
    }

    public String getCodigomoneda() {
        return codigomoneda;
    }

    public void setCodigomoneda(String codigomoneda) {
        this.codigomoneda = codigomoneda;
    }

    public BigDecimal getValorcomercializadora() {
        return valorcomercializadora;
    }

    public void setValorcomercializadora(BigDecimal valorcomercializadora) {
        this.valorcomercializadora = valorcomercializadora;
    }

    public BigDecimal getSumaavalizada() {
        return sumaavalizada;
    }

    public void setSumaavalizada(BigDecimal sumaavalizada) {
        this.sumaavalizada = sumaavalizada;
    }

    public BigDecimal getGarantia98() {
        return garantia98;
    }

    public void setGarantia98(BigDecimal garantia98) {
        this.garantia98 = garantia98;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldodisponible() {
        return saldodisponible;
    }

    public void setSaldodisponible(BigDecimal saldodisponible) {
        this.saldodisponible = saldodisponible;
    }

    public BigDecimal getPorcentajeuso() {
        return porcentajeuso;
    }

    public void setPorcentajeuso(BigDecimal porcentajeuso) {
        this.porcentajeuso = porcentajeuso;
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
    
}
