package com.restexample.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restexample.api.model.User;
import com.restexample.api.services.UserServices;

@RestController
public class UserController {
	@Autowired
	private UserServices userService;
	@Autowired
	private MessageSource messageSource; 
	
	@GetMapping(path="/users")
	public List<User> retriveAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(path="/users/{userid}")
	public EntityModel<User> getUserById(@PathVariable Long userid) {
		User user= userService.findOne(userid);
		if (user==null) {
			throw new UserNotFoundException("userId:"+userid);
		}
		
		// Hateoas implementation
		EntityModel<User> resource = EntityModel.of(user);//new EntityModel<User>(user.get());

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());

		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping(path="/users")  // @Valid for validation
	public ResponseEntity<User> getUserById(@Valid @RequestBody User user) {
		User userSaved= userService.save(user);
		
		// return created user url to client in response
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{userid}").buildAndExpand(userSaved.getUserId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/users/{userid}/posts")
	public User getUserPosts(@PathVariable Long userid) {
		// Exception handling
		User user= userService.findOne(userid);
		if (user==null) {
			throw new UserNotFoundException("userId:"+userid);
		}
		return user;
	}
	
	@DeleteMapping(path="/delete/{userid}")
	public User deleteUserById(@PathVariable Long userid) {
		User user= userService.deleteOne(userid);
		// Exception handling
		if (user==null) {
			throw new UserNotFoundException("userId:"+userid);
		}
		return user;
	}
	
	// Internationalization
	@GetMapping(path="/i18")
	public String internationalization() {
		return messageSource.getMessage("good.morining.message", null, LocaleContextHolder.getLocale());
	}
}
