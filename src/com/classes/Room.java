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

    public void addCliente(Cliente cliente) {
        for (int i = 0; i < clientes.length; i++){
            if (clientes[i] == null){
                clientes[i] = cliente;
                return;
            }
        }
    }

    public void removeClient(int slot) {
        clientes[slot] = null;
    }

    public int getClientes() {
        return clientes.length;
    }

    public void showClientes() {
        for (int i = 0; i < clientes.length; i++){
            System.out.println(clientes[i].getID() + " " + clientes[i].getName());
        }
    }

    public void clear() {
        System.out.println("Quarto limpo.");
    }
}