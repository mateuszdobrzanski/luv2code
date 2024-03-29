package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//annotate the class as an entity and map to db table (using javax libs)
@Entity
@Table(name="instructor")
public class Instructor {
	
	// define the fields
	// annotate the fields with db column names
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	// ** set up mapping to InstructorDetail entity
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instrutctorDetail;
	
	@OneToMany(mappedBy="instructor", // <- annotation to course class
			   cascade= {CascadeType.DETACH,
					   	 CascadeType.MERGE,
					   	 CascadeType.PERSIST,
					   	 CascadeType.REFRESH
						}) 
	private List<Course> courses;
	
	// create constructors
	
	public Instructor() {}

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// generate getters/setters methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstrutctorDetail() {
		return instrutctorDetail;
	}

	public void setInstrudtorDetail(InstructorDetail instrutctorDetail) {
		this.instrutctorDetail = instrutctorDetail;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	// add convenience methods for bi-directional relationship
	public void add(Course tempCourse) {
		if (courses == null ) {
			courses = new ArrayList<>();
		}
		
		courses.add(tempCourse);
		
		tempCourse.setInstructor(this);
	}

	// generate toString() method 
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instrudtorDetail=" + instrutctorDetail + "]";
	}
	 
}
