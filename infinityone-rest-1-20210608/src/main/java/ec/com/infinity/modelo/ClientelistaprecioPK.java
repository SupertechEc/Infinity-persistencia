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
 * @author Paul
 */
@Embeddable
public class ClientelistaprecioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "lis_codigo")
    private String lisCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigocliente")
    private String codigocliente;

    public ClientelistaprecioPK() {
    }

    public ClientelistaprecioPK(String codigocomercializadora, String lisCodigo, String codigocliente) {
        this.codigocomercializadora = codigocomercializadora;
        this.lisCodigo = lisCodigo;
        this.codigocliente = codigocliente;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public String getLisCodigo() {
        return lisCodigo;
    }

    public void setLisCodigo(String lisCodigo) {
        this.lisCodigo = lisCodigo;
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
        hash += (lisCodigo != null ? lisCodigo.hashCode() : 0);
        hash += (codigocliente != null ? codigocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientelistaprecioPK)) {
            return false;
        }
        ClientelistaprecioPK other = (ClientelistaprecioPK) object;
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.lisCodigo == null && other.lisCodigo != null) || (this.lisCodigo != null && !this.lisCodigo.equals(other.lisCodigo))) {
            return false;
        }
        if ((this.codigocliente == null && other.codigocliente != null) || (this.codigocliente != null && !this.codigocliente.equals(other.codigocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.ClientelistaprecioPK[ codigocomercializadora=" + codigocomercializadora + ", lisCodigo=" + lisCodigo + ", codigocliente=" + codigocliente + " ]";
    }
    
}
