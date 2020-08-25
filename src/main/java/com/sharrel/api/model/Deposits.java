package com.sharrel.api.model;

import java.math.BigDecimal;

public class Deposits {
	
	private Integer id;
	private String depositDate;
	private BigDecimal cost;
	private String currency;
	private String payer;
	private String beneficiary;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDepositDate() {
		return depositDate;
	}
	
	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getPayer() {
		return payer;
	}
	
	public void setPayer(String payer) {
		this.payer = payer;
	}
	
	public String getBeneficiary() {
		return beneficiary;
	}
	
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposits other = (Deposits) obj;
		if (beneficiary == null) {
			if (other.beneficiary != null)
				return false;
		} else if (!beneficiary.equals(other.beneficiary))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (depositDate == null) {
			if (other.depositDate != null)
				return false;
		} else if (!depositDate.equals(other.depositDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (payer == null) {
			if (other.payer != null)
				return false;
		} else if (!payer.equals(other.payer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Deposits [id=" + id + ", depositDate=" + depositDate + ", cost=" + cost + ", currency=" + currency
				+ ", payer=" + payer + ", beneficiary=" + beneficiary + "]";
	}

}
