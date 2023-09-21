package com;
import java.util.ArrayList;
import java.util.Scanner;
import com.classes.Employee;
import com.classes.Cliente;

public class Hotel {
    Scanner scanner = new Scanner(System.in);
    private static int count = 0;
    private int id = 1;
    private Boolean open = false; 

	//Iniciando uma lista de empregados.
	private ArrayList<Employee> empregados = new ArrayList<Employee>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Hotel () {
        id += count;
        count ++;
    }

    public int getID() {
        return id;
    }

    public void addEmployee() {
        int start;
        do {
            System.out.println("=======================================================================");
			System.out.println("Bem Vindo! Você está entrando ao Hall de comando do Hotel " + getID());
			System.out.println("=======================================================================");
			System.out.println("Escolha as opções de comando a seguir!");
			System.out.println("=======================================================================");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar funcionário novo");
            System.out.println("2. Comandar funções de Funcionários");
			System.out.println("3. Ver os funcionários do sistema");
			System.out.println("4. Registrar um novo quartos");
			System.out.println("5. Registrar um novo cliente em alguns dos quartos");
            System.out.println("6. Sair");
			System.out.println("=======================================================================");
            start = scanner.nextInt();
            switch (start) {
                case 6:
                    break;
                default:
                    break;
            }
        } while (start != 6);
    }

    public void addCliente() {
        if (open) {

        } else {
            System.out.println("O hotel não está funcionando.\nFuncionários insuficientes.");
        }
    }
}
