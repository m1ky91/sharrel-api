package com.sharrel.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharrel.api.dao.GuestsDAO;
import com.sharrel.api.dao.RatesDAO;
import com.sharrel.api.dao.SharesDAO;
import com.sharrel.api.model.Guests;
import com.sharrel.api.model.Rates;
import com.sharrel.api.model.Shares;
import com.sharrel.api.service.SharesService;

@Service
public class SharesServiceImpl implements SharesService {
	
	@Autowired
	private SharesDAO sharesDAO;
	
	@Autowired
	private GuestsDAO guestsDAO;
	
	@Autowired
	private RatesDAO ratesDAO;

	@Override
	public List<Shares> findAllShares() {
		return sharesDAO.findAll();
	}

	@Override
	public List<Shares> findShare(Integer id) {
		return sharesDAO.findById(id);
	}

	@Override
	public List<Shares> findSharesByGroupAndHost(Integer id, String username) {
		return sharesDAO.findByGroupAndHost(id, username);
	}

	@Override
	public List<Shares> findSharesByGroupAndHostAndGuest(Integer id, String username, String username2) {
		return sharesDAO.findByGroupAndHost(id, username).stream()
				.filter(s -> s.getGuests().contains(username2))
				.collect(Collectors.toList());
	}

	@Override
	public List<Shares> saveShare(Shares share) {
		sharesDAO.add(share);
		
		List<Shares> shareCreated = sharesDAO.findByIndexShareCreated(share.getGroupId(), share.getShareDate(), share.getMaxGuests(), share.getHost());
		
		Shares uniqueShareCreated = shareCreated.get(0);
		
		List<Guests> guests = share.getGuests().stream().map(g -> {
			Guests guest = new Guests();
			guest.setShareId(uniqueShareCreated.getId());
			guest.setGuest(g);
			return guest;
		}).collect(Collectors.toList());
		
		guests.stream()
			.filter(g -> g.getGuest() != null)
			.forEach(g -> guestsDAO.add(g));
		
		Rates rate = new Rates();
		rate.setShareId(uniqueShareCreated.getId());
		rate.setCost(share.getCost());
		rate.setCurrency(share.getCurrency());
		rate.setType(share.getType());
		
		ratesDAO.add(rate);
		
		return sharesDAO.findById(uniqueShareCreated.getId());
	}

	@Override
	public List<Shares> findSharesByGroup(Integer id) {
		return sharesDAO.findByGroup(id);
	}

}
