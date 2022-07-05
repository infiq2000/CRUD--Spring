package springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdemo.dao.StudentDao;
import springdemo.entity.Course;
import springdemo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentDao.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentDao.saveStudent(theStudent);
	}

	@Override
	@Transactional
	public Student getStudent(int theId) {
		return studentDao.getStudent(theId);
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
		studentDao.deleteStudent(theId);
	}

	@Override
	@Transactional
	public List<Student> searchCustomers(String theSearchName) {
		// TODO Auto-generated method stub
		return studentDao.seachCustomers(theSearchName);
	}

	@Override
	@Transactional
	public List<Course> getCourses(int theId) {
		
		return studentDao.getCourses(theId);
	}

}
