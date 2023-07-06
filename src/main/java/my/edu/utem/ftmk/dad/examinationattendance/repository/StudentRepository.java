package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

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

}
