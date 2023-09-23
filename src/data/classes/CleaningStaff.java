package data.classes;

public class CleaningStaff extends Employee {
    public CleaningStaff(String name, String sex, int age, Double wage) {
        super(name, sex, age, "Limpeza", wage);
    }

    public void clearRoom() {
        System.out.println("Limpando a quartos vazios");
    }
}