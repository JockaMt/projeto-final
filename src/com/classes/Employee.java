package com.classes;

public class Employee extends Person {
	private Double wage;
	private String role;

	public Employee (String name, String sex, int age, String role, Double wage) {
		super(name, sex, age);
		setRole(role);
		setWage(wage);
	}

	private void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}

	private void setWage(Double wage) {
		this.wage = wage;
	}
	public Double getWage() {
		return wage;
	}
}
