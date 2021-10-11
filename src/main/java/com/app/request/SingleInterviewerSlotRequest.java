package com.app.request;

import java.util.List;

import com.app.dto.SingleInterviewSlotRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SingleInterviewerSlotRequest {

	@JsonProperty("interviewer_id")
	private Integer interviewerId;

	@JsonProperty("single_interviewer_slots")
	private List<SingleInterviewSlotRequestDTO> singleInterviewSlots;

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public List<SingleInterviewSlotRequestDTO> getSingleInterviewSlots() {
		return singleInterviewSlots;
	}

	public void setSingleInterviewSlots(List<SingleInterviewSlotRequestDTO> singleInterviewSlots) {
		this.singleInterviewSlots = singleInterviewSlots;
	}

}
