package com.classes;

public class Room {
    private static int count = 0;
    private int id = 1;
    private Cliente[] clientes = new Cliente[4];

    public Room () {
        id += count;
        count ++;
    }

    public int getID() {
        return id;
    }

    public void addCliente(int slot, Cliente cliente) {
        clientes[slot] = cliente;
    }

    public void removeClient(int slot) {
        clientes[slot] = null;
    }
}