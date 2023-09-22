import com.Hotel;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Hotel> hoteis = new ArrayList<Hotel>();
		Scanner scanner = new Scanner(System.in);
		int start;
        String linha = "========================================================================";

        do {
			System.out.println(linha);
			System.out.println("Bem Vindo! Você está entrando ao gerenciador de Hoteis!");
			System.out.println(linha);
			System.out.println("Escolha as opções de comando a seguir!");
			System.out.println(linha);
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar novo hotel");
            System.out.println("2. Deletar hoteis");
			System.out.println("3. Ver hoteis");
            System.out.println("4. Sair");
			System.out.println("=");

            start = scanner.nextInt();

            switch (start) {
                case 1:
                    System.out.println("Você irá criar um novo hotel!");
                    break;
                case 2:
                    System.out.println("Você irá deletar um hotel!");
                    break;
				case 3:
					System.out.println("Irá ver todos os hoteis!");
					break;
                case 4:
                    System.out.println("Saindo do programa...\n" + linha);
                    break;
					default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (start != 4);

		Hotel h1 = new Hotel();
		h1.addEmployee();
        scanner.close();
	}
}