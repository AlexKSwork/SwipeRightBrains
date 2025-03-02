package com.nsa.cubric.application.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(value = "/userfeedback")
public class Feedback {
    private static final Logger LOG = LoggerFactory.getLogger(Feedback.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showFeedbackForm(){
        return "feedback_form";
    }

    @RequestMapping(value = "/submitted", method = RequestMethod.GET)
    public String showFeedbackSubmittedPage(){
        LOG.info("User has entered information check admin feedback");
        return "feedback_submitted";
    }
}
