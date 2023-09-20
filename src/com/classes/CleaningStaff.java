package com.classes;

public class CleaningStaff extends Employee {
    public CleaningStaff(String name, String sex, int age, String role, Double wage) {
        super(name, sex, age, role, wage);
        
    }

    public void clearRoom(int room) {
        System.out.println("Limpando a sala " + room);
    }

}