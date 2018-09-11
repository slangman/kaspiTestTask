package com.hustleind.dao;

import com.hustleind.entity.Request;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RequestDaoImpl implements RequestDao {

    @PersistenceContext
    private EntityManager entityManager;

   /* @Autowired
    public RequestDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }*/

    @Override
    public Request getRequestById(int id) {
        if (id<0) {
            return null;
        }
        return entityManager.find(Request.class, id);
    }

    @Override
    public List<Request> getAllRequests() {
        return (List<Request>)entityManager.createQuery("FROM Request").getResultList();
    }

    @Override
    public boolean addRequest(Request request) {
        if (request == null) {
            return false;
        }
        entityManager.persist(request);
        return true;
    }
}
