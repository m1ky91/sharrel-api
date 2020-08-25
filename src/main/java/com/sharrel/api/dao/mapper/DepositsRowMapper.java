package com.sharrel.api.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sharrel.api.model.Deposits;

@Component
public class DepositsRowMapper implements RowMapper<Deposits> {

	@Override
	public Deposits mapRow(ResultSet row, int rowNum) throws SQLException {
		Deposits deposit = new Deposits();
		
		deposit.setId(row.getInt("id"));
		deposit.setDepositDate(row.getString("deposit_date"));
		deposit.setCost(row.getBigDecimal("cost"));
		deposit.setCurrency(row.getString("currency"));
		deposit.setPayer(row.getString("payer"));
		deposit.setBeneficiary(row.getString("beneficiary"));
		
		return deposit;
	}

}
