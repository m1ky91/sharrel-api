package com.sharrel.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sharrel.api.model.Groups;
import com.sharrel.api.service.GroupsService;

@RestController
public class GroupsController {
	
	@Autowired
	GroupsService groupsService;
	
	@RequestMapping(value = "/groups", method = RequestMethod.GET)
	public ResponseEntity<?> getGroups() {
		List<Groups> groups = groupsService.findAllGroups();
		
		return groups.isEmpty() ? new ResponseEntity<String>("Groups not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Groups>>(groups, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/groups/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getGroupById(@PathVariable("id") Integer id) {
		List<Groups> groups = groupsService.findGroup(id);
		
		return groups.isEmpty() ? new ResponseEntity<String>("Group not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Groups>>(groups, HttpStatus.OK);
	}

}
