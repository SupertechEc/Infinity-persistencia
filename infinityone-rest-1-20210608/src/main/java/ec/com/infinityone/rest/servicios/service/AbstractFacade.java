/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Paul
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public T create(T entity) {
        getEntityManager().persist(entity);
        getEntityManager().flush();
        return entity;
    }
    
    public void createS(T entity) {
        getEntityManager().persist(entity);
    }

    public T edit(T entity) {
        getEntityManager().merge(entity);
        return entity;
    }

    public Object remove(Object id) throws PersistenceException {
        getEntityManager().remove(findOtro(id));
        return id;
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public T findOtro(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    /*public Object findAll() {
     javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
     cq.select(cq.from(entityClass));
     return getEntityManager().createQuery(cq).getResultList();   
     }*/

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public Response findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return Response.ok(q.getResultList(), MediaType.APPLICATION_JSON).build();
    }

    public Response count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return Response.ok(((Long) q.getSingleResult()).intValue(), MediaType.APPLICATION_JSON).build();
    }

}
