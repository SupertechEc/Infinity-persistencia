/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "clienteproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteproducto.findAll", query = "SELECT c FROM Clienteproducto c"),
    @NamedQuery(name = "Clienteproducto.findByCodigocliente", query = "SELECT c FROM Clienteproducto c WHERE c.clienteproductoPK.codigocliente = :codigocliente"),
    @NamedQuery(name = "Clienteproducto.findByCodigo", query = "SELECT c FROM Clienteproducto c WHERE c.clienteproductoPK.codigo = :codigo"),
    @NamedQuery(name = "Clienteproducto.findByActivo", query = "SELECT c FROM Clienteproducto c WHERE c.activo = :activo"),
    @NamedQuery(name = "Clienteproducto.findByUsuarioactual", query = "SELECT c FROM Clienteproducto c WHERE c.usuarioactual = :usuarioactual")})
public class Clienteproducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteproductoPK clienteproductoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Clienteproducto() {
    }

    public Clienteproducto(ClienteproductoPK clienteproductoPK) {
        this.clienteproductoPK = clienteproductoPK;
    }

    public Clienteproducto(ClienteproductoPK clienteproductoPK, boolean activo, String usuarioactual) {
        this.clienteproductoPK = clienteproductoPK;
        this.activo = activo;
        this.usuarioactual = usuarioactual;
    }

    public Clienteproducto(String codigocliente, String codigo) {
        this.clienteproductoPK = new ClienteproductoPK(codigocliente, codigo);
    }

    public ClienteproductoPK getClienteproductoPK() {
        return clienteproductoPK;
    }

    public void setClienteproductoPK(ClienteproductoPK clienteproductoPK) {
        this.clienteproductoPK = clienteproductoPK;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteproductoPK != null ? clienteproductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteproducto)) {
            return false;
        }
        Clienteproducto other = (Clienteproducto) object;
        if ((this.clienteproductoPK == null && other.clienteproductoPK != null) || (this.clienteproductoPK != null && !this.clienteproductoPK.equals(other.clienteproductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Clienteproducto[ clienteproductoPK=" + clienteproductoPK + " ]";
    }
    
}
