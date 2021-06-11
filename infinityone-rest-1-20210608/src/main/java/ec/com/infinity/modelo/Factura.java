/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByCodigoabastecedora", query = "SELECT f FROM Factura f WHERE f.facturaPK.codigoabastecedora = :codigoabastecedora"),
    @NamedQuery(name = "Factura.findByCodigocomercializadora", query = "SELECT f FROM Factura f WHERE f.facturaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Factura.findByNumeronotapedido", query = "SELECT f FROM Factura f WHERE f.facturaPK.numeronotapedido = :numeronotapedido"),
    @NamedQuery(name = "Factura.findByNumero", query = "SELECT f FROM Factura f WHERE f.facturaPK.numero = :numero"),
    @NamedQuery(name = "Factura.findByFechaventa", query = "SELECT f FROM Factura f WHERE f.fechaventa = :fechaventa"),
    @NamedQuery(name = "Factura.findByFechavencimiento", query = "SELECT f FROM Factura f WHERE f.fechavencimiento = :fechavencimiento"),
    @NamedQuery(name = "Factura.findByFechaacreditacion", query = "SELECT f FROM Factura f WHERE f.fechaacreditacion = :fechaacreditacion"),
    @NamedQuery(name = "Factura.findByFechadespacho", query = "SELECT f FROM Factura f WHERE f.fechadespacho = :fechadespacho"),
    @NamedQuery(name = "Factura.findByActiva", query = "SELECT f FROM Factura f WHERE f.activa = :activa"),
    @NamedQuery(name = "Factura.findByValortotal", query = "SELECT f FROM Factura f WHERE f.valortotal = :valortotal"),
    @NamedQuery(name = "Factura.findByIvatotal", query = "SELECT f FROM Factura f WHERE f.ivatotal = :ivatotal"),
    @NamedQuery(name = "Factura.findByObservacion", query = "SELECT f FROM Factura f WHERE f.observacion = :observacion"),
    @NamedQuery(name = "Factura.findByPagada", query = "SELECT f FROM Factura f WHERE f.pagada = :pagada"),
    @NamedQuery(name = "Factura.findByOeenpetro", query = "SELECT f FROM Factura f WHERE f.oeenpetro = :oeenpetro"),
    @NamedQuery(name = "Factura.findByCodigocliente", query = "SELECT f FROM Factura f WHERE f.codigocliente = :codigocliente"),
    @NamedQuery(name = "Factura.findByCodigoterminal", query = "SELECT f FROM Factura f WHERE f.codigoterminal = :codigoterminal"),
    @NamedQuery(name = "Factura.findByCodigobanco", query = "SELECT f FROM Factura f WHERE f.codigobanco = :codigobanco"),
    @NamedQuery(name = "Factura.findByAdelantar", query = "SELECT f FROM Factura f WHERE f.adelantar = :adelantar"),
    @NamedQuery(name = "Factura.findByUsuarioactual", query = "SELECT f FROM Factura f WHERE f.usuarioactual = :usuarioactual")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaPK facturaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaventa")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechavencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaacreditacion")
    @Temporal(TemporalType.DATE)
    private Date fechaacreditacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechadespacho")
    @Temporal(TemporalType.DATE)
    private Date fechadespacho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activa")
    private boolean activa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valortotal")
    private BigDecimal valortotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivatotal")
    private BigDecimal ivatotal;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagada")
    private boolean pagada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oeenpetro")
    private boolean oeenpetro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigocliente")
    private String codigocliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigoterminal")
    private String codigoterminal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigobanco")
    private String codigobanco;
    @Column(name = "adelantar")
    private Boolean adelantar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Detallepago> detallepagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Detallefactura> detallefacturaList;

    public Factura() {
    }

    public Factura(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
    }

    public Factura(FacturaPK facturaPK, Date fechaventa, Date fechavencimiento, Date fechaacreditacion, Date fechadespacho, boolean activa, BigDecimal valortotal, BigDecimal ivatotal, boolean pagada, boolean oeenpetro, String codigocliente, String codigoterminal, String codigobanco, String usuarioactual) {
        this.facturaPK = facturaPK;
        this.fechaventa = fechaventa;
        this.fechavencimiento = fechavencimiento;
        this.fechaacreditacion = fechaacreditacion;
        this.fechadespacho = fechadespacho;
        this.activa = activa;
        this.valortotal = valortotal;
        this.ivatotal = ivatotal;
        this.pagada = pagada;
        this.oeenpetro = oeenpetro;
        this.codigocliente = codigocliente;
        this.codigoterminal = codigoterminal;
        this.codigobanco = codigobanco;
        this.usuarioactual = usuarioactual;
    }

    public Factura(String codigoabastecedora, String codigocomercializadora, String numeronotapedido, String numero) {
        this.facturaPK = new FacturaPK(codigoabastecedora, codigocomercializadora, numeronotapedido, numero);
    }

    public FacturaPK getFacturaPK() {
        return facturaPK;
    }

    public void setFacturaPK(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
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

    public Date getFechaacreditacion() {
        return fechaacreditacion;
    }

    public void setFechaacreditacion(Date fechaacreditacion) {
        this.fechaacreditacion = fechaacreditacion;
    }

    public Date getFechadespacho() {
        return fechadespacho;
    }

    public void setFechadespacho(Date fechadespacho) {
        this.fechadespacho = fechadespacho;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public BigDecimal getIvatotal() {
        return ivatotal;
    }

    public void setIvatotal(BigDecimal ivatotal) {
        this.ivatotal = ivatotal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean getPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public boolean getOeenpetro() {
        return oeenpetro;
    }

    public void setOeenpetro(boolean oeenpetro) {
        this.oeenpetro = oeenpetro;
    }

    public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }

    public String getCodigoterminal() {
        return codigoterminal;
    }

    public void setCodigoterminal(String codigoterminal) {
        this.codigoterminal = codigoterminal;
    }

    public String getCodigobanco() {
        return codigobanco;
    }

    public void setCodigobanco(String codigobanco) {
        this.codigobanco = codigobanco;
    }

    public Boolean getAdelantar() {
        return adelantar;
    }

    public void setAdelantar(Boolean adelantar) {
        this.adelantar = adelantar;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    @XmlTransient
    public List<Detallepago> getDetallepagoList() {
        return detallepagoList;
    }

    public void setDetallepagoList(List<Detallepago> detallepagoList) {
        this.detallepagoList = detallepagoList;
    }

    @XmlTransient
    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaPK != null ? facturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturaPK == null && other.facturaPK != null) || (this.facturaPK != null && !this.facturaPK.equals(other.facturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Factura[ facturaPK=" + facturaPK + " ]";
    }
    
}
