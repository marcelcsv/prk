package br.com.bb.uop.geadesp.prk.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author F6750699
 */
@Entity
@Table(name = "Tags", catalog = "DIAGE", schema = "prk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tags.findAll", query = "SELECT t FROM Tags t")
    , @NamedQuery(name = "Tags.findByTag", query = "SELECT t FROM Tags t WHERE t.tag = :tag")
    , @NamedQuery(name = "Tags.findBySegundaVia", query = "SELECT t FROM Tags t WHERE t.segundaVia = :segundaVia")
    , @NamedQuery(name = "Tags.findByAcessoEstacionamento", query = "SELECT t FROM Tags t WHERE t.acessoEstacionamento = :acessoEstacionamento")
    , @NamedQuery(name = "Tags.findByNome", query = "SELECT t FROM Tags t WHERE t.nome = :nome")
    , @NamedQuery(name = "Tags.findBySituacao", query = "SELECT t FROM Tags t WHERE t.situacao = :situacao")
    , @NamedQuery(name = "Tags.findByVeiculo1", query = "SELECT t FROM Tags t WHERE t.veiculo1 = :veiculo1")
    , @NamedQuery(name = "Tags.findByVeiculo2", query = "SELECT t FROM Tags t WHERE t.veiculo2 = :veiculo2")
    , @NamedQuery(name = "Tags.findByVeiculo3", query = "SELECT t FROM Tags t WHERE t.veiculo3 = :veiculo3")
    , @NamedQuery(name = "Tags.findByUFComercial", query = "SELECT t FROM Tags t WHERE t.uFComercial = :uFComercial")
    , @NamedQuery(name = "Tags.findByBairroComercial", query = "SELECT t FROM Tags t WHERE t.bairroComercial = :bairroComercial")
    , @NamedQuery(name = "Tags.findByLogradouroComercial", query = "SELECT t FROM Tags t WHERE t.logradouroComercial = :logradouroComercial")
    , @NamedQuery(name = "Tags.findByLatitudeComercial", query = "SELECT t FROM Tags t WHERE t.latitudeComercial = :latitudeComercial")
    , @NamedQuery(name = "Tags.findByLongitudeComercial", query = "SELECT t FROM Tags t WHERE t.longitudeComercial = :longitudeComercial")
    , @NamedQuery(name = "Tags.findByCEPComercial", query = "SELECT t FROM Tags t WHERE t.cEPComercial = :cEPComercial")
    , @NamedQuery(name = "Tags.findByUFResidencial", query = "SELECT t FROM Tags t WHERE t.uFResidencial = :uFResidencial")
    , @NamedQuery(name = "Tags.findByBairroResidencial", query = "SELECT t FROM Tags t WHERE t.bairroResidencial = :bairroResidencial")
    , @NamedQuery(name = "Tags.findByLogradouroResidencial", query = "SELECT t FROM Tags t WHERE t.logradouroResidencial = :logradouroResidencial")
    , @NamedQuery(name = "Tags.findByCEPResidencial", query = "SELECT t FROM Tags t WHERE t.cEPResidencial = :cEPResidencial")
    , @NamedQuery(name = "Tags.findByLatitudeResidencial", query = "SELECT t FROM Tags t WHERE t.latitudeResidencial = :latitudeResidencial")
    , @NamedQuery(name = "Tags.findByLongitudeResidencial", query = "SELECT t FROM Tags t WHERE t.longitudeResidencial = :longitudeResidencial")
    , @NamedQuery(name = "Tags.findByDistancia", query = "SELECT t FROM Tags t WHERE t.distancia = :distancia")
    , @NamedQuery(name = "Tags.findByValeTransporte", query = "SELECT t FROM Tags t WHERE t.valeTransporte = :valeTransporte")
    , @NamedQuery(name = "Tags.findByDataAtualizacao", query = "SELECT t FROM Tags t WHERE t.dataAtualizacao = :dataAtualizacao")})
public class Tags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tag")
    private Integer tag;
    @Size(max = 2000)
    @Column(name = "SegundaVia")
    private String segundaVia;
    @Size(max = 20)
    @Column(name = "AcessoEstacionamento")
    private String acessoEstacionamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Situacao")
    private String situacao;
    @Size(max = 200)
    @Column(name = "Veiculo_1")
    private String veiculo1;
    @Size(max = 200)
    @Column(name = "Veiculo_2")
    private String veiculo2;
    @Size(max = 200)
    @Column(name = "Veiculo_3")
    private String veiculo3;
    @Size(max = 2)
    @Column(name = "UF_Comercial")
    private String uFComercial;
    @Size(max = 100)
    @Column(name = "Bairro_Comercial")
    private String bairroComercial;
    @Size(max = 1000)
    @Column(name = "Logradouro_Comercial")
    private String logradouroComercial;
    @Size(max = 50)
    @Column(name = "Latitude_Comercial")
    private String latitudeComercial;
    @Size(max = 50)
    @Column(name = "Longitude_Comercial")
    private String longitudeComercial;
    @Size(max = 9)
    @Column(name = "CEP_Comercial")
    private String cEPComercial;
    @Size(max = 2)
    @Column(name = "UF_Residencial")
    private String uFResidencial;
    @Size(max = 100)
    @Column(name = "Bairro_Residencial")
    private String bairroResidencial;
    @Size(max = 1000)
    @Column(name = "Logradouro_Residencial")
    private String logradouroResidencial;
    @Size(max = 9)
    @Column(name = "CEP_Residencial")
    private String cEPResidencial;
    @Size(max = 50)
    @Column(name = "Latitude_Residencial")
    private String latitudeResidencial;
    @Size(max = 50)
    @Column(name = "Longitude_Residencial")
    private String longitudeResidencial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Distancia")
    private Double distancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    @Size(max = 50)
    @Column(name = "ValeTransporte")
    private String valeTransporte;
    @JoinColumn(name = "Ativa", referencedColumnName = "idAtiva")
    @ManyToOne(optional = false)
    private Ativa ativa;
    @JoinColumn(name = "Prefixo", referencedColumnName = "Prefixo")
    @ManyToOne
    private Prefixos prefixo;
    @JoinColumn(name = "Status", referencedColumnName = "idStatus")
    @ManyToOne(optional = false)
    private Status status;
    @JoinColumn(name = "Matricula", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matricula;
    @JoinColumn(name = "MatriculaSolicitante", referencedColumnName = "Matricula")
    @ManyToOne
    private UorPos matriculaSolicitante;

    public Tags() {
    }

    public Tags(Integer tag) {
        this.tag = tag;
    }

    public Tags(Integer tag, String nome, String situacao, Date dataAtualizacao) {
        this.tag = tag;
        this.nome = nome;
        this.situacao = situacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getSegundaVia() {
        return segundaVia;
    }

    public void setSegundaVia(String segundaVia) {
        this.segundaVia = segundaVia;
    }

    public String getAcessoEstacionamento() {
        return acessoEstacionamento;
    }

    public void setAcessoEstacionamento(String acessoEstacionamento) {
        this.acessoEstacionamento = acessoEstacionamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getVeiculo1() {
        return veiculo1;
    }

    public void setVeiculo1(String veiculo1) {
        this.veiculo1 = veiculo1;
    }

    public String getVeiculo2() {
        return veiculo2;
    }

    public void setVeiculo2(String veiculo2) {
        this.veiculo2 = veiculo2;
    }

    public String getVeiculo3() {
        return veiculo3;
    }

    public void setVeiculo3(String veiculo3) {
        this.veiculo3 = veiculo3;
    }

    public String getUFComercial() {
        return uFComercial;
    }

    public void setUFComercial(String uFComercial) {
        this.uFComercial = uFComercial;
    }

    public String getBairroComercial() {
        return bairroComercial;
    }

    public void setBairroComercial(String bairroComercial) {
        this.bairroComercial = bairroComercial;
    }

    public String getLogradouroComercial() {
        return logradouroComercial;
    }

    public void setLogradouroComercial(String logradouroComercial) {
        this.logradouroComercial = logradouroComercial;
    }

    public String getLatitudeComercial() {
        return latitudeComercial;
    }

    public void setLatitudeComercial(String latitudeComercial) {
        this.latitudeComercial = latitudeComercial;
    }

    public String getLongitudeComercial() {
        return longitudeComercial;
    }

    public void setLongitudeComercial(String longitudeComercial) {
        this.longitudeComercial = longitudeComercial;
    }

    public String getCEPComercial() {
        return cEPComercial;
    }

    public void setCEPComercial(String cEPComercial) {
        this.cEPComercial = cEPComercial;
    }

    public String getUFResidencial() {
        return uFResidencial;
    }

    public void setUFResidencial(String uFResidencial) {
        this.uFResidencial = uFResidencial;
    }

    public String getBairroResidencial() {
        return bairroResidencial;
    }

    public void setBairroResidencial(String bairroResidencial) {
        this.bairroResidencial = bairroResidencial;
    }

    public String getLogradouroResidencial() {
        return logradouroResidencial;
    }

    public void setLogradouroResidencial(String logradouroResidencial) {
        this.logradouroResidencial = logradouroResidencial;
    }

    public String getCEPResidencial() {
        return cEPResidencial;
    }

    public void setCEPResidencial(String cEPResidencial) {
        this.cEPResidencial = cEPResidencial;
    }

    public String getLatitudeResidencial() {
        return latitudeResidencial;
    }

    public void setLatitudeResidencial(String latitudeResidencial) {
        this.latitudeResidencial = latitudeResidencial;
    }

    public String getLongitudeResidencial() {
        return longitudeResidencial;
    }

    public void setLongitudeResidencial(String longitudeResidencial) {
        this.longitudeResidencial = longitudeResidencial;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Ativa getAtiva() {
        return ativa;
    }

    public void setAtiva(Ativa ativa) {
        this.ativa = ativa;
    }

    public Prefixos getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(Prefixos prefixo) {
        this.prefixo = prefixo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UorPos getMatricula() {
        return matricula;
    }

    public void setMatricula(UorPos matricula) {
        this.matricula = matricula;
    }

    public UorPos getMatriculaSolicitante() {
        return matriculaSolicitante;
    }

    public void setMatriculaSolicitante(UorPos matriculaSolicitante) {
        this.matriculaSolicitante = matriculaSolicitante;
    }

    public String getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(String valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tag != null ? tag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tags)) {
            return false;
        }
        Tags other = (Tags) object;
        if ((this.tag == null && other.tag != null) || (this.tag != null && !this.tag.equals(other.tag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.bb.uop.geadesp.prk.entities.Tags[ tag=" + tag + " ]";
    }

}
