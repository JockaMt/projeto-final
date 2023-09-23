package data.classes;

public abstract class Person {
	private static int count = 0;
    private int id = 1;
    private String name;
    private String sex;
    private int age;

	public Person (String name, String sex, int age) {
        id += count;
        count ++;
		setName(name);
		setSex(sex);
		setAge(age);
    }

    public int getID() {
        return id;
    }

	private void setName (String newName) {
		this.name = newName;
	}
	public String getName() {
		return name;
	}
	
	private void setSex (String newSex) {
		this.sex = newSex;
	}
	public String getSex() {
		return sex;
	}
	
	private void setAge (int newAge) {
		this.age = newAge;
	}
	public int getAge() {
		return age;
	}
}
