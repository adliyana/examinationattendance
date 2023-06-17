package my.edu.utem.ftmk.dad.examinationattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.examinationattendance.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
