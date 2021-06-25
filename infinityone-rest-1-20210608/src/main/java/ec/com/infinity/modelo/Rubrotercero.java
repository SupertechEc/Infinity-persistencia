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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author Fernando Tapia
 */
@Entity
@Table(name = "rubrotercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rubrotercero.findAll", query = "SELECT r FROM Rubrotercero r"),
    @NamedQuery(name = "Rubrotercero.findByCodigocomercializadora", query = "SELECT r FROM Rubrotercero r WHERE r.rubroterceroPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Rubrotercero.findByCodigo", query = "SELECT r FROM Rubrotercero r WHERE r.rubroterceroPK.codigo = :codigo"),
    @NamedQuery(name = "Rubrotercero.findByNombre", query = "SELECT r FROM Rubrotercero r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Rubrotercero.findByActivo", query = "SELECT r FROM Rubrotercero r WHERE r.activo = :activo"),
    @NamedQuery(name = "Rubrotercero.findByCodigocontable", query = "SELECT r FROM Rubrotercero r WHERE r.codigocontable = :codigocontable"),
    @NamedQuery(name = "Rubrotercero.findByTipo", query = "SELECT r FROM Rubrotercero r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Rubrotercero.findByUsuarioactual", query = "SELECT r FROM Rubrotercero r WHERE r.usuarioactual = :usuarioactual")})
public class Rubrotercero implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RubroterceroPK rubroterceroPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Size(max = 20)
    @Column(name = "codigocontable")
    private String codigocontable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubrotercero")
    private List<Clienterubrotercero> clienterubroterceroList;
    @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comercializadora comercializadora;

    public Rubrotercero() {
    }

    public Rubrotercero(RubroterceroPK rubroterceroPK) {
        this.rubroterceroPK = rubroterceroPK;
    }

    public Rubrotercero(RubroterceroPK rubroterceroPK, String nombre, boolean activo, String tipo) {
        this.rubroterceroPK = rubroterceroPK;
        this.nombre = nombre;
        this.activo = activo;
        this.tipo = tipo;
    }

    public Rubrotercero(String codigocomercializadora, long codigo) {
        this.rubroterceroPK = new RubroterceroPK(codigocomercializadora, codigo);
    }

    public RubroterceroPK getRubroterceroPK() {
        return rubroterceroPK;
    }

    public void setRubroterceroPK(RubroterceroPK rubroterceroPK) {
        this.rubroterceroPK = rubroterceroPK;
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

    public String getCodigocontable() {
        return codigocontable;
    }

    public void setCodigocontable(String codigocontable) {
        this.codigocontable = codigocontable;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    @XmlTransient
    public List<Clienterubrotercero> getClienterubroterceroList() {
        return clienterubroterceroList;
    }

    public void setClienterubroterceroList(List<Clienterubrotercero> clienterubroterceroList) {
        this.clienterubroterceroList = clienterubroterceroList;
    }

    public Comercializadora getComercializadora() {
        return comercializadora;
    }

    public void setComercializadora(Comercializadora comercializadora) {
        this.comercializadora = comercializadora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rubroterceroPK != null ? rubroterceroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rubrotercero)) {
            return false;
        }
        Rubrotercero other = (Rubrotercero) object;
        if ((this.rubroterceroPK == null && other.rubroterceroPK != null) || (this.rubroterceroPK != null && !this.rubroterceroPK.equals(other.rubroterceroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Rubrotercero[ rubroterceroPK=" + rubroterceroPK + " ]";
    }
    
}
