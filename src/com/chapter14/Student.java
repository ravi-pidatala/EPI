package com.chapter14;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student>{

	String name;
	double gpa;
	int age;
	
	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Student that) {
		return name.compareTo(that.name);
	}
	
	public static void main(String[] args) {
		
	}

	static void sortByGpa(List<Student> studentList) {
		Collections.sort(studentList, Collections.reverseOrder(new Comparator<Student>() {
				@Override
				public int compare(Student s, Student b) {
					return Double.compare(s.gpa, b.gpa);
				} 
		}
		));
	}
	
	/*
	 * java 8 lambda expression
	 */
	static void sortBygpa(List<Student > list) {
		Collections.sort(list, 
				Collections.reverseOrder((Student s, Student b) -> Double.compare(s.gpa, b.gpa)));
	}
}
