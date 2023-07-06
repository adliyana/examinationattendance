package my.edu.utem.ftmk.dad.examinationattendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.edu.utem.ftmk.dad.examinationattendance.model.ExaminationAttendance;

/**
 * This interface represents to Examination Attendance class
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */

public interface ExaminationAttendanceRepository 
	extends JpaRepository<ExaminationAttendance, Long> {
	
	@Query(value = "SELECT * FROM examinationattendance"
			+ " WHERE ExaminationId = :ExaminationId", nativeQuery = true)
	public List<ExaminationAttendance> findExaminationId(@Param("ExaminationId")Long ExaminationId);
	
	@Query(value = "SELECT * FROM student s LEFT JOIN examinationattendance ea "
					+"ON s.StudentId = ea.StudentId AND ea.ExaminationId = :ExaminationId"
					+ " WHERE ea.ExaminationAttendanceId IS NULL", nativeQuery = true)
	public List<Object[]> findStudentAbsent(@Param("ExaminationId")int ExaminationId);


}
