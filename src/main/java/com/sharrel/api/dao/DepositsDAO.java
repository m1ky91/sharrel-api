package com.sharrel.api.dao;

import java.util.List;

import com.sharrel.api.model.Deposits;

public interface DepositsDAO {
	
	public List<Deposits> findAll();

	public List<Deposits> findById(Integer id);

	public List<Deposits> findByPayer(String username);

	public List<Deposits> findByPrayerAndBeneficiary(String username, String username2);

}
