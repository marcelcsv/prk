package br.com.bb.uop.geadesp.prk.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author F6750699
 */
@Entity
@Table(name = "UorPos", catalog = "DIAGE", schema = "prk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UorPos.findAll", query = "SELECT u FROM UorPos u")
    , @NamedQuery(name = "UorPos.findByMatricula", query = "SELECT u FROM UorPos u WHERE u.matricula = :matricula")
    , @NamedQuery(name = "UorPos.findByNome", query = "SELECT u FROM UorPos u WHERE u.nome = :nome")
    , @NamedQuery(name = "UorPos.findByNomeGuerra", query = "SELECT u FROM UorPos u WHERE u.nomeGuerra = :nomeGuerra")
    , @NamedQuery(name = "UorPos.findByCodComissao", query = "SELECT u FROM UorPos u WHERE u.codComissao = :codComissao")
    , @NamedQuery(name = "UorPos.findByNomeComissao", query = "SELECT u FROM UorPos u WHERE u.nomeComissao = :nomeComissao")
    , @NamedQuery(name = "UorPos.findByCodNivel", query = "SELECT u FROM UorPos u WHERE u.codNivel = :codNivel")
    , @NamedQuery(name = "UorPos.findByDescNivel", query = "SELECT u FROM UorPos u WHERE u.descNivel = :descNivel")
    , @NamedQuery(name = "UorPos.findByPrefixo", query = "SELECT u FROM UorPos u WHERE u.prefixo = :prefixo")
    , @NamedQuery(name = "UorPos.findByUORpos", query = "SELECT u FROM UorPos u WHERE u.uORpos = :uORpos")
    , @NamedQuery(name = "UorPos.findByEMailFuncionario", query = "SELECT u FROM UorPos u WHERE u.eMailFuncionario = :eMailFuncionario")
    , @NamedQuery(name = "UorPos.findByDataPermissaoAcesso", query = "SELECT u FROM UorPos u WHERE u.dataPermissaoAcesso = :dataPermissaoAcesso")
    , @NamedQuery(name = "UorPos.findByDataAtualizacao", query = "SELECT u FROM UorPos u WHERE u.dataAtualizacao = :dataAtualizacao")})
public class UorPos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Matricula")
    private String matricula;
    @Size(max = 200)
    @Column(name = "Nome")
    private String nome;
    @Size(max = 200)
    @Column(name = "NomeGuerra")
    private String nomeGuerra;
    @Column(name = "CodComissao")
    private Integer codComissao;
    @Size(max = 25)
    @Column(name = "NomeComissao")
    private String nomeComissao;
    @Size(max = 4)
    @Column(name = "CodNivel")
    private String codNivel;
    @Size(max = 50)
    @Column(name = "DescNivel")
    private String descNivel;
    @Column(name = "Prefixo")
    private Integer prefixo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UORpos")
    private int uORpos;
    @Size(max = 50)
    @Column(name = "eMailFuncionario")
    private String eMailFuncionario;
    @Column(name = "DataPermissaoAcesso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPermissaoAcesso;
    @Column(name = "DataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    @JoinColumn(name = "idPermissaoAcesso", referencedColumnName = "idPermissaoAcesso")
    @ManyToOne
    private PermissoesAcesso idPermissaoAcesso;
    @OneToMany(mappedBy = "matricula")
    private Collection<Tags> tagsCollection;
    @OneToMany(mappedBy = "matriculaSolicitante")
    private Collection<Tags> tagsCollection1;

    public UorPos() {
    }

    public UorPos(String matricula) {
        this.matricula = matricula;
    }

    public UorPos(String matricula, int uORpos) {
        this.matricula = matricula;
        this.uORpos = uORpos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    public Integer getCodComissao() {
        return codComissao;
    }

    public void setCodComissao(Integer codComissao) {
        this.codComissao = codComissao;
    }

    public String getNomeComissao() {
        return nomeComissao;
    }

    public void setNomeComissao(String nomeComissao) {
        this.nomeComissao = nomeComissao;
    }

    public String getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(String codNivel) {
        this.codNivel = codNivel;
    }

    public String getDescNivel() {
        return descNivel;
    }

    public void setDescNivel(String descNivel) {
        this.descNivel = descNivel;
    }

    public Integer getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Integer prefixo) {
        this.prefixo = prefixo;
    }

    public int getUORpos() {
        return uORpos;
    }

    public void setUORpos(int uORpos) {
        this.uORpos = uORpos;
    }

    public String getEMailFuncionario() {
        return eMailFuncionario;
    }

    public void setEMailFuncionario(String eMailFuncionario) {
        this.eMailFuncionario = eMailFuncionario;
    }

    public Date getDataPermissaoAcesso() {
        return dataPermissaoAcesso;
    }

    public void setDataPermissaoAcesso(Date dataPermissaoAcesso) {
        this.dataPermissaoAcesso = dataPermissaoAcesso;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public PermissoesAcesso getIdPermissaoAcesso() {
        return idPermissaoAcesso;
    }

    public void setIdPermissaoAcesso(PermissoesAcesso idPermissaoAcesso) {
        this.idPermissaoAcesso = idPermissaoAcesso;
    }

    @XmlTransient
    public Collection<Tags> getTagsCollection() {
        return tagsCollection;
    }

    public void setTagsCollection(Collection<Tags> tagsCollection) {
        this.tagsCollection = tagsCollection;
    }

    @XmlTransient
    public Collection<Tags> getTagsCollection1() {
        return tagsCollection1;
    }

    public void setTagsCollection1(Collection<Tags> tagsCollection1) {
        this.tagsCollection1 = tagsCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UorPos)) {
            return false;
        }
        UorPos other = (UorPos) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.prk.entities.UorPos[ matricula=" + matricula + " ]";
    }
    
}
