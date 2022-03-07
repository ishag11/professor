package com.example.professor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.professor.exceptionhandler.ProfessorException;
import com.example.professor.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	Professor findByProfessorID(Long professorID) throws ProfessorException;

	List<Professor> findByFirstName(String firstName);

}
