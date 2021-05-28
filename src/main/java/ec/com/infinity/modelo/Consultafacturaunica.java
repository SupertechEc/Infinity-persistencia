/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "consultafacturaunica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultafacturaunica.findAll", query = "SELECT c FROM Consultafacturaunica c"),
    @NamedQuery(name = "Consultafacturaunica.findByCodigocomercializadora", query = "SELECT c FROM Consultafacturaunica c WHERE c.consultafacturaunicaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Consultafacturaunica.findByNumerofactura", query = "SELECT c FROM Consultafacturaunica c WHERE c.consultafacturaunicaPK.numerofactura = :numerofactura"),
    @NamedQuery(name = "Consultafacturaunica.findByNumerosri", query = "SELECT c FROM Consultafacturaunica c WHERE c.numerosri = :numerosri"),
    @NamedQuery(name = "Consultafacturaunica.findByCodigobanco", query = "SELECT c FROM Consultafacturaunica c WHERE c.codigobanco = :codigobanco"),
    @NamedQuery(name = "Consultafacturaunica.findByFecharecepcion", query = "SELECT c FROM Consultafacturaunica c WHERE c.consultafacturaunicaPK.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Consultafacturaunica.findByFecha", query = "SELECT c FROM Consultafacturaunica c WHERE c.consultafacturaunicaPK.fecha = :fecha"),
    @NamedQuery(name = "Consultafacturaunica.findByFechavencimiento", query = "SELECT c FROM Consultafacturaunica c WHERE c.fechavencimiento = :fechavencimiento"),
    @NamedQuery(name = "Consultafacturaunica.findByFechaguia", query = "SELECT c FROM Consultafacturaunica c WHERE c.fechaguia = :fechaguia"),
    @NamedQuery(name = "Consultafacturaunica.findByEstadofactura", query = "SELECT c FROM Consultafacturaunica c WHERE c.estadofactura = :estadofactura"),
    @NamedQuery(name = "Consultafacturaunica.findByEstadopago", query = "SELECT c FROM Consultafacturaunica c WHERE c.estadopago = :estadopago"),
    @NamedQuery(name = "Consultafacturaunica.findByUsuarioactual", query = "SELECT c FROM Consultafacturaunica c WHERE c.usuarioactual = :usuarioactual")})
public class Consultafacturaunica implements Serializable {

    @Column(name = "numerosri")
    private String numerosri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigobanco")
    private String codigobanco;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "fechavencimiento")
    private String fechavencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaguia")
    private String fechaguia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadofactura")
    private String estadofactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadopago")
    private String estadopago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "usuarioactual")
    private String usuarioactual;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultafacturaunicaPK consultafacturaunicaPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultafacturaunica")
    private List<Detalleconsultafacturaunica> detalleconsultafacturaunicaList;

    public Consultafacturaunica() {
    }

    public Consultafacturaunica(ConsultafacturaunicaPK consultafacturaunicaPK) {
        this.consultafacturaunicaPK = consultafacturaunicaPK;
    }

    public Consultafacturaunica(ConsultafacturaunicaPK consultafacturaunicaPK, String codigobanco, String fechavencimiento, String fechaguia, String estadofactura, String estadopago) {
        this.consultafacturaunicaPK = consultafacturaunicaPK;
        this.codigobanco = codigobanco;
        this.fechavencimiento = fechavencimiento;
        this.fechaguia = fechaguia;
        this.estadofactura = estadofactura;
        this.estadopago = estadopago;
    }

    public Consultafacturaunica(String codigocomercializadora, String numerofactura, Date fecharecepcion, String fecha) {
        this.consultafacturaunicaPK = new ConsultafacturaunicaPK(codigocomercializadora, numerofactura, fecharecepcion, fecha);
    }

    public ConsultafacturaunicaPK getConsultafacturaunicaPK() {
        return consultafacturaunicaPK;
    }

    public void setConsultafacturaunicaPK(ConsultafacturaunicaPK consultafacturaunicaPK) {
        this.consultafacturaunicaPK = consultafacturaunicaPK;
    }

    @XmlTransient
    public List<Detalleconsultafacturaunica> getDetalleconsultafacturaunicaList() {
        return detalleconsultafacturaunicaList;
    }

    public void setDetalleconsultafacturaunicaList(List<Detalleconsultafacturaunica> detalleconsultafacturaunicaList) {
        this.detalleconsultafacturaunicaList = detalleconsultafacturaunicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultafacturaunicaPK != null ? consultafacturaunicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultafacturaunica)) {
            return false;
        }
        Consultafacturaunica other = (Consultafacturaunica) object;
        if ((this.consultafacturaunicaPK == null && other.consultafacturaunicaPK != null) || (this.consultafacturaunicaPK != null && !this.consultafacturaunicaPK.equals(other.consultafacturaunicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultafacturaunica{" + "numerosri=" + numerosri + ", codigobanco=" + codigobanco + ", fechavencimiento=" + fechavencimiento + ", fechaguia=" + fechaguia + ", estadofactura=" + estadofactura + ", estadopago=" + estadopago + ", activo=" + activo + ", usuarioactual=" + usuarioactual + ", consultafacturaunicaPK=" + consultafacturaunicaPK + ", detalleconsultafacturaunicaList=" + detalleconsultafacturaunicaList + '}';
    }

    public String getNumerosri() {
        return numerosri;
    }

    public void setNumerosri(String numerosri) {
        this.numerosri = numerosri;
    }

    public String getCodigobanco() {
        return codigobanco;
    }

    public void setCodigobanco(String codigobanco) {
        this.codigobanco = codigobanco;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getFechaguia() {
        return fechaguia;
    }

    public void setFechaguia(String fechaguia) {
        this.fechaguia = fechaguia;
    }

    public String getEstadofactura() {
        return estadofactura;
    }

    public void setEstadofactura(String estadofactura) {
        this.estadofactura = estadofactura;
    }

    public String getEstadopago() {
        return estadopago;
    }

    public void setEstadopago(String estadopago) {
        this.estadopago = estadopago;
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
