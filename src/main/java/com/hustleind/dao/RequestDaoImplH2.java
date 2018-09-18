package com.hustleind.dao;

import com.hustleind.entity.Request;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RequestDaoImplH2 implements  RequestDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Request getRequestById(Long id) {
        if (id <= 0) {
            return null;
        }
        return entityManager.find(Request.class, id);
    }

    @Override
    public List getAllRequests() {
        return entityManager.createQuery("SELECT r FROM Request r").getResultList();
    }

    @Override
    public boolean addRequest(Request request) {
        if (request == null) {
            return false;
        }
        entityManager.persist(request);
        return true;
    }

    @Override
    public boolean editRequest(Request request) {
        if (request == null) {
            return false;
        }
        entityManager.merge(request);
        return true;
    }

    @Override
    public boolean deleteRequest(Request request) {
        if (request == null) {
            return false;
        }
        entityManager.remove(request);
        return true;
    }

    @Override
    public boolean deleteRequestById(Long id) {
        if (id <= 0) {
            return false;
        }
        Request request = getRequestById(id);
        entityManager.remove(request);
        return true;
    }
}
