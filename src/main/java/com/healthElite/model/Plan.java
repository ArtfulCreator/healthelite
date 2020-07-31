package com.healthElite.model;

// Generated Dec 23, 2012 2:49:44 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Plan generated by hbm2java
 */
@Entity
@Table(name = "PLAN")
public class Plan implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PLAN_ID", unique = true, nullable = false)
	private int planId;

	@ManyToOne
	@JoinColumn(name="TRAINEE_INFO_ID")
	private TraineeInfo traineeInfo;
	
	@ManyToOne
	@JoinColumn(name="PLAN_INFO_ID")	
	private PlanInfo planInfo;

	public Plan() {
	}
	
	public Plan(int planId) {
		this.planId = planId;
	}

	public int getPlanId() {
		return planId;
	}


	public void setPlanId(int planId) {
		this.planId = planId;
	}

	
	public TraineeInfo getTraineeInfo() {
		return traineeInfo;
	}


	public void setTraineeInfo(TraineeInfo traineeInfo) {
		this.traineeInfo = traineeInfo;
	}


	public PlanInfo getPlanInfo() {
		return planInfo;
	}


	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}


	@Version
	protected Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}


	
}