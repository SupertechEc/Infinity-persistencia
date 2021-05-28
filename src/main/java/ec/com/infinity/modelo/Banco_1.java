/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Entity
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco_1.findAll", query = "SELECT b FROM Banco_1 b"),
    @NamedQuery(name = "Banco_1.findByCodigo", query = "SELECT b FROM Banco_1 b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "Banco_1.findByNombre", query = "SELECT b FROM Banco_1 b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Banco_1.findByActivo", query = "SELECT b FROM Banco_1 b WHERE b.activo = :activo"),
    @NamedQuery(name = "Banco_1.findByUsuarioactual", query = "SELECT b FROM Banco_1 b WHERE b.usuarioactual = :usuarioactual")})
public class Banco_1 implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @OneToMany(mappedBy = "codigobancodebito")
    private List<Cliente_1> cliente1List;
    @OneToMany(mappedBy = "codigobancodebito")
    private List<Comercializadora_1> comercializadora1List;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;

    public Banco_1() {
    }

    public Banco_1(String codigo) {
        this.codigo = codigo;
    }

    public Banco_1(String codigo, String nombre, boolean activo, String usuarioactual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.activo = activo;
        this.usuarioactual = usuarioactual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco_1)) {
            return false;
        }
        Banco_1 other = (Banco_1) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Banco[ codigo=" + codigo + " ]";
    }


    @XmlTransient
    public List<Comercializadora_1> getComercializadora1List() {
        return comercializadora1List;
    }

    public void setComercializadora1List(List<Comercializadora_1> comercializadora1List) {
        this.comercializadora1List = comercializadora1List;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    @XmlTransient
    public List<Cliente_1> getCliente1List() {
        return cliente1List;
    }

    public void setCliente1List(List<Cliente_1> cliente1List) {
        this.cliente1List = cliente1List;
    }
    
}
