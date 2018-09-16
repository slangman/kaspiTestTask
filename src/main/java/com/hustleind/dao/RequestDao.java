package com.hustleind.dao;

import com.hustleind.entity.Request;

import java.util.List;

public interface RequestDao {
    Request getRequestById(Long id);
    List getAllRequests();
    boolean addRequest(Request request);
    boolean editRequest(Request request);
    boolean deleteRequest(Request request);
}
