/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.uop.geadesp.prk.facade;

import br.com.bb.uop.geadesp.prk.entities.UorPos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.prk.entities.UorPos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.prk.entities.PermissoesAcesso;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import java.util.Collection;

/**
 *
 * @author F6750699
 */
@Stateless
public class UorPosFacade extends AbstractFacade<UorPos> {

    @PersistenceContext(unitName = "prkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UorPosFacade() {
        super(UorPos.class);
    }

    public boolean isIdPermissaoAcessoEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotNull(uorPos.get(UorPos_.idPermissaoAcesso)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public PermissoesAcesso findIdPermissaoAcesso(UorPos entity) {
        return this.getMergedEntity(entity).getIdPermissaoAcesso();
    }

    public boolean isTagsCollectionEmpty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.tagsCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Tags> findTagsCollection(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Tags> tagsCollection = mergedEntity.getTagsCollection();
        tagsCollection.size();
        return tagsCollection;
    }

    public boolean isTagsCollection1Empty(UorPos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UorPos> uorPos = cq.from(UorPos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(uorPos, entity), cb.isNotEmpty(uorPos.get(UorPos_.tagsCollection1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Tags> findTagsCollection1(UorPos entity) {
        UorPos mergedEntity = this.getMergedEntity(entity);
        Collection<Tags> tagsCollection1 = mergedEntity.getTagsCollection1();
        tagsCollection1.size();
        return tagsCollection1;
    }
    
}
