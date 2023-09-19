package com.classes;

public class KitchenStaff extends Employee {
    public KitchenStaff(String name, String sex, int age, String role, Double wage) {
        super(name, sex, age, role, wage);
    }

    // Só pra ter um método na classe.
    public void cook() {
        System.out.println("Cozinhando algo...");
    }
}