package data.classes;

public class AdministrationStaff extends Employee {

    public AdministrationStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Administração", wage);
    }

    
    public void payEmployee (Employee e) {
        e.receiveWage();
    }
    public void payEmployee (Employee e, double aumento) {
        e.receiveWage(aumento);
    }
}
