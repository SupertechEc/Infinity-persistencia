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
import javax.persistence.JoinColumns;
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
 * @author Fernando Tapia
 */
@Entity
@Table(name = "clienterubrotercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienterubrotercero.findAll", query = "SELECT c FROM Clienterubrotercero c"),
    @NamedQuery(name = "Clienterubrotercero.findByCodigocomercializadora", query = "SELECT c FROM Clienterubrotercero c WHERE c.clienterubroterceroPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Clienterubrotercero.findByFAC", query = "SELECT c FROM Clienterubrotercero c "
            + "WHERE c.clienterubroterceroPK.codigocomercializadora = :codigocomercializadora"
            + " and c.clienterubroterceroPK.codigocliente = :codigocliente"
            + " and c.tipocobro = :tipocobro"
            + " and c.activo = :activo"
            + " and c.fechainiciocobro <= :fechainiciocobro"),
    @NamedQuery(name = "Clienterubrotercero.findByCodigorubrotercero", query = "SELECT c FROM Clienterubrotercero c WHERE c.clienterubroterceroPK.codigorubrotercero = :codigorubrotercero"),
    @NamedQuery(name = "Clienterubrotercero.findByCodigocliente", query = "SELECT c FROM Clienterubrotercero c WHERE c.clienterubroterceroPK.codigocliente = :codigocliente"),
    @NamedQuery(name = "Clienterubrotercero.findByValor", query = "SELECT c FROM Clienterubrotercero c WHERE c.valor = :valor"),
    @NamedQuery(name = "Clienterubrotercero.findByCuotas", query = "SELECT c FROM Clienterubrotercero c WHERE c.cuotas = :cuotas"),
    @NamedQuery(name = "Clienterubrotercero.findByUsuarioactual", query = "SELECT c FROM Clienterubrotercero c WHERE c.usuarioactual = :usuarioactual")})
public class Clienterubrotercero implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienterubroterceroPK clienterubroterceroPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas")
    private int cuotas;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @Size(max = 3)
    @Column(name = "tipocobro")
    private String tipocobro;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente1;
    @Column(name = "fechainiciocobro")
    @Temporal(TemporalType.DATE)
    private Date fechainiciocobro;
    @Column(name = "activo")
    private boolean activo;
    
    @JoinColumns({
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "codigorubrotercero", referencedColumnName = "codigo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Rubrotercero rubrotercero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienterubrotercero")
    private List<Cuotarubroterceros> cuotarubrotercerosList;

    public Clienterubrotercero() {
    }

    public Clienterubrotercero(ClienterubroterceroPK clienterubroterceroPK) {
        this.clienterubroterceroPK = clienterubroterceroPK;
    }

    public Clienterubrotercero(ClienterubroterceroPK clienterubroterceroPK, BigDecimal valor, int cuotas) {
        this.clienterubroterceroPK = clienterubroterceroPK;
        this.valor = valor;
        this.cuotas = cuotas;
    }

    public Clienterubrotercero(String codigocomercializadora, long codigorubrotercero, String codigocliente) {
        this.clienterubroterceroPK = new ClienterubroterceroPK(codigocomercializadora, codigorubrotercero, codigocliente);
    }

    public ClienterubroterceroPK getClienterubroterceroPK() {
        return clienterubroterceroPK;
    }

    public void setClienterubroterceroPK(ClienterubroterceroPK clienterubroterceroPK) {
        this.clienterubroterceroPK = clienterubroterceroPK;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    public Rubrotercero getRubrotercero() {
        return rubrotercero;
    }

    public void setRubrotercero(Rubrotercero rubrotercero) {
        this.rubrotercero = rubrotercero;
    }

    @XmlTransient
    public List<Cuotarubroterceros> getCuotarubrotercerosList() {
        return cuotarubrotercerosList;
    }

    public void setCuotarubrotercerosList(List<Cuotarubroterceros> cuotarubrotercerosList) {
        this.cuotarubrotercerosList = cuotarubrotercerosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienterubroterceroPK != null ? clienterubroterceroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienterubrotercero)) {
            return false;
        }
        Clienterubrotercero other = (Clienterubrotercero) object;
        if ((this.clienterubroterceroPK == null && other.clienterubroterceroPK != null) || (this.clienterubroterceroPK != null && !this.clienterubroterceroPK.equals(other.clienterubroterceroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Clienterubrotercero[ clienterubroterceroPK=" + clienterubroterceroPK + " ]";
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
