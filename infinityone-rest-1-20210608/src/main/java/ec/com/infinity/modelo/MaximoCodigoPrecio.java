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
public class MaximoCodigoPrecio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo")
    private long codigoPrecio;

    public MaximoCodigoPrecio() {
    }

    public MaximoCodigoPrecio(long codigoPrecio) {
        this.codigoPrecio = codigoPrecio;
    }

    public long getCodigoPrecio() {
        return codigoPrecio;
    }

    public void setCodigoPrecio(long codigoPrecio) {
        this.codigoPrecio = codigoPrecio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int)codigoPrecio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaximoCodigoPrecio)) {
            return false;
        }
        MaximoCodigoPrecio other = (MaximoCodigoPrecio) object;
        if (this.codigoPrecio != other.codigoPrecio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.MaximoCodigoPrecio[ codigoPrecio=" + codigoPrecio + " ]";
    }
    
}
