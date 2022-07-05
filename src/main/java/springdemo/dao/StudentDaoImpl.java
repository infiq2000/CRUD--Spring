package springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Course;
import springdemo.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		Session session = sessionFactory.openSession();
		Query<Student> student = session.createQuery("from Student order by lastName", Student.class);
		List<Student> students = student.getResultList();
		return students;
	}

	@Override
	public void saveStudent(Student theStudent) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(theStudent);
	}

	@Override
	public Student getStudent(int theId) {
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, theId);
		return student;
	}

	@Override
	public void deleteStudent(int theId) {
		System.out.println("vào delete");
		System.out.println("theID: " + theId);
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, theId);
		session.remove(student);
	}

	@Override
	public List<Student> seachCustomers(String theSearchName) {
		Session currentSession = sessionFactory.openSession();
        Query theQuery = null;
        
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            theQuery =currentSession.createQuery("from Student where lower(firstName) like :theName or lower(lastName) like :theName", Student.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }
        else {
            theQuery =currentSession.createQuery("from Student", Student.class);            
        }
        List<Student> student = theQuery.getResultList();      
        return student;
	}

	@Override
	public List<Course> getCourses(int theId) {
		Session session =  sessionFactory.getCurrentSession();
		Student tempStudent = session.get(Student.class, theId);
		System.out.println("student:" + tempStudent);
		System.out.println("courses: " +tempStudent.getCourses());
		return tempStudent.getCourses();
	}


}
