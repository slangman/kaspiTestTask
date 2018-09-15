package com.hustleind.dao;

import com.hustleind.entity.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDaoImplSessionFactory {

    /*private final SessionFactory factory;

    @Autowired
    public RequestDaoImplSessionFactory (SessionFactory factory) {
        this.factory = factory;
    }

    *//*@PersistenceContext
    private EntityManager entityManager;*//*


    @Override
    public Request getRequestById(int id) {
        if (id < 0) {
            return null;
        }
        Session session = factory.getCurrentSession();
        return session.get(Request.class, id);
    }

    @Override
    public List<Request> getAllRequests() {
        Session session = factory.getCurrentSession();
        return (List<Request>) session.createQuery("FROM Request").getResultList();
    }

    @Override
    public boolean addRequest(Request request) {
        if (request == null) {
            return false;
        }
        Session session = factory.getCurrentSession();
        session.save(request);
        return true;
    }

    *//*public boolean containsNameDuplicates(Request request) {
        if (request==null || request.getFirstName()==null || request.getSecondName()==null) {
            return false;
        }
        List<Request> resultList = new ArrayList<>();
        String firstName = request.getFirstName();
        String middleName = request.getMiddleName();
        String secondName = request.getSecondName();
        if (middleName != null) {
            resultList = entityManager.createQuery("FROM Request r WHERE r.firstName = " +
                    ":firstName, r.secondName = :secondName, r.middleName = middleName")
                    .setParameter("firstName", firstName)
                    .setParameter("secondName", secondName)
                    .setParameter("middleName", middleName)
                    .getResultList();
        } else {
            resultList = entityManager.createQuery("FROM Request r WHERE r.firstName = " +
                    ":firstName, r.secondName = :secondName")
                    .setParameter("firstName", firstName)
                    .setParameter("secondName", secondName)
                    .getResultList();
        }
        return !resultList.isEmpty();
    }*//*

    *//*public boolean containsMobileNumberDuplicates(Request request) {
        if (request==null || request.getMobileNumber()==null) {
            return false;
        }
        List<Request> resultList = new ArrayList<>();
        String mobileNumber = request.getMobileNumber();
        resultList = entityManager.createQuery("FROM Request r WHERE r.mobileNumber")

    }*//*
*/
}
