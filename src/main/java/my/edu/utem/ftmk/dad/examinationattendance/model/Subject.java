package my.edu.utem.ftmk.dad.examinationattendance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SubjectId")
	private int SubjectId;
	
	@Column(name="SubjectCode")
	private String SubjectCode;
	
	@Column(name="SubjectName")
	private String SubjectName;

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		this.SubjectId = subjectId;
	}

	public String getSubjectCode() {
		return SubjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.SubjectCode = subjectCode;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		this.SubjectName = subjectName;
	}
	//try test
}
