package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Event;
import net.javaguides.springboot.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EventController {

	@Autowired
	private EventRepository eventRepository;
	
	// get all employees
	@GetMapping("/events")
	public List<Event> getAllEmployees(){
		return eventRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/events_create")
	public Event createEvent(@RequestBody Event event) {
		return eventRepository.save(event);
	}

	
	
}
