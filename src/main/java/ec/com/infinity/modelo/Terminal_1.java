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
@Table(name = "terminal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal_1.findAll", query = "SELECT t FROM Terminal_1 t"),
    @NamedQuery(name = "Terminal_1.findByCodigo", query = "SELECT t FROM Terminal_1 t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Terminal_1.findByNombre", query = "SELECT t FROM Terminal_1 t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Terminal_1.findByActivo", query = "SELECT t FROM Terminal_1 t WHERE t.activo = :activo"),
    @NamedQuery(name = "Terminal_1.findByUsuarioactual", query = "SELECT t FROM Terminal_1 t WHERE t.usuarioactual = :usuarioactual")})
public class Terminal_1 implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoterminal")
    private List<Notapedido> notapedidoList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(mappedBy = "codigoterminaldefecto")
    private Collection<Cliente_1> clienteCollection;

    public Terminal_1() {
    }

    public Terminal_1(String codigo) {
        this.codigo = codigo;
    }

    public Terminal_1(String codigo, String nombre, boolean activo, String usuarioactual) {
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
    public Collection<Cliente_1> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente_1> clienteCollection) {
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
        if (!(object instanceof Terminal_1)) {
            return false;
        }
        Terminal_1 other = (Terminal_1) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Terminal_1{" + "nombre=" + nombre + ", activo=" + activo + ", usuarioactual=" + usuarioactual + ", notapedidoList=" + notapedidoList + ", codigo=" + codigo + ", clienteCollection=" + clienteCollection + '}';
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
