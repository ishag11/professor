package com.example.professor.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.professor.dto.*;

import com.example.professor.dto.ProfessorStatus;
import com.example.professor.exceptionhandler.ProfessorException;
import com.example.professor.model.Professor;
import com.example.professor.service.ProfessorService;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@PostMapping("/add")
	public Professor saveProfessor(@Valid @RequestBody Professor professor) throws EntityNotFoundException {
		return professorService.saveProfessor(professor);
	}

	@PutMapping("/update")
	public Professor updateProfessor(@Valid @RequestBody Professor professor) {
		return professorService.saveProfessor(professor);
	}

	@GetMapping("/{id}")
	public Professor findByProfessorId(@PathVariable("id") Long professorID) {
		return professorService.findByProfessorId(professorID);
	}

	@GetMapping("/names")
	public List<Professor> findByFirstName(@RequestParam(value = "firstName") String firstName) {
		return professorService.findByFirstName(firstName);
	}

	@GetMapping(value = "/getProfessor/{professorID}")
	public ResponseEntity getProfessor(@PathVariable("professorID") Long professorID) {
		ProfessorStatus professorStatus = new ProfessorStatus();
		try {
			professorStatus.setStatus(Status.StatusType.SUCCESS);
			professorStatus.setMessage("Professor ID present");
			professorStatus.setProfessorID(professorService.findByProfessorId(professorID).getProfessorID());
			professorStatus.setEmail(professorService.findByProfessorId(professorID).getEmail());
			professorStatus.setFirstName(professorService.findByProfessorId(professorID).getFirstName());
			professorStatus.setHttpstatus(HttpStatus.OK);
			return new ResponseEntity<ProfessorStatus>(professorStatus, HttpStatus.OK);
		} catch (ProfessorException extracurricularException) {
			professorStatus.setStatus(Status.StatusType.FAILED);
			professorStatus.setMessage("Professor ID not present");
			professorStatus.setHttpstatus(HttpStatus.CONFLICT);
			return new ResponseEntity(professorStatus, HttpStatus.CONFLICT);
		}

	}



}