package com.java.restful.RESTfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {

	@Autowired
	private UserDaoService service;

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private UserPostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	

//	@GetMapping("/jpa/user/{id}")
//	public Resource<User> retrieveUser(@PathVariable int id) {
//		Optional<User> user = userRepository.findById(id);
//		if(!user.isPresent()) {
//			throw new UserNotFoundException("id-" + id);
//		}
//		
//		Resource<User> resource = new Resource<User>(user.get());
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//	    resource.add(linkTo.withRel("all-users"));
//	    return resource;
//		//return user;
//	}
//	
	@DeleteMapping("/jpa/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
//	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Posts> retrievePostsOfUser(@PathVariable int id) {
		Optional<User> posts = userRepository.findById(id);
		if(posts.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		
		return posts.get().getPostList();
	}
//	
//	@GetMapping("/jpa/users/{userId}/posts/{postId}")
//	public String retrievePostsOfUser(@PathVariable int userId, @PathVariable int postId) {
//		String posts = service.onePost(userId, postId);
//		if(posts == null) {
//			throw new UserNotFoundException("id-" + postId);
//		}
//		return posts;
//	}
//	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		// return status after created
		// return URI
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
			
	 }
	
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Posts post) {
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isPresent()) {
			throw new UserNotFoundException("id" + id);
		}
		 
		User savedUser = userOptional.get();
		post.setUser(savedUser);
		postRepository.save(post);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(post.getPostId()).toUri();
		
		return ResponseEntity.created(location).build();
			
	 }
}
