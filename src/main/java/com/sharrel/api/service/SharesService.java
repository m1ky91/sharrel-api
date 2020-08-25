package com.sharrel.api.service;

import java.util.List;

import com.sharrel.api.model.Shares;

public interface SharesService {
	
	public List<Shares> findAllShares();
	
	public List<Shares> findShare(Integer id);

	public List<Shares> findSharesByGroupAndHost(Integer id, String username);

	public List<Shares> findSharesByGroupAndHostAndGuest(Integer id, String username, String username2);

	public List<Shares> saveShare(Shares share);

	public List<Shares> findSharesByGroup(Integer id);

}
