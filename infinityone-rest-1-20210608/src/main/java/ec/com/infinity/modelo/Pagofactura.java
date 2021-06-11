/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "pagofactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagofactura.findAll", query = "SELECT p FROM Pagofactura p"),
    @NamedQuery(name = "Pagofactura.findByCodigoabastecedora", query = "SELECT p FROM Pagofactura p WHERE p.pagofacturaPK.codigoabastecedora = :codigoabastecedora"),
    @NamedQuery(name = "Pagofactura.findByCodigocomercializadora", query = "SELECT p FROM Pagofactura p WHERE p.pagofacturaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Pagofactura.findByNumero", query = "SELECT p FROM Pagofactura p WHERE p.pagofacturaPK.numero = :numero"),
    @NamedQuery(name = "Pagofactura.findByCodigobanco", query = "SELECT p FROM Pagofactura p WHERE p.pagofacturaPK.codigobanco = :codigobanco"),
    @NamedQuery(name = "Pagofactura.findByFecha", query = "SELECT p FROM Pagofactura p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pagofactura.findByActivo", query = "SELECT p FROM Pagofactura p WHERE p.activo = :activo"),
    @NamedQuery(name = "Pagofactura.findByValor", query = "SELECT p FROM Pagofactura p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagofactura.findByObservacion", query = "SELECT p FROM Pagofactura p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Pagofactura.findByFecharegistro", query = "SELECT p FROM Pagofactura p WHERE p.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "Pagofactura.findByUsuarioactual", query = "SELECT p FROM Pagofactura p WHERE p.usuarioactual = :usuarioactual")})
public class Pagofactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagofacturaPK pagofacturaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.DATE)
    private Date fecharegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagofactura")
    private List<Detallepago> detallepagoList;
    @JoinColumn(name = "codigoabastecedora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Abastecedora abastecedora;
    @JoinColumn(name = "codigobanco", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Banco banco;

    public Pagofactura() {
    }

    public Pagofactura(PagofacturaPK pagofacturaPK) {
        this.pagofacturaPK = pagofacturaPK;
    }

    public Pagofactura(PagofacturaPK pagofacturaPK, Date fecha, boolean activo, BigDecimal valor, String observacion, Date fecharegistro, String usuarioactual) {
        this.pagofacturaPK = pagofacturaPK;
        this.fecha = fecha;
        this.activo = activo;
        this.valor = valor;
        this.observacion = observacion;
        this.fecharegistro = fecharegistro;
        this.usuarioactual = usuarioactual;
    }

    public Pagofactura(String codigoabastecedora, String codigocomercializadora, String numero, String codigobanco) {
        this.pagofacturaPK = new PagofacturaPK(codigoabastecedora, codigocomercializadora, numero, codigobanco);
    }

    public PagofacturaPK getPagofacturaPK() {
        return pagofacturaPK;
    }

    public void setPagofacturaPK(PagofacturaPK pagofacturaPK) {
        this.pagofacturaPK = pagofacturaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    @XmlTransient
    public List<Detallepago> getDetallepagoList() {
        return detallepagoList;
    }

    public void setDetallepagoList(List<Detallepago> detallepagoList) {
        this.detallepagoList = detallepagoList;
    }

    public Abastecedora getAbastecedora() {
        return abastecedora;
    }

    public void setAbastecedora(Abastecedora abastecedora) {
        this.abastecedora = abastecedora;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagofacturaPK != null ? pagofacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagofactura)) {
            return false;
        }
        Pagofactura other = (Pagofactura) object;
        if ((this.pagofacturaPK == null && other.pagofacturaPK != null) || (this.pagofacturaPK != null && !this.pagofacturaPK.equals(other.pagofacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Pagofactura[ pagofacturaPK=" + pagofacturaPK + " ]";
    }
    
}
