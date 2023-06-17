package my.edu.utem.ftmk.dad.examinationattendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StaffId")
	private int StaffId;
	
	@Column(name="StaffName")
	private String StaffName;
	
	@Column(name="PhoneNumber")
	private int PhoneNumber;
	
	@Column(name="Email")
	private String Email;

	public int getStaffId() {
		return StaffId;
	}

	public void setStaffId(int staffId) {
		StaffId = staffId;
	}

	public String getStaffName() {
		return StaffName;
	}

	public void setStaffName(String staffName) {
		StaffName = staffName;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	
	
}
