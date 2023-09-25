package data.classes;

public class Employee extends Person {
	private static int count = 0;

	private double wage;
	private String role;

	public Employee (String name, String sex, int age, String role, double wage) {
		super(name, sex, age);
		setId(count);
		count ++;
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
	
	public String toString () {
		return "Nome: "+getName()+"\nIdade: "+getAge()+"\nSexo: "+getSex()+"\nCargo: "+getRole()+"\nSalário: "+getWage();
	}

	public void receiveWage() {
		System.out.println(getName() + " foi pago em " + getWage());
	}
	public void receiveWage(double aumento) {
		double money = getWage() + aumento;
		System.out.println(getName() + " foi pago em " + money);
	}
}
