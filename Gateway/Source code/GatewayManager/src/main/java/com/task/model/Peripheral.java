package com.task.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="PERIPHERAL", schema = "public")
@Entity
public class Peripheral {
	
	@Id
	@Column(name="uid")
	int uid;
	
	@Column(name="vendor")
	String vendor;
	
	//Ref: http://www.h2database.com/html/datatypes.html#timestamp_type
	@Column(name="date_created")
	LocalDateTime date_created;
	
	//Ref: https://stackoverflow.com/questions/25104692/java-lang-illegalargumentexception-can-not-set-java-lang-short-field-to-java-la
	@ManyToOne(targetEntity = Gateway.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "gid")
	Gateway gateway;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public LocalDateTime getDate_created() {
		return date_created;
	}

	public void setDate_created(LocalDateTime date_created) {
		this.date_created = date_created;
	}

	public Gateway getGateway() {
		return gateway;
	}

	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}
	
	

	

}
