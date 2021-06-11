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
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCodigo", query = "SELECT c FROM Cliente c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cliente.findByCodigoarch", query = "SELECT c FROM Cliente c WHERE c.codigoarch = :codigoarch"),
    @NamedQuery(name = "Cliente.findByCodigostc", query = "SELECT c FROM Cliente c WHERE c.codigostc = :codigostc"),
    @NamedQuery(name = "Cliente.findByClavestc", query = "SELECT c FROM Cliente c WHERE c.clavestc = :clavestc"),
    @NamedQuery(name = "Cliente.findByCodigocomercializadora", query = "SELECT c FROM Cliente c WHERE c.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Cliente.findByRuc", query = "SELECT c FROM Cliente c WHERE c.ruc = :ruc"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByIdentificacionrepresentantelega", query = "SELECT c FROM Cliente c WHERE c.identificacionrepresentantelega = :identificacionrepresentantelega"),
    @NamedQuery(name = "Cliente.findByNombrearrendatario", query = "SELECT c FROM Cliente c WHERE c.nombrearrendatario = :nombrearrendatario"),
    @NamedQuery(name = "Cliente.findByNombrerepresentantelegal", query = "SELECT c FROM Cliente c WHERE c.nombrerepresentantelegal = :nombrerepresentantelegal"),
    @NamedQuery(name = "Cliente.findByEscontribuyenteespacial", query = "SELECT c FROM Cliente c WHERE c.escontribuyenteespacial = :escontribuyenteespacial"),
    @NamedQuery(name = "Cliente.findByTelefono1", query = "SELECT c FROM Cliente c WHERE c.telefono1 = :telefono1"),
    @NamedQuery(name = "Cliente.findByTelefono2", query = "SELECT c FROM Cliente c WHERE c.telefono2 = :telefono2"),
    @NamedQuery(name = "Cliente.findByCorreo1", query = "SELECT c FROM Cliente c WHERE c.correo1 = :correo1"),
    @NamedQuery(name = "Cliente.findByCorreo2", query = "SELECT c FROM Cliente c WHERE c.correo2 = :correo2"),
    @NamedQuery(name = "Cliente.findByTipoplazocredito", query = "SELECT c FROM Cliente c WHERE c.tipoplazocredito = :tipoplazocredito"),
    @NamedQuery(name = "Cliente.findByDiasplazocredito", query = "SELECT c FROM Cliente c WHERE c.diasplazocredito = :diasplazocredito"),
    @NamedQuery(name = "Cliente.findByTasainteres", query = "SELECT c FROM Cliente c WHERE c.tasainteres = :tasainteres"),
    @NamedQuery(name = "Cliente.findByCuentadebito", query = "SELECT c FROM Cliente c WHERE c.cuentadebito = :cuentadebito"),
    @NamedQuery(name = "Cliente.findByTipocuentadebito", query = "SELECT c FROM Cliente c WHERE c.tipocuentadebito = :tipocuentadebito"),
    @NamedQuery(name = "Cliente.findByControlagarantia", query = "SELECT c FROM Cliente c WHERE c.controlagarantia = :controlagarantia"),
    @NamedQuery(name = "Cliente.findByCodigolistaprecio", query = "SELECT c FROM Cliente c WHERE c.codigolistaprecio = :codigolistaprecio"),
    @NamedQuery(name = "Cliente.findByCodigolistaflete", query = "SELECT c FROM Cliente c WHERE c.codigolistaflete = :codigolistaflete"),
    @NamedQuery(name = "Cliente.findByAplicasubsidio2", query = "SELECT c FROM Cliente c WHERE c.aplicasubsidio2 = :aplicasubsidio2"),
    @NamedQuery(name = "Cliente.findByCentrocosto", query = "SELECT c FROM Cliente c WHERE c.centrocosto = :centrocosto"),
    @NamedQuery(name = "Cliente.findByFehainscripcion", query = "SELECT c FROM Cliente c WHERE c.fehainscripcion = :fehainscripcion"),
    @NamedQuery(name = "Cliente.findByFehainiciooperacion", query = "SELECT c FROM Cliente c WHERE c.fehainiciooperacion = :fehainiciooperacion"),
    @NamedQuery(name = "Cliente.findByFeharegistroarch", query = "SELECT c FROM Cliente c WHERE c.feharegistroarch = :feharegistroarch"),
    @NamedQuery(name = "Cliente.findByFehavencimientocontrato", query = "SELECT c FROM Cliente c WHERE c.fehavencimientocontrato = :fehavencimientocontrato"),
    @NamedQuery(name = "Cliente.findByCodigosupervisorzonal", query = "SELECT c FROM Cliente c WHERE c.codigosupervisorzonal = :codigosupervisorzonal"),
    @NamedQuery(name = "Cliente.findByUsuarioactual", query = "SELECT c FROM Cliente c WHERE c.usuarioactual = :usuarioactual")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
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
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "escontribuyenteespacial")
    private Boolean escontribuyenteespacial;
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
    @Column(name = "diasplazocredito")
    private Short diasplazocredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tasainteres")
    private BigDecimal tasainteres;
    @Size(max = 10)
    @Column(name = "cuentadebito")
    private String cuentadebito;
    @Size(max = 3)
    @Column(name = "tipocuentadebito")
    private String tipocuentadebito;
    @Column(name = "controlagarantia")
    private Boolean controlagarantia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigolistaprecio")
    private String codigolistaprecio;
    @Size(max = 10)
    @Column(name = "codigolistaflete")
    private String codigolistaflete;
    @Column(name = "aplicasubsidio2")
    private Boolean aplicasubsidio2;
    @Size(max = 20)
    @Column(name = "centrocosto")
    private String centrocosto;
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
    @Size(max = 6)
    @Column(name = "codigosupervisorzonal")
    private String codigosupervisorzonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Clientegarantia> clientegarantiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Clientelistaprecio> clientelistaprecioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Clienteproducto> clienteproductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigocliente")
    private List<Notapedido> notapedidoList;
    @JoinColumn(name = "codigobancodebito", referencedColumnName = "codigo")
    @ManyToOne
    private Banco codigobancodebito;
    @JoinColumn(name = "codigodireccioninen", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Direccioninen codigodireccioninen;
    @JoinColumn(name = "codigoformapago", referencedColumnName = "codigo")
    @ManyToOne
    private Formapago codigoformapago;
    @JoinColumn(name = "codigoterminaldefecto", referencedColumnName = "codigo")
    @ManyToOne
    private Terminal codigoterminaldefecto;
    @JoinColumn(name = "codigotipocliente", referencedColumnName = "codigo")
    @ManyToOne
    private Tipocliente codigotipocliente;
    @OneToMany(mappedBy = "codigocliente")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Totalgarantizado> totalgarantizadoList;

    public Cliente() {
    }

    public Cliente(String codigo) {
        this.codigo = codigo;
    }

    public Cliente(String codigo, String nombre, String estado, String codigoarch, String codigostc, String codigocomercializadora, String ruc, String direccion, String codigolistaprecio, String usuarioactual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.codigoarch = codigoarch;
        this.codigostc = codigostc;
        this.codigocomercializadora = codigocomercializadora;
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

    public Boolean getEscontribuyenteespacial() {
        return escontribuyenteespacial;
    }

    public void setEscontribuyenteespacial(Boolean escontribuyenteespacial) {
        this.escontribuyenteespacial = escontribuyenteespacial;
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

    public Boolean getControlagarantia() {
        return controlagarantia;
    }

    public void setControlagarantia(Boolean controlagarantia) {
        this.controlagarantia = controlagarantia;
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

    public Boolean getAplicasubsidio2() {
        return aplicasubsidio2;
    }

    public void setAplicasubsidio2(Boolean aplicasubsidio2) {
        this.aplicasubsidio2 = aplicasubsidio2;
    }

    public String getCentrocosto() {
        return centrocosto;
    }

    public void setCentrocosto(String centrocosto) {
        this.centrocosto = centrocosto;
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
    public List<Clientegarantia> getClientegarantiaList() {
        return clientegarantiaList;
    }

    public void setClientegarantiaList(List<Clientegarantia> clientegarantiaList) {
        this.clientegarantiaList = clientegarantiaList;
    }

    @XmlTransient
    public List<Clientelistaprecio> getClientelistaprecioList() {
        return clientelistaprecioList;
    }

    public void setClientelistaprecioList(List<Clientelistaprecio> clientelistaprecioList) {
        this.clientelistaprecioList = clientelistaprecioList;
    }

    @XmlTransient
    public List<Clienteproducto> getClienteproductoList() {
        return clienteproductoList;
    }

    public void setClienteproductoList(List<Clienteproducto> clienteproductoList) {
        this.clienteproductoList = clienteproductoList;
    }

    @XmlTransient
    public List<Notapedido> getNotapedidoList() {
        return notapedidoList;
    }

    public void setNotapedidoList(List<Notapedido> notapedidoList) {
        this.notapedidoList = notapedidoList;
    }

    public Banco getCodigobancodebito() {
        return codigobancodebito;
    }

    public void setCodigobancodebito(Banco codigobancodebito) {
        this.codigobancodebito = codigobancodebito;
    }

    public Direccioninen getCodigodireccioninen() {
        return codigodireccioninen;
    }

    public void setCodigodireccioninen(Direccioninen codigodireccioninen) {
        this.codigodireccioninen = codigodireccioninen;
    }

    public Formapago getCodigoformapago() {
        return codigoformapago;
    }

    public void setCodigoformapago(Formapago codigoformapago) {
        this.codigoformapago = codigoformapago;
    }

    public Terminal getCodigoterminaldefecto() {
        return codigoterminaldefecto;
    }

    public void setCodigoterminaldefecto(Terminal codigoterminaldefecto) {
        this.codigoterminaldefecto = codigoterminaldefecto;
    }

    public Tipocliente getCodigotipocliente() {
        return codigotipocliente;
    }

    public void setCodigotipocliente(Tipocliente codigotipocliente) {
        this.codigotipocliente = codigotipocliente;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Totalgarantizado> getTotalgarantizadoList() {
        return totalgarantizadoList;
    }

    public void setTotalgarantizadoList(List<Totalgarantizado> totalgarantizadoList) {
        this.totalgarantizadoList = totalgarantizadoList;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Cliente[ codigo=" + codigo + " ]";
    }
    
}
