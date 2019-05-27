package com.java.restful.RESTfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static List<Posts> posts = new ArrayList<>();
    
	
	private static List<Posts> userOnePosts  = new ArrayList<>();
	{
	userOnePosts.add(new Posts(10, "Hello world, Good Morning!!"));
	userOnePosts.add(new Posts(11,"Hello world, Good Aftnoon!!"));
	}
	
	private static List<Posts> userTwoPosts  = new ArrayList<>();
	{
		userTwoPosts.add(new Posts(12,"Hi there!!, Good Evening!!"));
		userTwoPosts.add(new Posts(13,"Everthing gonna be fine!!"));
	}
	
	private static int userCount = 3;
	//static
	 {
	users.add(new User(1, "Yuvan", new Date(), userOnePosts));
	users.add(new User(2, "Pradeep", new Date(), userTwoPosts));
	}
	 
	// Return all the users
	public List<User> findAll() {
		return users;
	}
	
	// Return particular user
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	// Add new user
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	// Return all posts of particular user
	public List<Posts> allPosts(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user.getPostList();
			}
		}
		return null;
	}
	
	//Return particular post details
	public String onePost(int userId, int postId) {
		for(User user: users) {
			if(user.getId() == userId) {
				for(Posts post: user.getPostList()) {
					if(post.getPostId() == postId) {
						return post.getPostDescription();
					}
				}
			}
		}
		return null;
	}
}
