/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByNiveloperacion", query = "SELECT p FROM Permiso p WHERE p.permisoPK.niveloperacion = :niveloperacion"),
    @NamedQuery(name = "Permiso.findByCodigomenu", query = "SELECT p FROM Permiso p WHERE p.permisoPK.codigomenu = :codigomenu"),
    @NamedQuery(name = "Permiso.findByUsuarioactual", query = "SELECT p FROM Permiso p WHERE p.usuarioactual = :usuarioactual")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermisoPK permisoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumn(name = "codigomenu", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;

    public Permiso() {
    }

    public Permiso(PermisoPK permisoPK) {
        this.permisoPK = permisoPK;
    }

    public Permiso(PermisoPK permisoPK, String usuarioactual) {
        this.permisoPK = permisoPK;
        this.usuarioactual = usuarioactual;
    }

    public Permiso(String niveloperacion, String codigomenu) {
        this.permisoPK = new PermisoPK(niveloperacion, codigomenu);
    }

    public PermisoPK getPermisoPK() {
        return permisoPK;
    }

    public void setPermisoPK(PermisoPK permisoPK) {
        this.permisoPK = permisoPK;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisoPK != null ? permisoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.permisoPK == null && other.permisoPK != null) || (this.permisoPK != null && !this.permisoPK.equals(other.permisoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Permiso[ permisoPK=" + permisoPK + " ]";
    }
    
}
