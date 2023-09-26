package data.classes;

/** Classe pai de todos os empregados.
*/
public class Employee extends Person {
	private static int count = 0;

	private double wage;
	private String role;

	/** Define o ID, o cargo e o salário.
	 * @param name String - Nome do empregado.
	 * @param sex String - Sexo do empregado.
	 * @param age int - Idade do empregado.
	 * @param role String - cargo do empregado.
	 * @param wage double - salário do empregado.*/
	public Employee (String name, String sex, int age, String role, double wage) {
		super(name, sex, age);
		setId(count);
		count ++;
		setRole(role);
		setWage(wage);
	}

	/** Define o cargo do empregado.*/
	private void setRole(String role) {
		this.role = role;
	}
	/** Retorna para o usuário qual o cargo do empregado.
	 * @return String - Cargo do empregado.*/
	public String getRole() {
		return role;
	}

	/** Define o salário do empregado.
	 * @param wage double - Salário do empregado. */
	private void setWage(double wage) {
		this.wage = wage;
	}

	/** Retorna o valor do salário atual do empregado.
	 * @return double - Salário do empregado. */
	public double getWage() {
		return wage;
	}

	/** Retorna para o usuário todos os dados do empregado.
	 * @return String - dados formatados. */
	public String toString () {
		return "Nome: "+getName()+"\nIdade: "+getAge()+"\nSexo: "+getSex()+"\nCargo: "+getRole()+"\nSalário: "+getWage();
	}

	/** Método que simulo o recebimento de salário.
	 * */
	public void receiveWage() {
		System.out.println(getName() + " foi pago em " + getWage());
	}
	/** Método que simulo o recebimento de salário com salário.
	 * @param aumento double - Aumento decidido pelo Administrador. */
	public void receiveWage(double aumento) {
		double money = getWage() + aumento;
		System.out.println(getName() + " foi pago em " + money);
	}
}
