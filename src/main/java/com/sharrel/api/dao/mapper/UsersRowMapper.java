package com.sharrel.api.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sharrel.api.model.Users;

@Component
public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet row, int rowNum) throws SQLException {
		Users user = new Users();
		
		user.setUsername(row.getString("username"));
		user.setPassword(row.getString("password"));
		user.setEmail(row.getString("email"));
		
		return user;
	}

}
