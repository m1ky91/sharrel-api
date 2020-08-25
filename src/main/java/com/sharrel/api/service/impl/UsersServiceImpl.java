package com.sharrel.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharrel.api.dao.UsersDAO;
import com.sharrel.api.model.Users;
import com.sharrel.api.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public List<Users> findAllUsers() {
		return usersDAO.findAll();
	}

	@Override
	public List<Users> findUser(String username) {
		return usersDAO.findByUsername(username);
	}

}
