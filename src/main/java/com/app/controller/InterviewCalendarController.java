package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CandidateSlot;
import com.app.request.SingleInterviewerSlotRequest;
import com.app.service.InterviewerService;

@RestController
public class InterviewCalendarController {
	
	private InterviewerService interviewerService;
	
	/**
     * Get a collection of slots when it's possible to arrange an interview for given candidate
     *  and optionally interviewers ids
     *
     * Here is usage example:
     *
     * url: http://localhost:8000/api/interview-calendar/1?interviewer-ids=1,2
     *   (where
     *   - interviewer-ids is a coma separated list of interviewer ids
     *    * interviewer-ids filter is optional (you can skip this parameter)
     *   )
     *
     * @Route("/api/interview-calendar/{id}", methods={"GET"})
     * @param Candidate $candidate
     * @param Request $request
     * @param InterviewerService $interviewerService
     * @param ResponseErrorDecoratorService $errorDecorator
     * @return JsonResponse Data containing collection of available interview periods
     */
	@RequestMapping("/api/single-interviewer-slots")
    public ResponseEntity<String> getInterviewCalendar(SingleInterviewerSlotRequest request)
    {
        $candidateSlots = $candidate->getCandidateSlots();

        $filter = $request->query->all();
        $interviewers = $interviewerService->getInterviewers($filter);

        $intersections = [];
        foreach ($candidateSlots as $candidateSlot) {
            foreach ($interviewers as $interviewer) {
                $repeatableInterviewerSlots = $interviewer->getRepeatableInterviewerSlots();
                $singleInterviewerSlots = $interviewer->getSingleInterviewerSlots();

                $hasIntersection = $this->hasIntersections(
                    $candidateSlot, $repeatableInterviewerSlots, $singleInterviewerSlots
                );

                if ($hasIntersection)
                {
                    $intersections[] = [
                        'candidate' => [
                            'id' => $candidate->getId(),
                            'name' => $candidate->getName()
                        ],
                        'interviewer' => [
                            'id' => $interviewer->getId(),
                            'name' => $interviewer->getName()
                        ],
                        'weekday' => $candidateSlot->getDate()->format('N'),
                        'start_time' => $candidateSlot->getDate()->format('h:i A'),
                        'date' => $candidateSlot->getDate()->format('Y-m-d h:i A')
                    ];
                }
            }
        }

        $status = JsonResponse::HTTP_OK;
        $data = [
            'data' => [
                'intersections' => $intersections
            ]
        ];

        return new JsonResponse($data, $status);
    }

    /**
     * Check if there are intersections between given candidate slot and single/repeatable interviewer slots
     *
     * @param CandidateSlot $candidateSlot
     * @param $repeatableInterviewerSlots
     * @param $singleInterviewerSlots
     * @return bool True if candidate slot intersects with one of interviewer's slots (single or repeatable)
     */
    private function hasIntersections(
        CandidateSlot $candidateSlot,
        $repeatableInterviewerSlots,
        $singleInterviewerSlots
    ): bool
    {
        $format = "Y-m-d H:i";

        $candidateDate = $candidateSlot->getDate();
        $dayOfWeek = $candidateDate->format('N');
        $hour = $candidateDate->format('G');

        // check candidate-slot against single-interviewer-slots

        $gotIntersection = false;
        foreach ($singleInterviewerSlots as $singleInterviewerSlot) {
            $sisDate = $singleInterviewerSlot->getDate()->format($format);
            $isBlockedSlot = $singleInterviewerSlot->getIsBlockedSlot();
            if ($isBlockedSlot) {
                // check if interviewer has blocked current candidate-slot date
                if ($sisDate == $candidateDate->format($format)) {
                    return false;
                }
            } else {
                // is there a matching single-slot date?
                if ($sisDate == $candidateDate->format($format)) {
                    $gotIntersection = true; // (cannot break, have to make sure there are no blocked-slots)
                }
            }
        }

        if ($gotIntersection) {
            return true;
        }

        // check candidate-slot against repeatable-interviewer-slots

        foreach ($repeatableInterviewerSlots as $repeatableInterviewerSlot) {
            $risWeekday = $repeatableInterviewerSlot->getWeekday();
            $risHour = $repeatableInterviewerSlot->getHour();

            if ($risWeekday == $dayOfWeek && $risHour == $hour) {
                return true;
            }
        }

        return false;
    }
}
