package com.sharrel.api.dao;

import java.util.List;

import com.sharrel.api.model.Groups;

public interface GroupsDAO {
	
	public List<Groups> findAll();
	
	public List<Groups> findById(Integer id);

}
