package com.param.dto;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Employee {

	private @Id @GeneratedValue Long id;

	// @NotBlank(message = "Name is mandatory") // Add validation using validation
	// API
	private String name;
	// @JsonIgnore // it will filter this field in response
	private Integer age;
	
	private  @OneToMany(mappedBy = "employee", fetch=FetchType.LAZY) @Cascade(CascadeType.PERSIST) List<Address> addressList;

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	Employee() {
	}

	public Employee(String name,Integer age, List<Address> addressList) {

		this.name = name;
		this.age = age;
		this.addressList=addressList;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Employee))
			return false;
		Employee employee = (Employee) o;
		return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
	}
}