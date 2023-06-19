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

import my.edu.utem.ftmk.dad.examinationattendance.model.Examination_attendance;
import my.edu.utem.ftmk.dad.examinationattendance.repository.Examination_attendanceRepository;

@RestController
@RequestMapping("/api/examinationattends")
public class Examination_attendanceRESTController {

	@Autowired
	private Examination_attendanceRepository examination_attendanceRepository;
	
	@GetMapping
	public List<Examination_attendance> getExamination_attendance(){
		
		return examination_attendanceRepository.findAll();
	}
	
	@GetMapping("{ExaminationAttendanceId}")
	public Examination_attendance getExamination_attendance(@PathVariable long ExaminationAttendanceId){
		
		Examination_attendance examination_attendance = examination_attendanceRepository.findById(ExaminationAttendanceId).get();
		
		return examination_attendance;
	}
	
	@PostMapping()
	public Examination_attendance insertExamination_attendance(@RequestBody Examination_attendance examination_attendance) {
		
		return examination_attendanceRepository.save(examination_attendance);
	}
	
	@PutMapping()
	public Examination_attendance updateExamination_attendance(@RequestBody Examination_attendance examination_attendance) {
		
		return examination_attendanceRepository.save(examination_attendance);
	}
	
	@DeleteMapping("{ExaminationAttendanceId}")
	public ResponseEntity<HttpStatus> deleteExamination_attendance(@PathVariable long ExaminationAttendanceId){
		
		examination_attendanceRepository.deleteById(ExaminationAttendanceId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
