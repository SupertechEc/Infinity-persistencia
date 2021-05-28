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
@Table(name = "facturadordespachador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturadordespachador.findAll", query = "SELECT f FROM Facturadordespachador f"),
    @NamedQuery(name = "Facturadordespachador.findByCodigocomercializadora", query = "SELECT f FROM Facturadordespachador f WHERE f.facturadordespachadorPK.codigocomercializadora = :codigocomercializadora"),
    @NamedQuery(name = "Facturadordespachador.findByCodigoterminal", query = "SELECT f FROM Facturadordespachador f WHERE f.facturadordespachadorPK.codigoterminal = :codigoterminal"),
    @NamedQuery(name = "Facturadordespachador.findByCodigousuario", query = "SELECT f FROM Facturadordespachador f WHERE f.facturadordespachadorPK.codigousuario = :codigousuario"),
    @NamedQuery(name = "Facturadordespachador.findByActivo", query = "SELECT f FROM Facturadordespachador f WHERE f.activo = :activo"),
    @NamedQuery(name = "Facturadordespachador.findByUsuarioactual", query = "SELECT f FROM Facturadordespachador f WHERE f.usuarioactual = :usuarioactual")})
public class Facturadordespachador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturadordespachadorPK facturadordespachadorPK;
    @Column(name = "activo")
    private Boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuarioactual")
    private String usuarioactual;
    @JoinColumn(name = "codigocomercializadora", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comercializadora_1 comercializadora;
    @JoinColumn(name = "codigoterminal", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Terminal_1 terminal;

    public Facturadordespachador() {
    }

    public Facturadordespachador(FacturadordespachadorPK facturadordespachadorPK) {
        this.facturadordespachadorPK = facturadordespachadorPK;
    }

    public Facturadordespachador(FacturadordespachadorPK facturadordespachadorPK, String usuarioactual) {
        this.facturadordespachadorPK = facturadordespachadorPK;
        this.usuarioactual = usuarioactual;
    }

    public Facturadordespachador(String codigocomercializadora, String codigoterminal, String codigousuario) {
        this.facturadordespachadorPK = new FacturadordespachadorPK(codigocomercializadora, codigoterminal, codigousuario);
    }

    public FacturadordespachadorPK getFacturadordespachadorPK() {
        return facturadordespachadorPK;
    }

    public void setFacturadordespachadorPK(FacturadordespachadorPK facturadordespachadorPK) {
        this.facturadordespachadorPK = facturadordespachadorPK;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getUsuarioactual() {
        return usuarioactual;
    }

    public void setUsuarioactual(String usuarioactual) {
        this.usuarioactual = usuarioactual;
    }

    public Comercializadora_1 getComercializadora() {
        return comercializadora;
    }

    public void setComercializadora(Comercializadora_1 comercializadora) {
        this.comercializadora = comercializadora;
    }

    public Terminal_1 getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal_1 terminal) {
        this.terminal = terminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturadordespachadorPK != null ? facturadordespachadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturadordespachador)) {
            return false;
        }
        Facturadordespachador other = (Facturadordespachador) object;
        if ((this.facturadordespachadorPK == null && other.facturadordespachadorPK != null) || (this.facturadordespachadorPK != null && !this.facturadordespachadorPK.equals(other.facturadordespachadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.infinity.modelo.Facturadordespachador[ facturadordespachadorPK=" + facturadordespachadorPK + " ]";
    }
    
}
