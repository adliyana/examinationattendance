package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

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

}
