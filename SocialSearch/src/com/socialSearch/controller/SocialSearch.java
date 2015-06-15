package com.socialSearch.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.User;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

import twitter4j.TwitterException;

@Controller
public class SocialSearch {

	@RequestMapping(value = "/")
	public ModelAndView index() {
 
		ModelAndView model = new ModelAndView("index");		
		model.addObject("twitter", null);
		model.addObject("tumblr", null);
		model.addObject("reddit", null);
		return model;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("searchKeyword") String keyword) throws TwitterException {
 
		ModelAndView model = new ModelAndView("index");	
		TwitterAPI twitter = new TwitterAPI();
		RedditAPI reddit = new RedditAPI();
		TumblrAPI tumblr = new TumblrAPI();
		
		if(keyword.trim().isEmpty()){
			model.addObject("twitter", null);
			model.addObject("tumblr", null);
			model.addObject("reddit", null);
		}		
		else{
			model.addObject("twitter", twitter.getTwitterData(keyword));
			model.addObject("tumblr" ,tumblr.getTumblr(keyword));
			model.addObject("reddit", reddit.getReddit(keyword));
		}		
		
		model.addObject("facebook", null);
		return model;
	}		
	
}
