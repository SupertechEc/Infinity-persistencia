/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "clientelistaprecio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientelistaprecio.findAll", query = "SELECT c FROM Clientelistaprecio c"),
    @NamedQuery(name = "Clientelistaprecio.findByCodigocomercializadora", query = "SELECT c FROM Clientelistaprecio c WHERE c.clientelistaprecioPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Clientelistaprecio.findByLisCodigo", query = "SELECT c FROM Clientelistaprecio c WHERE c.clientelistaprecioPK.lisCodigo = :lisCodigo"),
    @NamedQuery(name = "Clientelistaprecio.findByCodigocliente", query = "SELECT c FROM Clientelistaprecio c WHERE c.clientelistaprecioPK.codigocliente = :codigocliente"),
    @NamedQuery(name = "Clientelistaprecio.findByActivo", query = "SELECT c FROM Clientelistaprecio c WHERE c.activo = :activo"),
    @NamedQuery(name = "Clientelistaprecio.findByFechainicio", query = "SELECT c FROM Clientelistaprecio c WHERE c.fechainicio = :fechainicio"),
    @NamedQuery(name = "Clientelistaprecio.findByFechafin", query = "SELECT c FROM Clientelistaprecio c WHERE c.fechafin = :fechafin"),
    @NamedQuery(name = "Clientelistaprecio.findByUsuarioactual", query = "SELECT c FROM Clientelistaprecio c WHERE c.usuarioactual = :usuarioactual")})
public class Clientelistaprecio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientelistaprecioPK clientelistaprecioPK;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente_1 cliente;
    @JoinColumns({
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "lis_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Listaprecio listaprecio;

    public Clientelistaprecio() {
    }

    public Clientelistaprecio(ClientelistaprecioPK clientelistaprecioPK) {
        this.clientelistaprecioPK = clientelistaprecioPK;
    }

    public Clientelistaprecio(String codigocomercializadora, String lisCodigo, String codigocliente) {
        this.clientelistaprecioPK = new ClientelistaprecioPK(codigocomercializadora, lisCodigo, codigocliente);
    }

    public ClientelistaprecioPK getClientelistaprecioPK() {
        return clientelistaprecioPK;
    }

    public void setClientelistaprecioPK(ClientelistaprecioPK clientelistaprecioPK) {
        this.clientelistaprecioPK = clientelistaprecioPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Cliente_1 getCliente() {
        return cliente;
    }

    public void setCliente(Cliente_1 cliente) {
        this.cliente = cliente;
    }

    public Listaprecio getListaprecio() {
        return listaprecio;
    }

    public void setListaprecio(Listaprecio listaprecio) {
        this.listaprecio = listaprecio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientelistaprecioPK != null ? clientelistaprecioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientelistaprecio)) {
            return false;
        }
        Clientelistaprecio other = (Clientelistaprecio) object;
        if ((this.clientelistaprecioPK == null && other.clientelistaprecioPK != null) || (this.clientelistaprecioPK != null && !this.clientelistaprecioPK.equals(other.clientelistaprecioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Clientelistaprecio[ clientelistaprecioPK=" + clientelistaprecioPK + " ]";
    }
    
}
