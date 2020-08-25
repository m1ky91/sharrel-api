package com.sharrel.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sharrel.api.model.Deposits;
import com.sharrel.api.service.DepositsService;

@RestController
public class DepositsController extends BaseController {
	
	@Autowired
	private DepositsService depositsService;
	
	@RequestMapping(value = "/deposits", method = RequestMethod.GET)
	public ResponseEntity<?> getDeposits() {
		List<Deposits> deposits = depositsService.findAllDeposits();
		
		return deposits.isEmpty() ? new ResponseEntity<String>("Deposits not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Deposits>>(deposits, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deposits/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDepositById(@PathVariable("id") Integer id) {
		List<Deposits> deposits = depositsService.findDeposit(id);
		
		return deposits.isEmpty() ? new ResponseEntity<String>("Deposit not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Deposits>>(deposits, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deposits/payer/{username}", method = RequestMethod.GET)
	public ResponseEntity<?> getDepositByPayer(@PathVariable("username") String username) {
		List<Deposits> deposits = depositsService.findDepositsByPayer(username);
		
		return deposits.isEmpty() ? new ResponseEntity<String>("Deposits not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Deposits>>(deposits, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deposits/payer/{username}/beneficiary/{username2}", method = RequestMethod.GET)
	public ResponseEntity<?> getDepositByPayerAndBeneficiary(@PathVariable("username") String username, @PathVariable("username2") String username2) {
		List<Deposits> deposits = depositsService.findDepositsByPayerAndBeneficiary(username, username2);
		
		return deposits.isEmpty() ? new ResponseEntity<String>("Deposits not found", HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Deposits>>(deposits, HttpStatus.OK);
	}

}
