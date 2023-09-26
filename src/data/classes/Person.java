package data.classes;

/** Classe modelo para Employee e Cliente. */
public abstract class Person {
    private String name;
	private int id = 1;
    private String sex;
    private int age;

	/** Define o nome, o sexo e a idade
	 * @param name String - Nome da pessoa.
	 * @param sex String - Sexo da pessoa.
	 * @param age int - Idade da pessoa.*/
	public Person (String name, String sex, int age) {
		setName(name);
		setSex(sex);
		setAge(age);
    }

	/** Retorna o ID da pessoa.
	 * @return int - ID. */
    public int getID() {
        return id;
    }

	/** Define o ID
	 * @param count int - Recebe o contador. */
	public void setId(int count) {
		id += count;
	}

	/** Define o nome da pessoa.
	 * @param newName String - Nome da pessoa. */
	private void setName (String newName) {
		this.name = newName;
	}

	/** Retorna o nome da pessoa.
	 * @return String - Nome.*/
	public String getName() {
		return name;
	}

	/** Define o sexo da pessoa.
	 * @param newSex String - Sexo da pessoa. */
	private void setSex (String newSex) {
		this.sex = newSex;
	}

	/** Retorna o sexo da pessoa.
	 * @return String - Sexo da pessoa. */
	public String getSex() {
		return sex;
	}

	/** Define a idade da pessoa.
	 * @param newAge int - Idade da pessoa. */
	private void setAge (int newAge) {
		this.age = newAge;
	}

	/** Retorna a idade da pessoa.
	 * @return int - Idade. */
	public int getAge() {
		return age;
	}
}
