package com.classes;

public class Room {
    private static int ID = 0;
    public Room () {
        ID ++;
    }

    public int getID() {
        return ID;
    }
}
