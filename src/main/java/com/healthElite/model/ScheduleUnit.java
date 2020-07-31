package com.healthElite.model;

// Generated Dec 23, 2012 2:49:44 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * ScheduleUnit generated by hbm2java
 */
@Entity
@Table(name = "SCHEDULE_UNIT")
public class ScheduleUnit implements java.io.Serializable {

	@ManyToOne
	private ScheduleUnitId id;
	private Date startTime;
	private Date endTime;

	public ScheduleUnit() {
	}

	public ScheduleUnit(ScheduleUnitId id, Date startTime) {
		this.id = id;
		this.startTime = startTime;
	}

	public ScheduleUnit(ScheduleUnitId id, Date startTime, Date endTime) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idScheduleUnit", column = @Column(name = "idSCHEDULE_UNIT", nullable = false)),
			@AttributeOverride(name = "activityActivityId", column = @Column(name = "ACTIVITY_ACTIVITY_ID", nullable = false, length = 45)) })
	public ScheduleUnitId getId() {
		return this.id;
	}

	public void setId(ScheduleUnitId id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_TIME", nullable = false, length = 19)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_TIME", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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