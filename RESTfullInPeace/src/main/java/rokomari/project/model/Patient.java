package rokomari.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private long patient_id;
	
	@Column(name = "name")
	@NotBlank
	private String name;
	
	@Column(name = "mobile")
	@NotBlank
	private long mobile;
	
	@Column(name = "gender")
	@NotBlank
	private String gender;
	
	@Column(name = "age")
	@NotBlank
	private int age;
	
	@Column(name = "occupation")
	@NotBlank
	private String occupation;
	
	@Column(name = "symptom_summary")
	@NotBlank
	private String symptom_summary;

	public long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSymptom_summary() {
		return symptom_summary;
	}

	public void setSymptom_summary(String symptom_summary) {
		this.symptom_summary = symptom_summary;
	}
	
	

}
