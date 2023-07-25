package my.edu.utem.ftmk.dad.examinationattendance.controller;

import java.util.ArrayList;
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

import my.edu.utem.ftmk.dad.examinationattendance.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.examinationattendance.model.Student;
import my.edu.utem.ftmk.dad.examinationattendance.repository.ExaminationAttendanceRepository;

/**
 * This class represents REST Controller for Examination Attendance
 * 
 * @author Adib Adliyana
 *
 */
@RestController
@RequestMapping("/api/examinationattends")
public class ExaminationAttendanceRestController {

	@Autowired
	private ExaminationAttendanceRepository examinationAttendanceRepository;
	
	/**
	 * This method demonstrate a list of Examination Attendance
	 * 
	 * @return
	 */
	@GetMapping
	public List<ExaminationAttendance> getExaminationAttendance(){
		
		return examinationAttendanceRepository.findAll();
	}
	
	/**
	 * This method demonstrate searching examination attendance by 
	 * examinationAttendanceId
	 * 
	 * @param examinationAttendanceId
	 * @return
	 */
	@GetMapping("{examinationAttendanceId}")
	public ExaminationAttendance getExaminationAttendance
	(@PathVariable long examinationAttendanceId){
		
		ExaminationAttendance examinationAttendance = 
				examinationAttendanceRepository.findById
				(examinationAttendanceId).get();
		
		return examinationAttendance;
	}
	
	/**
	 * This method gets report of examination attendance  by examinationId
	 * for student who attend the examination
	 * 
	 * @param examinationId
	 * @return
	 */
	@GetMapping("/report/{examinationId}")
	public List<ExaminationAttendance> findExaminationid
	(@PathVariable Long examinationId)
	{
		return examinationAttendanceRepository.findExaminationId(examinationId);
	}
	
	/**
	 * This method gets report of examination attendance  by examinationId
	 * for student who absent the examination
	 * 
	 * @param examinationId
	 * @return
	 */
	@GetMapping("/report/absent/{examinationId}")
	public List<Student> findStudentAbsent(@PathVariable int examinationId)
	{
		List<Object[]> queryResult = examinationAttendanceRepository.
				findStudentAbsent(examinationId);
		
	    List<Student> studentList = new ArrayList<>();

	    for (Object[] row : queryResult) {
	        String studentName = (String) row[1];
	        String studentMatricNo = (String) row[2];
	        String studentCourse = (String) row[3];
	        Student student = new Student();
	        student.setName(studentName);
	        student.setMatricNumber(studentMatricNo);
	        student.setCourse(studentCourse);
	        studentList.add(student);
	    }
		return studentList;
	}
	/**
	 * This method demonstrate to add Examination Attendance
	 * 
	 * @param examinationAttendance
	 * @return
	 */
	@PostMapping()
	public ExaminationAttendance insertExaminationAttendance
	(@RequestBody ExaminationAttendance examinationattendance) {
		
		return examinationAttendanceRepository.save(examinationattendance);
	}
}
