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
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByCodigo", query = "SELECT b FROM Banco b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "Banco.findByNombre", query = "SELECT b FROM Banco b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Banco.findByActivo", query = "SELECT b FROM Banco b WHERE b.activo = :activo"),
    @NamedQuery(name = "Banco.findByUsuarioactual", query = "SELECT b FROM Banco b WHERE b.usuarioactual = :usuarioactual")})
public class Banco implements Serializable {
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
    @OneToMany(mappedBy = "codigobancodebito")
    private List<Comercializadora> comercializadoraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banco")
    private List<Pagofactura> pagofacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banco")
    private List<Clientegarantia> clientegarantiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigobanco")
    private List<Notapedido> notapedidoList;
    @OneToMany(mappedBy = "codigobancodebito")
    private List<Cliente> clienteList;

    public Banco() {
    }

    public Banco(String codigo) {
        this.codigo = codigo;
    }

    public Banco(String codigo, String nombre, boolean activo, String usuarioactual) {
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
    public List<Clientegarantia> getClientegarantiaList() {
        return clientegarantiaList;
    }

    public void setClientegarantiaList(List<Clientegarantia> clientegarantiaList) {
        this.clientegarantiaList = clientegarantiaList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Banco[ codigo=" + codigo + " ]";
    }
    
}
