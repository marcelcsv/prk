package br.com.bb.uop.geadesp.prk.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author F6750699
 */
@Entity
@Table(name = "Ativa", catalog = "DIAGE", schema = "prk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ativa.findAll", query = "SELECT a FROM Ativa a")
    , @NamedQuery(name = "Ativa.findByIdAtiva", query = "SELECT a FROM Ativa a WHERE a.idAtiva = :idAtiva")
    , @NamedQuery(name = "Ativa.findByNomeAtiva", query = "SELECT a FROM Ativa a WHERE a.nomeAtiva = :nomeAtiva")
    , @NamedQuery(name = "Ativa.findByDescricaoAtiva", query = "SELECT a FROM Ativa a WHERE a.descricaoAtiva = :descricaoAtiva")})
public class Ativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAtiva")
    private Integer idAtiva;
    @Size(max = 200)
    @Column(name = "NomeAtiva")
    private String nomeAtiva;
    @Size(max = 200)
    @Column(name = "DescricaoAtiva")
    private String descricaoAtiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ativa")
    private Collection<Tags> tagsCollection;

    public Ativa() {
    }

    public Ativa(Integer idAtiva) {
        this.idAtiva = idAtiva;
    }

    public Integer getIdAtiva() {
        return idAtiva;
    }

    public void setIdAtiva(Integer idAtiva) {
        this.idAtiva = idAtiva;
    }

    public String getNomeAtiva() {
        return nomeAtiva;
    }

    public void setNomeAtiva(String nomeAtiva) {
        this.nomeAtiva = nomeAtiva;
    }

    public String getDescricaoAtiva() {
        return descricaoAtiva;
    }

    public void setDescricaoAtiva(String descricaoAtiva) {
        this.descricaoAtiva = descricaoAtiva;
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
        hash += (idAtiva != null ? idAtiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ativa)) {
            return false;
        }
        Ativa other = (Ativa) object;
        if ((this.idAtiva == null && other.idAtiva != null) || (this.idAtiva != null && !this.idAtiva.equals(other.idAtiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.prk.entities.Ativa[ idAtiva=" + idAtiva + " ]";
    }
    
}
