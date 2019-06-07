package com.cg.event.service;
import java.util.List;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;

import java.util.List;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
/**
 * @author :- barna 
 * Service interface 
 * */
public interface DelegateService{
	Delegate registerDelegate (Delegate delegate) throws DelegateException ;
	List<Event>showEvents() throws DelegateException;	
	List<Delegate> showDelegates() throws DelegateException;
	List<Event> eventInfo(String event) throws DelegateException;

	
}
