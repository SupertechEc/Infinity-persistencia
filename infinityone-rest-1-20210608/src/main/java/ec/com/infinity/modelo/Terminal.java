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
@Table(name = "terminal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t"),
    @NamedQuery(name = "Terminal.findByCodigo", query = "SELECT t FROM Terminal t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Terminal.findByNombre", query = "SELECT t FROM Terminal t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Terminal.findByActivo", query = "SELECT t FROM Terminal t WHERE t.activo = :activo"),
    @NamedQuery(name = "Terminal.findByUsuarioactual", query = "SELECT t FROM Terminal t WHERE t.usuarioactual = :usuarioactual")})
public class Terminal implements Serializable {
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
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminal")
    private List<Facturadordespachador> facturadordespachadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminal")
    private List<Precio> precioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoterminal")
    private List<Notapedido> notapedidoList;
    @OneToMany(mappedBy = "codigoterminaldefecto")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminal")
    private List<Listaprecioterminalproducto> listaprecioterminalproductoList;

    public Terminal() {
    }

    public Terminal(String codigo) {
        this.codigo = codigo;
    }

    public Terminal(String codigo, String nombre, boolean activo, String usuarioactual) {
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
    public List<Facturadordespachador> getFacturadordespachadorList() {
        return facturadordespachadorList;
    }

    public void setFacturadordespachadorList(List<Facturadordespachador> facturadordespachadorList) {
        this.facturadordespachadorList = facturadordespachadorList;
    }

    @XmlTransient
    public List<Precio> getPrecioList() {
        return precioList;
    }

    public void setPrecioList(List<Precio> precioList) {
        this.precioList = precioList;
    }

    @XmlTransient
    public List<Notapedido> getNotapedidoList() {
        return notapedidoList;
    }

    public void setNotapedidoList(List<Notapedido> notapedidoList) {
        this.notapedidoList = notapedidoList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Listaprecioterminalproducto> getListaprecioterminalproductoList() {
        return listaprecioterminalproductoList;
    }

    public void setListaprecioterminalproductoList(List<Listaprecioterminalproducto> listaprecioterminalproductoList) {
        this.listaprecioterminalproductoList = listaprecioterminalproductoList;
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
        if (!(object instanceof Terminal)) {
            return false;
        }
        Terminal other = (Terminal) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Terminal[ codigo=" + codigo + " ]";
    }
    
}
