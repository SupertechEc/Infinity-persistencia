/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "direccioninen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccioninen_1.findAll", query = "SELECT d FROM Direccioninen_1 d"),
    @NamedQuery(name = "Direccioninen_1.findByCodigo", query = "SELECT d FROM Direccioninen_1 d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Direccioninen_1.findByNombre", query = "SELECT d FROM Direccioninen_1 d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Direccioninen_1.findByActivo", query = "SELECT d FROM Direccioninen_1 d WHERE d.activo = :activo"),
    @NamedQuery(name = "Direccioninen_1.findByUsuarioactual", query = "SELECT d FROM Direccioninen_1 d WHERE d.usuarioactual = :usuarioactual")})
public class Direccioninen_1 implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigodireccioninen")
    private List<Cliente_1> clienteCollection;

    public Direccioninen_1() {
    }

    public Direccioninen_1(String codigo) {
        this.codigo = codigo;
    }

    public Direccioninen_1(String codigo, String nombre, boolean activo, String usuarioactual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.activo = activo;
        this.usuarioactual = usuarioactual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    @XmlTransient
    public List<Cliente_1> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(List<Cliente_1> clienteCollection) {
        this.clienteCollection = clienteCollection;
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
        if (!(object instanceof Direccioninen_1)) {
            return false;
        }
        Direccioninen_1 other = (Direccioninen_1) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Direccioninen_1[ codigo=" + codigo + " ]";
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

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }
    
}
