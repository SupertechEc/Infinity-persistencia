/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
//@Entity
//@Table(name = "areamercadeo")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Areamercadeo.findAll", query = "SELECT a FROM Areamercadeo a"),
//    @NamedQuery(name = "Areamercadeo.findByCodigo", query = "SELECT a FROM Areamercadeo a WHERE a.codigo = :codigo"),
//    @NamedQuery(name = "Areamercadeo.findByNombre", query = "SELECT a FROM Areamercadeo a WHERE a.nombre = :nombre"),
//    @NamedQuery(name = "Areamercadeo.findByActivo", query = "SELECT a FROM Areamercadeo a WHERE a.activo = :activo"),
//    @NamedQuery(name = "Areamercadeo.findByUsuarioactual", query = "SELECT a FROM Areamercadeo a WHERE a.usuarioactual = :usuarioactual")})
public class MejorCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 100)
    @Column(name = "nombrecliente")
    private String nombrecliente;
    @Column(name = "sumatotal")
    private BigDecimal sumatotal;
    @Column(name = "facturas")
    private Integer facturas;

    public MejorCliente() {
    }

    public MejorCliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public MejorCliente(String nombrecliente, BigDecimal sumatotal, Integer facturas) {
        
        this.nombrecliente = nombrecliente;
        this.sumatotal = sumatotal;
        this.facturas = facturas;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public BigDecimal getSumatotal() {
        return sumatotal;
    }

    public void setSumatotal(BigDecimal sumatotal) {
        this.sumatotal = sumatotal;
    }

    public Integer getFacturas() {
        return facturas;
    }

    public void setFacturas(Integer facturas) {
        this.facturas = facturas;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombrecliente != null ? nombrecliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MejorCliente)) {
            return false;
        }
        MejorCliente other = (MejorCliente) object;
        if ((this.nombrecliente == null && other.nombrecliente != null) || (this.nombrecliente != null && !this.nombrecliente.equals(other.nombrecliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Areamercadeo[ nombrecliente=" + nombrecliente + " ]";
    }
    
}
