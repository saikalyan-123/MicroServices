package com.google.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.dao.User;
import com.google.service.ServicesException;
import com.google.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserService userService = null;

	@Value("${usermanagementservice-env}")
	private String environment = null;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> userList = null;
		try {
			userList = userService.getAll();
		} catch (ServicesException e) {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		log.info(" *********  environment ********" + environment);

		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		try {
			userService.save(user);

		} catch (ServicesException e) {
			return new ResponseEntity<User>( HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<User> update(User user) {
		try {
			userService.update(user);
		} catch (ServicesException e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@GetMapping(path = "/{userId}")
	public ResponseEntity<User> get(@PathVariable("userId") String userId) {
		User user = null;
		try {

			user = userService.getById(userId);

		} catch (ServicesException e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<User> delete(@PathVariable("userId") String userId) {

		try {

			userService.DeleteById(userId);

		} catch (ServicesException e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<User>(HttpStatus.OK);

	}

}
