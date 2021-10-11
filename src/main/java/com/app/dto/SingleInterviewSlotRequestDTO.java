package com.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SingleInterviewSlotRequestDTO {

	@JsonProperty("date")
	private Date date;
	@JsonProperty("is_blocked_slot")
	private Boolean isBlockedSlot;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getIsBlockedSlot() {
		return isBlockedSlot;
	}

	public Boolean isBlockedSlot() {
		return isBlockedSlot;
	}

	public void setIsBlockedSlot(Boolean isBlockedSlot) {
		this.isBlockedSlot = isBlockedSlot;
	}

}
