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
public class ListaprecioterminalproductoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @Column(name = "codigolistaprecio")
    private long codigolistaprecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigoterminal")
    private String codigoterminal;
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

    public ListaprecioterminalproductoPK() {
    }

    public ListaprecioterminalproductoPK(String codigocomercializadora, long codigolistaprecio, String codigoterminal, String codigoproducto, String codigomedida) {
        this.codigocomercializadora = codigocomercializadora;
        this.codigolistaprecio = codigolistaprecio;
        this.codigoterminal = codigoterminal;
        this.codigoproducto = codigoproducto;
        this.codigomedida = codigomedida;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public long getCodigolistaprecio() {
        return codigolistaprecio;
    }

    public void setCodigolistaprecio(long codigolistaprecio) {
        this.codigolistaprecio = codigolistaprecio;
    }

    public String getCodigoterminal() {
        return codigoterminal;
    }

    public void setCodigoterminal(String codigoterminal) {
        this.codigoterminal = codigoterminal;
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
        hash += (int)codigolistaprecio;
        hash += (codigoterminal != null ? codigoterminal.hashCode() : 0);
        hash += (codigoproducto != null ? codigoproducto.hashCode() : 0);
        hash += (codigomedida != null ? codigomedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaprecioterminalproductoPK)) {
            return false;
        }
        ListaprecioterminalproductoPK other = (ListaprecioterminalproductoPK) object;
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if (this.codigolistaprecio != other.codigolistaprecio) {
            return false;
        }
        if ((this.codigoterminal == null && other.codigoterminal != null) || (this.codigoterminal != null && !this.codigoterminal.equals(other.codigoterminal))) {
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
        return "ec.com.infinity.modelo.ListaprecioterminalproductoPK[ codigocomercializadora=" + codigocomercializadora + ", codigolistaprecio=" + codigolistaprecio + ", codigoterminal=" + codigoterminal + ", codigoproducto=" + codigoproducto + ", codigomedida=" + codigomedida + " ]";
    }
    
}
