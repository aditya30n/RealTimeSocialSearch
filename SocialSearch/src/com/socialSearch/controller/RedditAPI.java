package com.socialSearch.controller;

import java.util.List;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.User;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

public class RedditAPI {

	public List<Submission> getReddit(String keyword){ 
		RestClient restClient = new HttpRestClient();
		restClient.setUserAgent("bot/1.0 by name");

		User user = new User(restClient, "aditya30n", "11091989");
		try {
		    user.connect();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		Submissions subms = new Submissions(restClient, user);
		List<Submission> submissionsSubreddit = subms.ofSubreddit(keyword, SubmissionSort.TOP, -1, 10, null, null, true);
		return submissionsSubreddit;
	}
}
