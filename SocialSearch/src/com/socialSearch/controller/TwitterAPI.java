package com.socialSearch.controller;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAPI {

	public List<Status> getTwitterData(String keyword) throws TwitterException{
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	          .setOAuthConsumerKey("I3m1bHCBZKDDdlOOD8LnHxcTa")
	          .setOAuthConsumerSecret("Z7VFYGyqE2bVx9CC8Vxn7mDTd1cVJ29dp4nAd6aE10X3D6E1v2")
	          .setOAuthAccessToken("166184725-IJtwv6SbpJufqFg63yhNdG6RLPiJvDpyBoCSpL0c")
	          .setOAuthAccessTokenSecret("6oyPXXEzgI8mJijIzfyFHzc1VAwUavldYqli3oBKyXkjc");
	    TwitterFactory tf = new TwitterFactory(cb.build());
		
		Twitter twitter = tf.getInstance(); 		
		Query query = new Query(keyword);
		query.count(10);
		QueryResult qr = twitter.search(query);
		List<Status> qrTweets = qr.getTweets();	
						
		return qrTweets;
	}

}
