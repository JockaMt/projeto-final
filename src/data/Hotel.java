package data;

import java.util.ArrayList;
import java.util.Scanner;
import data.classes.Employee;
import data.classes.KitchenStaff;
import data.classes.ReceptionStaff;
import data.classes.Room;
import data.classes.AdministrationStaff;
import data.classes.CleaningStaff;
import data.classes.Cliente;

/**Classe para objetos do tipo Hotel, onde serão contidos méodos e propriedades para o mesmo.
 * @author Jockson Mateus
 * @version 1.0
 */
public class Hotel {
    private final Scanner scanner = new Scanner(System.in);
    private static int count = 0;
    private int id = 1;


    private final ArrayList<Employee> empregados = new ArrayList<>();
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Room> quartos = new ArrayList<>();
    private final String linha = "========================================================================";


    /** Itera o ID automaticamente. */
    public Hotel() {
        id += count;
        count++;
    }

    /** Lista todos os funcionários cadastrados no hotel, com todas as suas informações. */
    public void listEmployees() {
        System.out.println(linha + "\nLista de Funcionários:\n" + linha);
        for (Employee empregado : empregados) {
            System.out.println("ID: " + empregado.getID());
            System.out.println(empregado);
            System.out.println(linha);
        }
    }

    /** Deleta um funcionário por ID. */
    public void deleteEmployee() {

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

        if (employeeToRemove != null) {
            empregados.remove(employeeToRemove);
            System.out.println(linha);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println(linha);
            System.out.println("Funcionário com ID " + employeeID + " não encontrado.");
        }
    }

    /** Lista os quartos criados para este Hotel. */
    public void listRooms() {
        System.out.println("Lista de Quartos:\n" + linha);
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto disponível.");
        } else {
            for (Room room : quartos) {
                System.out.println("Quarto " + room.getID()); 
            }
        }
    }

    /** Deleta um quarto por ID. */
    public void deleteRoom() {
    
        System.out.print("Digite a ID do quarto que deseja excluir: ");
        int roomID = scanner.nextInt();
    
        Room roomToRemove = null;
    
        for (Room room : quartos) {
            if (room.getID() == roomID) {
                roomToRemove = room;
                break;
            }
        }
    
        if (roomToRemove != null) {
            quartos.remove(roomToRemove);
            System.out.println(linha + "\nQuarto removido com sucesso.");
        } else {
            System.out.println(linha + "\nQuarto com ID " + roomID + " não encontrado.");
        }
    }

    /** Método que retorna o ID do hotel instanciado.
     * @return int - ID do Hotel */
    public int getID() {
        return id;
    }

    /** Método principal que permite o usuário utilizar todas as funções da classe Hotel. */
    public void actions() {
        int start;
        do {
            System.out.println(linha + "\nBem Vindo! Você está entrando ao Hall de comando do Hotel " + getID() + "\n" + linha);
            System.out.println("Escolha as opções de comando a seguir!\n" + linha);
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar funcionário novo");
            System.out.println("2. Deletar funcionários na lista");
            System.out.println("3. Comandar funções de Funcionários");
            System.out.println("4. Ver os funcionários do sistema");
            System.out.println("5. Registrar um novo quartos");
            System.out.println("6. Ver lista de quartos");
            System.out.println("7. Excluir quartos");
            System.out.println("8. Sair\n" + linha);
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
                    break;
                case 2:
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
                                    k.cook();
                                    break;
                                case "Limpeza":
                                    CleaningStaff c = (CleaningStaff) empregado;
                                    System.out.println("Deseja limpar os quartos vazios? S/N");
                                    String limpar_quartos = scanner.next();
                                    if (limpar_quartos.equalsIgnoreCase("s")){
                                        for (Room room : quartos){
                                            if (room.getClientes() == 0){
                                                room.clear();
                                            }
                                        }
                                    } else if (limpar_quartos.equalsIgnoreCase("n")){
                                        System.out.println("Os quartos continuarão fechados até a hora da limpeza.");
                                    }
                                    // ainda em teste para limpeza de quarto específico
                                    break;
                                default:
                                    System.out.println("Opção inválida.\n" + linha);
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println(linha);
                    listEmployees();
                    break;
                case 5:
                    Room newRoom = new Room();
                    quartos.add(quartos.size(), newRoom);
                    System.out.println(linha + "\nSala "  + newRoom.getID() + " adicionada!");
                    break;

                case 6:
                    listRooms();
                    break;
                case 7:
                    deleteRoom();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.\n" + linha);
                    break;
            }
        } while (start != 8);
    }
}
