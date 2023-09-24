package data.classes;

public class CleaningStaff extends Employee {
    public CleaningStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Limpeza", wage);
    }

    public void clearRoom(Room room) {
        room.clear();
    }
}