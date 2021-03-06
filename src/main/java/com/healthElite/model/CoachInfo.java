package com.healthElite.model;

// Generated Dec 23, 2012 2:49:44 PM by Hibernate Tools 4.0.0

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * CoachInfo generated by hbm2java
 */
@Entity
@Table(name = "COACH_INFO")
public class CoachInfo implements java.io.Serializable {

	@GeneratedValue
	@Id
	@Column(name = "COACH_INFO_ID", unique = true, nullable = false)
	private int coachInfoId;
	@Column(name = "SPECIALITY", length = 45)
	private String speciality;
	@Column(name = "DESCRIPTION", length = 200)
	private String description;
	
	@OneToOne(mappedBy="coachInfo")
	private Roles roles;
	

	@OneToMany(fetch = FetchType.EAGER,mappedBy="coachInfo",cascade=CascadeType.ALL, orphanRemoval=true) 
	private Set <PlanInfo> planInfos;
	
	public Set<PlanInfo> getPlanInfos() {
		return planInfos;
	}

	public void setPlanInfos(Set<PlanInfo> planInfos) {
		this.planInfos = planInfos;
	}

	/**
	//TODO: At some point you may need to change this from EAGER to using a query like FROM CoachInfo coachInfo JOIN FETCH coachInfo.trainees
		**/
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="coachInfo", cascade=CascadeType.ALL)
	private Set <CoachTraineeAssociation> coachTraineeAssociations;

	public Set<CoachTraineeAssociation> getCoachTraineeAssociations() {
		return coachTraineeAssociations;
	}

	public void setCoachTraineeAssociations(
			Set<CoachTraineeAssociation> coachTraineeAssociations) {
		this.coachTraineeAssociations = coachTraineeAssociations;
	}


	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	

	public CoachInfo() {
	}

	public CoachInfo(int coachInfoId) {
		this.coachInfoId = coachInfoId;
	}

	public CoachInfo(int coachInfoId, String speciality) {
		this.coachInfoId = coachInfoId;
		this.speciality = speciality;
	}


	public int getCoachInfoId() {
		return this.coachInfoId;
	}

	public void setCoachInfoId(int coachInfoId) {
		this.coachInfoId = coachInfoId;
	}


	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isTrainee(TraineeInfo traineeInfo){
		for(CoachTraineeAssociation cta: coachTraineeAssociations) {
			if(cta.getTraineeInfo().getTraineeInfoId() == traineeInfo.getTraineeInfoId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isTraineeActive(TraineeInfo traineeInfo){
		for(CoachTraineeAssociation cta: coachTraineeAssociations) {
			if(cta.getTraineeInfo().getTraineeInfoId() == traineeInfo.getTraineeInfoId()) {
				if(cta.isActive()) {
					return true;
				}
			}
		}
		return false;
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
