package com.sharrel.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharrel.api.dao.SharesDAO;
import com.sharrel.api.model.Shares;

@Repository
public class SharesDAOImpl implements SharesDAO {
	
	private static final String GET_ALL_SHARES = "SELECT " + 
													"	S.ID, " + 
													"	S.GROUP_ID, " + 
													"	TO_CHAR(S.SHARE_DATE, 'DD-MM-YYYY HH24:MI:SS') AS SHARE_DATE, " + 
													"	S.MAX_GUESTS, " + 
													"	S.HOST, " + 
													"	G.GUEST, " + 
													"	R.COST, " + 
													"	R.CURRENCY, " + 
													"	R.TYPE " + 
													"FROM " + 
													"	SHARES S " + 
													"LEFT JOIN GUESTS G ON " + 
													"	S.ID = G.SHARE_ID " +
													"LEFT JOIN RATES R ON " + 
													"	S.ID = R.SHARE_ID";
	private static final String CREATE_SHARE = "INSERT INTO SHARES" +
													" (GROUP_ID, SHARE_DATE, MAX_GUESTS, HOST)" + 
													" VALUES(?, TO_TIMESTAMP(?, 'DD-MM-YYYY HH24:MI:SS') , ?, ?)";
	private static final String WHERE_ID_EQUALS_TO = " WHERE S.ID = ?";
	private static final String AND_HOST_EQUALS_TO = " AND S.HOST = ?";
	private static final String WHERE_GROUP_EQUALS_TO = " WHERE S.GROUP_ID = ?";
	private static final String WHERE_INDEX_SHARE_CREATED = " WHERE S.GROUP_ID = ? AND S.SHARE_DATE = TO_TIMESTAMP(?, 'DD-MM-YYYY HH24:MI:SS') AND S.MAX_GUESTS = ? AND S.HOST = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ResultSetExtractor<List<Shares>> sharesResultSetExtractor;

	@Override
	public List<Shares> findAll() {
		return jdbcTemplate.query(GET_ALL_SHARES, sharesResultSetExtractor);
	}

	@Override
	public List<Shares> findById(Integer id) {
		return jdbcTemplate.query(GET_ALL_SHARES + WHERE_ID_EQUALS_TO, new Object[] { id }, sharesResultSetExtractor);
	}

	@Override
	public List<Shares> findByGroupAndHost(Integer id, String username) {
		return jdbcTemplate.query(GET_ALL_SHARES + WHERE_GROUP_EQUALS_TO + AND_HOST_EQUALS_TO, new Object[] { id, username }, sharesResultSetExtractor);
	}

	@Transactional
	@Override
	public void add(Shares share) {
		jdbcTemplate.update(CREATE_SHARE, new Object[] { share.getGroupId(), share.getShareDate(), share.getMaxGuests(), share.getHost() });
	}

	@Override
	public List<Shares> findByIndexShareCreated(Integer groupId, String shareDate, Integer maxGuests, String host) {
		return jdbcTemplate.query(GET_ALL_SHARES + WHERE_INDEX_SHARE_CREATED,
				new Object[] { groupId, shareDate, maxGuests, host },
				sharesResultSetExtractor);
	}

	@Override
	public List<Shares> findByGroup(Integer id) {
		return jdbcTemplate.query(GET_ALL_SHARES + WHERE_GROUP_EQUALS_TO, new Object[] { id }, sharesResultSetExtractor);		
	}

}
