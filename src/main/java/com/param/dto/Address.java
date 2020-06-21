package com.param.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {

	private @Id @GeneratedValue Long id;
	private String address;
	private @ManyToOne(fetch = FetchType.LAZY) 
	//@JoinColumn(name="employee_id", referencedColumnName = "id", nullable = true) //ToDo: add Employee along with address at one shot
	@JsonIgnore 
	Employee employee;
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", Address=" + address + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String homeAddress) {
		this.address = homeAddress;
	}

}
