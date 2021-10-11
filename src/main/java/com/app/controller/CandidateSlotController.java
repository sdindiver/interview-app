package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppResponseList;
import com.app.entity.CandidateSlot;
import com.app.request.CandidateSlotRequest;
import com.app.response.AppResponse;
import com.app.service.CandidateSlotService;

@RestController
public class CandidateSlotController {
	
	@Autowired
	private CandidateSlotService service;
	
	  /**
     * Creates new candidate slots by passed JSON data
     *
     * @Route("/api/candidate-slots", methods={"POST"})
     * @param Request $request
     * @param CandidateSlotService $candidateSlotService
     * @param ResponseErrorDecoratorService $errorDecorator
     * @return JsonResponse Data containing just created slots or error
     */
	@PostMapping("/api/candidate-slots")
    public ResponseEntity<AppResponse<AppResponseList<CandidateSlot>>> createCandidateSlots(CandidateSlotRequest request)
    {
		List<CandidateSlot>  list = service.createCandidateSlots(request);
		AppResponseList<CandidateSlot> dto = new AppResponseList<>(list);
		AppResponse<AppResponseList<CandidateSlot>> response = new AppResponse<>(dto);
		return ResponseEntity.ok().body(response);
    }

    /**
     * @Route("/api/candidate-slot/{id}", methods={"DELETE"})
     * @param CandidateSlot $candidateSlot
     * @param CandidateSlotService $candidateSlotService
     * @param ResponseErrorDecoratorService $errorDecorator
     * @return JsonResponse
     */
	@DeleteMapping("/api/candidate-slot/{id}")
    public ResponseEntity<Object> deleteCandidateSlot(CandidateSlot $candidateSlot)
    {
    	service.deleteCandidateSlot($candidateSlot);
    	return ResponseEntity.noContent().build();
    }
}
