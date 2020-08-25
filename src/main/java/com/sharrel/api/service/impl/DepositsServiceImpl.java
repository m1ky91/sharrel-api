package com.sharrel.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharrel.api.dao.DepositsDAO;
import com.sharrel.api.model.Deposits;
import com.sharrel.api.service.DepositsService;

@Service
public class DepositsServiceImpl implements DepositsService {
	
	@Autowired
	private DepositsDAO depositsDAO;

	@Override
	public List<Deposits> findAllDeposits() {
		return depositsDAO.findAll();
	}

	@Override
	public List<Deposits> findDeposit(Integer id) {
		return depositsDAO.findById(id);
	}

	@Override
	public List<Deposits> findDepositsByPayer(String username) {
		return depositsDAO.findByPayer(username);
	}

	@Override
	public List<Deposits> findDepositsByPayerAndBeneficiary(String username, String username2) {
		return depositsDAO.findByPrayerAndBeneficiary(username, username2);
	}

}
