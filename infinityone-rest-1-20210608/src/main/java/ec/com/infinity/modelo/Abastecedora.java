/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "abastecedora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abastecedora.findAll", query = "SELECT a FROM Abastecedora a"),
    @NamedQuery(name = "Abastecedora.findByCodigo", query = "SELECT a FROM Abastecedora a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Abastecedora.findByNombre", query = "SELECT a FROM Abastecedora a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Abastecedora.findByActivo", query = "SELECT a FROM Abastecedora a WHERE a.activo = :activo"),
    @NamedQuery(name = "Abastecedora.findByCodigoarch", query = "SELECT a FROM Abastecedora a WHERE a.codigoarch = :codigoarch"),
    @NamedQuery(name = "Abastecedora.findByCodigostc", query = "SELECT a FROM Abastecedora a WHERE a.codigostc = :codigostc"),
    @NamedQuery(name = "Abastecedora.findByClavestc", query = "SELECT a FROM Abastecedora a WHERE a.clavestc = :clavestc"),
    @NamedQuery(name = "Abastecedora.findByRuc", query = "SELECT a FROM Abastecedora a WHERE a.ruc = :ruc"),
    @NamedQuery(name = "Abastecedora.findByDireccion", query = "SELECT a FROM Abastecedora a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Abastecedora.findByIdentificacionrepresentantelega", query = "SELECT a FROM Abastecedora a WHERE a.identificacionrepresentantelega = :identificacionrepresentantelega"),
    @NamedQuery(name = "Abastecedora.findByNombrerepresentantelegal", query = "SELECT a FROM Abastecedora a WHERE a.nombrerepresentantelegal = :nombrerepresentantelegal"),
    @NamedQuery(name = "Abastecedora.findByEscontribuyenteespacial", query = "SELECT a FROM Abastecedora a WHERE a.escontribuyenteespacial = :escontribuyenteespacial"),
    @NamedQuery(name = "Abastecedora.findByTelefono1", query = "SELECT a FROM Abastecedora a WHERE a.telefono1 = :telefono1"),
    @NamedQuery(name = "Abastecedora.findByTelefono2", query = "SELECT a FROM Abastecedora a WHERE a.telefono2 = :telefono2"),
    @NamedQuery(name = "Abastecedora.findByCorreo1", query = "SELECT a FROM Abastecedora a WHERE a.correo1 = :correo1"),
    @NamedQuery(name = "Abastecedora.findByCorreo2", query = "SELECT a FROM Abastecedora a WHERE a.correo2 = :correo2"),
    @NamedQuery(name = "Abastecedora.findByUsuarioactual", query = "SELECT a FROM Abastecedora a WHERE a.usuarioactual = :usuarioactual")})
public class Abastecedora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoabastecedora")
    private List<Comercializadora> comercializadoraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abastecedora")
    private List<Pagofactura> pagofacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abastecedora")
    private List<Notapedido> notapedidoList;

    public Abastecedora() {
    }

    public Abastecedora(String codigo) {
        this.codigo = codigo;
    }

    public Abastecedora(String codigo, String nombre, boolean activo, String codigoarch, String codigostc, String ruc, String usuarioactual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.activo = activo;
        this.codigoarch = codigoarch;
        this.codigostc = codigostc;
        this.ruc = ruc;
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

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    @XmlTransient
    public List<Comercializadora> getComercializadoraList() {
        return comercializadoraList;
    }

    public void setComercializadoraList(List<Comercializadora> comercializadoraList) {
        this.comercializadoraList = comercializadoraList;
    }

    @XmlTransient
    public List<Pagofactura> getPagofacturaList() {
        return pagofacturaList;
    }

    public void setPagofacturaList(List<Pagofactura> pagofacturaList) {
        this.pagofacturaList = pagofacturaList;
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
        if (!(object instanceof Abastecedora)) {
            return false;
        }
        Abastecedora other = (Abastecedora) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Abastecedora[ codigo=" + codigo + " ]";
    }
    
}
