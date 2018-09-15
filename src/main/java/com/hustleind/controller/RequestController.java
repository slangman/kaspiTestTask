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
        Request request = requestService.createRequestByParams(requestParams);
        String[] messages = requestService.checkRequest(request);
        if (messages[0] == null && messages[1] == null && messages[2] == null) {
            if (requestService.addRequest(request)) {
                model.addAttribute("requestMessage", "Request sent successfully");
            } else {
                model.addAttribute("requestMessage", "Error while sending request");
            }
        } else {
            if (messages[0]!=null) {
                model.addAttribute("mobileNumberMessage" , messages[0]);
            }
            if (messages[1]!=null) {
                model.addAttribute("binMesage" , messages[1]);
            }
            if (messages[2]!=null) {
                model.addAttribute("dublicateMessage", messages[2]);
            }
        }
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
