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
@Table(name = "areamercadeo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areamercadeo.findAll", query = "SELECT a FROM Areamercadeo a"),
    @NamedQuery(name = "Areamercadeo.findByCodigo", query = "SELECT a FROM Areamercadeo a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Areamercadeo.findByNombre", query = "SELECT a FROM Areamercadeo a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Areamercadeo.findByActivo", query = "SELECT a FROM Areamercadeo a WHERE a.activo = :activo"),
    @NamedQuery(name = "Areamercadeo.findByUsuarioactual", query = "SELECT a FROM Areamercadeo a WHERE a.usuarioactual = :usuarioactual")})
public class Areamercadeo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
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
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoareamercadeo")
    private List<Producto> productoList;

    public Areamercadeo() {
    }

    public Areamercadeo(String codigo) {
        this.codigo = codigo;
    }

    public Areamercadeo(String codigo, String nombre, boolean activo, String usuarioactual) {
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

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
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
        if (!(object instanceof Areamercadeo)) {
            return false;
        }
        Areamercadeo other = (Areamercadeo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Areamercadeo[ codigo=" + codigo + " ]";
    }
    
}
