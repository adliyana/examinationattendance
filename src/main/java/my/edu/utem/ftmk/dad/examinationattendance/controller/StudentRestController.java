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
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */
@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> getStudent(){
		
		return studentRepository.findAll();
	}
	
	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable long studentId){
		
		Student student = studentRepository.findById(studentId).get();
		
		return student;
	}
	
	@GetMapping("/matric/{matricNo}")
	public Student getStudentByMatricNo(@PathVariable String matricNo){

		System.out.println("test lagi");
		return studentRepository.getStudentByMatricNo(matricNo);
	}
	
	@PostMapping()
	public Student insertStudent(@RequestBody Student student) {
		
		return studentRepository.save(student);
	}
	
	@PutMapping()
	public Student updateStudent(@RequestBody Student student) {
		
		return studentRepository.save(student);
	}
	
	@DeleteMapping("{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent
	(@PathVariable long studentId){
		
		studentRepository.deleteById(studentId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
