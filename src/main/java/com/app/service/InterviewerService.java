package com.app.service;

import java.util.List;

import javax.persistence.EntityManager;

public class InterviewerService {

	private EntityManager em;
	
	public void getInterviewers(List<?> $filter)
    {
        /*if (sizeof($filter)) {

            if (isset($filter['interviewer-ids'])) {
                $ids = explode(",", $filter['interviewer-ids']);
                foreach ($ids as $key => $val) {
                    $ids[$key] = (int)$val;
                }

                $filter['interviewer-ids'] = $ids;
            }
        }
        $interviewers = $this->em
            ->getRepository(Interviewer::class)
            ->findAllFiltered($filter);*/

        return null;
    }
}
