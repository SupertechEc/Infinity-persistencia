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
@Table(name = "medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medida.findAll", query = "SELECT m FROM Medida m"),
    @NamedQuery(name = "Medida.findByCodigo", query = "SELECT m FROM Medida m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Medida.findByNombre", query = "SELECT m FROM Medida m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Medida.findByAbreviacion", query = "SELECT m FROM Medida m WHERE m.abreviacion = :abreviacion"),
    @NamedQuery(name = "Medida.findByActivo", query = "SELECT m FROM Medida m WHERE m.activo = :activo"),
    @NamedQuery(name = "Medida.findByUsuarioactual", query = "SELECT m FROM Medida m WHERE m.usuarioactual = :usuarioactual")})
public class Medida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "abreviacion")
    private String abreviacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medida")
    private List<Comercializadoraproducto> comercializadoraproductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medida")
    private List<Detallenotapedido> detallenotapedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigomedida")
    private List<Detallefactura> detallefacturaList;

    public Medida() {
    }

    public Medida(String codigo) {
        this.codigo = codigo;
    }

    public Medida(String codigo, String nombre, String abreviacion, boolean activo, String usuarioactual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.abreviacion = abreviacion;
        this.activo = activo;
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

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
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
        if (!(object instanceof Medida)) {
            return false;
        }
        Medida other = (Medida) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Medida[ codigo=" + codigo + " ]";
    }
    
}
