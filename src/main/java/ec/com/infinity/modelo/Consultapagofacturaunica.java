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
@Table(name = "consultapagofacturaunica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultapagofacturaunica.findAll", query = "SELECT c FROM Consultapagofacturaunica c"),
    @NamedQuery(name = "Consultapagofacturaunica.findByCodigocomercializadora", query = "SELECT c FROM Consultapagofacturaunica c WHERE c.consultapagofacturaunicaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Consultapagofacturaunica.findByNumerofacturaunica", query = "SELECT c FROM Consultapagofacturaunica c WHERE c.consultapagofacturaunicaPK.numerofacturaunica = :numerofacturaunica"),
    @NamedQuery(name = "Consultapagofacturaunica.findByFecha", query = "SELECT c FROM Consultapagofacturaunica c WHERE c.consultapagofacturaunicaPK.fecha = :fecha"),
    @NamedQuery(name = "Consultapagofacturaunica.findByFecharecepcion", query = "SELECT c FROM Consultapagofacturaunica c WHERE c.consultapagofacturaunicaPK.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Consultapagofacturaunica.findByValorfacturaunica", query = "SELECT c FROM Consultapagofacturaunica c WHERE c.valorfacturaunica = :valorfacturaunica"),
    @NamedQuery(name = "Consultapagofacturaunica.findByValorpago", query = "SELECT c FROM Consultapagofacturaunica c WHERE c.valorpago = :valorpago"),
    @NamedQuery(name = "Consultapagofacturaunica.findByUsuarioactual", query = "SELECT c FROM Consultapagofacturaunica c WHERE c.usuarioactual = :usuarioactual")})
public class Consultapagofacturaunica implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultapagofacturaunicaPK consultapagofacturaunicaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorfacturaunica")
    private BigDecimal valorfacturaunica;
    @Column(name = "valorpago")
    private BigDecimal valorpago;

    public Consultapagofacturaunica() {
    }

    public Consultapagofacturaunica(ConsultapagofacturaunicaPK consultapagofacturaunicaPK) {
        this.consultapagofacturaunicaPK = consultapagofacturaunicaPK;
    }

    public Consultapagofacturaunica(String codigocomercializadora, String numerofacturaunica, String fecha, Date fecharecepcion) {
        this.consultapagofacturaunicaPK = new ConsultapagofacturaunicaPK(codigocomercializadora, numerofacturaunica, fecha, fecharecepcion);
    }

    public ConsultapagofacturaunicaPK getConsultapagofacturaunicaPK() {
        return consultapagofacturaunicaPK;
    }

    public void setConsultapagofacturaunicaPK(ConsultapagofacturaunicaPK consultapagofacturaunicaPK) {
        this.consultapagofacturaunicaPK = consultapagofacturaunicaPK;
    }

    public BigDecimal getValorfacturaunica() {
        return valorfacturaunica;
    }

    public void setValorfacturaunica(BigDecimal valorfacturaunica) {
        this.valorfacturaunica = valorfacturaunica;
    }

    public BigDecimal getValorpago() {
        return valorpago;
    }

    public void setValorpago(BigDecimal valorpago) {
        this.valorpago = valorpago;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultapagofacturaunicaPK != null ? consultapagofacturaunicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultapagofacturaunica)) {
            return false;
        }
        Consultapagofacturaunica other = (Consultapagofacturaunica) object;
        if ((this.consultapagofacturaunicaPK == null && other.consultapagofacturaunicaPK != null) || (this.consultapagofacturaunicaPK != null && !this.consultapagofacturaunicaPK.equals(other.consultapagofacturaunicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Consultapagofacturaunica[ consultapagofacturaunicaPK=" + consultapagofacturaunicaPK + " ]";
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
