package com.cg.event.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.event.dao.EventRepository;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.cg.event.dao.EventRepository;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
/**
 * @author :- barna 
 * Service interface implementation
 * */
@Service
	public class DelegateServiceImpl implements DelegateService
	{
		private static final Logger LOGGER = Logger.getLogger(DelegateServiceImpl.class);
		Event e =new Event();
		@Autowired
		EventRepository dao;		
		public DelegateServiceImpl() {}
		/**
		 * @author :- barna 
		 *  adds delegate to database
		 * */
		public Delegate registerDelegate(Delegate delegate)  throws DelegateException   
		{			
		
			LOGGER.info("Sending data to repository: "+delegate);
			return dao.save(delegate);
		}
		/**
		 * @author :- barna 
		 *  fetches list of delegates from database
		 * */
		public List<Delegate> showDelegates() throws DelegateException						
		{	
			if(!dao.findAll().isEmpty())
			return dao.findAll();
			LOGGER.warn("no data returned");
			throw new DelegateException("no delegates found");
			
		}
		/**
		 * @author :- barna 
		 *  to search an event by event name from database
		 * */
		@Override
		public List<Event> eventInfo(String event)	throws DelegateException 	
		{
			// TODO Auto-generated method stub
			return dao.findByEvent(event);
		}
		/**
		 * @author :- barna 
		 *  fetches list of events from database
		 * */
		@Override
		public List<Event> showEvents() throws DelegateException
		{
			if(!dao.findAllEvent().isEmpty())
			return dao.findAllEvent();
			LOGGER.warn("no data returned");
			throw new DelegateException("no events found");
		}	
			
	}
	