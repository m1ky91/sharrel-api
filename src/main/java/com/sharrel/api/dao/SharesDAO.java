package com.sharrel.api.dao;

import java.util.List;

import com.sharrel.api.model.Shares;

public interface SharesDAO {
	
	public List<Shares> findAll();
	
	public List<Shares> findById(Integer id);

	public List<Shares> findByGroupAndHost(Integer id, String username);

	public void add(Shares share);

	public List<Shares> findByIndexShareCreated(Integer groupId, String shareDate, Integer maxGuests, String host);

	public List<Shares> findByGroup(Integer id);

}
