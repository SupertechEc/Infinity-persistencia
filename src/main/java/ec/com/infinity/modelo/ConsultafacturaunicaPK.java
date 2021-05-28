/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

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
public class ConsultafacturaunicaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerofactura")
    private String numerofactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharecepcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecepcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private String fecha;

    public ConsultafacturaunicaPK() {
    }

    public ConsultafacturaunicaPK(String codigocomercializadora, String numerofactura, Date fecharecepcion, String fecha) {
        this.codigocomercializadora = codigocomercializadora;
        this.numerofactura = numerofactura;
        this.fecharecepcion = fecharecepcion;
        this.fecha = fecha;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (numerofactura != null ? numerofactura.hashCode() : 0);
        hash += (fecharecepcion != null ? fecharecepcion.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultafacturaunicaPK)) {
            return false;
        }
        ConsultafacturaunicaPK other = (ConsultafacturaunicaPK) object;
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.numerofactura == null && other.numerofactura != null) || (this.numerofactura != null && !this.numerofactura.equals(other.numerofactura))) {
            return false;
        }
        if ((this.fecharecepcion == null && other.fecharecepcion != null) || (this.fecharecepcion != null && !this.fecharecepcion.equals(other.fecharecepcion))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.ConsultafacturaunicaPK[ codigocomercializadora=" + codigocomercializadora + ", numerofactura=" + numerofactura + ", fecharecepcion=" + fecharecepcion + ", fecha=" + fecha + " ]";
    }

}
