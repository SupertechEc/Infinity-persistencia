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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "notapedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notapedido.findAll", query = "SELECT n FROM Notapedido n"),
    @NamedQuery(name = "Notapedido.findByCodigoabastecedora", query = "SELECT n FROM Notapedido n WHERE n.notapedidoPK.codigoabastecedora = :codigoabastecedora"),
    @NamedQuery(name = "Notapedido.findByCodigocomercializadora", query = "SELECT n FROM Notapedido n WHERE n.notapedidoPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Notapedido.findByNumero", query = "SELECT n FROM Notapedido n WHERE n.notapedidoPK.numero = :numero"),
    @NamedQuery(name = "Notapedido.findByFechaventa", query = "SELECT n FROM Notapedido n WHERE n.fechaventa = :fechaventa"),
    @NamedQuery(name = "Notapedido.findByFechadespacho", query = "SELECT n FROM Notapedido n WHERE n.fechadespacho = :fechadespacho"),
    @NamedQuery(name = "Notapedido.findByActiva", query = "SELECT n FROM Notapedido n WHERE n.activa = :activa"),
    @NamedQuery(name = "Notapedido.findByCodigoautotanque", query = "SELECT n FROM Notapedido n WHERE n.codigoautotanque = :codigoautotanque"),
    @NamedQuery(name = "Notapedido.findByCedulaconductor", query = "SELECT n FROM Notapedido n WHERE n.cedulaconductor = :cedulaconductor"),
    @NamedQuery(name = "Notapedido.findByNumerofacturasri", query = "SELECT n FROM Notapedido n WHERE n.numerofacturasri = :numerofacturasri"),
    @NamedQuery(name = "Notapedido.findByRespuestageneracionoeepp", query = "SELECT n FROM Notapedido n WHERE n.respuestageneracionoeepp = :respuestageneracionoeepp"),
    @NamedQuery(name = "Notapedido.findByObservacion", query = "SELECT n FROM Notapedido n WHERE n.observacion = :observacion"),
    @NamedQuery(name = "Notapedido.findByAdelantar", query = "SELECT n FROM Notapedido n WHERE n.adelantar = :adelantar"),
    @NamedQuery(name = "Notapedido.findByRespuestaanulacionoeepp", query = "SELECT n FROM Notapedido n WHERE n.respuestaanulacionoeepp = :respuestaanulacionoeepp"),
    @NamedQuery(name = "Notapedido.findByUsuarioactual", query = "SELECT n FROM Notapedido n WHERE n.usuarioactual = :usuarioactual")})
public class Notapedido implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaventa")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechadespacho")
    @Temporal(TemporalType.DATE)
    private Date fechadespacho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activa")
    private boolean activa;

    @Column(name = "codigoautotanque")
    private String codigoautotanque;
    @Column(name = "cedulaconductor")
    private String cedulaconductor;
    @Column(name = "numerofacturasri")
    private String numerofacturasri;
    @Column(name = "respuestageneracionoeepp")
    private String respuestageneracionoeepp;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "adelantar")
    private boolean adelantar;
    @Column(name = "respuestaanulacionoeepp")
    private String respuestaanulacionoeepp;
    @Column(name = "tramaenviadagoe")
    private String tramaenviadagoe;
    @Column(name = "tramarecibidagoe")
    private String tramarecibidagoe;
    @Column(name = "tramarenviadaaoe")
    private String tramarenviadaaoe;
    @Column(name = "tramarecibidaaoe")
    private String tramarecibidaaoe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioactual")
    private String usuarioactual;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotapedidoPK notapedidoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notapedido")
    private List<Detallenotapedido> detallenotapedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notapedido")
    private List<Factura> facturaList;
    @JoinColumn(name = "codigoabastecedora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Abastecedora_1 abastecedora;
    @JoinColumn(name = "codigobanco", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Banco_1 codigobanco;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Cliente_1 codigocliente;
    @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comercializadora_1 comercializadora;
    @JoinColumn(name = "codigoterminal", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Terminal_1 codigoterminal;

    public Notapedido() {
    }

    public Notapedido(NotapedidoPK notapedidoPK) {
        this.notapedidoPK = notapedidoPK;
    }

    public Notapedido(NotapedidoPK notapedidoPK, Date fechaventa, Date fechadespacho, boolean activa, boolean adelantar, String usuarioactual) {
        this.notapedidoPK = notapedidoPK;
        this.fechaventa = fechaventa;
        this.fechadespacho = fechadespacho;
        this.activa = activa;
        this.adelantar = adelantar;
        this.usuarioactual = usuarioactual;
    }

    public Notapedido(String codigoabastecedora, String codigocomercializadora, String numero) {
        this.notapedidoPK = new NotapedidoPK(codigoabastecedora, codigocomercializadora, numero);
    }

    public NotapedidoPK getNotapedidoPK() {
        return notapedidoPK;
    }

    public void setNotapedidoPK(NotapedidoPK notapedidoPK) {
        this.notapedidoPK = notapedidoPK;
    }

    @XmlTransient
    public List<Detallenotapedido> getDetallenotapedidoList() {
        return detallenotapedidoList;
    }

    public void setDetallenotapedidoList(List<Detallenotapedido> detallenotapedidoList) {
        this.detallenotapedidoList = detallenotapedidoList;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public Abastecedora_1 getAbastecedora() {
        return abastecedora;
    }

    public void setAbastecedora(Abastecedora_1 abastecedora) {
        this.abastecedora = abastecedora;
    }

    public Banco_1 getCodigobanco() {
        return codigobanco;
    }

    public void setCodigobanco(Banco_1 codigobanco) {
        this.codigobanco = codigobanco;
    }

    public Cliente_1 getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(Cliente_1 codigocliente) {
        this.codigocliente = codigocliente;
    }

    public Comercializadora_1 getComercializadora() {
        return comercializadora;
    }

    public void setComercializadora(Comercializadora_1 comercializadora) {
        this.comercializadora = comercializadora;
    }

    public Terminal_1 getCodigoterminal() {
        return codigoterminal;
    }

    public void setCodigoterminal(Terminal_1 codigoterminal) {
        this.codigoterminal = codigoterminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notapedidoPK != null ? notapedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notapedido)) {
            return false;
        }
        Notapedido other = (Notapedido) object;
        if ((this.notapedidoPK == null && other.notapedidoPK != null) || (this.notapedidoPK != null && !this.notapedidoPK.equals(other.notapedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Notapedido[ notapedidoPK=" + notapedidoPK + " ]";
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
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

    public String getCodigoautotanque() {
        return codigoautotanque;
    }

    public void setCodigoautotanque(String codigoautotanque) {
        this.codigoautotanque = codigoautotanque;
    }

    public String getCedulaconductor() {
        return cedulaconductor;
    }

    public void setCedulaconductor(String cedulaconductor) {
        this.cedulaconductor = cedulaconductor;
    }

    public String getNumerofacturasri() {
        return numerofacturasri;
    }

    public void setNumerofacturasri(String numerofacturasri) {
        this.numerofacturasri = numerofacturasri;
    }

    public String getRespuestageneracionoeepp() {
        return respuestageneracionoeepp;
    }

    public void setRespuestageneracionoeepp(String respuestageneracionoeepp) {
        this.respuestageneracionoeepp = respuestageneracionoeepp;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean getAdelantar() {
        return adelantar;
    }

    public void setAdelantar(boolean adelantar) {
        this.adelantar = adelantar;
    }

    public String getRespuestaanulacionoeepp() {
        return respuestaanulacionoeepp;
    }

    public void setRespuestaanulacionoeepp(String respuestaanulacionoeepp) {
        this.respuestaanulacionoeepp = respuestaanulacionoeepp;
    }

    public String getTramaenviadagoe() {
        return tramaenviadagoe;
    }

    public void setTramaenviadagoe(String tramaenviadagoe) {
        this.tramaenviadagoe = tramaenviadagoe;
    }

    public String getTramarecibidagoe() {
        return tramarecibidagoe;
    }

    public void setTramarecibidagoe(String tramarecibidagoe) {
        this.tramarecibidagoe = tramarecibidagoe;
    }

    public String getTramarenviadaaoe() {
        return tramarenviadaaoe;
    }

    public void setTramarenviadaaoe(String tramarenviadaaoe) {
        this.tramarenviadaaoe = tramarenviadaaoe;
    }

    public String getTramarecibidaaoe() {
        return tramarecibidaaoe;
    }

    public void setTramarecibidaaoe(String tramarecibidaaoe) {
        this.tramarecibidaaoe = tramarecibidaaoe;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

}
