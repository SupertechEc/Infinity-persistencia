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
@Table(name = "consultaguiaremision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaguiaremision.findAll", query = "SELECT c FROM Consultaguiaremision c"),
    @NamedQuery(name = "Consultaguiaremision.findByCodigocomercializadora", query = "SELECT c FROM Consultaguiaremision c WHERE c.consultaguiaremisionPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Consultaguiaremision.findByCodigoterminal", query = "SELECT c FROM Consultaguiaremision c WHERE c.codigoterminal = :codigoterminal"),
    @NamedQuery(name = "Consultaguiaremision.findByNumero", query = "SELECT c FROM Consultaguiaremision c WHERE c.consultaguiaremisionPK.numero = :numero"),
    @NamedQuery(name = "Consultaguiaremision.findByNumerooe", query = "SELECT c FROM Consultaguiaremision c WHERE c.numerooe = :numerooe"),
    @NamedQuery(name = "Consultaguiaremision.findByFecha", query = "SELECT c FROM Consultaguiaremision c WHERE c.consultaguiaremisionPK.fecha = :fecha"),
    @NamedQuery(name = "Consultaguiaremision.findByFecharecepcion", query = "SELECT c FROM Consultaguiaremision c WHERE c.consultaguiaremisionPK.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Consultaguiaremision.findByCodigoareamercadeo", query = "SELECT c FROM Consultaguiaremision c WHERE c.codigoareamercadeo = :codigoareamercadeo"),
    @NamedQuery(name = "Consultaguiaremision.findByCodigoproducto", query = "SELECT c FROM Consultaguiaremision c WHERE c.codigoproducto = :codigoproducto"),
    @NamedQuery(name = "Consultaguiaremision.findByCodigomedida", query = "SELECT c FROM Consultaguiaremision c WHERE c.codigomedida = :codigomedida"),
    @NamedQuery(name = "Consultaguiaremision.findByMedida", query = "SELECT c FROM Consultaguiaremision c WHERE c.medida = :medida"),
    @NamedQuery(name = "Consultaguiaremision.findByProducto", query = "SELECT c FROM Consultaguiaremision c WHERE c.producto = :producto"),
    @NamedQuery(name = "Consultaguiaremision.findByVolumenentregado", query = "SELECT c FROM Consultaguiaremision c WHERE c.volumenentregado = :volumenentregado"),
    @NamedQuery(name = "Consultaguiaremision.findByAutotanque", query = "SELECT c FROM Consultaguiaremision c WHERE c.autotanque = :autotanque"),
    @NamedQuery(name = "Consultaguiaremision.findByEstado", query = "SELECT c FROM Consultaguiaremision c WHERE c.estado = :estado"),
    @NamedQuery(name = "Consultaguiaremision.findByUsuarioactual", query = "SELECT c FROM Consultaguiaremision c WHERE c.usuarioactual = :usuarioactual")})
public class Consultaguiaremision implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoterminal")
    private String codigoterminal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerooe")
    private String numerooe;

    @Size(max = 10)
    @Column(name = "codigoareamercadeo")
    private String codigoareamercadeo;
    @Size(max = 10)
    @Column(name = "codigoproducto")
    private String codigoproducto;
    @Size(max = 10)
    @Column(name = "codigomedida")
    private String codigomedida;
    @Size(max = 10)
    @Column(name = "medida")
    private String medida;
    @Size(max = 50)
    @Column(name = "producto")
    private String producto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull()
    @Column(name = "volumenentregado")
    private BigDecimal volumenentregado;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 10)
    @Column(name = "autotanque")
    private String autotanque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Size(max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultaguiaremisionPK consultaguiaremisionPK;

    public Consultaguiaremision() {
    }

    public Consultaguiaremision(ConsultaguiaremisionPK consultaguiaremisionPK) {
        this.consultaguiaremisionPK = consultaguiaremisionPK;
    }

    public Consultaguiaremision(ConsultaguiaremisionPK consultaguiaremisionPK, String codigoterminal, String numerooe, BigDecimal volumenentregado, String autotanque) {
        this.consultaguiaremisionPK = consultaguiaremisionPK;
        this.codigoterminal = codigoterminal;
        this.numerooe = numerooe;
        this.volumenentregado = volumenentregado;
        this.autotanque = autotanque;
    }

    public Consultaguiaremision(String codigocomercializadora, String numero, String fecha, Date fecharecepcion) {
        this.consultaguiaremisionPK = new ConsultaguiaremisionPK(codigocomercializadora, numero, fecha, fecharecepcion);
    }

    public ConsultaguiaremisionPK getConsultaguiaremisionPK() {
        return consultaguiaremisionPK;
    }

    public void setConsultaguiaremisionPK(ConsultaguiaremisionPK consultaguiaremisionPK) {
        this.consultaguiaremisionPK = consultaguiaremisionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultaguiaremisionPK != null ? consultaguiaremisionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaguiaremision)) {
            return false;
        }
        Consultaguiaremision other = (Consultaguiaremision) object;
        if ((this.consultaguiaremisionPK == null && other.consultaguiaremisionPK != null) || (this.consultaguiaremisionPK != null && !this.consultaguiaremisionPK.equals(other.consultaguiaremisionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Consultaguiaremision[ consultaguiaremisionPK=" + consultaguiaremisionPK + " ]";
    }

    public String getCodigoterminal() {
        return codigoterminal;
    }

    public void setCodigoterminal(String codigoterminal) {
        this.codigoterminal = codigoterminal;
    }

    public String getNumerooe() {
        return numerooe;
    }

    public void setNumerooe(String numerooe) {
        this.numerooe = numerooe;
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

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigDecimal getVolumenentregado() {
        return volumenentregado;
    }

    public void setVolumenentregado(BigDecimal volumenentregado) {
        this.volumenentregado = volumenentregado;
    }

    public String getAutotanque() {
        return autotanque;
    }

    public void setAutotanque(String autotanque) {
        this.autotanque = autotanque;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

}
