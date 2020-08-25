package com.sharrel.api.service;

import java.util.List;

import com.sharrel.api.model.Groups;

public interface GroupsService {
	
	public List<Groups> findAllGroups();
	
	public List<Groups> findGroup(Integer id);

}
