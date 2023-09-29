package data;


import java.util.ArrayList;
import java.util.Scanner;
import data.classes.*;


public class Hotel {


    private final Scanner scanner = new Scanner(System.in);
    private static int count = 0;
    private int id = 1;
    private final ArrayList<Employee> empregados = new ArrayList<>();
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Room> quartos = new ArrayList<>();
    private final String linha = "========================================================================";


    public Hotel() {
        id += count;
        count++;
    }

    private void listEmployees() {
        if (empregados.isEmpty()) {
            System.out.println("Este hotel não possui funcionários.");
            return;
        }
        System.out.println("Lista de Funcionários:\n" + linha);
        for (Employee empregado : empregados) {
            System.out.println("ID: " + empregado.getID());
            System.out.println(empregado);
            try {
                if (empregado != empregados.get(empregados.size() - 1)){
                    System.out.println(linha);
                }
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    private void deleteEmployee() {

        if (empregados.isEmpty()){
            System.out.println(linha + "Este hotel ainda não possui empregados.");
            return;
        }

        System.out.println(linha);
        System.out.print("Digite a ID do funcionário que deseja remover: ");
        int employeeID = scanner.nextInt();
        
        Employee employeeToRemove = null;

        for (Employee empregado : empregados) {
            if (empregado.getID() == employeeID) {
                employeeToRemove = empregado;
                break;
            }
        }
        new ClearTerminal();
        if (employeeToRemove != null) {
            empregados.remove(employeeToRemove);
            System.out.println(linha);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println(linha);
            System.out.println("Funcionário com ID " + employeeID + " não encontrado.");
        }
    }

    private void listRooms() {
        System.out.println(linha + "\nLista de Quartos:\n" + linha);
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto disponível.");
        } else {
            for (Room room : quartos) {
                System.out.println("Quarto " + room.getID() + " --- Hóspedes: " + room.getClientes() + "/4");
            }
        }
    }

    private void deleteRoom() {

        System.out.print(linha + "\nDigite a ID do quarto que deseja excluir: ");
        int roomID = scanner.nextInt();
        Room roomToRemove = null;
    
        for (Room room : quartos) {
            if (room.getID() == roomID) {
                roomToRemove = room;
                break;
            }
        }
        new ClearTerminal();
        if (roomToRemove != null){
            quartos.remove(roomToRemove);
            System.out.println(linha + "\nQuarto removido com sucesso.");
        } else {
            System.out.println(linha + "\nQuarto com ID " + roomID + " não encontrado.");
        }
    }

    public int getID() {
        return id;
    }

    public void actions() {
        new ClearTerminal();
        int start;
        do {
            System.out.print(menu());
            start = scanner.nextInt();
            switch (start) {
                case 1:
                    System.out.println(linha + "\nEscolha uma área:");
                    System.out.print("1. Administração\n2. Recepção\n3. Cozinha\n4. Limpeza\n$ ");
                    int choice = scanner.nextInt();
                    System.out.print(linha + "\nQual o nome do funcionário: ");
                    String name = scanner.next();
                    System.out.print(linha + "\nQual a idade do funcionário: ");
                    int age = scanner.nextInt();
                    System.out.print(linha + "\nQual o sexo do funcionário: ");
                    String sex = scanner.next();
                    System.out.print(linha + "\nQuanto esse funcionário vai ganhar: ");
                    double wage = scanner.nextDouble();
                    switch (choice) {
                        case 1:
                            empregados.add(empregados.size(), new AdministrationStaff(name, sex, age, wage));
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
                            break;
                    }
                    new ClearTerminal();
                    break;
                case 2:
                    new ClearTerminal();
                    deleteEmployee();
                    break;
                case 3:
                    System.out.print(linha + "\nDigite o ID do funcionário: ");
                    int id = scanner.nextInt();
                    for (Employee empregado : empregados) {
                        if (empregado.getID() == id) {
                            switch (empregado.getRole()) {
                                case "Administração":
                                    AdministrationStaff a = (AdministrationStaff) empregado;
                                    System.out.print(linha + "\nDigite o ID do funcionário que deseja pagar: ");
                                    int empregadoID = scanner.nextInt();
                                    System.out.println("Deseja dar um aumento? S/N");
                                    String escolha;
                                    escolha = scanner.next();
                                    if (escolha.equalsIgnoreCase("s")) {
                                        System.out.print(linha + "\nDigite o valor do aumento: ");
                                        double aumento = scanner.nextDouble();
                                        System.out.println(linha);
                                        a.payEmployee(empregados.get(empregadoID - 1), aumento);
                                    } else if (escolha.equalsIgnoreCase("n")) {
                                        a.payEmployee(empregados.get(empregadoID));
                                    }
                                    break;
                                    
                                case "Recepção":
                                    ReceptionStaff r = (ReceptionStaff) empregado;
                                    boolean receptionMenu = true;
                                    do {
                                        System.out.print(linha + "\nOlá, me chamo " + r.getName() + " em que posso ajudar?\n1. Cadastrar cliente\n2. Remover Cliente\n3. Mostrar clientes\n4. Mostrar quartos disponíveis\n5. Voltar para o menu principal\nEscolha: ");
                                        int recepChoice = scanner.nextInt();
                                
                                        switch (recepChoice) {
                                            case 1:
                                                r.addCliente(empregados, quartos, clientes, linha, scanner);
                                                break;
                                            case 2:
                                                r.deleteClient(linha, scanner, clientes);
                                                break;
                                            case 3:
                                                r.showClients(clientes, linha);
                                                break;
                                            case 4:
                                                r.showRoom(quartos, linha);
                                                break;
                                            case 5:
                                                receptionMenu = false; 
                                                break;
                                            default:
                                                break;
                                        }
                                    } while (receptionMenu);
                                    break;

                                case "Cozinha":
                                    KitchenStaff k = (KitchenStaff) empregado;
                                    k.cook(scanner);
                                    break;
                                case "Limpeza":
                                    CleaningStaff c = (CleaningStaff) empregado;
                                    c.clearRoom(scanner, quartos);
                                    break;
                                default:
                                    System.out.println("Opção inválida.\n" + linha);
                            }
                        }
                    }
                    break;
                case 4:
                    new ClearTerminal();
                    System.out.println(linha);
                    listEmployees();
                    break;
                case 5:
                    new ClearTerminal();
                    Room newRoom = new Room();
                    quartos.add(quartos.size(), newRoom);
                    System.out.println(linha + "\nSala "  + newRoom.getID() + " adicionada!");
                    break;

                case 6:
                    new ClearTerminal();
                    listRooms();
                    break;
                case 7:
                    new ClearTerminal();
                    if (!quartos.isEmpty()) {
                        deleteRoom();
                    } else {
                        System.out.println("Este hotel não possui quartos.");
                    }
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.\n" + linha);
                    break;
            }
        } while (start != 8);
    }

    String menu (){
        String breakLine = "\n";
        return linha + breakLine + "Bem Vindo! Você está entrando ao Hall de comando do Hotel " + getID() + breakLine  + linha + breakLine + "Selecione uma opção:" + breakLine + "1. Criar funcionário novo" + breakLine + "2. Deletar funcionários na lista" + breakLine + "3. Comandar funções de Funcionários" + breakLine + "4. Ver os funcionários do sistema" + breakLine + "5. Registrar um novo quartos" + breakLine + "6. Ver lista de quartos" + breakLine + "7. Excluir quartos" + breakLine + "8. Sair" + breakLine + "$ ";
    }
}
