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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Tapia
 */
@Entity
@Table(name = "temporalparacobrar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporalparacobrar.findAll", query = "SELECT t FROM Temporalparacobrar t"),
    @NamedQuery(name = "Temporalparacobrar.findByFechahoraproceso", query = "SELECT t FROM Temporalparacobrar t WHERE t.temporalparacobrarPK.fechahoraproceso = :fechahoraproceso"),
    @NamedQuery(name = "Temporalparacobrar.DeleteByFechahoraproceso", query = "DELETE FROM Temporalparacobrar t WHERE t.temporalparacobrarPK.fechahoraproceso = :fechahoraproceso "
            + "and t.temporalparacobrarPK.usuarioactual = :usuarioactual "
            + "and t.temporalparacobrarPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Temporalparacobrar.findByUsuarioactual", query = "SELECT t FROM Temporalparacobrar t WHERE t.temporalparacobrarPK.usuarioactual = :usuarioactual"),
    @NamedQuery(name = "Temporalparacobrar.findByCodigocomercializadora", query = "SELECT t FROM Temporalparacobrar t WHERE t.temporalparacobrarPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Temporalparacobrar.findByNumerofactura", query = "SELECT t FROM Temporalparacobrar t WHERE t.temporalparacobrarPK.numerofactura = :numerofactura"),
    @NamedQuery(name = "Temporalparacobrar.findByCodigobanco", query = "SELECT t FROM Temporalparacobrar t WHERE t.codigobanco = :codigobanco"),
    @NamedQuery(name = "Temporalparacobrar.findByFechaventa", query = "SELECT t FROM Temporalparacobrar t WHERE t.fechaventa = :fechaventa"),
    @NamedQuery(name = "Temporalparacobrar.findByFechavencimiento", query = "SELECT t FROM Temporalparacobrar t WHERE t.fechavencimiento = :fechavencimiento"),
    @NamedQuery(name = "Temporalparacobrar.findByValortotal", query = "SELECT t FROM Temporalparacobrar t WHERE t.valortotal = :valortotal"),
    @NamedQuery(name = "Temporalparacobrar.findByValorconrubro", query = "SELECT t FROM Temporalparacobrar t WHERE t.valorconrubro = :valorconrubro"),
    @NamedQuery(name = "Temporalparacobrar.findByCodigocliente", query = "SELECT t FROM Temporalparacobrar t WHERE t.codigocliente = :codigocliente")})
public class Temporalparacobrar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TemporalparacobrarPK temporalparacobrarPK;
    @Size(max = 2)
    @Column(name = "codigobanco")
    private String codigobanco;
    @Column(name = "fechaventa")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valortotal")
    private BigDecimal valortotal;
    @Column(name = "valorconrubro")
    private BigDecimal valorconrubro;
    @Size(max = 8)
    @Column(name = "codigocliente")
    private String codigocliente;

    public Temporalparacobrar() {
    }

    public Temporalparacobrar(TemporalparacobrarPK temporalparacobrarPK) {
        this.temporalparacobrarPK = temporalparacobrarPK;
    }

    public Temporalparacobrar(String fechahoraproceso, String usuarioactual, String codigocomercializadora, String numerofactura) {
        this.temporalparacobrarPK = new TemporalparacobrarPK(fechahoraproceso, usuarioactual, codigocomercializadora, numerofactura);
    }

    public TemporalparacobrarPK getTemporalparacobrarPK() {
        return temporalparacobrarPK;
    }

    public void setTemporalparacobrarPK(TemporalparacobrarPK temporalparacobrarPK) {
        this.temporalparacobrarPK = temporalparacobrarPK;
    }

    public String getCodigobanco() {
        return codigobanco;
    }

    public void setCodigobanco(String codigobanco) {
        this.codigobanco = codigobanco;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public BigDecimal getValorconrubro() {
        return valorconrubro;
    }

    public void setValorconrubro(BigDecimal valorconrubro) {
        this.valorconrubro = valorconrubro;
    }

    public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (temporalparacobrarPK != null ? temporalparacobrarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporalparacobrar)) {
            return false;
        }
        Temporalparacobrar other = (Temporalparacobrar) object;
        if ((this.temporalparacobrarPK == null && other.temporalparacobrarPK != null) || (this.temporalparacobrarPK != null && !this.temporalparacobrarPK.equals(other.temporalparacobrarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Temporalparacobrar[ temporalparacobrarPK=" + temporalparacobrarPK + " ]";
    }
    
}
