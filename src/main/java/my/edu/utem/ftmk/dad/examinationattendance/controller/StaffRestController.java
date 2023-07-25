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
import my.edu.utem.ftmk.dad.examinationattendance.model.Staff;
import my.edu.utem.ftmk.dad.examinationattendance.repository.StaffRepository;

/**
 * This class represents REST Controller for Staff
 * 
 * @author Adib Adliyana
 *
 */

@RestController
@RequestMapping("/api/staffs")
public class StaffRestController {

	@Autowired
	private StaffRepository staffRepository;
	
	/**
	 * This method demonstrate a list of Staff
	 * 
	 * @return
	 */
	@GetMapping
	public List<Staff> getStaff(){
		
		return staffRepository.findAll();
	}
	
	/**
	 * This method demonstrate searching staff by staffId
	 * 
	 * @param staffId
	 * @return
	 */
	@GetMapping("{staffId}")
	public Staff getStaff(@PathVariable long staffId){
		
		Staff staff = staffRepository.findById(staffId).get();
		
		return staff;
	}
	
	/**
	 * This method demonstrate to add Staff
	 * 
	 * @param staff
	 * @return
	 */
	@PostMapping()
	public Staff insertStaff(@RequestBody Staff staff) {
		
		return staffRepository.save(staff);
	}
	
	/**
	 * This method demonstrate an update of Staff
	 * 
	 * @param staff
	 * @return
	 */
	@PutMapping()
	public Staff updateStaff(@RequestBody Staff staff) {
		return staffRepository.save(staff);
	}
}
