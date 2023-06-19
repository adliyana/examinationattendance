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
@Table(name="examination_attendance")
public class Examination_attendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ExaminationAttendanceId")
	private int ExaminationAttendanceId;
	
	@Column(name="CheckInTime")
	private String CheckInTime;
	
	@Column(name="Venue")
	private String Venue;
	
	@Column(name="DeviceType")
	private String DeviceType;
	
	@Column(name="Status")
	private String Status;
	
	@ManyToOne
	@JoinColumn(name="ExaminationId")
	private Examination ExaminationId;
	
	@ManyToOne
	@JoinColumn(name="StudentId")
	private Student StudentId;
	
	public int getExaminationAttendanceId() {
		return ExaminationAttendanceId;
	}

	public void setExaminationAttendanceId(int examinationAttendanceId) {
		this.ExaminationAttendanceId = examinationAttendanceId;
	}

	public String getCheckInTime() {
		return CheckInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.CheckInTime = checkInTime;
	}

	public String getVenue() {
		return Venue;
	}

	public void setVenue(String venue) {
		this.Venue = venue;
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		this.DeviceType = deviceType;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}
	
	public Examination getExaminationId() {
		return ExaminationId;
	}

	public void setExaminationId(Examination examinationId) {
		this.ExaminationId = examinationId;
	}

	public Student getStudentId() {
		return StudentId;
	}

	public void setStudentId(Student studentId) {
		this.StudentId = studentId;
	}

}
