package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.examinationattendance.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
