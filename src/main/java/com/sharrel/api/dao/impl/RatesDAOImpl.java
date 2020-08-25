package com.sharrel.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharrel.api.dao.RatesDAO;
import com.sharrel.api.model.Rates;

@Repository
public class RatesDAOImpl implements RatesDAO {
	
	private static final String CREATE_RATE = "INSERT INTO RATES" +
												" (SHARE_ID, COST, CURRENCY, TYPE)" + 
												" VALUES(?, ?, ?, ?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public void add(Rates rate) {
		jdbcTemplate.update(CREATE_RATE, new Object[]{ rate.getShareId(), rate.getCost(), rate.getCurrency(), rate.getType()});
	}

}
