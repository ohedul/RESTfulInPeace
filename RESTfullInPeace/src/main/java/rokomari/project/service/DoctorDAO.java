package rokomari.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rokomari.project.model.Doctor;
import rokomari.project.repository.DoctorRepository;

@Service
public class DoctorDAO {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	public Doctor save(Doctor doc) {
		return doctorRepository.save(doc);
	}
	
	public List<Doctor> getAllDoc(){
		return doctorRepository.findAll();
	}
	
	public Doctor findOne(Long docid) {
		return doctorRepository.findOne(docid);
	}
	
	public void delete(Doctor doc) {
		doctorRepository.delete(doc);
	}

}
