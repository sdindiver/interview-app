package com.app.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CandidateSlotRequest {

	@JsonProperty("candidate_id")
	private Integer candidateId;
	@JsonProperty("candidate_slots")
	private List<String> candidateSlots;
	
	public CandidateSlotRequest() {
		super();
	}
	public Integer getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	public List<String> getCandidateSlots() {
		return candidateSlots;
	}
	public void setCandidateSlots(List<String> candidateSlots) {
		this.candidateSlots = candidateSlots;
	}
	
	
	
}
