package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppResponseList;
import com.app.entity.RepeatableInterviewerSlot;
import com.app.request.RepeatableInterviewerSlotRequest;
import com.app.response.AppResponse;
import com.app.service.RepeatableInterviewerSlotService;

@RestController
public class RepeatableInterviewerSlotController {
	
	@Autowired
	private RepeatableInterviewerSlotService repeatableInterviewerSlotService;
	/**
     * Creates new repeatable interviewer slots by passed JSON data
     *
     * @Route("/api/repeatable-interviewer-slots", methods={"POST"})
     * @param Request $request
     * @param RepeatableInterviewerSlotService $repeatableInterviewerSlotService
     * @param ResponseErrorDecoratorService $errorDecorator
     * @return JsonResponse Data containing just created slots or error
     */
	@PostMapping("/api/repeatable-interviewer-slots")
    public ResponseEntity<AppResponse<AppResponseList<RepeatableInterviewerSlot>>> createRepeatableInterviewerSlots(RepeatableInterviewerSlotRequest request)
    {
		List<RepeatableInterviewerSlot> responseList =repeatableInterviewerSlotService.createRepeatableInterviewerSlots(request);
		AppResponseList<RepeatableInterviewerSlot> dto = new AppResponseList<>(responseList);
		AppResponse<AppResponseList<RepeatableInterviewerSlot>> response = new AppResponse<>(dto);
    	return ResponseEntity.ok().body(response);
    }
/*
	*//**
     * @Route("/api/repeatable-interviewer-slot/{id}", methods={"DELETE"})
     * @param RepeatableInterviewerSlot $repeatableInterviewerSlot
     * @param RepeatableInterviewerSlotService $repeatableInterviewerSlotService
     * @param ResponseErrorDecoratorService $errorDecorator
     * @return JsonResponse
     */
    public ResponseEntity<Object> deleteRepeatableInterviewerSlot(RepeatableInterviewerSlot entity)
    {
    	repeatableInterviewerSlotService.deleteRepeatableInterviewerSlot(entity);
    	return ResponseEntity.noContent().build();

    }
}
