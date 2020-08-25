package com.sharrel.api.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sharrel.api.model.Groups;

@Component
public class GroupsRowMapper implements RowMapper<Groups> {

	@Override
	public Groups mapRow(ResultSet row, int rowNum) throws SQLException {
		Groups group = new Groups();
		
		group.setId(row.getInt("id"));
		group.setGroupName(row.getString("group_name"));
		group.setCategoryId(row.getInt("category_id"));
		
		return group;
	}

}
