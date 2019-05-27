package com.java.restful.RESTfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private Integer id;
	
	private String name;
	
	private Date birthdate;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", postList=" + postList + "]";
	}

	private List<Posts> postList = new ArrayList<>();
	
	public List<Posts> getPostList() {
		return postList;
	}

	public void setPostList(List<Posts> postList) {
		this.postList = postList;
	}

	// Constructor
	protected User() {
		
	}
	
	public User(Integer id, String name, Date birthdate, List<Posts> userOnePosts) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.postList = userOnePosts;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	
}
