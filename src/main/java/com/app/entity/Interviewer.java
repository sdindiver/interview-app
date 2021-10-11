package com.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "interviewer")
public class Interviewer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", unique = true)
	private String name;

	@OneToMany(targetEntity = RepeatableInterviewerSlot.class, mappedBy = "interviewer")
	private List<RepeatableInterviewerSlot> repeatableInterviewerSlots;
	@OneToMany(targetEntity = RepeatableInterviewerSlot.class, mappedBy = "interviewer")
	private List<SingleInterviewerSlot> singleInterviewerSlots;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RepeatableInterviewerSlot> getRepeatableInterviewerSlots() {
		return repeatableInterviewerSlots;
	}

	public void setRepeatableInterviewerSlots(List<RepeatableInterviewerSlot> repeatableInterviewerSlots) {
		this.repeatableInterviewerSlots = repeatableInterviewerSlots;
	}

	public List<SingleInterviewerSlot> getSingleInterviewerSlots() {
		return singleInterviewerSlots;
	}

	public void setSingleInterviewerSlots(List<SingleInterviewerSlot> singleInterviewerSlots) {
		this.singleInterviewerSlots = singleInterviewerSlots;
	}

}
