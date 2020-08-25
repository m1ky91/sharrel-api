package com.sharrel.api.dao;

import java.util.List;

import com.sharrel.api.model.Users;

public interface UsersDAO {

	public List<Users> findAll();
	
	public List<Users> findByUsername(String username);
	
}
