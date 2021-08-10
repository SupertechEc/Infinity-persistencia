/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fernando Tapia
 */
@Embeddable
public class ClienterubroterceroPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @Column(name = "codigorubrotercero")
    private long codigorubrotercero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigocliente")
    private String codigocliente;

    public ClienterubroterceroPK() {
    }

    public ClienterubroterceroPK(String codigocomercializadora, long codigorubrotercero, String codigocliente) {
        this.codigocomercializadora = codigocomercializadora;
        this.codigorubrotercero = codigorubrotercero;
        this.codigocliente = codigocliente;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public long getCodigorubrotercero() {
        return codigorubrotercero;
    }

    public void setCodigorubrotercero(long codigorubrotercero) {
        this.codigorubrotercero = codigorubrotercero;
    }

    public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (int) codigorubrotercero;
        hash += (codigocliente != null ? codigocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienterubroterceroPK)) {
            return false;
        }
        ClienterubroterceroPK other = (ClienterubroterceroPK) object;
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if (this.codigorubrotercero != other.codigorubrotercero) {
            return false;
        }
        if ((this.codigocliente == null && other.codigocliente != null) || (this.codigocliente != null && !this.codigocliente.equals(other.codigocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.ClienterubroterceroPK[ codigocomercializadora=" + codigocomercializadora + ", codigorubrotercero=" + codigorubrotercero + ", codigocliente=" + codigocliente + " ]";
    }
    
}
