package com.cg.event.dto;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;


/**
 * @author :- barna 
 * event class
 * */

@Entity
@Table(name="event")
public class Event{
	@Id
	@Column(name="event_id")
	private int id;
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="event_name")
	private String eventname;
	@Column(name="event_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="event_city")
	private String city;
	
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="del_id",nullable=false)
	private Delegate delegate;
	*/
	
	public Event() {}

	public Event(int id, String eventname, Date date, String city) {
		super();
		this.id = id;
		this.eventname = eventname;
		this.date = date;
		this.city = city;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getEventname() {
		return eventname;
	}


	public void setEventname(String eventname) {
		this.eventname = eventname;
	}


	@Override
	public String toString() {
		return "Event [id=" + id + ", eventname=" + eventname + ", date=" + date + ", city=" + city + "]";
	}

}
