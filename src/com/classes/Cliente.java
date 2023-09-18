package com.classes;

public class Cliente extends Person {
    String type = "Normal";

    public Cliente(String name, String sex, int age, String type) {
        super(name, sex, age);
        setType(type);
    }
    
    private void setType (String type) {
        this.type = type;
    }
    public String getType () {
        // Cliente normal, vip, permuta, etc...
        return this.type;
    }
}
