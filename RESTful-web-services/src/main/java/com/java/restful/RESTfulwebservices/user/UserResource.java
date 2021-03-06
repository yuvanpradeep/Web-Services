package com.java.restful.RESTfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	 
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		
//		Resource<User> resource = new Resource<User>(user);
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//	    resource.add(linkTo.withRel("all-users"));
//	    return resource;
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}
	
//	@GetMapping("/users/{id}/posts")
//	public List<Posts> retrievePostsOfUser(@PathVariable int id) {
//		List<Posts> posts = service.allPosts(id);
//		return posts;
//	}
//	
//	@GetMapping("/users/{userId}/posts/{postId}")
//	public String retrievePostsOfUser(@PathVariable int userId, @PathVariable int postId) {
//		String posts = service.onePost(userId, postId);
//		if(posts == null) {
//			throw new UserNotFoundException("id-" + postId);
//		}
//		return posts;
//	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// return status after created
		// return URI
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
			
	}
}
