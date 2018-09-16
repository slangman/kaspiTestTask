package com.hustleind.dao;

import com.hustleind.entity.Request;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class RequestDaoImpl implements RequestDao {

    @PersistenceContext
    private EntityManager entityManager;

   /*@Autowired
    public RequestDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }*/

    @Override
    public Request getRequestById(Long id) {
        if (id < 0) {
            return null;
        }
        return entityManager.find(Request.class, id);
    }

    @SuppressWarnings("unchecked")
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

    @Override
    public boolean editRequest(Request request) {
        if (request == null) {
            return false;
        }
        Request editedRequest = getRequestById(request.getId());
        editedRequest.setFirstName(request.getFirstName());
        editedRequest.setSecondName(request.getSecondName());
        editedRequest.setMiddleName(request.getMiddleName());
        editedRequest.setCompanyName(request.getCompanyName());
        editedRequest.setCompanyNameAbb(request.getCompanyNameAbb());
        editedRequest.setBin(request.getBin());
        editedRequest.setMobileNumber(request.getMobileNumber());
        entityManager.flush();
        return true;
    }

    @Override
    public boolean deleteRequest(Request request) {
        if (request==null) {
            return false;
        }
        entityManager.remove(request);
        return true;
    }


}
