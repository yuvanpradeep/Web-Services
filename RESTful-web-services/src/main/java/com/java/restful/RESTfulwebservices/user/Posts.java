package com.java.restful.RESTfulwebservices.user;

public class Posts {
	
	private int postId;
	
	private String postDescription;
	
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
