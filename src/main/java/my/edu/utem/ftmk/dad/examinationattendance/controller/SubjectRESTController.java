/*package my.edu.utem.ftmk.dad.examinationattendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.examinationattendance.model.Subject;
import my.edu.utem.ftmk.dad.examinationattendance.repository.SubjectRepository;

@RestController
@RequestMapping("{/api/subjects}")
public class SubjectRESTController {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping
	public List<Subject> getSubject(){
		return subjectRepository.findAll();
	}
}*/
