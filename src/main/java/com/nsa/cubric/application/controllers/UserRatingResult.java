package com.nsa.cubric.application.controllers;

import com.nsa.cubric.application.domain.UserRating;
import com.nsa.cubric.application.services.UserRatingServiceStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserRatingResult {

	private UserRatingServiceStatic ratingService;

	@Autowired
	public UserRatingResult(UserRatingServiceStatic aRepo) {
		ratingService = aRepo;
	}

	private static final Logger LOG = LoggerFactory.getLogger(UserRatingResult.class);

	@RequestMapping(value = "/ratings", method = RequestMethod.GET)
	public String getAllUserResponse(WebRequest webRequest, Model model) {
		LOG.debug("Handling GET request to /ratings/");
		LOG.info("Ratings for all users");

		Map<Integer, Map<String, Integer>> userRatingMap = new HashMap<>();
		List<UserRating> ratingsList = ratingService.getAll();
		convertResultToMap(userRatingMap, ratingsList);
		model.addAttribute("userRatingMap", userRatingMap);
		return "all_user_rating_result";
	}

	@RequestMapping(value = "/ratings/{userEmail}", method = RequestMethod.GET)
	public String getSingleUserResponse(@PathVariable("userEmail") String userEmail,
			Model model) {
		LOG.debug("Handling GET request to /ratings/");

		Map<Integer, Map<String, Integer>> userRatingMap = new HashMap<>();

		List<UserRating> responsesList = ratingService.getUserRatings(userEmail);
		convertResultToMap(userRatingMap, responsesList);
		model.addAttribute("userRatingMap", userRatingMap);
		return "single_user_rating_result";
	}

	/**
	 * Method used to convert DB result to Map
	 * 
	 * @param userRatingMap
	 * @param ratingsList
	 */
	private void convertResultToMap(Map<Integer, Map<String, Integer>> userRatingMap, List<UserRating> ratingsList) {
		ratingsList.forEach(userRating -> {
			Map<String, Integer> userRatingCountMap = new HashMap<>();
			if (userRatingMap.containsKey(userRating.getScanId())) {
				userRatingCountMap = userRatingMap.get(userRating.getScanId());
				if (userRating.getResponse()) {
					if (null != userRatingCountMap.get("yes")) {
						userRatingCountMap.put("yes", userRatingCountMap.get("yes") + 1);
					}
					else {
						userRatingCountMap.put("yes", 1);
					}
				}
				else {
					if (null != userRatingCountMap.get("no")) {
						userRatingCountMap.put("no", userRatingCountMap.get("no") + 1);
					}
					else {
						userRatingCountMap.put("no", 1);
					}
				}
			}
			else {
				if (userRating.getResponse()) {
					userRatingCountMap.put("yes", 1);
				}
				else {
					userRatingCountMap.put("no", 1);
				}
			}
			userRatingMap.put(userRating.getScanId(), userRatingCountMap);
		});
	}
}