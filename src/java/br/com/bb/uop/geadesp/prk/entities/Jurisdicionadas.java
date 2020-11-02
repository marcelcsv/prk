package br.com.bb.uop.geadesp.prk.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author F6750699
 */
@Entity
@Table(name = "Jurisdicionadas", catalog = "DIAGE", schema = "prk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jurisdicionadas.findAll", query = "SELECT j FROM Jurisdicionadas j")
    , @NamedQuery(name = "Jurisdicionadas.findByIdJurisdicionada", query = "SELECT j FROM Jurisdicionadas j WHERE j.idJurisdicionada = :idJurisdicionada")
    , @NamedQuery(name = "Jurisdicionadas.findByPrefixoJurisdicionada", query = "SELECT j FROM Jurisdicionadas j WHERE j.prefixoJurisdicionada = :prefixoJurisdicionada")
    , @NamedQuery(name = "Jurisdicionadas.findByNomePrefixoJurisdicionada", query = "SELECT j FROM Jurisdicionadas j WHERE j.nomePrefixoJurisdicionada = :nomePrefixoJurisdicionada")})
public class Jurisdicionadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJurisdicionada")
    private Integer idJurisdicionada;
    @Column(name = "PrefixoJurisdicionada")
    private Integer prefixoJurisdicionada;
    @Size(max = 200)
    @Column(name = "NomePrefixoJurisdicionada")
    private String nomePrefixoJurisdicionada;
    @JoinColumn(name = "Prefixo", referencedColumnName = "Prefixo")
    @ManyToOne
    private Prefixos prefixo;

    public Jurisdicionadas() {
    }

    public Jurisdicionadas(Integer idJurisdicionada) {
        this.idJurisdicionada = idJurisdicionada;
    }

    public Integer getIdJurisdicionada() {
        return idJurisdicionada;
    }

    public void setIdJurisdicionada(Integer idJurisdicionada) {
        this.idJurisdicionada = idJurisdicionada;
    }

    public Integer getPrefixoJurisdicionada() {
        return prefixoJurisdicionada;
    }

    public void setPrefixoJurisdicionada(Integer prefixoJurisdicionada) {
        this.prefixoJurisdicionada = prefixoJurisdicionada;
    }

    public String getNomePrefixoJurisdicionada() {
        return nomePrefixoJurisdicionada;
    }

    public void setNomePrefixoJurisdicionada(String nomePrefixoJurisdicionada) {
        this.nomePrefixoJurisdicionada = nomePrefixoJurisdicionada;
    }

    public Prefixos getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Prefixos prefixo) {
        this.prefixo = prefixo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJurisdicionada != null ? idJurisdicionada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jurisdicionadas)) {
            return false;
        }
        Jurisdicionadas other = (Jurisdicionadas) object;
        if ((this.idJurisdicionada == null && other.idJurisdicionada != null) || (this.idJurisdicionada != null && !this.idJurisdicionada.equals(other.idJurisdicionada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.prk.entities.Jurisdicionadas[ idJurisdicionada=" + idJurisdicionada + " ]";
    }
    
}
