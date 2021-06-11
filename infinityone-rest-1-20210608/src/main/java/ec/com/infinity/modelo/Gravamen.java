/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "gravamen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gravamen.findAll", query = "SELECT g FROM Gravamen g"),
    @NamedQuery(name = "Gravamen.findByCodigocomercializadora", query = "SELECT g FROM Gravamen g WHERE g.gravamenPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Gravamen.findByCodigo", query = "SELECT g FROM Gravamen g WHERE g.gravamenPK.codigo = :codigo"),
    @NamedQuery(name = "Gravamen.findByNombre", query = "SELECT g FROM Gravamen g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Gravamen.findByActivo", query = "SELECT g FROM Gravamen g WHERE g.activo = :activo"),
    @NamedQuery(name = "Gravamen.findBySeimprime", query = "SELECT g FROM Gravamen g WHERE g.seimprime = :seimprime"),
    @NamedQuery(name = "Gravamen.findByFormulavalor", query = "SELECT g FROM Gravamen g WHERE g.formulavalor = :formulavalor"),
    @NamedQuery(name = "Gravamen.findByValordefecto", query = "SELECT g FROM Gravamen g WHERE g.valordefecto = :valordefecto"),
    @NamedQuery(name = "Gravamen.findByUsuarioactual", query = "SELECT g FROM Gravamen g WHERE g.usuarioactual = :usuarioactual")})
public class Gravamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GravamenPK gravamenPK;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "seimprime")
    private Boolean seimprime;
    @Size(max = 100)
    @Column(name = "formulavalor")
    private String formulavalor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valordefecto")
    private BigDecimal valordefecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gravamen")
    private List<Detalleprecio> detalleprecioList;

    public Gravamen() {
    }

    public Gravamen(GravamenPK gravamenPK) {
        this.gravamenPK = gravamenPK;
    }

    public Gravamen(GravamenPK gravamenPK, String usuarioactual) {
        this.gravamenPK = gravamenPK;
        this.usuarioactual = usuarioactual;
    }

    public Gravamen(String codigocomercializadora, String codigo) {
        this.gravamenPK = new GravamenPK(codigocomercializadora, codigo);
    }

    public GravamenPK getGravamenPK() {
        return gravamenPK;
    }

    public void setGravamenPK(GravamenPK gravamenPK) {
        this.gravamenPK = gravamenPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getSeimprime() {
        return seimprime;
    }

    public void setSeimprime(Boolean seimprime) {
        this.seimprime = seimprime;
    }

    public String getFormulavalor() {
        return formulavalor;
    }

    public void setFormulavalor(String formulavalor) {
        this.formulavalor = formulavalor;
    }

    public BigDecimal getValordefecto() {
        return valordefecto;
    }

    public void setValordefecto(BigDecimal valordefecto) {
        this.valordefecto = valordefecto;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    @XmlTransient
    public List<Detalleprecio> getDetalleprecioList() {
        return detalleprecioList;
    }

    public void setDetalleprecioList(List<Detalleprecio> detalleprecioList) {
        this.detalleprecioList = detalleprecioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gravamenPK != null ? gravamenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gravamen)) {
            return false;
        }
        Gravamen other = (Gravamen) object;
        if ((this.gravamenPK == null && other.gravamenPK != null) || (this.gravamenPK != null && !this.gravamenPK.equals(other.gravamenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Gravamen[ gravamenPK=" + gravamenPK + " ]";
    }
    
}
