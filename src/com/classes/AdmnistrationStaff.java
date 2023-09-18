package com.classes;

public class AdmnistrationStaff extends Employee {

    public AdmnistrationStaff(String name, String sex, int age, String role, Double wage) {
        super(name, sex, age, role, wage);
    }
    
    public void payEmployee (Employee e) {
        System.out.println("Not implemented!");
    }
}
