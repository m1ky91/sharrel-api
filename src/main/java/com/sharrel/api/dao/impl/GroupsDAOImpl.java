package com.sharrel.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sharrel.api.dao.GroupsDAO;
import com.sharrel.api.model.Groups;

@Repository
public class GroupsDAOImpl implements GroupsDAO {
	
	private static final String GET_ALL_GROUPS = "SELECT " + 
			"	G.ID, " + 
			"	G.GROUP_NAME, " + 
			"	G.CATEGORY_ID " +
			"FROM " + 
			"	GROUPS G";
	private static final String WHERE_ID_EQUALS_TO = " WHERE G.ID = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RowMapper<Groups> groupsRowMapper;

	@Override
	public List<Groups> findAll() {
		return jdbcTemplate.query(GET_ALL_GROUPS, groupsRowMapper);
	}
	
	@Override
	public List<Groups> findById(Integer id) {
		return jdbcTemplate.query(GET_ALL_GROUPS + WHERE_ID_EQUALS_TO, new Object[] { id }, groupsRowMapper);
	}

}
