package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.RepeatableInterviewerSlot;

public interface RepeatableInterviewerSlotRepository extends JpaRepository<RepeatableInterviewerSlot, Integer>{
	
}
