package com;

public class Hotel {
    private static int ID = 0;
    public Hotel () {
        ID ++;
    }

    public int getID() {
        return ID;
    }
}
