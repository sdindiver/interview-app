package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Integer>{
	
}
