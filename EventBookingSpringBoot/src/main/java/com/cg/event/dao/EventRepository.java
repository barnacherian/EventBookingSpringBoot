package com.cg.event.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
/**
 * @author :- barna 
 * Repository extending JpaRepository
 * */

public interface EventRepository extends JpaRepository<Delegate, Integer>
{
	@Query("select e from Event e where e.eventname =:eventname")
	List<Event> findByEvent(String eventname);	
	
	@Query("From Event")
	List<Event> findAllEvent();	
	
}
