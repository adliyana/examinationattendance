package my.edu.utem.ftmk.dad.examinationattendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StudentId")
	private int StudentId;
	
	@Column(name="StudentName")
	private String StudentName;
	
	@Column(name="Course")
	private String Course;
	
	@Column(name="Session")
	private String Session;
	
	@Column(name="PhoneNumber")
	private int PhoneNumber;
	
	@Column(name="Email")
	private String Email;
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		this.StudentId = studentId;
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
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	
	
	
}
