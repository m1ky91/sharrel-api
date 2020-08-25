package com.sharrel.api.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Shares {
	
	private Integer id;
	
	@NotNull
	@Min(1)
	private Integer groupId;
	@NotNull
	private String shareDate;
	@NotNull
	private Integer maxGuests;
	@NotNull
	private String host;
	private List<String> guests;
	@NotNull
	@Digits(integer=8, fraction=2)
	private BigDecimal cost;
	@NotNull
	@Size(min=3, max=3)
	private String currency;
	@NotNull
	@Size(min=1, max=1)
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getShareDate() {
		return shareDate;
	}

	public void setShareDate(String shareDate) {
		this.shareDate = shareDate;
	}

	public Integer getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(Integer maxGuests) {
		this.maxGuests = maxGuests;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<String> getGuests() {
		return guests;
	}

	public void setGuests(List<String> guests) {
		this.guests = guests;
	}

	public Shares addGuestsItem(String guestsItem) {
		if (this.guests == null)
			this.guests = new ArrayList<String>();

		this.guests.add(guestsItem);

		return this;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shares other = (Shares) obj;
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
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (guests == null) {
			if (other.guests != null)
				return false;
		} else if (!guests.equals(other.guests))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxGuests == null) {
			if (other.maxGuests != null)
				return false;
		} else if (!maxGuests.equals(other.maxGuests))
			return false;
		if (shareDate == null) {
			if (other.shareDate != null)
				return false;
		} else if (!shareDate.equals(other.shareDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Shares [id=" + id + ", groupId=" + groupId + ", shareDate=" + shareDate + ", maxGuests=" + maxGuests
				+ ", host=" + host + ", guests=" + guests + ", cost=" + cost + ", currency=" + currency + ", type="
				+ type + "]";
	}

}
