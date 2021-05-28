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
public class LogtotalgarantizadoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigocliente")
    private String codigocliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaoperacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaoperacion;
    @Basic(optional = false)
    @Column(name = "secuencial")
    private int secuencial;

    public LogtotalgarantizadoPK() {
    }

    public LogtotalgarantizadoPK(String codigocomercializadora, String codigocliente, Date fechaoperacion, int secuencial) {
        this.codigocomercializadora = codigocomercializadora;
        this.codigocliente = codigocliente;
        this.fechaoperacion = fechaoperacion;
        this.secuencial = secuencial;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }

    public Date getFechaoperacion() {
        return fechaoperacion;
    }

    public void setFechaoperacion(Date fechaoperacion) {
        this.fechaoperacion = fechaoperacion;
    }

    public int getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(int secuencial) {
        this.secuencial = secuencial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (codigocliente != null ? codigocliente.hashCode() : 0);
        hash += (fechaoperacion != null ? fechaoperacion.hashCode() : 0);
        hash += (int) secuencial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogtotalgarantizadoPK)) {
            return false;
        }
        LogtotalgarantizadoPK other = (LogtotalgarantizadoPK) object;
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.codigocliente == null && other.codigocliente != null) || (this.codigocliente != null && !this.codigocliente.equals(other.codigocliente))) {
            return false;
        }
        if ((this.fechaoperacion == null && other.fechaoperacion != null) || (this.fechaoperacion != null && !this.fechaoperacion.equals(other.fechaoperacion))) {
            return false;
        }
        if (this.secuencial != other.secuencial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.LogtotalgarantizadoPK[ codigocomercializadora=" + codigocomercializadora + ", codigocliente=" + codigocliente + ", fechaoperacion=" + fechaoperacion + ", secuencial=" + secuencial + " ]";
    }
    
}
