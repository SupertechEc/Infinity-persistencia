/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
public class TotalParaCobrar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 02)
    @Column(name = "banco")
    private String banco;
    //@Size(max = 02)
    @Column(name = "fechavencimiento")
    private String fechavencimiento;
    @Column(name = "valortotal")
    private BigDecimal valortotal;
    @Column(name = "valortotalconrubro")
    private BigDecimal valortotalconrubro;
    @Column(name = "facturas")
    private Integer facturas;

    public TotalParaCobrar() {
    }

    public TotalParaCobrar(String banco) {
        this.banco = banco;
    }

    public TotalParaCobrar(String banco, String fechavencimiento, BigDecimal valortotal, BigDecimal valortotalconrubro, Integer facturas) {
        
        this.banco = banco;
        this.fechavencimiento = fechavencimiento;
        this.valortotal = valortotal;
        this.valortotalconrubro = valortotalconrubro;
        this.facturas = facturas;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banco != null ? banco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TotalParaCobrar)) {
            return false;
        }
        TotalParaCobrar other = (TotalParaCobrar) object;
        if ((this.banco == null && other.banco != null) || (this.banco != null && !this.banco.equals(other.banco))) {
            return false;
        }
        return true;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public BigDecimal getValortotalconrubro() {
        return valortotalconrubro;
    }

    public void setValortotalconrubro(BigDecimal valortotalconrubro) {
        this.valortotalconrubro = valortotalconrubro;
    }

    public Integer getFacturas() {
        return facturas;
    }

    public void setFacturas(Integer facturas) {
        this.facturas = facturas;
    }
    
    

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.TotalParaCobrar[ banco= " + banco + "F. vencimiento= " + fechavencimiento + " ]";
    }
    
}
