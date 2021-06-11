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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Paul
 */
@Entity
@Table(name = "detalleconsultafacturaunica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleconsultafacturaunica.findAll", query = "SELECT d FROM Detalleconsultafacturaunica d"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findById", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.id = :id"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByCodigocomercializadora", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByNumerofactura", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.numerofactura = :numerofactura"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByNumerosri", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.numerosri = :numerosri"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByFecha", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByFecharecepcion", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByCodigoareamercadeo", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.codigoareamercadeo = :codigoareamercadeo"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByCodigoproducto", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByCodigomedida", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.codigomedida = :codigomedida"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByProducto", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.producto = :producto"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByMedida", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.medida = :medida"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByVolumen", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.volumen = :volumen"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByPrecio", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.precio = :precio"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByValor", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.valor = :valor"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByUsuarioactual", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.usuarioactual = :usuarioactual")})
public class Detalleconsultafacturaunica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numerofactura")
    private String numerofactura;
    @Size(max = 100)
    @Column(name = "numerosri")
    private String numerosri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharecepcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigoareamercadeo")
    private String codigoareamercadeo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigoproducto")
    private String codigoproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigomedida")
    private String codigomedida;
    @Size(max = 100)
    @Column(name = "producto")
    private String producto;
    @Size(max = 100)
    @Column(name = "medida")
    private String medida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumen")
    private BigDecimal volumen;
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumn(name = "idfacturaunica", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Consultafacturaunica idfacturaunica;
    @Column(name = "activo")
    private boolean activo;
    

    public Detalleconsultafacturaunica() {
    }

    public Detalleconsultafacturaunica(Long id) {
        this.id = id;
    }

    public Detalleconsultafacturaunica(Long id, String codigocomercializadora, String numerofactura, String fecha, Date fecharecepcion, String codigoareamercadeo, String codigoproducto, String codigomedida, BigDecimal volumen, BigDecimal valor) {
        this.id = id;
        this.codigocomercializadora = codigocomercializadora;
        this.numerofactura = numerofactura;
        this.fecha = fecha;
        this.fecharecepcion = fecharecepcion;
        this.codigoareamercadeo = codigoareamercadeo;
        this.codigoproducto = codigoproducto;
        this.codigomedida = codigomedida;
        this.volumen = volumen;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public String getNumerosri() {
        return numerosri;
    }

    public void setNumerosri(String numerosri) {
        this.numerosri = numerosri;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Date getFecharecepcion() {
        return fecharecepcion;
    }

    public void setFecharecepcion(Date fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    public String getCodigoareamercadeo() {
        return codigoareamercadeo;
    }

    public void setCodigoareamercadeo(String codigoareamercadeo) {
        this.codigoareamercadeo = codigoareamercadeo;
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getCodigomedida() {
        return codigomedida;
    }

    public void setCodigomedida(String codigomedida) {
        this.codigomedida = codigomedida;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public BigDecimal getVolumen() {
        return volumen;
    }

    public void setVolumen(BigDecimal volumen) {
        this.volumen = volumen;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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

    public Consultafacturaunica getIdfacturaunica() {
        return idfacturaunica;
    }

    public void setIdfacturaunica(Consultafacturaunica idfacturaunica) {
        this.idfacturaunica = idfacturaunica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleconsultafacturaunica)) {
            return false;
        }
        Detalleconsultafacturaunica other = (Detalleconsultafacturaunica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Detalleconsultafacturaunica[ id=" + id + " ]";
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
