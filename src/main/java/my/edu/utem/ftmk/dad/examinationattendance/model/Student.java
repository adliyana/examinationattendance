package my.edu.utem.ftmk.dad.examinationattendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StudentId")
	private int StudentId;
	
	@Column(name="MatricNumber")
	private String MatricNumber;
	
	@Column(name="StudentName")
	private String StudentName;
	
	@Column(name="Course")
	private String Course;
	
	@Column(name="Session")
	private String Session;
	
	@Column(name="PhoneNumber")
	private String PhoneNumber;
	
	@Column(name="Email")
	private String Email;
	
	@ManyToOne
	@JoinColumn(name="AcademicAdvisor")
	private Staff StaffId;
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		this.StudentId = studentId;
	}
	public String getMatricNumber() {
		return MatricNumber;
	}
	public void setMatricNumber(String matricNumber) {
		MatricNumber = matricNumber;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		this.StudentName = studentName;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		this.Course = course;
	}
	public String getSession() {
		return Session;
	}
	public void setSession(String session) {
		this.Session = session;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public Staff getStaffId() {
		return StaffId;
	}
	public void setStaffId(Staff staffId) {
		this.StaffId = staffId;
	}
	
	
	
}
