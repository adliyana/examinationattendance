package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.examinationattendance.model.Examination_attendance;

@Repository
public interface ExaminationAttendanceRepository extends JpaRepository<Examination_attendance, Long> {

}
