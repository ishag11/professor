package com.example.professor.exceptionhandler;

@SuppressWarnings("serial")
public class ProfessorException extends RuntimeException{

	public ProfessorException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfessorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProfessorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProfessorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProfessorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
