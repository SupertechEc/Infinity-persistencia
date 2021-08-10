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
@Table(name = "detallefacturarubrotercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefacturarubrotercero.findAll", query = "SELECT d FROM Detallefacturarubrotercero d"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByCodigoabastecedora", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.detallefacturarubroterceroPK.codigoabastecedora = :codigoabastecedora"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByCodigocomercializadora", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.detallefacturarubroterceroPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByNumeronotapedido", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.detallefacturarubroterceroPK.numeronotapedido = :numeronotapedido"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByNumerofactura", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.detallefacturarubroterceroPK.numerofactura = :numerofactura"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByCodigorubrotercero", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.detallefacturarubroterceroPK.codigorubrotercero = :codigorubrotercero"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByCodigoclientecuota", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.detallefacturarubroterceroPK.codigoclientecuota = :codigoclientecuota"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByCuota", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.detallefacturarubroterceroPK.cuota = :cuota"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByValorcuota", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.valorcuota = :valorcuota"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByFechacobroreal", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.fechacobroreal = :fechacobroreal"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByFechacobrocuota", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.fechacobrocuota = :fechacobrocuota"),
    @NamedQuery(name = "Detallefacturarubrotercero.findByUsuarioactual", query = "SELECT d FROM Detallefacturarubrotercero d WHERE d.usuarioactual = :usuarioactual")})
public class Detallefacturarubrotercero implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallefacturarubroterceroPK detallefacturarubroterceroPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorcuota")
    private BigDecimal valorcuota;
    @Column(name = "fechacobroreal")
    @Temporal(TemporalType.DATE)
    private Date fechacobroreal;
    @Column(name = "fechacobrocuota")
    @Temporal(TemporalType.DATE)
    private Date fechacobrocuota;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;

    public Detallefacturarubrotercero() {
    }

    public Detallefacturarubrotercero(DetallefacturarubroterceroPK detallefacturarubroterceroPK) {
        this.detallefacturarubroterceroPK = detallefacturarubroterceroPK;
    }

    public Detallefacturarubrotercero(String codigoabastecedora, String codigocomercializadora, String numeronotapedido, String numerofactura, long codigorubrotercero, String codigoclientecuota, int cuota) {
        this.detallefacturarubroterceroPK = new DetallefacturarubroterceroPK(codigoabastecedora, codigocomercializadora, numeronotapedido, numerofactura, codigorubrotercero, codigoclientecuota, cuota);
    }

    public DetallefacturarubroterceroPK getDetallefacturarubroterceroPK() {
        return detallefacturarubroterceroPK;
    }

    public void setDetallefacturarubroterceroPK(DetallefacturarubroterceroPK detallefacturarubroterceroPK) {
        this.detallefacturarubroterceroPK = detallefacturarubroterceroPK;
    }

    public BigDecimal getValorcuota() {
        return valorcuota;
    }

    public void setValorcuota(BigDecimal valorcuota) {
        this.valorcuota = valorcuota;
    }

    public Date getFechacobroreal() {
        return fechacobroreal;
    }

    public void setFechacobroreal(Date fechacobroreal) {
        this.fechacobroreal = fechacobroreal;
    }

    public Date getFechacobrocuota() {
        return fechacobrocuota;
    }

    public void setFechacobrocuota(Date fechacobrocuota) {
        this.fechacobrocuota = fechacobrocuota;
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
        hash += (detallefacturarubroterceroPK != null ? detallefacturarubroterceroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefacturarubrotercero)) {
            return false;
        }
        Detallefacturarubrotercero other = (Detallefacturarubrotercero) object;
        if ((this.detallefacturarubroterceroPK == null && other.detallefacturarubroterceroPK != null) || (this.detallefacturarubroterceroPK != null && !this.detallefacturarubroterceroPK.equals(other.detallefacturarubroterceroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Detallefacturarubrotercero[ detallefacturarubroterceroPK=" + detallefacturarubroterceroPK + " ]";
    }
    
}
