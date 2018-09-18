package com.hustleind.service;

import com.hustleind.dao.RequestDao;
import com.hustleind.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    private RequestDao requestDao;

    @Autowired
    public RequestServiceImpl(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public Request getRequestById(Long id) {
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
    public boolean editRequest(Request request) {
        return requestDao.editRequest(request);
    }

    @Override
    public boolean deleteRequest(Request request) {
        return requestDao.deleteRequest(request);
    }

    @Override
    public Request createRequestByParams(MultiValueMap<String, String> requestParams) {
        Request request = new Request();
        if (requestParams.get("requestId")!=null) {
            request.setId(Long.parseLong(requestParams.get("requestId").get(0)));
        }
        request.setFirstName(requestParams.get("firstName").get(0));
        request.setMiddleName(requestParams.get("middleName").get(0));
        request.setSecondName(requestParams.get("secondName").get(0));
        request.setCompanyName(requestParams.get("companyName").get(0));
        request.setBin(requestParams.get("bin").get(0));
        request.setMobileNumber(requestParams.get("mobileNumber").get(0));
        request.setCompanyNameAbb(generateAbbreviation(requestParams.get("companyName").get(0)));
        return request;
    }

    /**
     * Generates company name abbreviation
     * @param companyName
     * @return
     */
    @Override
    public String generateAbbreviation(String companyName) {
        String[] splitted = companyName.split(" ");
        StringBuffer sb = new StringBuffer("");
        for (String s : splitted) {
            sb.append(s.charAt(0));
        }
        return sb.toString().toUpperCase();
    }

    /** Checks request validity
     *
     * @param request
     * @return true if entered request meets requirements
     */
    @Override
    public String[] checkRequest(Request request) {
        String[] messages = new String[3];
        if (!mobileNumberIsValid(request.getMobileNumber())) {
            messages[0] = "Wrong mobile number format";
        }
        if (!binIsValid(request.getBin())) {
            messages[1] = "Bin length must be 12 characters containing only digits";
        }
        if (containsDuplicates(request)) {
            messages[2] = "Request with same parameters have already been sent";
        }
        return messages;
    }

    /**
     * Verifies {@link Request#mobileNumber} and {@link Request#bin} fields of edited/updated request.
     * Edited request might duplicate existing one.
     *
     * @param request
     * @return array of messages
     */
    @Override
    public String[] checkEditedRequest(Request request) {
        String[] messages = new String[2];
        if (!mobileNumberIsValid(request.getMobileNumber())) {
            messages[0] = "Wrong mobile number format";
        }
        if (!binIsValid(request.getBin())) {
            messages[1] = "Bin length must be 12 characters containing only digits";
        }
        return messages;
    }

    /**
     * Checks entered request for duplicates
     * @param request
     * @return true if database stores record with same combination of fields
     */
    private boolean containsDuplicates(Request request) {
        boolean result = false;
        if (request == null) {
            return false;
        }
        List<Request> requests = requestDao.getAllRequests();
        if (requests.isEmpty()) {
            return false;
        } else {
            result = containsNameDuplicates(request, requests) &&
                    containsMobileNumberDuplicates(request, requests) &&
                    containsCompanyNameDuplicates(request, requests) &&
                    containsBinDuplicates(request, requests);
        }
        return result;
    }

    /**
     * Checks whether entered mobileNumber fits mask +7-XXX-XXXXXXX
     * @param mobileNumber
     * @return tru if entered mobileNumber meets requirements
     */
    private boolean mobileNumberIsValid(String mobileNumber) {
        Pattern pattern = Pattern.compile("[+]7[-]\\d{3}[-]\\d{7}");
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }

    /**
     * Checks whether entered bin lenth is 12 characters containing only digits
     * @param bin
     * @return true if entered bin meets requirement
     */
    private boolean binIsValid(String bin) {
        Pattern pattern = Pattern.compile("\\d{12}");
        Matcher matcher = pattern.matcher(bin);
        return matcher.matches();
    }

    /**
     *
     * @param request Request object verified for duplicates
     * @param requests Collection of requests stored in database
     * @return true if there is a record in database with same firstName, middleName, secondName
     */
    private boolean containsNameDuplicates(Request request, List<Request> requests) {
        boolean result = false;
        for (Request existingRequest : requests) {
            if (request.getMiddleName() != null) {
                if (request.getFirstName().equals(existingRequest.getFirstName()) &&
                        request.getMiddleName().equals(existingRequest.getMiddleName()) &&
                        request.getSecondName().equals(existingRequest.getSecondName())) {
                    result = true;
                }
            } else {
                if (request.getFirstName().equals(existingRequest.getFirstName()) &&
                        request.getSecondName().equals(existingRequest.getSecondName())) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     *
     * @param request Request object verified for duplicates
     * @param requests Collection of requests stored in database
     * @return true if there is a record in database with same mobileNumber
     */
    private boolean containsMobileNumberDuplicates(Request request, List<Request> requests) {
        boolean result = false;
        for (Request existingRequest : requests) {
            if (request.getMobileNumber().equals(existingRequest.getMobileNumber())) {
                result = true;
            }
        }
        return result;
    }

    /**
     *
     * @param request Request object verified for duplicates
     * @param requests Collection of requests stored in database
     * @return true if there is a record in database with same companyName
     */
    private boolean containsCompanyNameDuplicates(Request request, List<Request> requests) {
        boolean result = false;
        for (Request existingRequest : requests) {
            if (request.getCompanyName().equals(existingRequest.getCompanyName())) {
                result = true;
            }
        }
        return result;
    }

    /**
     *
     * @param request Request object verified for duplicates
     * @param requests Collection of requests stored in database
     * @return true if there is a record in database with same bin
     */
    private boolean containsBinDuplicates(Request request, List<Request> requests) {
        boolean result = false;
        for (Request existingRequest : requests) {
            if (request.getBin().equals(existingRequest.getBin())) {
                result = true;
            }
        }
        return result;
    }

}
