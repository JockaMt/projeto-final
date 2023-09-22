package con.classes;

public class KitchenStaff extends Employee {
    public KitchenStaff(String name, String sex, int age, Double wage) {
        super(name, sex, age, "Cozinha", wage);
    }

    // Só pra ter um método na classe.
    public void cook() {
        System.out.println("Cozinhando algo...");
    }
}