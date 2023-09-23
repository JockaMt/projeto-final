package data.classes;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ReceptionStaff extends Employee {
    public ReceptionStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Recepção", wage);
    }

    public void showRoom (ArrayList<Room> quartos, String linha) {
        for (Room room : quartos){
            System.out.println(linha + "\nID: " + room.getID() + " ---- " + "Capacidade: " + room.getClientes() + "/4");
        }
    }

    public void addCliente(ArrayList<Employee> empregados, ArrayList<Room> quartos, ArrayList<Cliente> clientes, String linha, Scanner scanner) {
        if (verifyOpen(empregados)) {
            if (verifyRooms(quartos)) {
                System.out.println(linha + "\nMenu de Adição de Cliente");
                System.out.println("1. Adicionar Cliente");
                System.out.println("2. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");
    
                int escolha = scanner.nextInt();
    
                switch (escolha) {
                    case 1:
                        System.out.print("Nome do Cliente: ");
                        String nomeCliente = scanner.next();
                        System.out.print("Sexo do Cliente: ");
                        String sexoCliente = scanner.next();
                        System.out.print("Idade do Cliente: ");
                        int idadeCliente = scanner.nextInt();
                        System.out.print("Tipo do Cliente (Ex: Pro): ");
                        String tipoCliente = scanner.next();
    
                        Cliente cliente = new Cliente(nomeCliente, sexoCliente, idadeCliente, tipoCliente);
                        clientes.add(cliente);
    
                        System.out.print("Escolha um quarto: ");
                        int roomID = scanner.nextInt();
    
                        try {
                            quartos.get(roomID - 1).addCliente(cliente);
                            System.out.println(cliente.getName() + " adicionado ao quarto " + roomID);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Este quarto não existe");
                        }
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } else {
                System.out.println("O Hotel não possuí quartos disponíveis.");
            }
        } else {
            System.out.println("O hotel não está funcionando.\nFuncionários insuficientes.");
        }
    }
    
    public Boolean verifyRooms(ArrayList<Room> quartos) {
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

    public Boolean verifyOpen(ArrayList<Employee> empregados) {
        /* Como no diagrama temos que só podemos colocar clientes se todas as vagas
           estiverem ocupadas, fazemos essa verificação.
           Uma lista de boolean, se toda a lista for true, então o hotel tem todas as
           funções ativas. */
        boolean[] n = new boolean[4];
        for (Employee empregado : empregados) {
            if (Objects.equals(empregado.getRole(), "Administração")) {
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
}