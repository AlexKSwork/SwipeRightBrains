package com.nsa.cubric.application.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(value = "/ratings")
public class Ratings {
	private static final Logger LOG = LoggerFactory.getLogger(Ratings.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showTutorialOverview(WebRequest webRequest, Model model) {
		LOG.debug("Handling GET request to /ratings/");
		LOG.info("Score for swiperight game");
		return "ratings";
	}
}
