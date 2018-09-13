package com.hustleind.controller;


import com.hustleind.entity.Request;
import com.hustleind.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {

    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @RequestMapping(value = "/requestPage")
    private String requstPage() {
        return "requestPage";
    }

    @RequestMapping(value = "/sendRequest", method = RequestMethod.POST)
    private String sendRequest(@RequestBody MultiValueMap<String, String> requestParams, Model model) {
        requestService.addRequestByParam(requestParams);
        return "requestPage";
    }

    /*@RequestMapping(value = "/sendRequest", method = RequestMethod.POST)
    private String sendRequest(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "middleName", required = false) String middleName,
            @RequestParam(value="lastName") String lastName,
            @RequestParam(value="companyName") String companyName,
            @RequestParam(value="bin") String bin,
            @RequestParam(value="mobileNumber") String mobileNumber
            ) {
        Request request = new Request();
        request.setFirstName(firstName);
        request.setCompanyNameAbb(requestService.generateAbbreviation(companyName));
    }*/

}
