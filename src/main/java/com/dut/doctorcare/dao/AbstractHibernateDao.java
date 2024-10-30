package com.dut.doctorcare.dao;


import com.dut.doctorcare.dao.iface.common.GenericDao;
import com.dut.doctorcare.model.BaseClazz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.*;


public abstract class AbstractHibernateDao<T extends BaseClazz> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> entityClass;

    public AbstractHibernateDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Optional<T> findById(UUID id) {

            Session session = getCurrentSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);

            cq.where(
                    cb.and(
                            cb.equal(root.get("id"), id),
                            cb.isTrue(root.get("isActive"))));

            return session.createQuery(cq).uniqueResultOptional();

    }

    @Override
    public List<T> findAll(Map<String, Object> filterParams){


            CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);

            List<Predicate> predicates = createPredicates(cb, root, filterParams);
            predicates.add(cb.isTrue(root.get("isActive")));
            cq.where(predicates.toArray(new Predicate[0]));

            return getCurrentSession().createQuery(cq).getResultList();

    }
    private List<Predicate> createPredicates(CriteriaBuilder cb, Root<T> root, Map<String, Object> filterParams) {
        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String, Object> entry : filterParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (root.getModel().getAttribute(key) != null) {
                predicates.add(cb.equal(root.get(key), value));
            }
        }
        return predicates;
    }


    @Override
    public T save(T entity){
            getCurrentSession().persist(entity);
            return entity;
    }

    @Override
    public T update(T entity){
            getCurrentSession().merge(entity);
            return entity;
    }

    @Override
    public void delete(T entity){
            Session session = getCurrentSession();
            session.remove(entity);
            session.flush();
    }


}


