package rokomari.project.model.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rokomari.project.model.Doctor;
import rokomari.project.model.Patient;
import rokomari.project.service.DoctorDAO;
import rokomari.project.service.PatientDAO;

@RestController
@RequestMapping("/api")
public class APIcontroller {
	
	@Autowired
	PatientDAO patientDao;
	
	@Autowired
	DoctorDAO doctorDao;
	
	@PostMapping("/insert/doctor/new")
	public Doctor insertDoctor(@Valid @RequestBody Doctor doctor) {
		return doctorDao.save(doctor);
	}
	
	@PostMapping("/insert/patient/new")
	public Patient insertPatient(@Valid @RequestBody Patient patient) {
		return patientDao.save(patient);
	}
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctor(){
		return doctorDao.getAllDoc();
	}
	
	@GetMapping("/patients")
	public List<Patient> getAllPatient(){
		return patientDao.findAll();
	}
	
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable(value = "id") Long docid){
		Doctor doc = doctorDao.findOne(docid);
		if(doc == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(doc);
	}
	
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long pntid){
		Patient pnt = patientDao.findOne(pntid);
		if(pnt == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(pnt);
	}
	
	@PutMapping("/update/doctors")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "id") Long docid, @Valid @RequestBody Doctor doc){
		Doctor doctor = doctorDao.findOne(docid);
		if(doctor == null) {
			return ResponseEntity.notFound().build();
		}
		
		doctor.setName(doc.getName());
		doctor.setDepartment(doc.getDepartment());
		doctor.setJoining_date(doc.getJoining_date());
		
		Doctor update = doctorDao.save(doctor);
		return ResponseEntity.ok().body(update);
	}
	
	@PutMapping("/update/patients")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Long pntid, @Valid @RequestBody Patient pnt){
		Patient patient = patientDao.findOne(pntid);
		if(patient == null) {
			return ResponseEntity.notFound().build();
		}
		
		patient.setName(pnt.getName());
		patient.setAge(pnt.getAge());
		patient.setGender(pnt.getGender());
		patient.setMobile(pnt.getMobile());
		patient.setOccupation(pnt.getOccupation());
		patient.setSymptom_summary(pnt.getSymptom_summary());
		
		Patient update = patientDao.save(patient);
		return ResponseEntity.ok().body(update);
	}
	
	@DeleteMapping("/delete/doctors")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable(value ="id") Long docid){
		Doctor doc = doctorDao.findOne(docid);
		if(doc == null) {
			return ResponseEntity.notFound().build();
		}
		
		doctorDao.delete(doc);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/patients")
	public ResponseEntity<Patient> deletePatient(@PathVariable(value ="id") Long pntid){
		Patient pnt = patientDao.findOne(pntid);
		if(pnt == null) {
			return ResponseEntity.notFound().build();
		}
		
		patientDao.delete(pnt);
		return ResponseEntity.ok().build();
	}



}
