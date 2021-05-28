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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente_1.findAll", query = "SELECT c FROM Cliente_1 c"),
    @NamedQuery(name = "Cliente_1.findByCodigo", query = "SELECT c FROM Cliente_1 c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Cliente_1.findByNombre", query = "SELECT c FROM Cliente_1 c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente_1.findByEstado", query = "SELECT c FROM Cliente_1 c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cliente_1.findByCodigoarch", query = "SELECT c FROM Cliente_1 c WHERE c.codigoarch = :codigoarch"),
    @NamedQuery(name = "Cliente_1.findByCodigostc", query = "SELECT c FROM Cliente_1 c WHERE c.codigostc = :codigostc"),
    @NamedQuery(name = "Cliente_1.findByClavestc", query = "SELECT c FROM Cliente_1 c WHERE c.clavestc = :clavestc"),
    @NamedQuery(name = "Cliente_1.findByRuc", query = "SELECT c FROM Cliente_1 c WHERE c.ruc = :ruc"),
    @NamedQuery(name = "Cliente_1.findByDireccion", query = "SELECT c FROM Cliente_1 c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente_1.findByIdentificacionrepresentantelega", query = "SELECT c FROM Cliente_1 c WHERE c.identificacionrepresentantelega = :identificacionrepresentantelega"),
    @NamedQuery(name = "Cliente_1.findByNombrearrendatario", query = "SELECT c FROM Cliente_1 c WHERE c.nombrearrendatario = :nombrearrendatario"),
    @NamedQuery(name = "Cliente_1.findByNombrerepresentantelegal", query = "SELECT c FROM Cliente_1 c WHERE c.nombrerepresentantelegal = :nombrerepresentantelegal"),
    @NamedQuery(name = "Cliente_1.findByEscontribuyenteespacial", query = "SELECT c FROM Cliente_1 c WHERE c.escontribuyenteespacial = :escontribuyenteespacial"),
    @NamedQuery(name = "Cliente_1.findByTelefono1", query = "SELECT c FROM Cliente_1 c WHERE c.telefono1 = :telefono1"),
    @NamedQuery(name = "Cliente_1.findByTelefono2", query = "SELECT c FROM Cliente_1 c WHERE c.telefono2 = :telefono2"),
    @NamedQuery(name = "Cliente_1.findByCorreo1", query = "SELECT c FROM Cliente_1 c WHERE c.correo1 = :correo1"),
    @NamedQuery(name = "Cliente_1.findByCorreo2", query = "SELECT c FROM Cliente_1 c WHERE c.correo2 = :correo2"),
    @NamedQuery(name = "Cliente_1.findByTipoplazocredito", query = "SELECT c FROM Cliente_1 c WHERE c.tipoplazocredito = :tipoplazocredito"),
    @NamedQuery(name = "Cliente_1.findByDiasplazocredito", query = "SELECT c FROM Cliente_1 c WHERE c.diasplazocredito = :diasplazocredito"),
    @NamedQuery(name = "Cliente_1.findByTasainteres", query = "SELECT c FROM Cliente_1 c WHERE c.tasainteres = :tasainteres"),
    @NamedQuery(name = "Cliente_1.findByCuentadebito", query = "SELECT c FROM Cliente_1 c WHERE c.cuentadebito = :cuentadebito"),
    @NamedQuery(name = "Cliente_1.findByTipocuentadebito", query = "SELECT c FROM Cliente_1 c WHERE c.tipocuentadebito = :tipocuentadebito"),
    @NamedQuery(name = "Cliente_1.findByControlagarantia", query = "SELECT c FROM Cliente_1 c WHERE c.controlagarantia = :controlagarantia"),
    @NamedQuery(name = "Cliente_1.findByCodigolistaprecio", query = "SELECT c FROM Cliente_1 c WHERE c.codigolistaprecio = :codigolistaprecio"),
    @NamedQuery(name = "Cliente_1.findByCodigolistaflete", query = "SELECT c FROM Cliente_1 c WHERE c.codigolistaflete = :codigolistaflete"),
    @NamedQuery(name = "Cliente_1.findByAplicasubsidio2", query = "SELECT c FROM Cliente_1 c WHERE c.aplicasubsidio2 = :aplicasubsidio2"),
    @NamedQuery(name = "Cliente_1.findByCentrocosto", query = "SELECT c FROM Cliente_1 c WHERE c.centrocosto = :centrocosto"),
    @NamedQuery(name = "Cliente_1.findByFehainscripcion", query = "SELECT c FROM Cliente_1 c WHERE c.fehainscripcion = :fehainscripcion"),
    @NamedQuery(name = "Cliente_1.findByFehainiciooperacion", query = "SELECT c FROM Cliente_1 c WHERE c.fehainiciooperacion = :fehainiciooperacion"),
    @NamedQuery(name = "Cliente_1.findByFeharegistroarch", query = "SELECT c FROM Cliente_1 c WHERE c.feharegistroarch = :feharegistroarch"),
    @NamedQuery(name = "Cliente_1.findByFehavencimientocontrato", query = "SELECT c FROM Cliente_1 c WHERE c.fehavencimientocontrato = :fehavencimientocontrato"),
    @NamedQuery(name = "Cliente_1.findByCodigosupervisorzonal", query = "SELECT c FROM Cliente_1 c WHERE c.codigosupervisorzonal = :codigosupervisorzonal"),
    @NamedQuery(name = "Cliente_1.findByUsuarioactual", query = "SELECT c FROM Cliente_1 c WHERE c.usuarioactual = :usuarioactual")})
public class Cliente_1 implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 3)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigoarch")
    private String codigoarch;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigostc")
    private String codigostc;
    @Size(max = 4)
    @Column(name = "clavestc")
    private String clavestc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 13)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 13)
    @Column(name = "identificacionrepresentantelega")
    private String identificacionrepresentantelega;
    @Size(max = 100)
    @Column(name = "nombrearrendatario")
    private String nombrearrendatario;
    @Size(max = 100)
    @Column(name = "nombrerepresentantelegal")
    private String nombrerepresentantelegal;
    @Size(max = 12)
    @Column(name = "telefono1")
    private String telefono1;
    @Size(max = 12)
    @Column(name = "telefono2")
    private String telefono2;
    @Size(max = 100)
    @Column(name = "correo1")
    private String correo1;
    @Size(max = 100)
    @Column(name = "correo2")
    private String correo2;
    @Size(max = 3)
    @Column(name = "tipoplazocredito")
    private String tipoplazocredito;
    @Size(max = 10)
    @Column(name = "cuentadebito")
    private String cuentadebito;
    @Size(max = 3)
    @Column(name = "tipocuentadebito")
    private String tipocuentadebito;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 10)
    @Column(name = "codigolistaprecio")
    private String codigolistaprecio;
    @Size(max = 10)
    @Column(name = "codigolistaflete")
    private String codigolistaflete;
    @Size(max = 20)
    @Column(name = "centrocosto")
    private String centrocosto;
    @Size(max = 6)
    @Column(name = "codigosupervisorzonal")
    private String codigosupervisorzonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente1")
    private List<Clienterubrotercero> clienterubroterceroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigocliente")
    private List<Notapedido> notapedidoList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "escontribuyenteespacial")
    private Boolean escontribuyenteespacial;
    @Column(name = "diasplazocredito")
    private Short diasplazocredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tasainteres")
    private BigDecimal tasainteres;
    @Column(name = "controlagarantia")
    private Boolean controlagarantia;
    @Column(name = "aplicasubsidio2")
    private Boolean aplicasubsidio2;
    @Column(name = "fehainscripcion")
    @Temporal(TemporalType.DATE)
    private Date fehainscripcion;
    @Column(name = "fehainiciooperacion")
    @Temporal(TemporalType.DATE)
    private Date fehainiciooperacion;
    @Column(name = "feharegistroarch")
    @Temporal(TemporalType.DATE)
    private Date feharegistroarch;
    @Column(name = "fehavencimientocontrato")
    @Temporal(TemporalType.DATE)
    private Date fehavencimientocontrato;
    @JoinColumn(name = "codigobancodebito", referencedColumnName = "codigo")
    @ManyToOne
    private Banco_1 codigobancodebito;
    @JoinColumn(name = "codigodireccioninen", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Direccioninen_1 codigodireccioninen;
    @JoinColumn(name = "codigoformapago", referencedColumnName = "codigo")
    @ManyToOne
    private Formapago_1 codigoformapago;
    @JoinColumn(name = "codigoterminaldefecto", referencedColumnName = "codigo")
    @ManyToOne
    private Terminal_1 codigoterminaldefecto;
    @JoinColumn(name = "codigotipocliente", referencedColumnName = "codigo")
    @ManyToOne
    private Tipocliente_1 codigotipocliente;

    public Cliente_1() {
    }

    public Cliente_1(String codigo) {
        this.codigo = codigo;
    }

    public Cliente_1(String codigo, String nombre, String estado, String codigoarch, String codigostc, String ruc, String direccion, String codigolistaprecio, String usuarioactual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.codigoarch = codigoarch;
        this.codigostc = codigostc;
        this.ruc = ruc;
        this.direccion = direccion;
        this.codigolistaprecio = codigolistaprecio;
        this.usuarioactual = usuarioactual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Boolean getEscontribuyenteespacial() {
        return escontribuyenteespacial;
    }

    public void setEscontribuyenteespacial(Boolean escontribuyenteespacial) {
        this.escontribuyenteespacial = escontribuyenteespacial;
    }


    public Short getDiasplazocredito() {
        return diasplazocredito;
    }

    public void setDiasplazocredito(Short diasplazocredito) {
        this.diasplazocredito = diasplazocredito;
    }

    public BigDecimal getTasainteres() {
        return tasainteres;
    }

    public void setTasainteres(BigDecimal tasainteres) {
        this.tasainteres = tasainteres;
    }


    public Boolean getControlagarantia() {
        return controlagarantia;
    }

    public void setControlagarantia(Boolean controlagarantia) {
        this.controlagarantia = controlagarantia;
    }


    public Boolean getAplicasubsidio2() {
        return aplicasubsidio2;
    }

    public void setAplicasubsidio2(Boolean aplicasubsidio2) {
        this.aplicasubsidio2 = aplicasubsidio2;
    }


    public Date getFehainscripcion() {
        return fehainscripcion;
    }

    public void setFehainscripcion(Date fehainscripcion) {
        this.fehainscripcion = fehainscripcion;
    }

    public Date getFehainiciooperacion() {
        return fehainiciooperacion;
    }

    public void setFehainiciooperacion(Date fehainiciooperacion) {
        this.fehainiciooperacion = fehainiciooperacion;
    }

    public Date getFeharegistroarch() {
        return feharegistroarch;
    }

    public void setFeharegistroarch(Date feharegistroarch) {
        this.feharegistroarch = feharegistroarch;
    }

    public Date getFehavencimientocontrato() {
        return fehavencimientocontrato;
    }

    public void setFehavencimientocontrato(Date fehavencimientocontrato) {
        this.fehavencimientocontrato = fehavencimientocontrato;
    }


    public Banco_1 getCodigobancodebito() {
        return codigobancodebito;
    }

    public void setCodigobancodebito(Banco_1 codigobancodebito) {
        this.codigobancodebito = codigobancodebito;
    }

    public Direccioninen_1 getCodigodireccioninen() {
        return codigodireccioninen;
    }

    public void setCodigodireccioninen(Direccioninen_1 codigodireccioninen) {
        this.codigodireccioninen = codigodireccioninen;
    }

    public Formapago_1 getCodigoformapago() {
        return codigoformapago;
    }

    public void setCodigoformapago(Formapago_1 codigoformapago) {
        this.codigoformapago = codigoformapago;
    }

    public Terminal_1 getCodigoterminaldefecto() {
        return codigoterminaldefecto;
    }

    public void setCodigoterminaldefecto(Terminal_1 codigoterminaldefecto) {
        this.codigoterminaldefecto = codigoterminaldefecto;
    }

    public Tipocliente_1 getCodigotipocliente() {
        return codigotipocliente;
    }

    public void setCodigotipocliente(Tipocliente_1 codigotipocliente) {
        this.codigotipocliente = codigotipocliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente_1)) {
            return false;
        }
        Cliente_1 other = (Cliente_1) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Cliente_1[ codigo=" + codigo + " ]";
    }
    @XmlTransient
    public List<Notapedido> getNotapedidoList() {
        return notapedidoList;
    }
    public void setNotapedidoList(List<Notapedido> notapedidoList) {
        this.notapedidoList = notapedidoList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoarch() {
        return codigoarch;
    }

    public void setCodigoarch(String codigoarch) {
        this.codigoarch = codigoarch;
    }

    public String getCodigostc() {
        return codigostc;
    }

    public void setCodigostc(String codigostc) {
        this.codigostc = codigostc;
    }

    public String getClavestc() {
        return clavestc;
    }

    public void setClavestc(String clavestc) {
        this.clavestc = clavestc;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacionrepresentantelega() {
        return identificacionrepresentantelega;
    }

    public void setIdentificacionrepresentantelega(String identificacionrepresentantelega) {
        this.identificacionrepresentantelega = identificacionrepresentantelega;
    }

    public String getNombrearrendatario() {
        return nombrearrendatario;
    }

    public void setNombrearrendatario(String nombrearrendatario) {
        this.nombrearrendatario = nombrearrendatario;
    }

    public String getNombrerepresentantelegal() {
        return nombrerepresentantelegal;
    }

    public void setNombrerepresentantelegal(String nombrerepresentantelegal) {
        this.nombrerepresentantelegal = nombrerepresentantelegal;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getTipoplazocredito() {
        return tipoplazocredito;
    }

    public void setTipoplazocredito(String tipoplazocredito) {
        this.tipoplazocredito = tipoplazocredito;
    }

    public String getCuentadebito() {
        return cuentadebito;
    }

    public void setCuentadebito(String cuentadebito) {
        this.cuentadebito = cuentadebito;
    }

    public String getTipocuentadebito() {
        return tipocuentadebito;
    }

    public void setTipocuentadebito(String tipocuentadebito) {
        this.tipocuentadebito = tipocuentadebito;
    }

    public String getCodigolistaprecio() {
        return codigolistaprecio;
    }

    public void setCodigolistaprecio(String codigolistaprecio) {
        this.codigolistaprecio = codigolistaprecio;
    }

    public String getCodigolistaflete() {
        return codigolistaflete;
    }

    public void setCodigolistaflete(String codigolistaflete) {
        this.codigolistaflete = codigolistaflete;
    }

    public String getCentrocosto() {
        return centrocosto;
    }

    public void setCentrocosto(String centrocosto) {
        this.centrocosto = centrocosto;
    }

    public String getCodigosupervisorzonal() {
        return codigosupervisorzonal;
    }

    public void setCodigosupervisorzonal(String codigosupervisorzonal) {
        this.codigosupervisorzonal = codigosupervisorzonal;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    @XmlTransient
    public List<Clienterubrotercero> getClienterubroterceroList() {
        return clienterubroterceroList;
    }

    public void setClienterubroterceroList(List<Clienterubrotercero> clienterubroterceroList) {
        this.clienterubroterceroList = clienterubroterceroList;
    }

    
}
