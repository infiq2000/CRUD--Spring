package springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Course;
import springdemo.entity.Student;
import springdemo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/showStudent")
	public String showStudent(Model theModel) {
		List<Student> student = studentService.getStudents();
		theModel.addAttribute("students", student);
		return "list-student";
	}
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		Student theStudent =  new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	@RequestMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult) {
		System.out.println("Last name: |" + theStudent.getLastName() + "|");
		if (theBindingResult.hasErrors()) {
			return "student-form";
		}
		else {
			studentService.saveStudent(theStudent);
			return "redirect:/student/showStudent";
		}

	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		Student theStudent = studentService.getStudent(theId);
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int theId, Model theModel) {
		studentService.deleteStudent(theId);
		return "redirect:/student/showStudent";
	}
    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        List<Student> theStudent = studentService.searchCustomers(theSearchName);

        theModel.addAttribute("students", theStudent);
        return "list-student";        
    }
    
    @RequestMapping("/getListCourse")
    public String getCourses(@RequestParam("studentId") int theId, Model theModel) {
    	List<Course> coursesStu = studentService.getCourses(theId);
    	theModel.addAttribute("courses", coursesStu );
    	return "list-course-student";
    }
    
}
