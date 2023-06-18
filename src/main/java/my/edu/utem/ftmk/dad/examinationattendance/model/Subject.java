package my.edu.utem.ftmk.dad.examinationattendance.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SubjectId")
	private int SubjectId;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="TeachingLecturer")
	private String TeachingLecturer;
	
//	@ManyToOne
//	@JoinColumn(name="StudentId")
//	private Student StudentId;

	public int getSubjectId() {
		return SubjectId;
	}

	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}



	public String getTeachingLecturer() {
		return TeachingLecturer;
	}

	public void setTeachingLecturer(String teachingLecturer) {
		TeachingLecturer = teachingLecturer;
	}

//	public Student getStudentId() {
//		return StudentId;
//	}
//
//	public void setStudentId(Student studentId) {
//		StudentId = studentId;
//	}
	
	
	
	
}
