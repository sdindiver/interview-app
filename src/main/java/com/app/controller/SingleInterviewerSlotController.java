package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppResponseList;
import com.app.entity.SingleInterviewerSlot;
import com.app.request.SingleInterviewerSlotRequest;
import com.app.response.AppResponse;
import com.app.service.SingleInterviewerSlotService;

@RestController
public class SingleInterviewerSlotController {

	@Autowired
	private SingleInterviewerSlotService singleInterviewerSlotService;
	

    /**
     * Creates new single interviewer slots by passed JSON data
     *
     * @Route("/api/single-interviewer-slots", methods={"POST"})
     * @param Request $request
     * @param SingleInterviewerSlotService $singleInterviewerSlotService
     * @param ResponseErrorDecoratorService $errorDecorator
     * @return JsonResponse Data containing just created slots or error
     */
	@PostMapping("/api/single-interviewer-slots")
    public ResponseEntity<AppResponse<AppResponseList<SingleInterviewerSlot>>> createSingleInterviewerSlots(SingleInterviewerSlotRequest request)
    {
		List<SingleInterviewerSlot> list = singleInterviewerSlotService.createSingleInterviewerSlots(request);
		AppResponseList<SingleInterviewerSlot> dto = new AppResponseList<>(list);
		AppResponse<AppResponseList<SingleInterviewerSlot>> response = new AppResponse<>(dto);
		return ResponseEntity.ok().body(response);
		
    }
    /*
    *//**
     * @Route("/api/single-interviewer-slot/{id}", methods={"DELETE"})
     * @param SingleInterviewerSlot $singleInterviewerSlot
     * @param SingleInterviewerSlotService $singleInterviewerSlotService
     * @param ResponseErrorDecoratorService $errorDecorator
     * @return JsonResponse
     */
	@DeleteMapping("/api/single-interviewer-slot/{id}")
    public ResponseEntity<Object> deleteSingleInterviewerSlot(SingleInterviewerSlot entity)
    {
    	singleInterviewerSlotService.deleteSingleInterviewerSlot(entity);
    	return ResponseEntity.noContent().build();
    }
}
