package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.edu.utem.ftmk.dad.examinationattendance.model.Student;

/**
 * This interface represents to Student class
 * 
 * @author Adib Adliyana
 * @author Rose Asnarizza
 * @author Syafiqah
 *
 */


public interface StudentRepository extends JpaRepository<Student, Long> {

	// To retrieve all value from student by matric number
	@Query(value= "select * from student where MatricNumber = :matricNo",
			nativeQuery = true)
	public Student getStudentByMatricNo(@Param("matricNo") String matricNo);
}
