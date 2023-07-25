package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.examinationattendance.model.Examination;

/**
 * This interface represents to Examination class
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */
public interface ExaminationRepository 
	extends JpaRepository<Examination, Long> {

}
