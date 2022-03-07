package com.example.professor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.professor.exceptionhandler.ProfessorException;
import com.example.professor.model.Professor;
import com.example.professor.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public Professor saveProfessor(Professor professor) {
		return professorRepository.save(professor);
	}

	public Professor findByProfessorId(Long professorID) throws ProfessorException {
		Professor p;
		if (!(professorRepository.findById(professorID).isPresent())) {

			throw new ProfessorException();
		} else {
			p = professorRepository.findByProfessorID(professorID);
		}
		return p;
	}
	
	public List<Professor> findByFirstName(String firstName) throws ProfessorException {
		return professorRepository.findByFirstName(firstName);
	}


}