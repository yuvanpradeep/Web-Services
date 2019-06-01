package com.java.restful.RESTfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the users")
@Entity
public class User {

	@Id
	@GeneratedValue
    private Integer id;
	
    @Size(min=2, message= "Name should have atleast two characters")
    @ApiModelProperty(notes="Name should have atleast two characters")
	private String name;
	
    @Past
    @ApiModelProperty(notes="Birth date should be in past")
	private Date birthdate;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]"; //, postList=" + postList + "
	}

	@OneToMany(mappedBy = "user")
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
		//this.postList = userOnePosts;
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
