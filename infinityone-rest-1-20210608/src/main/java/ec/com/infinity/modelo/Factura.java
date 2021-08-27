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
import javax.persistence.FetchType;
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
    @NamedQuery(name = "Factura.findForVenta",    query = "SELECT n FROM Factura n WHERE n.facturaPK.codigoabastecedora = :codigoabastecedora and n.facturaPK.codigocomercializadora = :codigocomercializadora and n.codigoterminal = :codigoterminal and n.fechaventa = :fecha"),
    @NamedQuery(name = "Factura.mejorCliente",    query = "select n.nombrecliente as nomcliente, count (DISTINCT n.nombrecliente) as facturas, sum(n.valortotal) as sumatotal from Factura n where n.activa = :activo group by n.nombrecliente order by sumatotal desc"),
    @NamedQuery(name = "Factura.findForDespacho", query = "SELECT n FROM Factura n WHERE n.facturaPK.codigoabastecedora = :codigoabastecedora and n.facturaPK.codigocomercializadora = :codigocomercializadora and n.codigoterminal = :codigoterminal and n.fechadespacho = :fecha"),
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
    @NamedQuery(name = "Factura.findBySeriesri", query = "SELECT f FROM Factura f WHERE f.seriesri = :seriesri"),
    @NamedQuery(name = "Factura.findByPagarFVenta", query = "SELECT f FROM Factura f WHERE f.fechaventa = :fechaventa and "
             + " f.facturaPK.codigocomercializadora = :codigocomercializadora and"
            + " f.oeenpetro = :oeenpetro and"
            + " f.activa = :activa and"
            + " f.pagada = :pagada"
            + " order by f.codigobanco, f.fechaventa, f.fechavencimiento"),
    @NamedQuery(name = "Factura.findByPagarFVencimiento", query = "SELECT f FROM Factura f WHERE f.fechavencimiento = :fechavencimiento and"
             + " f.facturaPK.codigocomercializadora = :codigocomercializadora and"
            + " f.oeenpetro = :oeenpetro and"
            + " f.activa = :activa and"
            + " f.pagada = :pagada"
            + " order by f.codigobanco, f.fechaventa, f.fechavencimiento"),
    @NamedQuery(name = "Factura.findByUsuarioactual", query = "SELECT f FROM Factura f WHERE f.usuarioactual = :usuarioactual")})

public class Factura implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagada")
    private boolean pagada;
    @Basic(optional = false)
    @NotNull()
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @Size(max = 100)
    @Column(name = "nombrecomercializadora")
    private String nombrecomercializadora;
    @Size(max = 13)
    @Column(name = "ruccomercializadora")
    private String ruccomercializadora;
    @Size(max = 100)
    @Column(name = "direccionmatrizcomercializadora")
    private String direccionmatrizcomercializadora;
    @Size(max = 100)
    @Column(name = "nombrecliente")
    private String nombrecliente;
    @Size(max = 13)
    @Column(name = "ruccliente")
    private String ruccliente;
    @Column(name = "valorsinimpuestos")
    private BigDecimal valorsinimpuestos;
    @Size(max = 300)
    @Column(name = "correocliente")
    private String correocliente;
    @Size(max = 300)
    @Column(name = "direccioncliente")
    private String direccioncliente;
    @Size(max = 50)
    @Column(name = "telefonocliente")
    private String telefonocliente;
    @Size(max = 49)
    @Column(name = "numeroautorizacion")
    private String numeroautorizacion;
    @Size(max = 29)
    @Column(name = "fechaautorizacion")
    private String fechaautorizacion;
    @Size(max = 2)
    @Column(name = "clienteformapago")
    private String clienteformapago;
    @Size(max = 3)
    @Column(name = "tipoplazocredito")
    private String tipoplazocredito;
    @Column(name = "plazocliente")
    private Integer plazocliente;
    @Size(max = 49)
    @Column(name = "claveacceso")
    private String claveacceso;
    @Size(max = 300)
    @Column(name = "campoadicional_campo1")
    private String campoadicionalCampo1;
    @Size(max = 300)
    @Column(name = "campoadicional_campo2")
    private String campoadicionalCampo2;
    @Size(max = 300)
    @Column(name = "campoadicional_campo3")
    private String campoadicionalCampo3;
    @Size(max = 300)
    @Column(name = "campoadicional_campo4")
    private String campoadicionalCampo4;
    @Size(max = 300)
    @Column(name = "campoadicional_campo5")
    private String campoadicionalCampo5;
    @Size(max = 300)
    @Column(name = "campoadicional_campo6")
    private String campoadicionalCampo6;
    @Size(max = 25)
    @Column(name = "estado")
    private String estado;
    @Column(name = "errordocumento")
    private Short errordocumento;
    @Column(name = "hospedado")
    private Short hospedado;
    @Column(name = "ambientesri")
    private Character ambientesri;
    @Column(name = "tipoemision")
    private Character tipoemision;
    @Size(max = 2)
    @Column(name = "codigodocumento")
    private String codigodocumento;
    @Column(name = "esagenteretencion")
    private Boolean esagenteretencion;
    @Size(max = 6)
    @Column(name = "escontribuyenteespacial")
    private String escontribuyenteespacial;
    @Size(max = 2)
    @Column(name = "obligadocontabilidad")
    private String obligadocontabilidad;
    @Size(max = 2)
    @Column(name = "tipocomprador")
    private String tipocomprador;
    @Size(max = 10)
    @Column(name = "moneda")
    private String moneda;
    @Size(max = 6)
    @Column(name = "seriesri")
    private String seriesri;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaPK facturaPK;
    @Column(name = "adelantar")
    private Boolean adelantar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Detallepago> detallepagoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura", fetch = FetchType.EAGER)
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
    public Boolean getAdelantar() {
        return adelantar;
    }
    public void setAdelantar(Boolean adelantar) {
        this.adelantar = adelantar;
    }
    @XmlTransient
    public List<Detallepago> getDetallepagoList() {
        return detallepagoList;
    }
    public void setDetallepagoList(List<Detallepago> detallepagoList) {
        this.detallepagoList = detallepagoList;
    }
    //@XmlTransient
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

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public String getNombrecomercializadora() {
        return nombrecomercializadora;
    }

    public void setNombrecomercializadora(String nombrecomercializadora) {
        this.nombrecomercializadora = nombrecomercializadora;
    }

    public String getRuccomercializadora() {
        return ruccomercializadora;
    }

    public void setRuccomercializadora(String ruccomercializadora) {
        this.ruccomercializadora = ruccomercializadora;
    }

    public String getDireccionmatrizcomercializadora() {
        return direccionmatrizcomercializadora;
    }

    public void setDireccionmatrizcomercializadora(String direccionmatrizcomercializadora) {
        this.direccionmatrizcomercializadora = direccionmatrizcomercializadora;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getRuccliente() {
        return ruccliente;
    }

    public void setRuccliente(String ruccliente) {
        this.ruccliente = ruccliente;
    }

    public BigDecimal getValorsinimpuestos() {
        return valorsinimpuestos;
    }

    public void setValorsinimpuestos(BigDecimal valorsinimpuestos) {
        this.valorsinimpuestos = valorsinimpuestos;
    }

    public String getCorreocliente() {
        return correocliente;
    }

    public void setCorreocliente(String correocliente) {
        this.correocliente = correocliente;
    }

    public String getDireccioncliente() {
        return direccioncliente;
    }

    public void setDireccioncliente(String direccioncliente) {
        this.direccioncliente = direccioncliente;
    }

    public String getTelefonocliente() {
        return telefonocliente;
    }

    public void setTelefonocliente(String telefonocliente) {
        this.telefonocliente = telefonocliente;
    }

    public String getNumeroautorizacion() {
        return numeroautorizacion;
    }

    public void setNumeroautorizacion(String numeroautorizacion) {
        this.numeroautorizacion = numeroautorizacion;
    }

    public String getFechaautorizacion() {
        return fechaautorizacion;
    }

    public void setFechaautorizacion(String fechaautorizacion) {
        this.fechaautorizacion = fechaautorizacion;
    }

    public String getClienteformapago() {
        return clienteformapago;
    }

    public void setClienteformapago(String clienteformapago) {
        this.clienteformapago = clienteformapago;
    }

    public Integer getPlazocliente() {
        return plazocliente;
    }

    public void setPlazocliente(Integer plazocliente) {
        this.plazocliente = plazocliente;
    }

    public String getClaveacceso() {
        return claveacceso;
    }

    public void setClaveacceso(String claveacceso) {
        this.claveacceso = claveacceso;
    }

    public String getCampoadicionalCampo1() {
        return campoadicionalCampo1;
    }

    public void setCampoadicionalCampo1(String campoadicionalCampo1) {
        this.campoadicionalCampo1 = campoadicionalCampo1;
    }

    public String getCampoadicionalCampo2() {
        return campoadicionalCampo2;
    }

    public void setCampoadicionalCampo2(String campoadicionalCampo2) {
        this.campoadicionalCampo2 = campoadicionalCampo2;
    }

    public String getCampoadicionalCampo3() {
        return campoadicionalCampo3;
    }

    public void setCampoadicionalCampo3(String campoadicionalCampo3) {
        this.campoadicionalCampo3 = campoadicionalCampo3;
    }

    public String getCampoadicionalCampo4() {
        return campoadicionalCampo4;
    }

    public void setCampoadicionalCampo4(String campoadicionalCampo4) {
        this.campoadicionalCampo4 = campoadicionalCampo4;
    }

    public String getCampoadicionalCampo5() {
        return campoadicionalCampo5;
    }

    public void setCampoadicionalCampo5(String campoadicionalCampo5) {
        this.campoadicionalCampo5 = campoadicionalCampo5;
    }

    public String getCampoadicionalCampo6() {
        return campoadicionalCampo6;
    }

    public void setCampoadicionalCampo6(String campoadicionalCampo6) {
        this.campoadicionalCampo6 = campoadicionalCampo6;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Short getErrordocumento() {
        return errordocumento;
    }

    public void setErrordocumento(Short errordocumento) {
        this.errordocumento = errordocumento;
    }

    public Short getHospedado() {
        return hospedado;
    }

    public void setHospedado(Short hospedado) {
        this.hospedado = hospedado;
    }

    public Character getAmbientesri() {
        return ambientesri;
    }

    public void setAmbientesri(Character ambientesri) {
        this.ambientesri = ambientesri;
    }

    public Character getTipoemision() {
        return tipoemision;
    }

    public void setTipoemision(Character tipoemision) {
        this.tipoemision = tipoemision;
    }

    public String getCodigodocumento() {
        return codigodocumento;
    }

    public void setCodigodocumento(String codigodocumento) {
        this.codigodocumento = codigodocumento;
    }

    public Boolean getEsagenteretencion() {
        return esagenteretencion;
    }

    public void setEsagenteretencion(Boolean esagenteretencion) {
        this.esagenteretencion = esagenteretencion;
    }

    public String getEscontribuyenteespacial() {
        return escontribuyenteespacial;
    }

    public void setEscontribuyenteespacial(String escontribuyenteespacial) {
        this.escontribuyenteespacial = escontribuyenteespacial;
    }

    public String getObligadocontabilidad() {
        return obligadocontabilidad;
    }

    public void setObligadocontabilidad(String obligadocontabilidad) {
        this.obligadocontabilidad = obligadocontabilidad;
    }

    public String getTipocomprador() {
        return tipocomprador;
    }

    public void setTipocomprador(String tipocomprador) {
        this.tipocomprador = tipocomprador;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
     
    public String getSeriesri() {
        return seriesri;
    }

    public void setSeriesri(String seriesri) {
        this.seriesri = seriesri;
    }

    public String getTipoplazocredito() {
        return tipoplazocredito;
    }

    public void setTipoplazocredito(String tipoplazocredito) {
        this.tipoplazocredito = tipoplazocredito;
    }
    
}
