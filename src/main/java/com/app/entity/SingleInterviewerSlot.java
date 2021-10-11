package com.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "single_interviewer_slot", uniqueConstraints = {
		@UniqueConstraint(name = "singleslot", columnNames = { "date", "is_blocked_slot" }) })
public class SingleInterviewerSlot implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date date;

	@Column(name = "is_blocked_slot")
	private Boolean isBlockedSlot;

	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "interviewer_id", referencedColumnName = "id")
	private Interviewer interviewer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getIsBlockedSlot() {
		return isBlockedSlot;
	}

	public void setIsBlockedSlot(Boolean isBlockedSlot) {
		this.isBlockedSlot = isBlockedSlot;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

}
