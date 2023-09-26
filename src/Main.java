import data.Hotel;

import java.util.ArrayList;
import java.util.Scanner;

/** Class Main. */
public class Main {
	private final ArrayList<Hotel> hoteis = new ArrayList<>();
	private final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){ new Main(); }
	/** Começa o gerenciamento de hotéis. */
    Main() {
		action();
	}

	/** Inicia o menu de gerenciamento. */
	public void action(){
		boolean loop = true;
		do {
			System.out.println(message());
			int selection = scanner.nextInt();
			int ID;
			switch (selection) {
				case 1:
					createHotel();
					break;
				case 2:
					ID = scanner.nextInt();
					accessHotel(ID);
					break;
				case 3:
					ID = scanner.nextInt();
					removeHotel(ID);
					break;
				case 4:
					listHotel();
					break;
				case 5:
					break;
				default:
					System.out.println("Opção inválida.");
					break;

			}
		} while (loop);
	}

	/** Cria a instância de um hotel e adiciona na lista de hotéis. */
	private void createHotel(){
		hoteis.add(new Hotel());
	}

	/** Acessa um hotel via ID.
	 * @param index int - Index do hotel que deseja acessar.*/
	private void accessHotel(int index){
		hoteis.get(index - 1).actions();
	}

	/** Remove um hotel via ID.
	 * @param ID int - ID do hotel que deseja remover. */
	private void removeHotel(int ID){
		for (Hotel hotel : hoteis){
			if (hotel.getID() == (hoteis.get(ID)).getID()){
				hoteis.remove(hoteis.get(ID));
			};
		}
	}

	/** Lita todos os hotéis cadastrados. */
	private void listHotel(){
		for (Hotel hotel : hoteis){
			System.out.println("Hotel ID: " + hotel.getID());
		}
	}

	/** Apenas uma mensagem para o menu.
	 * @return String - Menu. */
	private String message(){
		return "1. Criar um Hotel.\n2. Acessar um Hotel.\n3. Remover um Hotel.\n4. Listar todos os Hoteis.\n5. Sair.";
	}
}