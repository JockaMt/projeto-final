package com;
import java.util.ArrayList;
import com.classes.Employee;
import com.classes.Cliente;

public class Hotel {
    private static int count = 0;
    public int id = 1;

	//Iniciando uma lista de empregados.
	ArrayList<Employee> empregados = new ArrayList<Employee>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Hotel () {
        id += count;
        count ++;
    }

    public int getID() {
        return id;
    }

    public void addEmployee() {
        for (int i = 0; i < empregados.size(); i++){
            
        }
    }

    public void addCliente() {
        
    }
}
