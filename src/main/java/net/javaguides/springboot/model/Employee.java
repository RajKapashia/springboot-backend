package net.javaguides.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	@Size(min=2,max=15,message = "Name minimum length is 2 and max length 15 your length")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	@Email(message="Not valid email")
	private String emailId;

	@Column(name= "house_no")
	private  String house_no;

	@ManyToOne(cascade=CascadeType.ALL)
	private Employee employee;
	
	public Employee() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
}
