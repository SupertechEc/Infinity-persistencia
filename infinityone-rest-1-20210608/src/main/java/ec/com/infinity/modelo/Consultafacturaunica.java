/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "consultafacturaunica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultafacturaunica.findAll", query = "SELECT c FROM Consultafacturaunica c"),
    @NamedQuery(name = "Consultafacturaunica.findById", query = "SELECT c FROM Consultafacturaunica c WHERE c.id = :id"),
    @NamedQuery(name = "Consultafacturaunica.findByCodigocomercializadora", query = "SELECT c FROM Consultafacturaunica c WHERE c.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Consultafacturaunica.findByNumerofactura", query = "SELECT c FROM Consultafacturaunica c WHERE c.numerofactura = :numerofactura"),
    @NamedQuery(name = "Consultafacturaunica.findByNumerosri", query = "SELECT c FROM Consultafacturaunica c WHERE c.numerosri = :numerosri"),
    @NamedQuery(name = "Consultafacturaunica.findByCodigobanco", query = "SELECT c FROM Consultafacturaunica c WHERE c.codigobanco = :codigobanco"),
    @NamedQuery(name = "Consultafacturaunica.findByFecharecepcion", query = "SELECT c FROM Consultafacturaunica c WHERE c.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Consultafacturaunica.findByFecha", query = "SELECT c FROM Consultafacturaunica c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Consultafacturaunica.findByFechavencimiento", query = "SELECT c FROM Consultafacturaunica c WHERE c.fechavencimiento = :fechavencimiento"),
    @NamedQuery(name = "Consultafacturaunica.findByFechaguia", query = "SELECT c FROM Consultafacturaunica c WHERE c.fechaguia = :fechaguia"),
    @NamedQuery(name = "Consultafacturaunica.findByEstadofactura", query = "SELECT c FROM Consultafacturaunica c WHERE c.estadofactura = :estadofactura"),
    @NamedQuery(name = "Consultafacturaunica.findByEstadopago", query = "SELECT c FROM Consultafacturaunica c WHERE c.estadopago = :estadopago"),
    @NamedQuery(name = "Consultafacturaunica.findByActivo", query = "SELECT c FROM Consultafacturaunica c WHERE c.activo = :activo"),
    @NamedQuery(name = "Consultafacturaunica.findByUsuarioactual", query = "SELECT c FROM Consultafacturaunica c WHERE c.usuarioactual = :usuarioactual")})
public class Consultafacturaunica implements Serializable {
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
    @Column(name = "codigobanco")
    private String codigobanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharecepcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fechavencimiento")
    private String fechavencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fechaguia")
    private String fechaguia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estadofactura")
    private String estadofactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estadopago")
    private String estadopago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfacturaunica")
    private List<Detalleconsultafacturaunica> detalleconsultafacturaunicaList;

    public Consultafacturaunica() {
    }

    public Consultafacturaunica(Long id) {
        this.id = id;
    }

    public Consultafacturaunica(Long id, String codigocomercializadora, String numerofactura, String codigobanco, Date fecharecepcion, String fecha, String fechavencimiento, String fechaguia, String estadofactura, String estadopago, boolean activo) {
        this.id = id;
        this.codigocomercializadora = codigocomercializadora;
        this.numerofactura = numerofactura;
        this.codigobanco = codigobanco;
        this.fecharecepcion = fecharecepcion;
        this.fecha = fecha;
        this.fechavencimiento = fechavencimiento;
        this.fechaguia = fechaguia;
        this.estadofactura = estadofactura;
        this.estadopago = estadopago;
        this.activo = activo;
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

    public String getCodigobanco() {
        return codigobanco;
    }

    public void setCodigobanco(String codigobanco) {
        this.codigobanco = codigobanco;
    }

    public Date getFecharecepcion() {
        return fecharecepcion;
    }

    public void setFecharecepcion(Date fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getFechaguia() {
        return fechaguia;
    }

    public void setFechaguia(String fechaguia) {
        this.fechaguia = fechaguia;
    }

    public String getEstadofactura() {
        return estadofactura;
    }

    public void setEstadofactura(String estadofactura) {
        this.estadofactura = estadofactura;
    }

    public String getEstadopago() {
        return estadopago;
    }

    public void setEstadopago(String estadopago) {
        this.estadopago = estadopago;
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
    public List<Detalleconsultafacturaunica> getDetalleconsultafacturaunicaList() {
        return detalleconsultafacturaunicaList;
    }

    public void setDetalleconsultafacturaunicaList(List<Detalleconsultafacturaunica> detalleconsultafacturaunicaList) {
        this.detalleconsultafacturaunicaList = detalleconsultafacturaunicaList;
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
        if (!(object instanceof Consultafacturaunica)) {
            return false;
        }
        Consultafacturaunica other = (Consultafacturaunica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Consultafacturaunica[ id=" + id + " ]";
    }
    
}
