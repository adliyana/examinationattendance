package my.edu.utem.ftmk.dad.examinationattendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.examinationattendance.model.Student;
import my.edu.utem.ftmk.dad.examinationattendance.repository.StudentRepository;

/**
 * This class represents REST Controller for Student
 * 
 * @author Adib Adliyana
 *
 */

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * This method demonstrate list of Student
	 * 
	 * @return
	 */
	@GetMapping
	public List<Student> getStudent(){
		
		return studentRepository.findAll();
	}
	
	/**
	 * This method demonstrate searching Student by studentId
	 * 
	 * @param studentId
	 * @return
	 */
	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable long studentId){
		
		Student student = studentRepository.findById(studentId).get();
		
		return student;
	}
	
	/**
	 * This method demonstrate to get Student Matric Number
	 * 
	 * @param matricNo
	 * @return
	 */
	@GetMapping("/matric/{matricNo}")
	public Student getStudentByMatricNo(@PathVariable String matricNo){

		System.out.println("test lagi");
		return studentRepository.getStudentByMatricNo(matricNo);
	}
}
