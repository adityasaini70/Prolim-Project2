

package com.simplilearn.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.project.errors.UserNotFoundException;
import com.simplilearn.project.model.User;
import com.simplilearn.project.service.AdminService;
import com.simplilearn.project.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@GetMapping(path = "/sportyshoes/{username}/{password}/usertbl")
	public List<User> listAllUsers(@PathVariable String username, @PathVariable String password) {

		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		return this.userService.findAll();
	}
	
	@GetMapping(path = "/sportyshoes/{username}/{password}/usertbl/id/{id}")
	public User findUserByID(@PathVariable String username, @PathVariable String password, @PathVariable long id) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		User theUser = this.userService.findById(id);

		if (theUser == null) {
			throw new UserNotFoundException("User with id - " + id + " not found!");
		}

		return theUser;
	}

	@GetMapping(path = "/sportyshoes/{username}/{password}/usertbl/name/{name}")
	public User findUserByName(@PathVariable String username, @PathVariable String password, @PathVariable String name) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		User theUser = this.userService.findByName(name);

		if (theUser == null) {
			throw new UserNotFoundException("User with name - " + name + " not found!");
		}

		return theUser;
	}
	
	@GetMapping(path = "/sportyshoes/{username}/{password}/usertbl/size/{size}")
	public User findUserBySize(@PathVariable String username, @PathVariable String password, @PathVariable double size) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		User theUser = this.userService.findBySize(size);

		if (theUser == null) {
			throw new UserNotFoundException("User with size - " + size + " not found!");
		}

		return theUser;
	}

	@GetMapping(path = "/sportyshoes/{username}/{password}/usertbl/mobile/{mobile}")
	public User findUserByMobile(@PathVariable String username, @PathVariable String password, @PathVariable String mobile) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		User theUser = this.userService.findByMobile(mobile);

		if (theUser == null) {
			throw new UserNotFoundException("User with mobile - " + mobile + " not found!");
		}

		return theUser;
	}
	
	@GetMapping(path = "/sportyshoes/{username}/{password}/usertbl/email/{email}")
	public User findUserByEmail(@PathVariable String username, @PathVariable String password, @PathVariable String email) {
		
		// Validating admin: Raises AdminNotFoundException if invalid
		this.adminService.findByUsernameAndPassword(username, password);

		User theUser = this.userService.findByEmail(email);

		if (theUser == null) {
			throw new UserNotFoundException("User with email - " + email + " not found!");
		}

		return theUser;
	}
}
