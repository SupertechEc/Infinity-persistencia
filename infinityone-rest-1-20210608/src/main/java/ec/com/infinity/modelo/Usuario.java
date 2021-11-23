/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Tapia
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodigo", query = "SELECT u FROM Usuario u WHERE u.codigo = :codigo"),
    @NamedQuery(name = "Usuario.findAcceso", query = "SELECT u FROM Usuario u WHERE u.codigo = :codigo and u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByCedula", query = "SELECT u FROM Usuario u WHERE u.cedula = :cedula"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByNombrever", query = "SELECT u FROM Usuario u WHERE u.nombrever = :nombrever"),
    @NamedQuery(name = "Usuario.findByCodigocomercializadora", query = "SELECT u FROM Usuario u WHERE u.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Usuario.findByActivo", query = "SELECT u FROM Usuario u WHERE u.activo = :activo"),
    @NamedQuery(name = "Usuario.findByNiveloperacion", query = "SELECT u FROM Usuario u WHERE u.niveloperacion = :niveloperacion"),
    @NamedQuery(name = "Usuario.findByHash", query = "SELECT u FROM Usuario u WHERE u.hash = :hash"),
    @NamedQuery(name = "Usuario.findByVigenciahash", query = "SELECT u FROM Usuario u WHERE u.vigenciahash = :vigenciahash"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByUsuarioactual", query = "SELECT u FROM Usuario u WHERE u.usuarioactual = :usuarioactual")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 10)
    @Column(name = "nombrever")
    private String nombrever;
    @Size(max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Size(max = 8)
    @Column(name = "codigocliente")
    private String codigocliente;  
    @Column(name = "activo")
    private Boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "niveloperacion")
    private String niveloperacion;
    @Size(max = 10)
    @Column(name = "hash")
    private String hash;
    @Column(name = "vigenciahash")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenciahash;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;

    public Usuario() {
    }

    public Usuario(String codigo) {
        this.codigo = codigo;
    }

    public Usuario(String codigo, String cedula, String niveloperacion, String clave, String usuarioactual) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.niveloperacion = niveloperacion;
        this.clave = clave;
        this.usuarioactual = usuarioactual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrever() {
        return nombrever;
    }

    public void setNombrever(String nombrever) {
        this.nombrever = nombrever;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNiveloperacion() {
        return niveloperacion;
    }

    public void setNiveloperacion(String niveloperacion) {
        this.niveloperacion = niveloperacion;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getVigenciahash() {
        return vigenciahash;
    }

    public void setVigenciahash(Date vigenciahash) {
        this.vigenciahash = vigenciahash;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }
    
      public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Usuario[ codigo=" + codigo + " ]";
    }
    
}
