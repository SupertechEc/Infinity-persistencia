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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByCodigostc", query = "SELECT p FROM Producto p WHERE p.codigostc = :codigostc"),
    @NamedQuery(name = "Producto.findByCodigoarch", query = "SELECT p FROM Producto p WHERE p.codigoarch = :codigoarch"),
    @NamedQuery(name = "Producto.findByUsuarioactual", query = "SELECT p FROM Producto p WHERE p.usuarioactual = :usuarioactual")})
public class Producto implements Serializable {
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
    @Size(min = 1, max = 7)
    @Column(name = "codigostc")
    private String codigostc;
    @Size(max = 3)
    @Column(name = "codigoarch")
    private String codigoarch;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Comercializadoraproducto> comercializadoraproductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detallenotapedido> detallenotapedidoList;
    @JoinColumn(name = "codigoareamercadeo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Areamercadeo codigoareamercadeo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Clienteproducto> clienteproductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detallefactura> detallefacturaList;

    public Producto() {
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }

    public Producto(String codigo, String nombre, String codigostc, String usuarioactual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigostc = codigostc;
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

    public String getCodigostc() {
        return codigostc;
    }

    public void setCodigostc(String codigostc) {
        this.codigostc = codigostc;
    }

    public String getCodigoarch() {
        return codigoarch;
    }

    public void setCodigoarch(String codigoarch) {
        this.codigoarch = codigoarch;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    @XmlTransient
    public List<Comercializadoraproducto> getComercializadoraproductoList() {
        return comercializadoraproductoList;
    }

    public void setComercializadoraproductoList(List<Comercializadoraproducto> comercializadoraproductoList) {
        this.comercializadoraproductoList = comercializadoraproductoList;
    }

    @XmlTransient
    public List<Detallenotapedido> getDetallenotapedidoList() {
        return detallenotapedidoList;
    }

    public void setDetallenotapedidoList(List<Detallenotapedido> detallenotapedidoList) {
        this.detallenotapedidoList = detallenotapedidoList;
    }

    public Areamercadeo getCodigoareamercadeo() {
        return codigoareamercadeo;
    }

    public void setCodigoareamercadeo(Areamercadeo codigoareamercadeo) {
        this.codigoareamercadeo = codigoareamercadeo;
    }

    @XmlTransient
    public List<Clienteproducto> getClienteproductoList() {
        return clienteproductoList;
    }

    public void setClienteproductoList(List<Clienteproducto> clienteproductoList) {
        this.clienteproductoList = clienteproductoList;
    }

    @XmlTransient
    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Producto[ codigo=" + codigo + " ]";
    }
    
}
