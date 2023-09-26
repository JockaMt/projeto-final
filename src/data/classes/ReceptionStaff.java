package data.classes;
import java.util.ArrayList;
import java.util.Scanner;

/** Classe do cargo de recepção.
 */
public class ReceptionStaff extends Employee {

    /** Apenas define a string do cargo como Recepção.
     * @param name String - Nome do funcionário.
     * @param sex String - Sexo do funcionário.
     * @param age int - Idade do funcionário.
     * @param wage double - Salário padrão do funcionário.
    */
    public ReceptionStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Recepção", wage);
    }

    /** Mostra uma lista de todos os quartos registrados no hotel.
     * @param quartos Room - Lista onde está armazenado os quartos.
     * @param linha String - String para decoração das impressões. (Divisor)
    */
    public void showRoom (ArrayList<Room> quartos, String linha) {
        for (Room room : quartos){
            System.out.println(linha + "\nID: " + room.getID() + " ---- " + "Capacidade: " + room.getClientes() + "/4");
        }
    }

    /** Mostra uma lista de todos os clientes registrados no hotel.
     * @param clientes ArrayList - Lista onde está armazenado os clientes.
     * @param linha String - String para decoração das impressões. (Divisor)
    */
    public void showClients (ArrayList<Cliente> clientes, String linha) {
        for (Cliente cliente : clientes) {
            System.out.println(linha + "\nID: " + cliente.getID() + " ---- " + cliente.getName());
        }
    }

    /** Realiza o cadastro de clientes no hotel.
     * @param clientes ArrayList - Lista onde está armazenado os clientes.
     * @param quartos ArrayList - Lista onde está armazenado os quartos.
     * @param empregados ArrayList - Lista onde está armazenado os clientes.
     * @param linha String - String para decoração das impressões. (Divisor)
     * @param scanner Scanner - Scanner para digitar no menu.
    */
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

    /** Remove o cadastro de um usuário por meio do ID do usuário.
     * @param clientes ArrayList - Lista onde está armazenado os clientes.
     * @param scanner Scanner - Scanner para digitar no menu.
     * @param linha String - String para decoração das impressões. (Divisor)
    */
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

    /** Aqui verificamos se o hotel tem quartos e se os quartos têm espaço para mais
     um cliente. Um quarto só pode guardar até 4 cliente.
     * @param quartos ArrayList - Lista onde está armazenado os quartos.
     * @return boolean - Quarto pode receber mais um cliente?
    */
    public boolean verifyRooms(ArrayList<Room> quartos) {
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

    /** Verifica se o hotel tem funcionários suficiente para funcionar corretamente. Um hotel precisa ter um funcionário para cada cargo.
     * @param empregados ArrayList - Lista onde está armazenado os empregados.
     * @return boolean - Hotel tem todos os cargos com pelo menos um funcionário.
    */
    public boolean verifyOpen(ArrayList<Employee> empregados) {
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