package com.sharrel.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharrel.api.dao.GuestsDAO;
import com.sharrel.api.model.Guests;

@Repository
public class GuestsDAOImpl implements GuestsDAO {
	
	private static final String CREATE_GUEST = "INSERT INTO GUESTS" +
												" (SHARE_ID, GUEST)" + 
												" VALUES(?, ?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public void add(Guests guest) {
		jdbcTemplate.update(CREATE_GUEST, new Object[]{ guest.getShareId(),  guest.getGuest()});
	}

}
