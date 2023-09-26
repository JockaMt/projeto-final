package data.classes;

/** Classe de quartos para o hotel. */
public class Room {
    private static int count = 0;
    private int id = 1;
    private final Cliente[] clientes = new Cliente[4];

    /** Itera o ID automaticamente. */
    public Room () {
        id += count;
        count ++;
    }

    /** Retorna o ID do quarto.
     * @return int - ID. */
    public int getID() {
        return id;
    }

    /** Adiciona um cliente a uma lista de 4 cliente e retorna uma string caso não possa adicionar mais cliente.
     * @param cliente Client - cliente a ser adicionado. */
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

    /** Remove o cliente da lista de clientes no quarto por ID.
     * @param nome String - Nome do cliente que deseja remover. */
    public void removeClient(String nome) {
        int index = 0;
        for (Cliente cliente : clientes){
            if (cliente.getName().equals(nome)){
                clientes[index] = null;
            }
            index++;
        }
    }

    /** Retorna a quantidade de clientes que ocupam o quarto.
     * @return int - Quantidade de clientes */
    public int getClientes() {
        int quantidade = 0;
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                quantidade++;
            }
        }
        return quantidade;
    }

    /** Mostra o ID e o nome dos clientes que ocupam o quarto. */
    public void showClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getID() + " " + cliente.getName());
        }
    }

    /** Mostra no terminal uma mensagem que o quarto está limpo. */
    public void clear() {
        System.out.println("Quarto limpo.");
    }
}