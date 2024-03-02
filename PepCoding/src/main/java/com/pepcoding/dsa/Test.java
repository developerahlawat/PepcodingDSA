package com.pepcoding.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String [] args) {
	
	HashMap<String, Integer> val1 = new HashMap<>();
	val1.put("Math", 90);
	val1.put("Physics", 85);
	val1.put("History", 78);
	
	StudentGrade student1= new StudentGrade("student1",val1);
	
	Map<String, Integer> val2 = new HashMap<>();
	val2.put("Math", 92);
	val2.put("Physics", 88);
	val2.put("History", 75);
	StudentGrade student2= new StudentGrade("student1",val1);
	
	
	Map<String, Integer> val3 = new HashMap<>();
	val3.put("Math", 85);
	val3.put("Physics", 95);
	val3.put("History", 80);
	StudentGrade student3= new StudentGrade("student1",val1);
	
	ArrayList<StudentGrade> listStudentGrade = new ArrayList<>();
	listStudentGrade.add(student1);
	listStudentGrade.add(student2);
	listStudentGrade.add(student3);
	
	//listStudentGrade.stream().map(e->e.getStudentGrade().get("Math"))
	
	
	}

	
}
