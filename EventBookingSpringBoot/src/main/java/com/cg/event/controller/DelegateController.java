package com.cg.event.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;
import com.cg.event.service.DelegateService;
import com.cg.event.service.DelegateServiceImpl;

/**
 * @author :- barna 
 * Controller class
 * */

@RestController
@RequestMapping("/delegate")
@CrossOrigin(origins="http://localhost:4200")
public class DelegateController 
{

	private static final Logger LOGGER = Logger.getLogger(DelegateController.class);
	@Autowired
	DelegateService delegateservice;

	/**
	 * @author :- barna 
	 * @return :- delegate
	 *@exception : No delegates added
	 * */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Delegate> addDelegate(@ModelAttribute Delegate del, @RequestParam("ename")String ename,@RequestParam("eid")int eid, @RequestParam("date")String date,  @RequestParam("city")String city ) throws DelegateException 	
	{
	
		List<Event> eone=new ArrayList(); 
		Event e=new Event();
		e.setId(eid);
		e.setEventname(ename);
		e.setCity(city);

		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Date dateone=null;
		try {
			dateone = dateFormat.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		e.setDate(dateone);
		if(del.getEvents()!=null)
		
			eone=del.getEvents();
		eone.add(e);
			
		del.setEvents(eone);
		Delegate dele=delegateservice.registerDelegate(del);
		if(dele==null) {
			return new ResponseEntity("Delegate Not Added",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dele,HttpStatus.OK);
	}	
	/**
	 * @author :- barna 
	 * @return :-list of events
	 *@exception : No delegates 
	 * */
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public ResponseEntity<List<Delegate>> showAllDelegate() throws DelegateException
		
	{
		List<Delegate> myList=delegateservice.showDelegates();
		if(myList.isEmpty()) {

			return new ResponseEntity("No Delegate to show",HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<List<Delegate>>(myList,HttpStatus.OK);
	}
	 /**
	 * @author :- barna 
	 * @return :- list of events
	 *@exception : No events added
	 * */
	@RequestMapping(value="/showevents",method=RequestMethod.GET)
	public ResponseEntity<List<Event>> showAllEvents() throws DelegateException	 	 
	{
		List<Event> myList=delegateservice.showEvents();
		if(myList.isEmpty()) {

			return new ResponseEntity("No Event to show",HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<List<Event>>(myList,HttpStatus.OK);
	}
	/**
	 * @author :- barna 
	 * @return :- list of events
	 *@exception : No events added
	 * */
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ResponseEntity <List<Event>> searchEvent(@RequestParam ("eventname")String name ) throws DelegateException
	
	{
		List<Event> myList=delegateservice.eventInfo(name);
		if(myList.isEmpty())
		{

			return new ResponseEntity("No Event to show",HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity <List<Event>>(myList,HttpStatus.OK);
	}	
	
	/**
	 * Last modified on 2019-05-27
	 * @author barna
	 * Exception Handler Method
	 * The following method is used to handle handleDelegateDetailNotFoundException
	 * @param DelegateException
	 * @return ResponseEntity: NOT FOUND
	 */
	@ExceptionHandler(DelegateException.class)
	public ResponseEntity handleDelegateDetailNotFoundException(DelegateException ex) {
		LOGGER.error("Resolved "+DelegateException.class.getName()+" :"+ex.getMessage());
		return new  ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
	} 
}
