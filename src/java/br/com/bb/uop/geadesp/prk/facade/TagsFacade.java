package br.com.bb.uop.geadesp.prk.facade;

import br.com.bb.uop.geadesp.prk.entities.Tags;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.prk.entities.Tags_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.prk.entities.Ativa;
import br.com.bb.uop.geadesp.prk.entities.Prefixos;
import br.com.bb.uop.geadesp.prk.entities.Status;
import br.com.bb.uop.geadesp.prk.entities.UorPos;

/**
 *
 * @author F6750699
 */
@Stateless
public class TagsFacade extends AbstractFacade<Tags> {

    @PersistenceContext(unitName = "prkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TagsFacade() {
        super(Tags.class);
    }

    public boolean isAtivaEmpty(Tags entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tags> tags = cq.from(Tags.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tags, entity), cb.isNotNull(tags.get(Tags_.ativa)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ativa findAtiva(Tags entity) {
        return this.getMergedEntity(entity).getAtiva();
    }

    public boolean isPrefixoEmpty(Tags entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tags> tags = cq.from(Tags.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tags, entity), cb.isNotNull(tags.get(Tags_.prefixo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Prefixos findPrefixo(Tags entity) {
        return this.getMergedEntity(entity).getPrefixo();
    }

    public boolean isStatusEmpty(Tags entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tags> tags = cq.from(Tags.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tags, entity), cb.isNotNull(tags.get(Tags_.status)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Status findStatus(Tags entity) {
        return this.getMergedEntity(entity).getStatus();
    }

    public boolean isMatriculaEmpty(Tags entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tags> tags = cq.from(Tags.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tags, entity), cb.isNotNull(tags.get(Tags_.matricula)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatricula(Tags entity) {
        return this.getMergedEntity(entity).getMatricula();
    }

    public boolean isMatriculaSolicitanteEmpty(Tags entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tags> tags = cq.from(Tags.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tags, entity), cb.isNotNull(tags.get(Tags_.matriculaSolicitante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public UorPos findMatriculaSolicitante(Tags entity) {
        return this.getMergedEntity(entity).getMatriculaSolicitante();
    }
    
}
