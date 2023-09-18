package com;

public class Hotel {
    private static int count = 0;
    public int id = 1;

    public Hotel () {
        id += count;
        count ++;
    }

    public int getID() {
        return id;
    }
}