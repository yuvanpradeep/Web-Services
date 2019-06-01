package com.java.restful.RESTfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Posts {
	
	@Id
	@GeneratedValue
	private int postId;
	
	private String postDescription;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	public Posts(int postId, String postDescription) {
		super();
		this.postId = postId;
		this.postDescription = postDescription;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", postDescription=" + postDescription + "]";
	}
}
