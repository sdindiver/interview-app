package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.entity.Interviewer;
import com.app.entity.SingleInterviewerSlot;
import com.app.repository.InterviewerRepository;
import com.app.repository.SingleInterviewerSlotRepository;
import com.app.request.SingleInterviewerSlotRequest;

public class SingleInterviewerSlotService extends BaseService {

	@Autowired
	private InterviewerRepository interviewerRepository;
	
	@Autowired
	private SingleInterviewerSlotRepository singleInterviewerSlotRepository;

	public List<SingleInterviewerSlot> createSingleInterviewerSlots(SingleInterviewerSlotRequest request){
		Optional<Interviewer> interviewer = interviewerRepository.findById(request.getInterviewerId());
		List<SingleInterviewerSlot> responseList = new ArrayList<>();
		if(interviewer.isPresent()){
			request.getSingleInterviewSlots().forEach(x->{
				SingleInterviewerSlot slot = new SingleInterviewerSlot();
				slot.setInterviewer(interviewer.get());
				slot.setDate(x.getDate());
				slot.setIsBlockedSlot(x.getIsBlockedSlot());
				singleInterviewerSlotRepository.save(slot);
				responseList.add(slot);
			});
		}
		return responseList;
	}


	public void deleteSingleInterviewerSlot(SingleInterviewerSlot entity) {
		singleInterviewerSlotRepository.delete(entity);
	}
}
