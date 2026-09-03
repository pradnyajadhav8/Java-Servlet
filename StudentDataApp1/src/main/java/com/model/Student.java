package com.model;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private double marks;
	private String gender;

	public Student() {

	}

	public Student(int id, String name, double marks, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.gender = gender;
	}

	public Student(String name, double marks, String gender) {
		this.name = name;
		this.marks = marks;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format("%-5d %-25s %-2f \t %-6s", id, name, marks, gender);
	}

}
