package com.hustleind.service;

import com.hustleind.entity.Request;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface RequestService {
    Request getRequestById(int id);
    List<Request> getAllRequests();
    boolean addRequest(Request request);
    boolean editRequest(Request request);
    boolean deleteRequest(Request request);
    Request createRequestByParams(MultiValueMap<String, String> requestParams);
    String[] checkRequest(Request request);
    String[] checkEditedRequest(Request request);
}
