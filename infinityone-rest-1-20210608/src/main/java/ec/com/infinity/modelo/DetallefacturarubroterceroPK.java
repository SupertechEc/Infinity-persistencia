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
public class DetallefacturarubroterceroPK implements Serializable {
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
    @Size(min = 1, max = 16)
    @Column(name = "numerofactura")
    private String numerofactura;
    @Basic(optional = false)
    @Column(name = "codigorubrotercero")
    private long codigorubrotercero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigoclientecuota")
    private String codigoclientecuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuota")
    private int cuota;

    public DetallefacturarubroterceroPK() {
    }

    public DetallefacturarubroterceroPK(String codigoabastecedora, String codigocomercializadora, String numeronotapedido, String numerofactura, long codigorubrotercero, String codigoclientecuota, int cuota) {
        this.codigoabastecedora = codigoabastecedora;
        this.codigocomercializadora = codigocomercializadora;
        this.numeronotapedido = numeronotapedido;
        this.numerofactura = numerofactura;
        this.codigorubrotercero = codigorubrotercero;
        this.codigoclientecuota = codigoclientecuota;
        this.cuota = cuota;
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

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public long getCodigorubrotercero() {
        return codigorubrotercero;
    }

    public void setCodigorubrotercero(long codigorubrotercero) {
        this.codigorubrotercero = codigorubrotercero;
    }

    public String getCodigoclientecuota() {
        return codigoclientecuota;
    }

    public void setCodigoclientecuota(String codigoclientecuota) {
        this.codigoclientecuota = codigoclientecuota;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoabastecedora != null ? codigoabastecedora.hashCode() : 0);
        hash += (codigocomercializadora != null ? codigocomercializadora.hashCode() : 0);
        hash += (numeronotapedido != null ? numeronotapedido.hashCode() : 0);
        hash += (numerofactura != null ? numerofactura.hashCode() : 0);
        hash += (int) codigorubrotercero;
        hash += (codigoclientecuota != null ? codigoclientecuota.hashCode() : 0);
        hash += (int) cuota;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallefacturarubroterceroPK)) {
            return false;
        }
        DetallefacturarubroterceroPK other = (DetallefacturarubroterceroPK) object;
        if ((this.codigoabastecedora == null && other.codigoabastecedora != null) || (this.codigoabastecedora != null && !this.codigoabastecedora.equals(other.codigoabastecedora))) {
            return false;
        }
        if ((this.codigocomercializadora == null && other.codigocomercializadora != null) || (this.codigocomercializadora != null && !this.codigocomercializadora.equals(other.codigocomercializadora))) {
            return false;
        }
        if ((this.numeronotapedido == null && other.numeronotapedido != null) || (this.numeronotapedido != null && !this.numeronotapedido.equals(other.numeronotapedido))) {
            return false;
        }
        if ((this.numerofactura == null && other.numerofactura != null) || (this.numerofactura != null && !this.numerofactura.equals(other.numerofactura))) {
            return false;
        }
        if (this.codigorubrotercero != other.codigorubrotercero) {
            return false;
        }
        if ((this.codigoclientecuota == null && other.codigoclientecuota != null) || (this.codigoclientecuota != null && !this.codigoclientecuota.equals(other.codigoclientecuota))) {
            return false;
        }
        if (this.cuota != other.cuota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.DetallefacturarubroterceroPK[ codigoabastecedora=" + codigoabastecedora + ", codigocomercializadora=" + codigocomercializadora + ", numeronotapedido=" + numeronotapedido + ", numerofactura=" + numerofactura + ", codigorubrotercero=" + codigorubrotercero + ", codigoclientecuota=" + codigoclientecuota + ", cuota=" + cuota + " ]";
    }
    
}
