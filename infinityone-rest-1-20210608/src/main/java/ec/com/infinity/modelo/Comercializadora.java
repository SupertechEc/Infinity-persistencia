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
import javax.persistence.Lob;
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
@Table(name = "comercializadora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comercializadora.findAll", query = "SELECT c FROM Comercializadora c"),
    @NamedQuery(name = "Comercializadora.findByCodigo", query = "SELECT c FROM Comercializadora c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Comercializadora.findByNombre", query = "SELECT c FROM Comercializadora c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Comercializadora.findByActivo", query = "SELECT c FROM Comercializadora c WHERE c.activo = :activo"),
    @NamedQuery(name = "Comercializadora.findByCodigoarch", query = "SELECT c FROM Comercializadora c WHERE c.codigoarch = :codigoarch"),
    @NamedQuery(name = "Comercializadora.findByCodigostc", query = "SELECT c FROM Comercializadora c WHERE c.codigostc = :codigostc"),
    @NamedQuery(name = "Comercializadora.findByClavestc", query = "SELECT c FROM Comercializadora c WHERE c.clavestc = :clavestc"),
    @NamedQuery(name = "Comercializadora.findByRuc", query = "SELECT c FROM Comercializadora c WHERE c.ruc = :ruc"),
    @NamedQuery(name = "Comercializadora.findByNombrecorto", query = "SELECT c FROM Comercializadora c WHERE c.nombrecorto = :nombrecorto"),
    @NamedQuery(name = "Comercializadora.findByDireccion", query = "SELECT c FROM Comercializadora c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Comercializadora.findByIdentificacionrepresentantelega", query = "SELECT c FROM Comercializadora c WHERE c.identificacionrepresentantelega = :identificacionrepresentantelega"),
    @NamedQuery(name = "Comercializadora.findByNombrerepresentantelegal", query = "SELECT c FROM Comercializadora c WHERE c.nombrerepresentantelegal = :nombrerepresentantelegal"),
    @NamedQuery(name = "Comercializadora.findByEscontribuyenteespacial", query = "SELECT c FROM Comercializadora c WHERE c.escontribuyenteespacial = :escontribuyenteespacial"),
    @NamedQuery(name = "Comercializadora.findByTelefono1", query = "SELECT c FROM Comercializadora c WHERE c.telefono1 = :telefono1"),
    @NamedQuery(name = "Comercializadora.findByTelefono2", query = "SELECT c FROM Comercializadora c WHERE c.telefono2 = :telefono2"),
    @NamedQuery(name = "Comercializadora.findByCorreo1", query = "SELECT c FROM Comercializadora c WHERE c.correo1 = :correo1"),
    @NamedQuery(name = "Comercializadora.findByCorreo2", query = "SELECT c FROM Comercializadora c WHERE c.correo2 = :correo2"),
    @NamedQuery(name = "Comercializadora.findByTipoplazocredito", query = "SELECT c FROM Comercializadora c WHERE c.tipoplazocredito = :tipoplazocredito"),
    @NamedQuery(name = "Comercializadora.findByDiasplazocredito", query = "SELECT c FROM Comercializadora c WHERE c.diasplazocredito = :diasplazocredito"),
    @NamedQuery(name = "Comercializadora.findByCuentadebito", query = "SELECT c FROM Comercializadora c WHERE c.cuentadebito = :cuentadebito"),
    @NamedQuery(name = "Comercializadora.findByTipocuentadebito", query = "SELECT c FROM Comercializadora c WHERE c.tipocuentadebito = :tipocuentadebito"),
    @NamedQuery(name = "Comercializadora.findByTasainteres", query = "SELECT c FROM Comercializadora c WHERE c.tasainteres = :tasainteres"),
    @NamedQuery(name = "Comercializadora.findByFechavencimientocontr", query = "SELECT c FROM Comercializadora c WHERE c.fechavencimientocontr = :fechavencimientocontr"),
    @NamedQuery(name = "Comercializadora.findByFehainiciocontrato", query = "SELECT c FROM Comercializadora c WHERE c.fehainiciocontrato = :fehainiciocontrato"),
    @NamedQuery(name = "Comercializadora.findByEstablecimientofac", query = "SELECT c FROM Comercializadora c WHERE c.establecimientofac = :establecimientofac"),
    @NamedQuery(name = "Comercializadora.findByPuntoventafac", query = "SELECT c FROM Comercializadora c WHERE c.puntoventafac = :puntoventafac"),
    @NamedQuery(name = "Comercializadora.findByUsuarioactual", query = "SELECT c FROM Comercializadora c WHERE c.usuarioactual = :usuarioactual"),
    @NamedQuery(name = "Comercializadora.findByEstablecimientondb", query = "SELECT c FROM Comercializadora c WHERE c.establecimientondb = :establecimientondb"),
    @NamedQuery(name = "Comercializadora.findByPuntoventandb", query = "SELECT c FROM Comercializadora c WHERE c.puntoventandb = :puntoventandb"),
    @NamedQuery(name = "Comercializadora.findByEstablecimientoncr", query = "SELECT c FROM Comercializadora c WHERE c.establecimientoncr = :establecimientoncr"),
    @NamedQuery(name = "Comercializadora.findByPuntoventancr", query = "SELECT c FROM Comercializadora c WHERE c.puntoventancr = :puntoventancr"),
    @NamedQuery(name = "Comercializadora.findByPrefijonpe", query = "SELECT c FROM Comercializadora c WHERE c.prefijonpe = :prefijonpe"),
    @NamedQuery(name = "Comercializadora.findByClavewsepp", query = "SELECT c FROM Comercializadora c WHERE c.clavewsepp = :clavewsepp")})
public class Comercializadora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
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
    @Size(min = 1, max = 13)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 10)
    @Column(name = "nombrecorto")
    private String nombrecorto;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 13)
    @Column(name = "identificacionrepresentantelega")
    private String identificacionrepresentantelega;
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
    @Size(max = 10)
    @Column(name = "cuentadebito")
    private String cuentadebito;
    @Size(max = 3)
    @Column(name = "tipocuentadebito")
    private String tipocuentadebito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tasainteres")
    private BigDecimal tasainteres;
    @Column(name = "fechavencimientocontr")
    @Temporal(TemporalType.DATE)
    private Date fechavencimientocontr;
    @Column(name = "fehainiciocontrato")
    @Temporal(TemporalType.DATE)
    private Date fehainiciocontrato;
    @Size(max = 3)
    @Column(name = "establecimientofac")
    private String establecimientofac;
    @Size(max = 3)
    @Column(name = "puntoventafac")
    private String puntoventafac;
    @Lob
    @Column(name = "logo")
    private Object logo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @Size(max = 3)
    @Column(name = "establecimientondb")
    private String establecimientondb;
    @Size(max = 3)
    @Column(name = "puntoventandb")
    private String puntoventandb;
    @Size(max = 3)
    @Column(name = "establecimientoncr")
    private String establecimientoncr;
    @Size(max = 3)
    @Column(name = "puntoventancr")
    private String puntoventancr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "prefijonpe")
    private String prefijonpe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "clavewsepp")
    private String clavewsepp;
    @JoinColumn(name = "codigoabastecedora", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Abastecedora codigoabastecedora;
    @JoinColumn(name = "codigobancodebito", referencedColumnName = "codigo")
    @ManyToOne
    private Banco codigobancodebito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigocomercializadora")
    private List<Numeracion> numeracionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comercializadora")
    private List<Notapedido> notapedidoList;

    public Comercializadora() {
    }

    public Comercializadora(String codigo) {
        this.codigo = codigo;
    }

    public Comercializadora(String codigo, String nombre, boolean activo, String codigoarch, String codigostc, String ruc, String usuarioactual, String prefijonpe, String clavewsepp) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.activo = activo;
        this.codigoarch = codigoarch;
        this.codigostc = codigostc;
        this.ruc = ruc;
        this.usuarioactual = usuarioactual;
        this.prefijonpe = prefijonpe;
        this.clavewsepp = clavewsepp;
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombrecorto() {
        return nombrecorto;
    }

    public void setNombrecorto(String nombrecorto) {
        this.nombrecorto = nombrecorto;
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

    public BigDecimal getTasainteres() {
        return tasainteres;
    }

    public void setTasainteres(BigDecimal tasainteres) {
        this.tasainteres = tasainteres;
    }

    public Date getFechavencimientocontr() {
        return fechavencimientocontr;
    }

    public void setFechavencimientocontr(Date fechavencimientocontr) {
        this.fechavencimientocontr = fechavencimientocontr;
    }

    public Date getFehainiciocontrato() {
        return fehainiciocontrato;
    }

    public void setFehainiciocontrato(Date fehainiciocontrato) {
        this.fehainiciocontrato = fehainiciocontrato;
    }

    public String getEstablecimientofac() {
        return establecimientofac;
    }

    public void setEstablecimientofac(String establecimientofac) {
        this.establecimientofac = establecimientofac;
    }

    public String getPuntoventafac() {
        return puntoventafac;
    }

    public void setPuntoventafac(String puntoventafac) {
        this.puntoventafac = puntoventafac;
    }

    public Object getLogo() {
        return logo;
    }

    public void setLogo(Object logo) {
        this.logo = logo;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public String getEstablecimientondb() {
        return establecimientondb;
    }

    public void setEstablecimientondb(String establecimientondb) {
        this.establecimientondb = establecimientondb;
    }

    public String getPuntoventandb() {
        return puntoventandb;
    }

    public void setPuntoventandb(String puntoventandb) {
        this.puntoventandb = puntoventandb;
    }

    public String getEstablecimientoncr() {
        return establecimientoncr;
    }

    public void setEstablecimientoncr(String establecimientoncr) {
        this.establecimientoncr = establecimientoncr;
    }

    public String getPuntoventancr() {
        return puntoventancr;
    }

    public void setPuntoventancr(String puntoventancr) {
        this.puntoventancr = puntoventancr;
    }

    public String getPrefijonpe() {
        return prefijonpe;
    }

    public void setPrefijonpe(String prefijonpe) {
        this.prefijonpe = prefijonpe;
    }

    public String getClavewsepp() {
        return clavewsepp;
    }

    public void setClavewsepp(String clavewsepp) {
        this.clavewsepp = clavewsepp;
    }

    public Abastecedora getCodigoabastecedora() {
        return codigoabastecedora;
    }

    public void setCodigoabastecedora(Abastecedora codigoabastecedora) {
        this.codigoabastecedora = codigoabastecedora;
    }

    public Banco getCodigobancodebito() {
        return codigobancodebito;
    }

    public void setCodigobancodebito(Banco codigobancodebito) {
        this.codigobancodebito = codigobancodebito;
    }

    @XmlTransient
    public List<Numeracion> getNumeracionList() {
        return numeracionList;
    }

    public void setNumeracionList(List<Numeracion> numeracionList) {
        this.numeracionList = numeracionList;
    }

    @XmlTransient
    public List<Notapedido> getNotapedidoList() {
        return notapedidoList;
    }

    public void setNotapedidoList(List<Notapedido> notapedidoList) {
        this.notapedidoList = notapedidoList;
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
        if (!(object instanceof Comercializadora)) {
            return false;
        }
        Comercializadora other = (Comercializadora) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Comercializadora[ codigo=" + codigo + " ]";
    }
    
}
