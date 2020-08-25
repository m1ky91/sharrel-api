package com.sharrel.api.service;

import java.util.List;

import com.sharrel.api.model.Deposits;

public interface DepositsService {
	
	public List<Deposits> findAllDeposits();

	public List<Deposits> findDeposit(Integer id);

	public List<Deposits> findDepositsByPayer(String username);

	public List<Deposits> findDepositsByPayerAndBeneficiary(String username, String username2);

}
