package rokomari.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rokomari.project.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	Doctor findOne(Long docid);

}
