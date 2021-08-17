/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Tapia
 */
@Entity
@Table(name = "cuotarubroterceros")
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "Cuotarubroterceros.findParaCobrar", query = "SELECT c FROM Cuotarubroterceros c WHERE c.cuotarubrotercerosPK.codigocliente = :codigocliente "
//            + " and pagada = FALSE "
//            + " and tipocobro = 'FAC'"
//            + " UNION "
//            + " SELECT c FROM Cuotarubroterceros c "
//            + "WHERE c.cuotarubrotercerosPK.codigocliente = :codigocliente"
//            + " and pagada = FALSE "
//            + " and tipocobro != 'FAC' "
//            + " and fechacobro <= '2021-06-17'"),
    @NamedQuery(name = "Cuotarubroterceros.findAll", query = "SELECT c FROM Cuotarubroterceros c"),
    @NamedQuery(name = "Cuotarubroterceros.findByCodigocomercializadora", query = "SELECT c FROM Cuotarubroterceros c WHERE c.cuotarubrotercerosPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Cuotarubroterceros.findByCodigorubrocliente", query = "SELECT c FROM Cuotarubroterceros c WHERE c.cuotarubrotercerosPK.codigorubrotercero = :codigorubrotercero"),
    @NamedQuery(name = "Cuotarubroterceros.findByCodigocliente", query = "SELECT c FROM Cuotarubroterceros c WHERE c.cuotarubrotercerosPK.codigocliente = :codigocliente"),
    @NamedQuery(name = "Cuotarubroterceros.findByCuota", query = "SELECT c FROM Cuotarubroterceros c WHERE c.cuotarubrotercerosPK.cuota = :cuota"),
    @NamedQuery(name = "Cuotarubroterceros.findByPagada", query = "SELECT c FROM Cuotarubroterceros c WHERE c.pagada = :pagada"),
    @NamedQuery(name = "Cuotarubroterceros.findByFechacobro", query = "SELECT c FROM Cuotarubroterceros c WHERE c.fechacobro = :fechacobro"),
    @NamedQuery(name = "Cuotarubroterceros.findByValor", query = "SELECT c FROM Cuotarubroterceros c WHERE c.valor = :valor"),
    @NamedQuery(name = "Cuotarubroterceros.findByUsuarioactual", query = "SELECT c FROM Cuotarubroterceros c WHERE c.usuarioactual = :usuarioactual")})
public class Cuotarubroterceros implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuotarubrotercerosPK cuotarubrotercerosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagada")
    private boolean pagada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacobro")
    @Temporal(TemporalType.DATE)
    private Date fechacobro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
     @Size(max = 3)
    @Column(name = "tipocobro")
    private String tipocobro;
     @Column(name = "fechainiciocobro")
    @Temporal(TemporalType.DATE)
    private Date fechainiciocobro;
    @JoinColumns({
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "codigorubrotercero", referencedColumnName = "codigorubrotercero", insertable = false, updatable = false),
        @JoinColumn(name = "codigocliente", referencedColumnName = "codigocliente", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Clienterubrotercero clienterubrotercero;

    public Cuotarubroterceros() {
    }

    public Cuotarubroterceros(CuotarubrotercerosPK cuotarubrotercerosPK) {
        this.cuotarubrotercerosPK = cuotarubrotercerosPK;
    }

    public Cuotarubroterceros(CuotarubrotercerosPK cuotarubrotercerosPK, boolean pagada, Date fechacobro, BigDecimal valor) {
        this.cuotarubrotercerosPK = cuotarubrotercerosPK;
        this.pagada = pagada;
        this.fechacobro = fechacobro;
        this.valor = valor;
    }

    public Cuotarubroterceros(String codigocomercializadora, long codigorubrotercero, String codigocliente, int cuota) {
        this.cuotarubrotercerosPK = new CuotarubrotercerosPK(codigocomercializadora, codigorubrotercero, codigocliente, cuota);
    }

    public CuotarubrotercerosPK getCuotarubrotercerosPK() {
        return cuotarubrotercerosPK;
    }

    public void setCuotarubrotercerosPK(CuotarubrotercerosPK cuotarubrotercerosPK) {
        this.cuotarubrotercerosPK = cuotarubrotercerosPK;
    }

    public boolean getPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public Date getFechacobro() {
        return fechacobro;
    }

    public void setFechacobro(Date fechacobro) {
        this.fechacobro = fechacobro;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Clienterubrotercero getClienterubrotercero() {
        return clienterubrotercero;
    }

    public void setClienterubrotercero(Clienterubrotercero clienterubrotercero) {
        this.clienterubrotercero = clienterubrotercero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuotarubrotercerosPK != null ? cuotarubrotercerosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuotarubroterceros)) {
            return false;
        }
        Cuotarubroterceros other = (Cuotarubroterceros) object;
        if ((this.cuotarubrotercerosPK == null && other.cuotarubrotercerosPK != null) || (this.cuotarubrotercerosPK != null && !this.cuotarubrotercerosPK.equals(other.cuotarubrotercerosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Cuotarubroterceros[ cuotarubrotercerosPK=" + cuotarubrotercerosPK + " ]";
    }

    public String getTipocobro() {
        return tipocobro;
    }

    public void setTipocobro(String tipocobro) {
        this.tipocobro = tipocobro;
    }

    public Date getFechainiciocobro() {
        return fechainiciocobro;
    }

    public void setFechainiciocobro(Date fechainiciocobro) {
        this.fechainiciocobro = fechainiciocobro;
    }
    
    
    
}
