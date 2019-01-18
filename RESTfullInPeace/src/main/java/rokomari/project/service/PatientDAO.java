package rokomari.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rokomari.project.model.Patient;
import rokomari.project.repository.PatientRepository;

@Service
public class PatientDAO {
	
	@Autowired
	PatientRepository patientRepository;
	
	public Patient save(Patient ptnt) {
		return patientRepository.save(ptnt);
	}
	
	public List<Patient> findAll(){
		return patientRepository.findAll();
	}
	
	public Patient findOne(Long ptntid) {
		return patientRepository.findOne(ptntid);
	}
	
	public void delete(Patient pnt) {
		patientRepository.delete(pnt);
	}
	
	

}
