/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.uop.geadesp.prk.facade;

import br.com.bb.uop.geadesp.prk.entities.Jurisdicionadas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.bb.uop.geadesp.prk.entities.Jurisdicionadas_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.bb.uop.geadesp.prk.entities.Prefixos;

/**
 *
 * @author F6750699
 */
@Stateless
public class JurisdicionadasFacade extends AbstractFacade<Jurisdicionadas> {

    @PersistenceContext(unitName = "prkPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JurisdicionadasFacade() {
        super(Jurisdicionadas.class);
    }

    public boolean isPrefixoEmpty(Jurisdicionadas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Jurisdicionadas> jurisdicionadas = cq.from(Jurisdicionadas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(jurisdicionadas, entity), cb.isNotNull(jurisdicionadas.get(Jurisdicionadas_.prefixo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Prefixos findPrefixo(Jurisdicionadas entity) {
        return this.getMergedEntity(entity).getPrefixo();
    }
    
}
