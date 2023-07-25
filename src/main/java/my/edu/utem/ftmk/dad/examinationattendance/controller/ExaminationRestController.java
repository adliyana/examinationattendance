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
 *
 */

@RestController
@RequestMapping("/api/examinations")
public class ExaminationRestController {

	@Autowired
	private ExaminationRepository examinationRepository;
	
	/**
	 * This method demonstrate a list of Examination
	 * 
	 * @return
	 */
	@GetMapping
	public List<Examination> getExamination(){
		
		return examinationRepository.findAll();
	}
	
	/**
	 * This method demonstrate searching examination by examinationId
	 * 
	 * @param examinationId
	 * @return
	 */
	@GetMapping("{examinationId}")
	public Examination getExamination(@PathVariable long examinationId){
		
		Examination examination = examinationRepository.
				findById(examinationId).get();
		
		return examination;
	}
}
