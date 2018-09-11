package com.hustleind.dao;

import com.hustleind.entity.Request;

import java.util.List;

public interface RequestDao {
    Request getRequestById(int id);
    List<Request> getAllRequests();
    boolean addRequest(Request request);
}
