/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.uop.geadesp.prk.facade;

import br.com.bb.uop.geadesp.prk.entities.Ativa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.prk.entities.Ativa_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import java.util.Collection;

/**
 *
 * @author F6750699
 */
@Stateless
public class AtivaFacade extends AbstractFacade<Ativa> {

    @PersistenceContext(unitName = "prkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AtivaFacade() {
        super(Ativa.class);
    }

    public boolean isTagsCollectionEmpty(Ativa entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ativa> ativa = cq.from(Ativa.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ativa, entity), cb.isNotEmpty(ativa.get(Ativa_.tagsCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Tags> findTagsCollection(Ativa entity) {
        Ativa mergedEntity = this.getMergedEntity(entity);
        Collection<Tags> tagsCollection = mergedEntity.getTagsCollection();
        tagsCollection.size();
        return tagsCollection;
    }
    
}
