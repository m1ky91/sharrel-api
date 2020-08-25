package com.sharrel.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sharrel.api.model.Users;
import com.sharrel.api.service.UsersService;

@RestController
public class UsersController extends BaseController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		List<Users> users = usersService.findAllUsers();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Requested-With", "*");
	    headers.add("Access-Control-Allow-Origin", "*");
	    headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, OPTIONS");
	    headers.add("Access-Control-Allow-Headers", "Content-Type,X-Amz-Date,Authorization,X-Api-Key,x-requested-with");

		return users.isEmpty() ? new ResponseEntity<String>("Users not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Users>>(users, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("username") String username) {
		List<Users> users = usersService.findUser(username);
		
		return users.isEmpty() ? new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}

}
