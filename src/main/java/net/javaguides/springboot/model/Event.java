package net.javaguides.springboot.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "organiser_name")
	private String organiserName;

	@Column(name = "invites")
	@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
	ArrayList<Employee> employeeArrayList;

	public Event() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getOrganiserName() {
		return organiserName;
	}

	public void setOrganiserName(String organiserName) {
		this.organiserName = organiserName;
	}

	public ArrayList<Employee> getEmployeeArrayList() {
		return employeeArrayList;
	}

}
