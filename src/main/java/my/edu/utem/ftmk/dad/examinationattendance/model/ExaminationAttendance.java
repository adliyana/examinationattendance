package my.edu.utem.ftmk.dad.examinationattendance.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

/**
 * This class represents of Examination Attendance
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */

@Entity
@Table(name="examinationattendance")
public class ExaminationAttendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="examinationAttendanceId")
	private int examinationAttendanceId;
	
//	@Column(name="checkInTime")
//	private LocalDateTime checkInTime;
	
	@Column(name="venue")
	private String venue;
	
	@Column(name="deviceType")
	private String deviceType;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="examinationId")
	private Examination examination;
	
	@ManyToOne
	@JoinColumn(name="studentId")
	private Student student;

	public int getExaminationAttendanceId() {
		return examinationAttendanceId;
	}

	public void setExaminationAttendanceId(int examinationAttendanceId) {
		this.examinationAttendanceId = examinationAttendanceId;
	}

//	public LocalDateTime getCheckInTime() {
//		return checkInTime;
//	}
//
//	public void setCheckInTime() {
//		this.checkInTime = checkInTime;
//	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
