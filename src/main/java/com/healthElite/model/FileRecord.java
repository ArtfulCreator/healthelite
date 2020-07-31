package com.healthElite.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "FILE_RECORD")
public class FileRecord {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FILE_RECORD_ID", unique = true, nullable = false)
	private int id;
	@Column(name = "NAME", length = 45)
	private String name;
	@Column(name= "DATA")
	@Lob
	private byte [] data;
	
	@OneToOne(mappedBy="fileRecord")
	private PlanInfo planInfo;
	
	public PlanInfo getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public FileRecord(int id) {
		this.id = id;
	}

	public FileRecord(int id,String name) {
		super();
		this.id = id;
		this.name = name; 

	}
	public FileRecord() {

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
