package br.com.bb.uop.geadesp.prk.entities;

import java.io.Serializable;
import java.util.Collection;
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
 * @author F6750699
 */
@Entity
@Table(name = "Prefixos", catalog = "DIAGE", schema = "prk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prefixos.findAll", query = "SELECT p FROM Prefixos p")
    , @NamedQuery(name = "Prefixos.findByPrefixo", query = "SELECT p FROM Prefixos p WHERE p.prefixo = :prefixo")
    , @NamedQuery(name = "Prefixos.findByNomePrefixo", query = "SELECT p FROM Prefixos p WHERE p.nomePrefixo = :nomePrefixo")
    , @NamedQuery(name = "Prefixos.findByEMailInterno", query = "SELECT p FROM Prefixos p WHERE p.eMailInterno = :eMailInterno")
    , @NamedQuery(name = "Prefixos.findByEMailExterno", query = "SELECT p FROM Prefixos p WHERE p.eMailExterno = :eMailExterno")})
public class Prefixos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prefixo")
    private Integer prefixo;
    @Size(max = 100)
    @Column(name = "NomePrefixo")
    private String nomePrefixo;
    @Size(max = 25)
    @Column(name = "eMailInterno")
    private String eMailInterno;
    @Size(max = 25)
    @Column(name = "eMailExterno")
    private String eMailExterno;
    @OneToMany(mappedBy = "prefixo")
    private Collection<Jurisdicionadas> jurisdicionadasCollection;
    @OneToMany(mappedBy = "prefixo")
    private Collection<Tags> tagsCollection;

    public Prefixos() {
    }

    public Prefixos(Integer prefixo) {
        this.prefixo = prefixo;
    }

    public Integer getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Integer prefixo) {
        this.prefixo = prefixo;
    }

    public String getNomePrefixo() {
        return nomePrefixo;
    }

    public void setNomePrefixo(String nomePrefixo) {
        this.nomePrefixo = nomePrefixo;
    }

    public String getEMailInterno() {
        return eMailInterno;
    }

    public void setEMailInterno(String eMailInterno) {
        this.eMailInterno = eMailInterno;
    }

    public String getEMailExterno() {
        return eMailExterno;
    }

    public void setEMailExterno(String eMailExterno) {
        this.eMailExterno = eMailExterno;
    }

    @XmlTransient
    public Collection<Jurisdicionadas> getJurisdicionadasCollection() {
        return jurisdicionadasCollection;
    }

    public void setJurisdicionadasCollection(Collection<Jurisdicionadas> jurisdicionadasCollection) {
        this.jurisdicionadasCollection = jurisdicionadasCollection;
    }

    @XmlTransient
    public Collection<Tags> getTagsCollection() {
        return tagsCollection;
    }

    public void setTagsCollection(Collection<Tags> tagsCollection) {
        this.tagsCollection = tagsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prefixo != null ? prefixo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prefixos)) {
            return false;
        }
        Prefixos other = (Prefixos) object;
        if ((this.prefixo == null && other.prefixo != null) || (this.prefixo != null && !this.prefixo.equals(other.prefixo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.prk.entities.Prefixos[ prefixo=" + prefixo + " ]";
    }
    
}
