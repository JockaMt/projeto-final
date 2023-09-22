package com;

import java.util.ArrayList;
import java.util.Scanner;
import com.classes.Employee;
import com.classes.KitchenStaff;
import com.classes.ReceptionStaff;
import com.classes.AdmnistrationStaff;
import com.classes.CleaningStaff;
import com.classes.Cliente;

public class Hotel {
    Scanner scanner = new Scanner(System.in);
    String linha = "========================================================================";
    private static int count = 0;
    private int id = 1;
    private Boolean open = false;

    // Iniciando uma lista de empregados.
    private ArrayList<Employee> empregados = new ArrayList<Employee>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Hotel() {
        id += count;
        count++;
    }

    public int getID() {
        return id;
    }

    public void addEmployee() {
        int start;
        do {
            System.out.println(
                    linha + "\nBem Vindo! Você está entrando ao Hall de comando do Hotel " + getID() + "\n" + linha);
            System.out.println("Escolha as opções de comando a seguir!\n" + linha);
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar funcionário novo");
            System.out.println("2. Comandar funções de Funcionários");
            System.out.println("3. Ver os funcionários do sistema");
            System.out.println("4. Registrar um novo quartos");
            System.out.println("5. Registrar um novo cliente em alguns dos quartos");
            System.out.println("6. Sair\n" + linha);
            start = scanner.nextInt();
            switch (start) {
                case 1:
                    System.out.println("Escolha uma área:");
                    System.out.println("1. Administração\n2. Recepção\n3. Cozinha\n4. Limpeza");
                    int choice = scanner.nextInt();
                    System.out.println("Qual o nome do funcionário?");
                    String name = scanner.next();
                    System.out.println("Qual a idade do funcionário?");
                    int age = scanner.nextInt();
                    System.out.println("Qual o sexo do funcionário?");
                    String sex = scanner.next();
                    System.out.println("Quanto esse funcionário vai ganhar?");
                    Double wage = scanner.nextDouble();
                    switch (choice) {
                        case 1:
                            empregados.add(empregados.size(), new AdmnistrationStaff(name, sex, age, wage));
                            break;
                        case 2:
                            empregados.add(empregados.size(), new ReceptionStaff(name, sex, age, wage));
                            break;
                        case 3:
                            empregados.add(empregados.size(), new KitchenStaff(name, sex, age, wage));
                            break;
                        case 4:
                            empregados.add(empregados.size(), new CleaningStaff(name, sex, age, wage));
                            break;
                        default:
                            System.out.println("Opção inválida.\n" + linha);
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID do funcionário:");
                    int id = scanner.nextInt();
                    for (int i = 0; i < empregados.size(); i++) {
                        if (empregados.get(i).getID() == id) {
                            switch (empregados.get(i).getRole()) {
                                case "Admnistração":
                                    AdmnistrationStaff a = (AdmnistrationStaff) empregados.get(i);
                                    // a.payEmployee(a);
                                    System.out.println(a.getName());
                                    break;
                                case "Recepção":
                                    ReceptionStaff r = (ReceptionStaff) empregados.get(i);
                                    // r.showRoom(id);
                                    break;
                                case "Cozinha":
                                    KitchenStaff k = (KitchenStaff) empregados.get(i);
                                    // k.cook();
                                    break;
                                case "Limpeza":
                                    CleaningStaff c = (CleaningStaff) empregados.get(i);
                                    // c.clearRoom(id);
                                    break;
                                default:
                                    System.out.println("Opção inválida.\n" + linha);
                            }
                        }
                    }
                    // System.out.println("Pressione Enter para continuar...");
                    // System.console().readLine();
                    break;
                case 3:
                    for (int i = 0; i < empregados.size(); i++){
                        System.out.println(linha + "\nID: " + empregados.get(i).getID() + "\n" + empregados.get(i));
                    }
                    System.out.println("Pressione Enter para continuar...");
                    System.console().readLine();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
                default:
                    System.out.println("Opção inválida.\n" + linha);
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
