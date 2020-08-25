package com.sharrel.api.service;

import java.util.List;

import com.sharrel.api.model.Users;

public interface UsersService {
	
	List<Users> findAllUsers();
	
	List<Users> findUser(String username);

}
