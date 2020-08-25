package com.sharrel.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sharrel.api.dao.DepositsDAO;
import com.sharrel.api.model.Deposits;

@Repository
public class DepositsDAOImpl implements DepositsDAO {
	
	private static final String GET_ALL_DEPOSITS = "SELECT " + 
													"	D.ID, " + 
													"	TO_CHAR(D.DEPOSIT_DATE, 'DD-MM-YYYY HH24:MI:SS') AS DEPOSIT_DATE, " + 
													"	D.COST, " + 
													"	D.CURRENCY, " + 
													"	D.PAYER, " + 
													"	D.BENEFICIARY " +
													"FROM " + 
													"	DEPOSITS D";
	private static final String WHERE_ID_EQUALS_TO = " WHERE D.ID = ?";
	private static final String WHERE_PAYER_EQUALS_TO = " WHERE D.PAYER = ?";
	private static final String WHERE_PAYER_AND_BENEFICIARY_EQUALS_TO = " WHERE D.PAYER = ? AND D.BENEFICIARY = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RowMapper<Deposits> depositsRowMapper;

	@Override
	public List<Deposits> findAll() {
		return jdbcTemplate.query(GET_ALL_DEPOSITS, depositsRowMapper);
	}

	@Override
	public List<Deposits> findById(Integer id) {
		return jdbcTemplate.query(GET_ALL_DEPOSITS + WHERE_ID_EQUALS_TO, new Object[] { id }, depositsRowMapper);
	}

	@Override
	public List<Deposits> findByPayer(String username) {
		return jdbcTemplate.query(GET_ALL_DEPOSITS + WHERE_PAYER_EQUALS_TO, new Object[] { username }, depositsRowMapper);
	}

	@Override
	public List<Deposits> findByPrayerAndBeneficiary(String username, String username2) {
		return jdbcTemplate.query(GET_ALL_DEPOSITS + WHERE_PAYER_AND_BENEFICIARY_EQUALS_TO, new Object[] { username, username2 }, depositsRowMapper);
	}

}
