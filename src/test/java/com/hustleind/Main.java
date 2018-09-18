package com.hustleind;

import com.hustleind.entity.Request;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        RequestDaoImpl requestDao = new RequestDaoImpl();

        List<Request> requests = requestDao.getAllRequests();

        System.out.println(requests.size());
    }
}
