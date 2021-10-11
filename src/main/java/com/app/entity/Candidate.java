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
@Table(name = "candidate")
public class Candidate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", unique = true)
	private String name;

	@OneToMany(targetEntity = CandidateSlot.class, mappedBy = "candidate")
	private List<CandidateSlot> candidateSlots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CandidateSlot> getCandidateSlots() {
		return candidateSlots;
	}

	public void setCandidateSlots(List<CandidateSlot> candidateSlots) {
		this.candidateSlots = candidateSlots;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
