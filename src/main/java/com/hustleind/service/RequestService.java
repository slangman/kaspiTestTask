package com.hustleind.service;

import com.hustleind.entity.Request;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface RequestService {
    Request getRequestById(int id);
    List<Request> getAllRequests();
    boolean addRequest(Request request);
    Request createRequestByParams(MultiValueMap<String, String> requestParams);
    String[] checkRequest(Request request);
    //boolean containsDuplicates(Request request);
}
