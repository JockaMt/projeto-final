package com.classes;

public class Room {
    private static int count = 0;
    public int id = 1;

    public Room () {
        id += count;
        count ++;
    }

    public int getID() {
        return id;
    }
}