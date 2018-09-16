package com.hustleind.controller;


import com.hustleind.entity.Request;
import com.hustleind.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RequestController {

    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @RequestMapping(value = "/requestPage")
    private String requestPage() {
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
            if (messages[0] != null) {
                model.addAttribute("mobileNumberMessage", messages[0]);
            }
            if (messages[1] != null) {
                model.addAttribute("binMessage", messages[1]);
            }
            if (messages[2] != null) {
                model.addAttribute("duplicateMessage", messages[2]);
            }
        }
        return "requestPage";
    }

    @RequestMapping(value = "/viewAllRequests", method = RequestMethod.GET)
    private String viewAllRequests(Model model) {
        List<Request> requestsList = requestService.getAllRequests();
        System.out.println(requestsList.size());
        model.addAttribute("requestsList", requestsList);
        return "viewAllRequests";
    }

    @RequestMapping(value = "/viewRequest/{id}", method = RequestMethod.GET)
    private String viewRequest(@PathVariable("id") int id, Model model) {
        Request requestForView = requestService.getRequestById(id);
        model.addAttribute("requestForView", requestForView);
        return "viewRequest";
    }

    /**
     * Opens page for editing existing request.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/editRequest/{id}", method = RequestMethod.GET)
    private String editRequestPage(@PathVariable("id") int id, Model model) {
        Request requestForEdit = requestService.getRequestById(id);
        model.addAttribute("requestForEdit", requestForEdit);
        return "requestPage";
    }

    @RequestMapping(value="/requestEdited", method=RequestMethod.POST)
    private String editRequest(@RequestBody MultiValueMap<String, String> requestParams, Model model) {
        Request request = requestService.createRequestByParams(requestParams);
        String[] messages = requestService.checkEditedRequest(request);
        if (messages[0] == null && messages[1] == null) {
            if (requestService.editRequest(request)) {
                model.addAttribute("requestMessage", "Request edited successfully");
            } else {
                model.addAttribute("requestMessage", "Error while editing request");
            }
        } else {
            if (messages[0] != null) {
                model.addAttribute("mobileNumberMessage", messages[0]);
            }
            if (messages[1] != null) {
                model.addAttribute("binMessage", messages[1]);
            }
        }
        return "requestPage";
    }

    @RequestMapping(value="/deleteRequest/{id}", method=RequestMethod.GET)
    private String deleteRequest(@PathVariable("id") int id, Model model) {
        Request requestToDelete = requestService.getRequestById(id);
        if (!requestService.deleteRequest(requestToDelete)) {
            model.addAttribute("deleteMessage", "Unable to delete request");
            return "redirect:/editRequest/"+id;
        } else {
            model.addAttribute("deleteMessage", "Request successfully deleted");
            return "redirect:/viewAllRequests";
        }
    }

}
