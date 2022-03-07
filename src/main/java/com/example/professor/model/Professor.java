package com.example.professor.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Details")
public class Professor {

	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="book_generator")
	@SequenceGenerator(name="book_generator", sequenceName ="book_seq", allocationSize=50)
	private Long professorID;

	@Size(min = 3, max = 15)
	@NotBlank(message = "Enter the firstname")
	private String firstName;

	@Size(min = 3, max = 15)
	@NotEmpty(message = "Enter the lastname")
	private String lastName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dob;

	@NotBlank(message = "Gender is required")
	private String gender;

	@NotNull
	@Email(message = "Enter a Valid email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "currentAddressId", referencedColumnName = "Id")
	private Address currentAddressId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "permanentAddressId", referencedColumnName = "Id")
	private Address permanentAddressId;

	@Size(min = 10, max = 10)
	@NotBlank(message = "Enter the ContactNumber")
	private String contactNumber;

	@Size(min = 10, max = 10)
	private String emergencyNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professionalDetails", referencedColumnName = "Id")
	private ProfessionalDetails professionalDetails;
	
	private String lastModifiedBy;
	
	@LastModifiedDate
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate lastModifiedDate= LocalDate.now();
	
	private String createdBy;
	
	@CreatedDate
	@Column(name = "created_Date", nullable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate createdDate=LocalDate.now();

	public Long getProfessorID() {
		return professorID;
	}

	public void setProfessorID(Long professorID) {
		this.professorID = professorID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getCurrentAddressId() {
		return currentAddressId;
	}

	public void setCurrentAddressId(Address currentAddressId) {
		this.currentAddressId = currentAddressId;
	}

	public Address getPermanentAddressId() {
		return permanentAddressId;
	}

	public void setPermanentAddressId(Address permanentAddressId) {
		this.permanentAddressId = permanentAddressId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	public ProfessionalDetails getProfessionalDetails() {
		return professionalDetails;
	}

	public void setProfessionalDetails(ProfessionalDetails professionalDetails) {
		this.professionalDetails = professionalDetails;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Professor [professorID=" + professorID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + ", gender=" + gender + ", email=" + email + ", currentAddressId=" + currentAddressId
				+ ", permanentAddressId=" + permanentAddressId + ", contactNumber=" + contactNumber
				+ ", emergencyNumber=" + emergencyNumber + ", professionalDetails=" + professionalDetails
				+ ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + "]";
	}

	
	
	
	
}
