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
 * @author Fernando Tapia
 */
@Embeddable
public class TemporalparacobrarPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechahoraproceso")
    @Size(min = 1, max = 30)
    private String fechahoraproceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numerofactura")
    private String numerofactura;

    public TemporalparacobrarPK() {
    }

    public TemporalparacobrarPK(String fechahoraproceso, String usuarioactual, String codigocomercializadora, String numerofactura) {
        this.fechahoraproceso = fechahoraproceso;
        this.usuarioactual = usuarioactual;
        this.codigocomercializadora = codigocomercializadora;
        this.numerofactura = numerofactura;
    }

    public String getFechahoraproceso() {
        return fechahoraproceso;
    }

    public void setFechahoraproceso(String fechahoraproceso) {
        this.fechahoraproceso = fechahoraproceso;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechahoraproceso != null ? fechahoraproceso.hashCode() : 0);
        hash += (usuarioactual != null ? usuarioactual.hashCode() : 0);
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (numerofactura != null ? numerofactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemporalparacobrarPK)) {
            return false;
        }
        TemporalparacobrarPK other = (TemporalparacobrarPK) object;
        if ((this.fechahoraproceso == null && other.fechahoraproceso != null) || (this.fechahoraproceso != null && !this.fechahoraproceso.equals(other.fechahoraproceso))) {
            return false;
        }
        if ((this.usuarioactual == null && other.usuarioactual != null) || (this.usuarioactual != null && !this.usuarioactual.equals(other.usuarioactual))) {
            return false;
        }
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.numerofactura == null && other.numerofactura != null) || (this.numerofactura != null && !this.numerofactura.equals(other.numerofactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.TemporalparacobrarPK[ fechahoraproceso=" + fechahoraproceso + ", usuarioactual=" + usuarioactual + ", codigocomercializadora=" + codigocomercializadora + ", numerofactura=" + numerofactura + " ]";
    }
    
}
