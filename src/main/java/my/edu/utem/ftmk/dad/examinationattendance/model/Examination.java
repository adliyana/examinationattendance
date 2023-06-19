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
@Table(name="examination")
public class Examination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ExaminationId")
	private int ExaminationId;
	
	@Column(name="DateTime")
	private String DateTime;
	
	@ManyToOne
	@JoinColumn(name="SubjectId")
	private Subject SubjectId;
	
	@ManyToOne
	@JoinColumn(name="ChiefInvigilator")
	private Staff StaffId;
	
	public int getExaminationId() {
		return ExaminationId;
	}

	public void setExaminationId(int examinationId) {
		this.ExaminationId = examinationId;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		this.DateTime = dateTime;
	}
    
	public Subject getSubjectId() {
		return SubjectId;
	}
    
	public void setSubjectId(Subject subjectId) {
		this.SubjectId = subjectId;
	}

	public Staff getStaffId() {
		return StaffId;
	}

	public void setStaffId(Staff staffId) {
		this.StaffId = staffId;
	}
}
