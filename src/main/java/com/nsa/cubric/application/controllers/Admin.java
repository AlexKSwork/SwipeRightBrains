package com.nsa.cubric.application.controllers;

import com.nsa.cubric.application.services.LoggedUserService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(value = "/admin")
public class Admin {
    private static final Logger LOG = LoggerFactory.getLogger(Practice.class);

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAdminPage(WebRequest webRequest, Model model){
        LOG.debug("Handling GET request to /admin/");
        LOG.info("GET admin privileges");
        System.out.println();

        if(!checkIfAdmin()){
            return "noaccess";
        }

        return "admin";
    }

    @GetMapping(value = "/usermanagement")
    public String showUserManagementPage() {
        LOG.info("Returns the management option to access the all user information");
        return "user_management";
    }

    @GetMapping(value = "/export_images")
    public String getExportImagesPage() {
        LOG.info("Returns the option to Export Images into a folder");
        return "export_images";
    }

    @GetMapping(value = "/feedback")
    public String showFeedbackListPage() {
        LOG.info("Returns usersfeedback in a list so it can be seen");
        return "feedback_list";
    }
        
    @RequestMapping(value = "/noaccess", method=RequestMethod.GET)
    public String showNoAccessPage(){
        return "noaccess";
    }

    public Boolean checkIfAdmin(){
        if(loggedUserService.getUserRole() != null){
            if(loggedUserService.getUserRole().equals("admin")){
                return true;
            }
        }
        return false;
    }
}
