package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RepeatableInterviewerSlotDTO {

	@JsonProperty("start_time")
	private String startTime;
	@JsonProperty("day_number")
	private Integer dayNumber;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

}
