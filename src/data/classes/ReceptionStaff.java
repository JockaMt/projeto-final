package data.classes;
import java.util.ArrayList;
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

    public void showClients (ArrayList<Cliente> clientes, String linha) {
        for (Cliente cliente : clientes) {
            System.out.println(linha + "\nID: " + cliente.getID() + " ---- " + cliente.getName());
        }
    }

    public void addCliente(ArrayList<Employee> empregados, ArrayList<Room> quartos, ArrayList<Cliente> clientes, String linha, Scanner scanner) {
        if (verifyOpen(empregados)) {
            if (verifyRooms(quartos)) {
                System.out.print(linha + "\nNome do Cliente: ");
                String nomeCliente = scanner.next();
                System.out.print(linha + "\nSexo do Cliente: ");
                String sexoCliente = scanner.next();
                System.out.print(linha + "\nIdade do Cliente: ");
                int idadeCliente = scanner.nextInt();
                System.out.print(linha + "\nTipo do Cliente (Ex: Pro): ");
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
            } else {
                System.out.println("O Hotel não possuí quartos disponíveis.");
            }
        } else {
            System.out.println("O hotel não está funcionando.\nFuncionários insuficientes.");
        }
    }

    public void deleteClient(String linha, Scanner scanner, ArrayList<Cliente> clientes) {

        System.out.println(linha);
        System.out.print("Digite a ID do cliente que deseja remover: ");
        int clientID = scanner.nextInt();

        Cliente clientsToRemove = null;

        for (Cliente cliente : clientes) {
            if (cliente.getID() == clientID) {
                clientsToRemove = cliente;
                break;
            }
        }

        if (clientsToRemove != null) {
            clientes.remove(clientsToRemove);
            System.out.println(linha);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println(linha);
            System.out.println("Cliente com ID " + clientID + " não encontrado.");
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
            if (empregado instanceof AdministrationStaff) {
                n[0] = true;
                break;
            }
        }
        for (Employee empregado : empregados) {
            if (empregado instanceof ReceptionStaff) {
                n[1] = true;
                break;
            }
        }
        for (Employee empregado : empregados) {
            if (empregado instanceof CleaningStaff) {
                n[2] = true;
                break;
            }
        }
        for (Employee empregado : empregados) {
            if (empregado instanceof CleaningStaff) {
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