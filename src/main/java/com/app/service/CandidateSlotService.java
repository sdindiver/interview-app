package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Candidate;
import com.app.entity.CandidateSlot;
import com.app.repository.CandidateRepository;
import com.app.repository.CandidateSlotRepository;
import com.app.request.CandidateSlotRequest;

@Service
public class CandidateSlotService {

	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private CandidateSlotRepository candidateSlotRepository;
	
	
	/**
     * Create candidate slot(s) by given data
     *
     * @param $data array which contains information about candidate slots
     *    $data = [
     *      'candidate_id' => (int) Candidate id. Required.
     *      'candidate_slots' => (array) Array of candidate slots. Required.
     *    ]
     *
     *    Repeatable candidate slots structure example:
     *      $data['candidate_slots'] = [
     *           ['date' => '2018-09-01 10:00 AM'],
     *           ['date' => '2018-09-01 11:00 PM'],
     *           ['date' => '2018-09-15 01:00 AM'],
     *           ['date' => '2018-10-30 04:00 PM'],
     *      ];
	 * @return 
     *
     * @return CandidateSlot[]|string Array of CandidateSlot objects or error message
     */
	public List<CandidateSlot> createCandidateSlots(CandidateSlotRequest data) {
		
		Candidate candidate = candidateRepository.findById(data.getCandidateId()).get();
		List<CandidateSlot> list = new ArrayList<>();
		candidate.getCandidateSlots().stream().forEach(x->{
			CandidateSlot slot = new CandidateSlot();
			slot.setCandidate(candidate);
			slot.setDate(x.getDate());
			candidateSlotRepository.save(slot);
			list.add(slot);
		});
		return list;
	}


	public void deleteCandidateSlot(CandidateSlot entity) {
		candidateSlotRepository.delete(entity);
	}

}
