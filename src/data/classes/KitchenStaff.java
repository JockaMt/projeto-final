package data.classes;

public class KitchenStaff extends Employee {
    public KitchenStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Cozinha", wage);
    }

    // Só para ter um método na classe.
    public void cook() {
        System.out.println("Cozinhando algo...");
    }
}