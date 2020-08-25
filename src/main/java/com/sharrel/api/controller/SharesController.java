package com.sharrel.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sharrel.api.model.Shares;
import com.sharrel.api.service.SharesService;

@RestController
public class SharesController extends BaseController {
	
	@Autowired
	private SharesService sharesService;
	
	@RequestMapping(value = "/shares", method = RequestMethod.GET)
	public ResponseEntity<?> getShares() {
		List<Shares> shares = sharesService.findAllShares();
		
		return shares.isEmpty() ? new ResponseEntity<String>("Shares not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Shares>>(shares, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shares", method = RequestMethod.POST)
	public ResponseEntity<?> createShare(@Valid @RequestBody Shares share) {
		return new ResponseEntity<List<Shares>>(sharesService.saveShare(share), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/shares/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSharesById(@PathVariable("id") Integer id) {
		List<Shares> shares = sharesService.findShare(id);
		
		return shares.isEmpty() ? new ResponseEntity<String>("Share not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Shares>>(shares, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shares/group/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSharesByGroup(@PathVariable("id") Integer id) {
		List<Shares> shares = sharesService.findSharesByGroup(id);
		
		return shares.isEmpty() ? new ResponseEntity<String>("Shares not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Shares>>(shares, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shares/group/{id}/host/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> getSharesByGroupAndHost(@PathVariable("id") Integer id, @PathVariable("username") String username) {
		List<Shares> shares = sharesService.findSharesByGroupAndHost(id, username);
		
		return shares.isEmpty() ? new ResponseEntity<String>("Shares not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Shares>>(shares, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shares/group/{id}/host/{username}/guest/{username2}", method = RequestMethod.GET)
	public ResponseEntity<?> getSharesByGroupAndHostAndGuest(@PathVariable("id") Integer id, @PathVariable("username") String username, @PathVariable("username2") String username2) {
		List<Shares> shares = sharesService.findSharesByGroupAndHostAndGuest(id, username, username2);
		
		return shares.isEmpty() ? new ResponseEntity<String>("Shares not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Shares>>(shares, HttpStatus.OK);
	}

}
