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

import my.edu.utem.ftmk.dad.examinationattendance.model.Examination;
import my.edu.utem.ftmk.dad.examinationattendance.repository.ExaminationRepository;

/**
 * This class represents REST Controller for Examination
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */

@RestController
@RequestMapping("/api/examinations")
public class ExaminationRestController {

	@Autowired
	private ExaminationRepository examinationRepository;
	
	@GetMapping
	public List<Examination> getExamination(){
		
		return examinationRepository.findAll();
	}
	
	// examinationId
	@GetMapping("{examinationId}")
	public Examination getExamination(@PathVariable long examinationId){
		
		Examination examination = examinationRepository.findById(examinationId)
				.get();
		
		return examination;
	}
	
	@PostMapping()
	public Examination insertExamination(@RequestBody Examination examination) {
		
		return examinationRepository.save(examination);
	}
	
	@PutMapping()
	public Examination updateExamination(@RequestBody Examination examination) {
		
		return examinationRepository.save(examination);
	}
	
	@DeleteMapping("{examinationId}")
	public ResponseEntity<HttpStatus> deleteExamination(@PathVariable long 
			examinationId){
		
		examinationRepository.deleteById(examinationId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
