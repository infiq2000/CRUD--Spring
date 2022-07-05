package springdemo.dao;

import java.util.List;

import springdemo.entity.Course;
import springdemo.entity.Student;

public interface StudentDao {
	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);

	public List<Student> seachCustomers(String theSearchName);

	public List<Course> getCourses(int theId);


}
