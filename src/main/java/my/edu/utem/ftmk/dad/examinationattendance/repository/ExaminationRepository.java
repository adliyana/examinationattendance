package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.examinationattendance.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}