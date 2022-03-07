
package com.example.professor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

@Table(name = "professionalDetails")
public class ProfessionalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 100)

	@NotBlank(message = "Enter the designation")
	private String designation;

	@Column(length = 100)

	@NotBlank(message = "Enter your Education qualification")
	private String qualification;

	@Column(length = 50)
	private String departmentName;

	@Column(length = 200)
	private String coursesHandled;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateOfJoining;

	private int yearsOfExperience;

	@OneToOne(mappedBy = "professionalDetails")
	private Professor professorC;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCoursesHandled() {
		return coursesHandled;
	}

	public void setCoursesHandled(String coursesHandled) {
		this.coursesHandled = coursesHandled;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	

	@Override
	public String toString() {
		return "ProfessionalDetails [id=" + id + ", designation=" + designation + ", qualification=" + qualification
				+ ", departmentName=" + departmentName + ", coursesHandled=" + coursesHandled + ", dateOfJoining="
				+ dateOfJoining + ", yearsOfExperience=" + yearsOfExperience +  "]";
	}

}
