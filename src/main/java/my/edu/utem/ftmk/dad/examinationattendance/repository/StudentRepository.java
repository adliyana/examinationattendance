package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.examinationattendance.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
