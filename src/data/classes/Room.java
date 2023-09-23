package data.classes;

public class Room {
    private static int count = 0;
    private int id = 1;
    private final Cliente[] clientes = new Cliente[4];

    public Room () {
        id += count;
        count ++;
    }

    public int getID() {
        return id;
    }

    public void addCliente(Cliente cliente) {
        for (int index = 0; index < clientes.length; index++){
            if (clientes[index] == null){
                clientes[index] = cliente;
                return;
            }
        }
        System.out.println("Não há vagas neste quarto.");
        addCliente(cliente);
    }

    public void removeClient(int slot) {
        clientes[slot] = null;
    }

    public int getClientes() {
        int quantidade = 0;
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public void showClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getID() + " " + cliente.getName());
        }
    }

    public void clear() {
        System.out.println("Quarto limpo.");
    }
}