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
public class FacturadordespachadorPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigoterminal")
    private String codigoterminal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigousuario")
    private String codigousuario;

    public FacturadordespachadorPK() {
    }

    public FacturadordespachadorPK(String codigocomercializadora, String codigoterminal, String codigousuario) {
        this.codigocomercializadora = codigocomercializadora;
        this.codigoterminal = codigoterminal;
        this.codigousuario = codigousuario;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public String getCodigoterminal() {
        return codigoterminal;
    }

    public void setCodigoterminal(String codigoterminal) {
        this.codigoterminal = codigoterminal;
    }

    public String getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(String codigousuario) {
        this.codigousuario = codigousuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (codigoterminal != null ? codigoterminal.hashCode() : 0);
        hash += (codigousuario != null ? codigousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturadordespachadorPK)) {
            return false;
        }
        FacturadordespachadorPK other = (FacturadordespachadorPK) object;
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.codigoterminal == null && other.codigoterminal != null) || (this.codigoterminal != null && !this.codigoterminal.equals(other.codigoterminal))) {
            return false;
        }
        if ((this.codigousuario == null && other.codigousuario != null) || (this.codigousuario != null && !this.codigousuario.equals(other.codigousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.FacturadordespachadorPK[ codigocomercializadora=" + codigocomercializadora + ", codigoterminal=" + codigoterminal + ", codigousuario=" + codigousuario + " ]";
    }
    
}
