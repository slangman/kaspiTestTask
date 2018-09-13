package com.hustleind.service;

import com.hustleind.dao.RequestDao;
import com.hustleind.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    private RequestDao requestDao;

    @Autowired
    public RequestServiceImpl(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public Request getRequestById(int id) {
        return requestDao.getRequestById(id);
    }

    @Override
    public List<Request> getAllRequests() {
        return requestDao.getAllRequests();
    }

    @Override
    public boolean addRequest(Request request) {
        return requestDao.addRequest(request);
    }

    @Override
    public boolean addRequestByParam(MultiValueMap<String, String> requestParams) {
        /*Request request = new Request();
        request.setFirstName(requestParams.get("firstName").get(0));
        request.setMiddleName(requestParams.get("middleName").get(0));
        request.setSecondName(requestParams.get("secondName").get(0));
        request.setCompanyName(requestParams.get("companyName").get(0));
        request.setBin(requestParams.get("bin").get(0));
        request.setMobileNumber(requestParams.get("mobileNumber").get(0));*/
        return false;
    }

    //@Override
    private String generateAbbreviation(String companyName) {
        String[] splitted = companyName.split(" ");
        StringBuffer sb = new StringBuffer("");
        for (String s : splitted) {
            sb.append(s.charAt(0));
        }
        return sb.toString().toUpperCase();
    }

    private String checkRequestForDuplicates(Request request) {
        List<Request> requestsList = requestDao.getAllRequests();
        return null;
    }

    private boolean checkForNameDuplicates(Request request) {
        boolean result = false;
        List<Request> requestList = requestDao.getAllRequests();
        for (Request req : requestList) {
            if (request.getMiddleName() != null) {
                if (request.getFirstName().equals(req.getFirstName()) &&
                        request.getMiddleName().equals(req.getMiddleName()) &&
                        request.getSecondName().equals(req.getSecondName())) {
                    result = true;
                }
            } else {
                if (request.getFirstName().equals(req.getFirstName()) &&
                        request.getSecondName().equals(req.getSecondName())) {
                    result = true;
                }
            }
        }
        return result;
    }


}
