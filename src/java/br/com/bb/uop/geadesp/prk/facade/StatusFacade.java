/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.uop.geadesp.prk.facade;

import br.com.bb.uop.geadesp.prk.entities.Status;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.prk.entities.Status_;
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
public class StatusFacade extends AbstractFacade<Status> {

    @PersistenceContext(unitName = "prkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatusFacade() {
        super(Status.class);
    }

    public boolean isTagsCollectionEmpty(Status entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Status> status = cq.from(Status.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(status, entity), cb.isNotEmpty(status.get(Status_.tagsCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Tags> findTagsCollection(Status entity) {
        Status mergedEntity = this.getMergedEntity(entity);
        Collection<Tags> tagsCollection = mergedEntity.getTagsCollection();
        tagsCollection.size();
        return tagsCollection;
    }
    
}
