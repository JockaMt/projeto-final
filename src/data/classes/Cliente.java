package data.classes;

public class Cliente extends Person {
    private static int count = 0;
    String type = "Normal";

    public Cliente(String name, String sex, int age) {
        super(name, sex, age);
        setId(count);
    }
    public Cliente(String name, String sex, int age, String type) {
        super(name, sex, age);
        setId(count);
        setType(type);
    }
    
    private void setType (String type) {
        this.type = type;
    }
    public String getType () {
        return this.type;
    }
}
