package com.app.request;

import java.util.List;

import com.app.dto.RepeatableInterviewerSlotDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RepeatableInterviewerSlotRequest {

	@JsonProperty("interviewer_id")
	private Integer interviewerId;

	@JsonProperty("repeatable_interviewer_slots")
	private List<RepeatableInterviewerSlotDTO> repeatableInterviewerSlots;

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public List<RepeatableInterviewerSlotDTO> getRepeatableInterviewerSlots() {
		return repeatableInterviewerSlots;
	}

	public void setRepeatableInterviewerSlots(List<RepeatableInterviewerSlotDTO> repeatableInterviewerSlots) {
		this.repeatableInterviewerSlots = repeatableInterviewerSlots;
	}


}
