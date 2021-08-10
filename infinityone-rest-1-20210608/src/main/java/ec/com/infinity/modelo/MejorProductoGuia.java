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
public class MejorProductoGuia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 100)
    @Column(name = "nombremes")
    private String nombremes;
    @Size(max = 100)
    @Column(name = "nombreproducto")
    private String nombreproducto;
    @Column(name = "volumentotal")
    private BigDecimal volumentotal;
    

    public MejorProductoGuia() {
    }

    public MejorProductoGuia(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public MejorProductoGuia(String nombremes, String nombreproducto, BigDecimal volumentotal) {
        
        this.nombremes = nombremes;
        this.nombreproducto = nombreproducto;
        this.volumentotal = volumentotal;
    }

    public String getNombremes() {
        return nombremes;
    }

    public void setNombremes(String nombremes) {
        this.nombremes = nombremes;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public BigDecimal getVolumentotal() {
        return volumentotal;
    }

    public void setVolumentotal(BigDecimal volumentotal) {
        this.volumentotal = volumentotal;
    }

       

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreproducto != null ? nombreproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MejorProductoGuia)) {
            return false;
        }
        MejorProductoGuia other = (MejorProductoGuia) object;
        if ((this.nombremes == null && other.nombremes != null) || (this.nombreproducto != null && !this.nombreproducto.equals(other.nombreproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.MejorProductoGuia[ nombremes=" + nombremes + " nombreproducto=" + nombreproducto + " ]";
    }
    
}
