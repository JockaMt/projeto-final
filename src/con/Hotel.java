package con;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import con.classes.Employee;
import con.classes.KitchenStaff;
import con.classes.ReceptionStaff;
import con.classes.Room;
import con.classes.AdmnistrationStaff;
import con.classes.CleaningStaff;
import con.classes.Cliente;

public class Hotel {
    Scanner scanner = new Scanner(System.in);
    String linha = "========================================================================";
    private static int count = 0;
    private int id = 1;

    // #LISTAS01
    private final ArrayList<Employee> empregados = new ArrayList<Employee>();
    private final ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private final ArrayList<Room> quartos = new ArrayList<Room>();
    // #LISTAS01

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
            System.out.println(linha + "\nBem Vindo! Você está entrando ao Hall de comando do Hotel " + getID() + "\n" + linha);
            System.out.println("Escolha as opções de comando a seguir!\n" + linha);
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar funcionário novo");
            System.out.println("2. Comandar funções de Funcionários");
            System.out.println("3. Ver os funcionários do sistema");
            System.out.println("4. Registrar um novo quartos");
            System.out.println("5. Ver quartos");
            System.out.println("6. Registrar um novo cliente em alguns dos quartos");
            System.out.println("7. Sair\n" + linha);
            // TODO: Precisamos fazer um CRUD para cada lista pesquise #LISTAS01, não precisa ter o update. (CRD)
            start = scanner.nextInt();
            switch (start) {
                case 1:
                    System.out.println(linha + "\nEscolha uma área:");
                    System.out.println("1. Administração\n2. Recepção\n3. Cozinha\n4. Limpeza");
                    int choice = scanner.nextInt();
                    System.out.print(linha + "\nQual o nome do funcionário: ");
                    String name = scanner.next();
                    System.out.print(linha + "\nQual a idade do funcionário: ");
                    int age = scanner.nextInt();
                    System.out.print(linha + "\nQual o sexo do funcionário: ");
                    String sex = scanner.next();
                    System.out.print(linha + "\nQuanto esse funcionário vai ganhar: ");
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
                    System.out.print(linha + "\nDigite o ID do funcionário: ");
                    int id = scanner.nextInt();
                    for (Employee empregado : empregados) {
                        if (empregado.getID() == id) {
                            switch (empregado.getRole()) {
                                case "Admnistração":
                                    AdmnistrationStaff a = (AdmnistrationStaff) empregado;
                                    System.out.print(linha + "\nDigite o ID do funcionário que deseja pagar: ");
                                    int empregadoID = scanner.nextInt();
                                    System.out.println("Deseja dar um aumento? S/N");
                                    String escolha;
                                    escolha = scanner.next();
                                    if (escolha.equalsIgnoreCase("s")) {
                                        System.out.print(linha + "\nDigite o valor do aumento: ");
                                        Double aumento = scanner.nextDouble();
                                        System.out.println(linha);
                                        a.payEmployee(empregados.get(empregadoID - 1), aumento);
                                    } else if (escolha.equalsIgnoreCase("n")) {
                                        a.payEmployee(empregados.get(empregadoID));
                                    }
                                    // TODO: Precisamos fazer com que as funções de cada classe funcione, nem que seja um print.
                                    break;
                                case "Recepção":
                                    // ReceptionStaff r = (ReceptionStaff) empregados.get(i);
                                    // r.showRoom(id);
                                    break;
                                case "Cozinha":
                                    // KitchenStaff k = (KitchenStaff) empregados.get(i);
                                    // k.cook();
                                    break;
                                case "Limpeza":
                                    // CleaningStaff c = (CleaningStaff) empregados.get(i);
                                    // c.clearRoom(id);
                                    break;
                                default:
                                    System.out.println("Opção inválida.\n" + linha);
                            }
                        }
                    }
                    break;
                case 3:
                    for (Employee empregado : empregados) {
                        System.out.println(linha + "\nID: " + empregado.getID() + "\n" + empregado);
                    }
                    break;
                case 4:
                    Room newRoom = new Room();
                    quartos.add(quartos.size(), newRoom);
                    System.out.println(linha + "Sala " + newRoom.getID() + " adicionada!");
                    break;
                case 5:
                    for (Room quarto : quartos) {
                        System.out.println(linha + "\nID: " + quarto.getID() + "\n" + quarto);
                    }
                    break;
                case 6:
                    addCliente();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválida.\n" + linha);
                    break;
            }
        } while (start != 7);
    }

    public void addCliente() {
        if (verifyOpen()) {
            if (verifyRooms()) {
                clientes.add(clientes.size(), new Cliente("test", "M", 1, "Pro"));
                // TODO: Precisamos fazer um menu para adicionar os clientes
            } else {
                System.out.println("O Hotel não possúi quartos disponíveis.");
            }
        } else {
            System.out.println("O hotel não está funcionando.\nFuncionários insuficientes.");
        }
    }

    public Boolean verifyOpen() {

        /* Como no diagrama temos que só podemos colocar clientes se todas as vagas
           estiverem ocupadas, fazemos essa verificação.
           Uma lista de booleanos, se toda a lista for true, então o hotel tem todas as
           funcões ativas. */

        boolean[] n = new boolean[4];
        for (Employee empregado : empregados) {
            if (Objects.equals(empregado.getRole(), "Admnistração")) {
                n[0] = true;
                break;
            }
        }
        for (Employee empregado : empregados) {
            if (Objects.equals(empregado.getRole(), "Recepção")) {
                n[1] = true;
                break;
            }
        }
        for (Employee empregado : empregados) {
            if (Objects.equals(empregado.getRole(), "Cozinha")) {
                n[2] = true;
                break;
            }
        }
        for (Employee empregado : empregados) {
            if (Objects.equals(empregado.getRole(), "Limpeza")) {
                n[3] = true;
                break;
            }
        }
        for (boolean b : n) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public Boolean verifyRooms() {

        /* Aqui verificamos se o hotel tem quartos e se os quartos têm espaço para mais
           um cliente.
           No diagrama está escrito que um quarto só pode guardar até 4 cliente.  */

        if (!quartos.isEmpty()) {
            for (Room quarto : quartos) {
                if (quarto.getClientes() < 4) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
