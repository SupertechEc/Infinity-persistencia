/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "clientegarantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientegarantia.findAll", query = "SELECT c FROM Clientegarantia c"),
    @NamedQuery(name = "Clientegarantia.findByCodigocomercializadora", query = "SELECT c FROM Clientegarantia c WHERE c.clientegarantiaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Clientegarantia.findByCodigocliente", query = "SELECT c FROM Clientegarantia c WHERE c.clientegarantiaPK.codigocliente = :codigocliente"),
    @NamedQuery(name = "Clientegarantia.findByCodigobanco", query = "SELECT c FROM Clientegarantia c WHERE c.clientegarantiaPK.codigobanco = :codigobanco"),
    @NamedQuery(name = "Clientegarantia.findByNumero", query = "SELECT c FROM Clientegarantia c WHERE c.clientegarantiaPK.numero = :numero"),
    @NamedQuery(name = "Clientegarantia.findBySecuencial", query = "SELECT c FROM Clientegarantia c WHERE c.clientegarantiaPK.secuencial = :secuencial"),
    @NamedQuery(name = "Clientegarantia.findByActivo", query = "SELECT c FROM Clientegarantia c WHERE c.activo = :activo"),
    @NamedQuery(name = "Clientegarantia.findByFechainiciovigencia", query = "SELECT c FROM Clientegarantia c WHERE c.fechainiciovigencia = :fechainiciovigencia"),
    @NamedQuery(name = "Clientegarantia.findByFechafinvigencia", query = "SELECT c FROM Clientegarantia c WHERE c.fechafinvigencia = :fechafinvigencia"),
    @NamedQuery(name = "Clientegarantia.findByValor", query = "SELECT c FROM Clientegarantia c WHERE c.valor = :valor"),
    @NamedQuery(name = "Clientegarantia.findByObservacion", query = "SELECT c FROM Clientegarantia c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "Clientegarantia.findByUsuarioactual", query = "SELECT c FROM Clientegarantia c WHERE c.usuarioactual = :usuarioactual")})
public class Clientegarantia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientegarantiaPK clientegarantiaPK;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fechainiciovigencia")
    @Temporal(TemporalType.DATE)
    private Date fechainiciovigencia;
    @Column(name = "fechafinvigencia")
    @Temporal(TemporalType.DATE)
    private Date fechafinvigencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumn(name = "codigobanco", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Banco banco;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Clientegarantia() {
    }

    public Clientegarantia(ClientegarantiaPK clientegarantiaPK) {
        this.clientegarantiaPK = clientegarantiaPK;
    }

    public Clientegarantia(String codigocomercializadora, String codigocliente, String codigobanco, String numero, int secuencial) {
        this.clientegarantiaPK = new ClientegarantiaPK(codigocomercializadora, codigocliente, codigobanco, numero, secuencial);
    }

    public ClientegarantiaPK getClientegarantiaPK() {
        return clientegarantiaPK;
    }

    public void setClientegarantiaPK(ClientegarantiaPK clientegarantiaPK) {
        this.clientegarantiaPK = clientegarantiaPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechainiciovigencia() {
        return fechainiciovigencia;
    }

    public void setFechainiciovigencia(Date fechainiciovigencia) {
        this.fechainiciovigencia = fechainiciovigencia;
    }

    public Date getFechafinvigencia() {
        return fechafinvigencia;
    }

    public void setFechafinvigencia(Date fechafinvigencia) {
        this.fechafinvigencia = fechafinvigencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientegarantiaPK != null ? clientegarantiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientegarantia)) {
            return false;
        }
        Clientegarantia other = (Clientegarantia) object;
        if ((this.clientegarantiaPK == null && other.clientegarantiaPK != null) || (this.clientegarantiaPK != null && !this.clientegarantiaPK.equals(other.clientegarantiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Clientegarantia[ clientegarantiaPK=" + clientegarantiaPK + " ]";
    }
    
}
