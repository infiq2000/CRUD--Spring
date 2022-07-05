package springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;



@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="student_id")
			)
	private List<Student> student;
	
	public Course() {
		
	}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	// add convenince method

	
	public void addStudent(Student theStudent) {
		if (student == null) {
			student = new ArrayList<>();
		}
		student.add(theStudent);
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
}
