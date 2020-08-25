package com.sharrel.api.model;

public class Guests {
	
	private Integer shareId;
	private String guest;
	
	public Integer getShareId() {
		return shareId;
	}
	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guests other = (Guests) obj;
		if (guest == null) {
			if (other.guest != null)
				return false;
		} else if (!guest.equals(other.guest))
			return false;
		if (shareId == null) {
			if (other.shareId != null)
				return false;
		} else if (!shareId.equals(other.shareId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Guests [shareId=" + shareId + ", guest=" + guest + "]";
	}	

}
