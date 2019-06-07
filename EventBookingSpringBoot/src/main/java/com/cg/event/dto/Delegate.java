package com.cg.event.dto;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author :- barna 
 * delegate class
 * */


@Entity
@Table(name="delegate")
public class Delegate
{

	@Id
	@Column(name="delegate_id")
	private int id;
	@Column(name="delegate_name")
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="del_id")
	private Address address;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="del_id")
	private List<Event> events;
	public Delegate() {	
	}		

	public Delegate(int id, String name, Address address, List<Event> events) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.events = events;
	}


	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Delegate [id=" + id + ", name=" + name + ", address=" + address + ", events=" + events + "]";
	}

					
}
