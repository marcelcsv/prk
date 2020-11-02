/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.uop.geadesp.prk.facade;

import br.com.bb.uop.geadesp.prk.entities.Prefixos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.prk.entities.Prefixos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.prk.entities.Jurisdicionadas;
import br.com.bb.uop.geadesp.prk.entities.Tags;
import java.util.Collection;

/**
 *
 * @author F6750699
 */
@Stateless
public class PrefixosFacade extends AbstractFacade<Prefixos> {

    @PersistenceContext(unitName = "prkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrefixosFacade() {
        super(Prefixos.class);
    }

    public boolean isJurisdicionadasCollectionEmpty(Prefixos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Prefixos> prefixos = cq.from(Prefixos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(prefixos, entity), cb.isNotEmpty(prefixos.get(Prefixos_.jurisdicionadasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Jurisdicionadas> findJurisdicionadasCollection(Prefixos entity) {
        Prefixos mergedEntity = this.getMergedEntity(entity);
        Collection<Jurisdicionadas> jurisdicionadasCollection = mergedEntity.getJurisdicionadasCollection();
        jurisdicionadasCollection.size();
        return jurisdicionadasCollection;
    }

    public boolean isTagsCollectionEmpty(Prefixos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Prefixos> prefixos = cq.from(Prefixos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(prefixos, entity), cb.isNotEmpty(prefixos.get(Prefixos_.tagsCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Tags> findTagsCollection(Prefixos entity) {
        Prefixos mergedEntity = this.getMergedEntity(entity);
        Collection<Tags> tagsCollection = mergedEntity.getTagsCollection();
        tagsCollection.size();
        return tagsCollection;
    }
    
}
