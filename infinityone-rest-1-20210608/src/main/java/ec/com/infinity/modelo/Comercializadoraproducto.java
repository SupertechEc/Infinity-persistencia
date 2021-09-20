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
@Table(name = "comercializadoraproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comercializadoraproducto.findAll", query = "SELECT c FROM Comercializadoraproducto c"),
    @NamedQuery(name = "Comercializadoraproducto.findByCodigocomercializadora", query = "SELECT c FROM Comercializadoraproducto c WHERE c.comercializadoraproductoPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Comercializadoraproducto.findByCodigoproducto", query = "SELECT c FROM Comercializadoraproducto c WHERE c.comercializadoraproductoPK.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Comercializadoraproducto.findByCodigomedida", query = "SELECT c FROM Comercializadoraproducto c WHERE c.comercializadoraproductoPK.codigomedida = :codigomedida"),
    @NamedQuery(name = "Comercializadoraproducto.findByActivo", query = "SELECT c FROM Comercializadoraproducto c WHERE c.activo = :activo"),
    @NamedQuery(name = "Comercializadoraproducto.findByMargencomercializacion", query = "SELECT c FROM Comercializadoraproducto c WHERE c.margencomercializacion = :margencomercializacion"),
    @NamedQuery(name = "Comercializadoraproducto.findByPrecioepp", query = "SELECT c FROM Comercializadoraproducto c WHERE c.precioepp = :precioepp"),
    @NamedQuery(name = "Comercializadoraproducto.findByPvpsugerido", query = "SELECT c FROM Comercializadoraproducto c WHERE c.pvpsugerido = :pvpsugerido"),
    @NamedQuery(name = "Comercializadoraproducto.findBySoloaplicaiva", query = "SELECT c FROM Comercializadoraproducto c WHERE c.soloaplicaiva = :soloaplicaiva"),
    @NamedQuery(name = "Comercializadoraproducto.findByUsuarioactual", query = "SELECT c FROM Comercializadoraproducto c WHERE c.usuarioactual = :usuarioactual")})
public class Comercializadoraproducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComercializadoraproductoPK comercializadoraproductoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "margencomercializacion")
    private BigDecimal margencomercializacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioepp")
    private BigDecimal precioepp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pvpsugerido")
    private BigDecimal pvpsugerido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soloaplicaiva")
    private boolean soloaplicaiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @Column(name = "procesar")
    private boolean procesar;
    @JoinColumn(name = "codigomedida", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medida medida;
    @JoinColumn(name = "codigoproducto", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comercializadoraproducto")
    private List<Precio> precioList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comercializadoraproducto")
//    private List<Listaprecioterminalproducto> listaprecioterminalproductoList;

    public Comercializadoraproducto() {
    }

    public Comercializadoraproducto(ComercializadoraproductoPK comercializadoraproductoPK) {
        this.comercializadoraproductoPK = comercializadoraproductoPK;
    }

    public Comercializadoraproducto(ComercializadoraproductoPK comercializadoraproductoPK, boolean activo, BigDecimal margencomercializacion, BigDecimal precioepp, BigDecimal pvpsugerido, boolean soloaplicaiva, String usuarioactual) {
        this.comercializadoraproductoPK = comercializadoraproductoPK;
        this.activo = activo;
        this.margencomercializacion = margencomercializacion;
        this.precioepp = precioepp;
        this.pvpsugerido = pvpsugerido;
        this.soloaplicaiva = soloaplicaiva;
        this.usuarioactual = usuarioactual;
    }

    public Comercializadoraproducto(String codigocomercializadora, String codigoproducto, String codigomedida) {
        this.comercializadoraproductoPK = new ComercializadoraproductoPK(codigocomercializadora, codigoproducto, codigomedida);
    }

    public ComercializadoraproductoPK getComercializadoraproductoPK() {
        return comercializadoraproductoPK;
    }

    public void setComercializadoraproductoPK(ComercializadoraproductoPK comercializadoraproductoPK) {
        this.comercializadoraproductoPK = comercializadoraproductoPK;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public BigDecimal getMargencomercializacion() {
        return margencomercializacion;
    }

    public void setMargencomercializacion(BigDecimal margencomercializacion) {
        this.margencomercializacion = margencomercializacion;
    }

    public BigDecimal getPrecioepp() {
        return precioepp;
    }

    public void setPrecioepp(BigDecimal precioepp) {
        this.precioepp = precioepp;
    }

    public BigDecimal getPvpsugerido() {
        return pvpsugerido;
    }

    public void setPvpsugerido(BigDecimal pvpsugerido) {
        this.pvpsugerido = pvpsugerido;
    }

    public boolean getSoloaplicaiva() {
        return soloaplicaiva;
    }

    public void setSoloaplicaiva(boolean soloaplicaiva) {
        this.soloaplicaiva = soloaplicaiva;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @XmlTransient
    public List<Precio> getPrecioList() {
        return precioList;
    }

    public void setPrecioList(List<Precio> precioList) {
        this.precioList = precioList;
    }

//    @XmlTransient
//    public List<Listaprecioterminalproducto> getListaprecioterminalproductoList() {
//        return listaprecioterminalproductoList;
//    }
//
//    public void setListaprecioterminalproductoList(List<Listaprecioterminalproducto> listaprecioterminalproductoList) {
//        this.listaprecioterminalproductoList = listaprecioterminalproductoList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comercializadoraproductoPK != null ? comercializadoraproductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comercializadoraproducto)) {
            return false;
        }
        Comercializadoraproducto other = (Comercializadoraproducto) object;
        if ((this.comercializadoraproductoPK == null && other.comercializadoraproductoPK != null) || (this.comercializadoraproductoPK != null && !this.comercializadoraproductoPK.equals(other.comercializadoraproductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Comercializadoraproducto[ comercializadoraproductoPK=" + comercializadoraproductoPK + " ]";
    }

    public boolean isProcesar() {
        return procesar;
    }

    public void setProcesar(boolean procesar) {
        this.procesar = procesar;
    }
    
}
