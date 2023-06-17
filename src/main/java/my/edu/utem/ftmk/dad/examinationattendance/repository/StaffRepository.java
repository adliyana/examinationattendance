package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.examinationattendance.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
