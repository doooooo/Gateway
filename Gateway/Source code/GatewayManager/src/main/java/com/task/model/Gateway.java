package com.task.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="GATEWAY", schema = "public")
@Entity
public class Gateway {
	
	@Id
	@Column(name="serial")
	String serial;
	
	@Column(name="name")
	String name;
	
	@Column(name="ipv4")
	String ipv4;
	
	//https://www.baeldung.com/hibernate-one-to-many
	@OneToMany(mappedBy="gateway",fetch = FetchType.LAZY)
    private Set<Peripheral> peripherals;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public Set<Peripheral> getPeripherals() {
		return peripherals;
	}

	public void setPeripherals(Set<Peripheral> peripherals) {
		this.peripherals = peripherals;
	}
	
	

}
