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
public class ConsultapagofacturaunicaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "numerofacturaunica")
    private String numerofacturaunica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharecepcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecepcion;

    public ConsultapagofacturaunicaPK() {
    }

    public ConsultapagofacturaunicaPK(String codigocomercializadora, String numerofacturaunica, String fecha, Date fecharecepcion) {
        this.codigocomercializadora = codigocomercializadora;
        this.numerofacturaunica = numerofacturaunica;
        this.fecha = fecha;
        this.fecharecepcion = fecharecepcion;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public String getNumerofacturaunica() {
        return numerofacturaunica;
    }

    public void setNumerofacturaunica(String numerofacturaunica) {
        this.numerofacturaunica = numerofacturaunica;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (numerofacturaunica != null ? numerofacturaunica.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (fecharecepcion != null ? fecharecepcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultapagofacturaunicaPK)) {
            return false;
        }
        ConsultapagofacturaunicaPK other = (ConsultapagofacturaunicaPK) object;
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.numerofacturaunica == null && other.numerofacturaunica != null) || (this.numerofacturaunica != null && !this.numerofacturaunica.equals(other.numerofacturaunica))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.fecharecepcion == null && other.fecharecepcion != null) || (this.fecharecepcion != null && !this.fecharecepcion.equals(other.fecharecepcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.ConsultapagofacturaunicaPK[ codigocomercializadora=" + codigocomercializadora + ", numerofacturaunica=" + numerofacturaunica + ", fecha=" + fecha + ", fecharecepcion=" + fecharecepcion + " ]";
    }
    
}
