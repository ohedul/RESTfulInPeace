package rokomari.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rokomari.project.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	Patient findOne(Long ptntid);

}
