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

import my.edu.utem.ftmk.dad.examinationattendance.model.ExaminationAttendance;
import my.edu.utem.ftmk.dad.examinationattendance.repository.ExaminationAttendanceRepository;

/**
 * This class represents REST Controller for Examination Attendance
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */
@RestController
@RequestMapping("/api/examinationattends")
public class ExaminationAttendanceRestController {

	@Autowired
	private ExaminationAttendanceRepository examinationAttendanceRepository;
	
	/**
	 * 
	 */
	@GetMapping
	public List<ExaminationAttendance> getExaminationAttendance(){
		
		return examinationAttendanceRepository.findAll();
	}
	
	@GetMapping("{examinationAttendanceId}")
	public ExaminationAttendance getExaminationAttendance
	(@PathVariable long examinationAttendanceId){
		
		ExaminationAttendance examinationAttendance = 
				examinationAttendanceRepository.findById
				(examinationAttendanceId).get();
		
		return examinationAttendance;
	}
	
	@PostMapping()
	public ExaminationAttendance insertExaminationAttendance
	(@RequestBody ExaminationAttendance examinationattendance) {
		
		return examinationAttendanceRepository.save(examinationattendance);
	}
	
	@PutMapping()
	public ExaminationAttendance updateExaminationAttendance
	(@RequestBody ExaminationAttendance examinationAttendance) {
		
		return examinationAttendanceRepository.save(examinationAttendance);
	}
	
	@DeleteMapping("{examinationAttendanceId}")
	public ResponseEntity<HttpStatus> deleteExaminationAttendance
	(@PathVariable long examinationAttendanceId){
		
		examinationAttendanceRepository.deleteById(examinationAttendanceId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
