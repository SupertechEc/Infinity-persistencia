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
public class DetallepagoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigoabastecedora")
    private String codigoabastecedora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigocomercializadora")
    private String codigocomercializadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "numeronotapedido")
    private String numeronotapedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigobanco")
    private String codigobanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numerofactura")
    private String numerofactura;

    public DetallepagoPK() {
    }

    public DetallepagoPK(String codigoabastecedora, String codigocomercializadora, String numeronotapedido, String numero, String codigobanco, String numerofactura) {
        this.codigoabastecedora = codigoabastecedora;
        this.codigocomercializadora = codigocomercializadora;
        this.numeronotapedido = numeronotapedido;
        this.numero = numero;
        this.codigobanco = codigobanco;
        this.numerofactura = numerofactura;
    }

    public String getCodigoabastecedora() {
        return codigoabastecedora;
    }

    public void setCodigoabastecedora(String codigoabastecedora) {
        this.codigoabastecedora = codigoabastecedora;
    }

    public String getCodigocomercializadora() {
        return codigocomercializadora;
    }

    public void setCodigocomercializadora(String codigocomercializadora) {
        this.codigocomercializadora = codigocomercializadora;
    }

    public String getNumeronotapedido() {
        return numeronotapedido;
    }

    public void setNumeronotapedido(String numeronotapedido) {
        this.numeronotapedido = numeronotapedido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigobanco() {
        return codigobanco;
    }

    public void setCodigobanco(String codigobanco) {
        this.codigobanco = codigobanco;
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
        hash += (codigoabastecedora != null ? codigoabastecedora.hashCode() : 0);
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (numeronotapedido != null ? numeronotapedido.hashCode() : 0);
        hash += (numero != null ? numero.hashCode() : 0);
        hash += (codigobanco != null ? codigobanco.hashCode() : 0);
        hash += (numerofactura != null ? numerofactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallepagoPK)) {
            return false;
        }
        DetallepagoPK other = (DetallepagoPK) object;
        if ((this.codigoabastecedora == null && other.codigoabastecedora != null) || (this.codigoabastecedora != null && !this.codigoabastecedora.equals(other.codigoabastecedora))) {
            return false;
        }
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.numeronotapedido == null && other.numeronotapedido != null) || (this.numeronotapedido != null && !this.numeronotapedido.equals(other.numeronotapedido))) {
            return false;
        }
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        if ((this.codigobanco == null && other.codigobanco != null) || (this.codigobanco != null && !this.codigobanco.equals(other.codigobanco))) {
            return false;
        }
        if ((this.numerofactura == null && other.numerofactura != null) || (this.numerofactura != null && !this.numerofactura.equals(other.numerofactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.DetallepagoPK[ codigoabastecedora=" + codigoabastecedora + ", codigocomercializadora=" + codigocomercializadora + ", numeronotapedido=" + numeronotapedido + ", numero=" + numero + ", codigobanco=" + codigobanco + ", numerofactura=" + numerofactura + " ]";
    }
    
}
