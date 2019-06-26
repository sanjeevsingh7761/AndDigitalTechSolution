package com.anddigital.springboot.model;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private String id;
	private String name;
	
	@OneToMany
	private List <Phone> phones;
	
	public Customer(String id, String name, List<Phone> phones) {
		super();
		this.id = id;
		this.name = name;
		this.phones = phones;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phones=" + phones + "]";
	}
	
}