package com.sharrel.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharrel.api.dao.GroupsDAO;
import com.sharrel.api.model.Groups;
import com.sharrel.api.service.GroupsService;

@Service
public class GroupsServiceImpl implements GroupsService {
	
	@Autowired
	private GroupsDAO groupsDAO;

	@Override
	public List<Groups> findAllGroups() {
		return groupsDAO.findAll();
	}

	@Override
	public List<Groups> findGroup(Integer id) {
		return groupsDAO.findById(id);
	}

}
