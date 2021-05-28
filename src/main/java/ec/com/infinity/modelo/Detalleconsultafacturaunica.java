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
    @NamedQuery(name = "Detalleconsultafacturaunica.findByCodigocomercializadora", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.detalleconsultafacturaunicaPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByNumerofactura", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.detalleconsultafacturaunicaPK.numerofactura = :numerofactura"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByNumerosri", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.numerosri = :numerosri"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByFecha", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.detalleconsultafacturaunicaPK.fecha = :fecha"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByFecharecepcion", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.detalleconsultafacturaunicaPK.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByCodigoareamercadeo", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.codigoareamercadeo = :codigoareamercadeo"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByCodigoproducto", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.detalleconsultafacturaunicaPK.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByCodigomedida", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.detalleconsultafacturaunicaPK.codigomedida = :codigomedida"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByProducto", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.producto = :producto"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByMedida", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.medida = :medida"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByVolumen", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.volumen = :volumen"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByPrecio", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.precio = :precio"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByValor", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.valor = :valor"),
    @NamedQuery(name = "Detalleconsultafacturaunica.findByUsuarioactual", query = "SELECT d FROM Detalleconsultafacturaunica d WHERE d.usuarioactual = :usuarioactual")})
public class Detalleconsultafacturaunica implements Serializable {
    @Size(max = 16)
    @Column(name = "numerosri")
    private String numerosri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigoareamercadeo")
    private String codigoareamercadeo;
    @Size(max = 50)
    @Column(name = "producto")
    private String producto;
    @Size(max = 20)
    @Column(name = "medida")
    private String medida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumen")
    private BigDecimal volumen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleconsultafacturaunicaPK detalleconsultafacturaunicaPK;
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumns({
        @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigocomercializadora", insertable = false, updatable = false),
        @JoinColumn(name = "numerofactura", referencedColumnName = "numerofactura", insertable = false, updatable = false),
        @JoinColumn(name = "fecha", referencedColumnName = "fecha", insertable = false, updatable = false),
        @JoinColumn(name = "fecharecepcion", referencedColumnName = "fecharecepcion", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Consultafacturaunica consultafacturaunica;

    public Detalleconsultafacturaunica() {
    }

    public Detalleconsultafacturaunica(DetalleconsultafacturaunicaPK detalleconsultafacturaunicaPK) {
        this.detalleconsultafacturaunicaPK = detalleconsultafacturaunicaPK;
    }

    public Detalleconsultafacturaunica(DetalleconsultafacturaunicaPK detalleconsultafacturaunicaPK, String codigoareamercadeo, BigDecimal volumen, BigDecimal valor) {
        this.detalleconsultafacturaunicaPK = detalleconsultafacturaunicaPK;
        this.codigoareamercadeo = codigoareamercadeo;
        this.volumen = volumen;
        this.valor = valor;
    }

    public Detalleconsultafacturaunica(String codigocomercializadora, String numerofactura, String fecha, Date fecharecepcion, String codigoproducto, String codigomedida) {
        this.detalleconsultafacturaunicaPK = new DetalleconsultafacturaunicaPK(codigocomercializadora, numerofactura, fecha, fecharecepcion, codigoproducto, codigomedida);
    }

    public DetalleconsultafacturaunicaPK getDetalleconsultafacturaunicaPK() {
        return detalleconsultafacturaunicaPK;
    }

    public void setDetalleconsultafacturaunicaPK(DetalleconsultafacturaunicaPK detalleconsultafacturaunicaPK) {
        this.detalleconsultafacturaunicaPK = detalleconsultafacturaunicaPK;
    }


    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }


    public Consultafacturaunica getConsultafacturaunica() {
        return consultafacturaunica;
    }

    public void setConsultafacturaunica(Consultafacturaunica consultafacturaunica) {
        this.consultafacturaunica = consultafacturaunica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleconsultafacturaunicaPK != null ? detalleconsultafacturaunicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleconsultafacturaunica)) {
            return false;
        }
        Detalleconsultafacturaunica other = (Detalleconsultafacturaunica) object;
        if ((this.detalleconsultafacturaunicaPK == null && other.detalleconsultafacturaunicaPK != null) || (this.detalleconsultafacturaunicaPK != null && !this.detalleconsultafacturaunicaPK.equals(other.detalleconsultafacturaunicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Detalleconsultafacturaunica{" + "numerosri=" + numerosri + ", codigoareamercadeo=" + codigoareamercadeo + ", producto=" + producto + ", medida=" + medida + ", volumen=" + volumen + ", valor=" + valor + ", usuarioactual=" + usuarioactual + ", detalleconsultafacturaunicaPK=" + detalleconsultafacturaunicaPK + ", precio=" + precio + ", consultafacturaunica=" + consultafacturaunica + '}';
    }

   

    public String getNumerosri() {
        return numerosri;
    }

    public void setNumerosri(String numerosri) {
        this.numerosri = numerosri;
    }

    public String getCodigoareamercadeo() {
        return codigoareamercadeo;
    }

    public void setCodigoareamercadeo(String codigoareamercadeo) {
        this.codigoareamercadeo = codigoareamercadeo;
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
    
}
