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
import javax.persistence.FetchType;
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
    //@NamedQuery(name = "Notapedido.findByCodigoabastecedora", query = "SELECT * FROM Notapedido n join Detallenotapeido d on n.numero = d.numero WHERE n.notapedidoPK.codigoabastecedora = :codigoabastecedora"),
    @NamedQuery(name = "Notapedido.findForVenta", query = "SELECT n FROM Notapedido n WHERE n.notapedidoPK.codigoabastecedora = :codigoabastecedora and n.notapedidoPK.codigocomercializadora = :codigocomercializadora and n.codigoterminal.codigo = :codigoterminal and n.fechaventa = :fecha order by n.notapedidoPK.numero"),
    @NamedQuery(name = "Notapedido.findForDespacho", query = "SELECT n FROM Notapedido n WHERE n.notapedidoPK.codigoabastecedora = :codigoabastecedora and n.notapedidoPK.codigocomercializadora = :codigocomercializadora and n.codigoterminal.codigo = :codigoterminal and n.fechadespacho = :fecha order by n.notapedidoPK.numero"),
    @NamedQuery(name = "Notapedido.findByCodigocomercializadora", query = "SELECT n FROM Notapedido n WHERE n.notapedidoPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Notapedido.findByComerterminal", query = "SELECT n FROM Notapedido n WHERE n.notapedidoPK.codigocomercializadora = :codigocomercializadora"
            + " and n.codigoterminal.codigo = :codigoterminal"),
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
    @NamedQuery(name = "Notapedido.findByTramaenviadagoe", query = "SELECT n FROM Notapedido n WHERE n.tramaenviadagoe = :tramaenviadagoe"),
    @NamedQuery(name = "Notapedido.findByTramarecibidagoe", query = "SELECT n FROM Notapedido n WHERE n.tramarecibidagoe = :tramarecibidagoe"),
    @NamedQuery(name = "Notapedido.findByTramarenviadaaoe", query = "SELECT n FROM Notapedido n WHERE n.tramarenviadaaoe = :tramarenviadaaoe"),
    @NamedQuery(name = "Notapedido.findByTramarecibidaaoe", query = "SELECT n FROM Notapedido n WHERE n.tramarecibidaaoe = :tramarecibidaaoe"),
    @NamedQuery(name = "Notapedido.findByUsuarioactual", query = "SELECT n FROM Notapedido n WHERE n.usuarioactual = :usuarioactual")})
public class Notapedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotapedidoPK notapedidoPK;
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
    @Size(max = 6)
    @Column(name = "codigoautotanque")
    private String codigoautotanque;
    @Size(max = 10)
    @Column(name = "cedulaconductor")
    private String cedulaconductor;
    @Size(max = 16)
    @Column(name = "numerofacturasri")
    private String numerofacturasri;
    @Size(max = 500)
    @Column(name = "respuestageneracionoeepp")
    private String respuestageneracionoeepp;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "adelantar")
    private boolean adelantar;
    @Size(max = 500)
    @Column(name = "respuestaanulacionoeepp")
    private String respuestaanulacionoeepp;
    @Size(max = 500)
    @Column(name = "tramaenviadagoe")
    private String tramaenviadagoe;
    @Size(max = 500)
    @Column(name = "tramarecibidagoe")
    private String tramarecibidagoe;
    @Size(max = 500)
    @Column(name = "tramarenviadaaoe")
    private String tramarenviadaaoe;
    @Size(max = 500)
    @Column(name = "tramarecibidaaoe")
    private String tramarecibidaaoe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
     @Column(name = "procesar")
    private boolean procesar;
    
    
    @JoinColumn(name = "codigoabastecedora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Abastecedora abastecedora;
    @JoinColumn(name = "codigobanco", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Banco codigobanco;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Cliente codigocliente;
    @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comercializadora comercializadora;
    @JoinColumn(name = "codigoterminal", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Terminal codigoterminal;
    
    
    //@JoinColumn(name = "codigoterminal", referencedColumnName = "codigo")
    //@ManyToOne(optional = false)
    
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "precio")
    private List<Detalleprecio> detalleprecioList;
    */
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="notapedido", fetch = FetchType.EAGER)
    private List<Detallenotapedido> detallesNP;
    
    @Size(max = 2)
    @Column(name = "prefijo")
    private String prefijo;

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

    
    
    public Abastecedora getAbastecedora() {
        return abastecedora;
    }

    public void setAbastecedora(Abastecedora abastecedora) {
        this.abastecedora = abastecedora;
    }

    public Banco getCodigobanco() {
        return codigobanco;
    }

    public void setCodigobanco(Banco codigobanco) {
        this.codigobanco = codigobanco;
    }

    public Cliente getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(Cliente codigocliente) {
        this.codigocliente = codigocliente;
    }

    public Comercializadora getComercializadora() {
        return comercializadora;
    }

    public void setComercializadora(Comercializadora comercializadora) {
        this.comercializadora = comercializadora;
    }

    public Terminal getCodigoterminal() {
        return codigoterminal;
    }

    public void setCodigoterminal(Terminal codigoterminal) {
        this.codigoterminal = codigoterminal;
    }
    
    
    
     public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public boolean isProcesar() {
        return procesar;
    }

    public void setProcesar(boolean procesar) {
        this.procesar = procesar;
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

    
    public List<Detallenotapedido> getDetallesNP() {
        return detallesNP;
    }

    public void setDetallesNP(List<Detallenotapedido> detallesNP) {
        this.detallesNP = detallesNP;
    }
    
   
    
}
