package com.sharrel.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sharrel.api.dao.UsersDAO;
import com.sharrel.api.model.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	private static final String GET_ALL_USERS = "SELECT * FROM USERS";
	private static final String WHERE_USERNAME_EQUALS_TO = " WHERE USERNAME = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private RowMapper<Users> usersRowMapper;

	@Override
	public List<Users> findAll() {
		return jdbcTemplate.query(GET_ALL_USERS, usersRowMapper);
	}

	@Override
	public List<Users> findByUsername(String username) {
		return jdbcTemplate.query(GET_ALL_USERS + WHERE_USERNAME_EQUALS_TO, new Object[] { username }, usersRowMapper);
	}

}
