package com.pepcoding.dsa;

import java.util.HashMap;

public class StudentGrade {
	
	private String name;
	private HashMap<String,Integer> studentGrade;
	
	
	public StudentGrade(String name, HashMap<String, Integer> studentGrade) {
		super();
		this.name = name;
		this.studentGrade = studentGrade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Integer> getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(HashMap<String, Integer> studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	

}
