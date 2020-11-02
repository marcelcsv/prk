package br.com.bb.uop.geadesp.prk.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "PermissoesAcesso", catalog = "DIAGE", schema = "prk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissoesAcesso.findAll", query = "SELECT p FROM PermissoesAcesso p")
    , @NamedQuery(name = "PermissoesAcesso.findByIdPermissaoAcesso", query = "SELECT p FROM PermissoesAcesso p WHERE p.idPermissaoAcesso = :idPermissaoAcesso")
    , @NamedQuery(name = "PermissoesAcesso.findByNomeAcesso", query = "SELECT p FROM PermissoesAcesso p WHERE p.nomeAcesso = :nomeAcesso")
    , @NamedQuery(name = "PermissoesAcesso.findBySiglaAcesso", query = "SELECT p FROM PermissoesAcesso p WHERE p.siglaAcesso = :siglaAcesso")})
public class PermissoesAcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPermissaoAcesso")
    private Integer idPermissaoAcesso;
    @Size(max = 100)
    @Column(name = "NomeAcesso")
    private String nomeAcesso;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "DescricaoAcesso")
    private String descricaoAcesso;
    @Size(max = 10)
    @Column(name = "SiglaAcesso")
    private String siglaAcesso;
    @OneToMany(mappedBy = "idPermissaoAcesso")
    private Collection<UorPos> uorPosCollection;

    public PermissoesAcesso() {
    }

    public PermissoesAcesso(Integer idPermissaoAcesso) {
        this.idPermissaoAcesso = idPermissaoAcesso;
    }

    public Integer getIdPermissaoAcesso() {
        return idPermissaoAcesso;
    }

    public void setIdPermissaoAcesso(Integer idPermissaoAcesso) {
        this.idPermissaoAcesso = idPermissaoAcesso;
    }

    public String getNomeAcesso() {
        return nomeAcesso;
    }

    public void setNomeAcesso(String nomeAcesso) {
        this.nomeAcesso = nomeAcesso;
    }

    public String getDescricaoAcesso() {
        return descricaoAcesso;
    }

    public void setDescricaoAcesso(String descricaoAcesso) {
        this.descricaoAcesso = descricaoAcesso;
    }

    public String getSiglaAcesso() {
        return siglaAcesso;
    }

    public void setSiglaAcesso(String siglaAcesso) {
        this.siglaAcesso = siglaAcesso;
    }

    @XmlTransient
    public Collection<UorPos> getUorPosCollection() {
        return uorPosCollection;
    }

    public void setUorPosCollection(Collection<UorPos> uorPosCollection) {
        this.uorPosCollection = uorPosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissaoAcesso != null ? idPermissaoAcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissoesAcesso)) {
            return false;
        }
        PermissoesAcesso other = (PermissoesAcesso) object;
        if ((this.idPermissaoAcesso == null && other.idPermissaoAcesso != null) || (this.idPermissaoAcesso != null && !this.idPermissaoAcesso.equals(other.idPermissaoAcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.prk.entities.PermissoesAcesso[ idPermissaoAcesso=" + idPermissaoAcesso + " ]";
    }
    
}
