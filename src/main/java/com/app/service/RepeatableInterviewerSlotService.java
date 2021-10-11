package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.entity.Interviewer;
import com.app.entity.RepeatableInterviewerSlot;
import com.app.repository.InterviewerRepository;
import com.app.repository.RepeatableInterviewerSlotRepository;
import com.app.request.RepeatableInterviewerSlotRequest;

public class RepeatableInterviewerSlotService extends BaseService {

	@Autowired
	private TimeConverterService timeConverterService;
	
	@Autowired
	private InterviewerRepository interviewerRepository;
	
	@Autowired
	private RepeatableInterviewerSlotRepository repeatableInterviewerSlotRepository;

	public List<RepeatableInterviewerSlot> createRepeatableInterviewerSlots(RepeatableInterviewerSlotRequest request) {
		Optional<Interviewer> interviewer = interviewerRepository.findById(request.getInterviewerId());
		List<RepeatableInterviewerSlot> list = new ArrayList<>();
		if(interviewer.isPresent()){
			request.getRepeatableInterviewerSlots().forEach(x->{
				int hours24 = timeConverterService.convertTo24H(x.getStartTime());
				RepeatableInterviewerSlot entity = new RepeatableInterviewerSlot();
				entity.setInterviewer(interviewer.get());
				entity.setWeekday(x.getDayNumber());
				entity.setHour(hours24);
				repeatableInterviewerSlotRepository.save(entity);
				list.add(entity);
			});
		}
          return list;
	}
	public void deleteRepeatableInterviewerSlot(RepeatableInterviewerSlot entity) {
		repeatableInterviewerSlotRepository.delete(entity);
	}

}
