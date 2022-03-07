package com.example.professor.dto;

import org.springframework.http.HttpStatus;

public class ProfessorStatus extends Status {
	
	private HttpStatus httpstatus;
	private Long professorID;
	private String firstName;
	private String email;
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
