package data.classes;

public class AdmnistrationStaff extends Employee {

    public AdmnistrationStaff(String name, String sex, int age, Double wage) {
        super(name, sex, age, "Admnistração", wage);
    }

    
    public void payEmployee (Employee e) {
        e.recieveWage();
    }
    public void payEmployee (Employee e, Double aumento) {
        e.recieveWage(aumento);
    }
}
