package com.sharrel.api.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.sharrel.api.model.Shares;

@Component
public class SharesResultSetExtractor implements ResultSetExtractor<List<Shares>> {

	@Override
	public List<Shares> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Shares> uniqueShares = new HashMap<Integer, Shares>();
		
		while(rs.next()) {
			Integer shareId = rs.getInt("id");
			Shares currentShare = uniqueShares.get(shareId);
			
			if (currentShare == null) {
				currentShare = new Shares();
				currentShare.setId(shareId);
				currentShare.setGroupId(rs.getInt("group_id"));
				currentShare.setShareDate(rs.getString("share_date"));				
				currentShare.setMaxGuests(rs.getInt("max_guests"));
				currentShare.setHost(rs.getString("host"));
				uniqueShares.put(shareId, currentShare);	
				currentShare.setCost(rs.getBigDecimal("cost"));
				currentShare.setCurrency(rs.getString("currency"));
				currentShare.setType(rs.getString("type"));
			}
			
			currentShare.addGuestsItem(rs.getString("guest"));
		}
		
		return new ArrayList<Shares>(uniqueShares.values());
	}

}
