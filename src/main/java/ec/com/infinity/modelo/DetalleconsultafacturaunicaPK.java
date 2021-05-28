/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Paul
 */
@Embeddable
public class DetalleconsultafacturaunicaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "numerofactura")
    private String numerofactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharecepcion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-hh:mm:ss")
    private Date fecharecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigoproducto")
    private String codigoproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigomedida")
    private String codigomedida;

    public DetalleconsultafacturaunicaPK() {
    }

    public DetalleconsultafacturaunicaPK(String codigocomercializadora, String numerofactura, String fecha, Date fecharecepcion, String codigoproducto, String codigomedida) {
        this.codigocomercializadora = codigocomercializadora;
        this.numerofactura = numerofactura;
        this.fecha = fecha;
        this.fecharecepcion = fecharecepcion;
        this.codigoproducto = codigoproducto;
        this.codigomedida = codigomedida;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (numerofactura != null ? numerofactura.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (fecharecepcion != null ? fecharecepcion.hashCode() : 0);
        hash += (codigoproducto != null ? codigoproducto.hashCode() : 0);
        hash += (codigomedida != null ? codigomedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleconsultafacturaunicaPK)) {
            return false;
        }
        DetalleconsultafacturaunicaPK other = (DetalleconsultafacturaunicaPK) object;
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.numerofactura == null && other.numerofactura != null) || (this.numerofactura != null && !this.numerofactura.equals(other.numerofactura))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.fecharecepcion == null && other.fecharecepcion != null) || (this.fecharecepcion != null && !this.fecharecepcion.equals(other.fecharecepcion))) {
            return false;
        }
        if ((this.codigoproducto == null && other.codigoproducto != null) || (this.codigoproducto != null && !this.codigoproducto.equals(other.codigoproducto))) {
            return false;
        }
        if ((this.codigomedida == null && other.codigomedida != null) || (this.codigomedida != null && !this.codigomedida.equals(other.codigomedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.DetalleconsultafacturaunicaPK[ codigocomercializadora=" + codigocomercializadora + ", numerofactura=" + numerofactura + ", fecha=" + fecha + ", fecharecepcion=" + fecharecepcion + ", codigoproducto=" + codigoproducto + ", codigomedida=" + codigomedida + " ]";
    }

}
