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

@RestController
@RequestMapping("/api/students")
public class StudentRESTController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> getStudent(){
		
		return studentRepository.findAll();
	}
	
	@GetMapping("{StudentId}")
	public Student getStudent(@PathVariable long StudentId){
		
		Student student = studentRepository.findById(StudentId).get();
		
		return student;
	}
	
	@PostMapping()
	public Student insertStudent(@RequestBody Student student) {
		
		return studentRepository.save(student);
	}
	
	@PutMapping()
	public Student updateStudent(@RequestBody Student student) {
		
		return studentRepository.save(student);
	}
	
	@DeleteMapping("{StudentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long StudentId){
		
		studentRepository.deleteById(StudentId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
