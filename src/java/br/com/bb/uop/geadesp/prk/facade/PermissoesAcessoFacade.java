/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.uop.geadesp.prk.facade;

import br.com.bb.uop.geadesp.prk.entities.PermissoesAcesso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.prk.entities.PermissoesAcesso_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.prk.entities.UorPos;
import java.util.Collection;

/**
 *
 * @author F6750699
 */
@Stateless
public class PermissoesAcessoFacade extends AbstractFacade<PermissoesAcesso> {

    @PersistenceContext(unitName = "prkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermissoesAcessoFacade() {
        super(PermissoesAcesso.class);
    }

    public boolean isUorPosCollectionEmpty(PermissoesAcesso entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PermissoesAcesso> permissoesAcesso = cq.from(PermissoesAcesso.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(permissoesAcesso, entity), cb.isNotEmpty(permissoesAcesso.get(PermissoesAcesso_.uorPosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<UorPos> findUorPosCollection(PermissoesAcesso entity) {
        PermissoesAcesso mergedEntity = this.getMergedEntity(entity);
        Collection<UorPos> uorPosCollection = mergedEntity.getUorPosCollection();
        uorPosCollection.size();
        return uorPosCollection;
    }
    
}
