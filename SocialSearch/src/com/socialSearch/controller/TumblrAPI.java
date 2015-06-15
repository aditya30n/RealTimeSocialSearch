package com.socialSearch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.QuotePost;
import com.tumblr.jumblr.types.TextPost;
import com.tumblr.jumblr.types.VideoPost;


public class TumblrAPI{

	public List<String> getTumblr(String keyword){
		JumblrClient client = new JumblrClient("fChLT1WrYTMKQ7oIu2vyRK0xgDsBmzG0f85L6MLu25cWfnwz8U", "FQir9ADglEMUoksWTErckDP88UQhAWg32l4WBJrJZ00ICPudp2");
		client.setToken("8BdkOTOUOngKonFfCoAktfY6Y0PTrf9aXQGlUyIeLD1Yvj8SB4", "oO9jutGddyLKZY7IW9b2hBx1hYQL0Lzd5F3hhxjKlPo6H7hPoo");
		
		Map<String, Integer> options = new HashMap<String, Integer>();
		options.put("limit", 10);		
		List<Post> tumblr = client.tagged(keyword, options);
		
		List<String> output = new ArrayList<String>();
		
		for(Post post : tumblr){
			switch(post.getType()){
			case "text": 
				TextPost textPost = (TextPost)post;
				output.add(textPost.getTitle());
				break;
			case "photo":
				PhotoPost photoPost = (PhotoPost)post;
				output.add(photoPost.getCaption());
				break;
			case "quote":
				QuotePost quotePost = (QuotePost)post;
				output.add(quotePost.getText());
				break;
			case "video":
				VideoPost videoPost = (VideoPost)post;
				output.add(videoPost.getCaption());
				break;	
			}
		}
		
		return output;
	}
}
