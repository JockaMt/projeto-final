import data.Hotel;
import data.classes.ClearTerminal;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	private final ArrayList<Hotel> hotels = new ArrayList<>();
	private final Scanner scanner = new Scanner(System.in);
	private final String linha = "========================================================================";

	public static void main(String[] args){
		Main instance = new Main();
		instance.action();
	}

	public void action(){
		boolean loop = true;
		do {
			try {
				System.out.println(message());
				System.out.print("$ ");
				int selection = scanner.nextInt();
				int ID;
				switch (selection) {
					case 1:
						new ClearTerminal();
						System.out.println(linha);
						createHotel();
						break;
					case 2:
						new ClearTerminal();
						System.out.println(linha);
						if (verifyHotel()) {
							System.out.print("Acessar Hotel\n\nID do Hotel: ");
							ID = scanner.nextInt();
							new ClearTerminal();
							accessHotel(ID);
						}
						break;
					case 3:
						new ClearTerminal();
						System.out.println(linha);
						if (verifyHotel()) {
							System.out.print("Remover Hotel\n\nID do Hotel: ");
							ID = scanner.nextInt();
							removeHotel(ID);
						}
						break;
					case 4:
						new ClearTerminal();
						System.out.println(linha);
						listHotel();
						break;
					case 5:
						new ClearTerminal();
						loop = false;
						break;
					default:
						System.out.println("Opção inválida.");
						break;

				}
			} catch (Exception e){
				System.err.println("Error");
				break;
			}
		} while (loop);
	}

	private void createHotel(){
		Hotel novo = new Hotel();
		hotels.add(novo);
		System.out.println("Hotel "+novo.getID()+ " criado.");
	}

	private void accessHotel(int ID){
		for (Hotel hotel : hotels) {
			try {
				if (hotel.getID() == ID) {
					System.out.println(hotel.getID());
					hotel.actions();
					return;
				}
			} catch (Exception e){
				new ClearTerminal();
				System.out.println(linha);
				System.out.println("Este Hotel não existe.");
			}
		}
	}

	private void removeHotel(int ID){
		for (Hotel hotel : hotels) {
			try {
				if (hotel.getID() == ID) {
					System.out.println("O hotel " + hotel.getID() + " foi removido.");
					hotels.remove(hotel);
					return;
				}
			} catch (Exception e){
				new ClearTerminal();
				System.out.println(linha);
				System.out.println("Este Hotel não existe.");
			}
		}
	}

	private void listHotel(){
		if (verifyHotel()){
			for (Hotel hotel : hotels){
				System.out.println("Hotel ID: " + hotel.getID());
			}
		}
	}

	private String message(){
		return linha + "\nBem Vindo! Você está no menu principal.\n" + linha + "\n1. Criar um Hotel.\n2. Acessar um Hotel.\n3. Remover um Hotel.\n4. Listar todos os Hotéis.\n5. Sair.";
	}

	private boolean verifyHotel(){
		if (hotels.isEmpty()){
			System.out.println("Nenhum hotel cadastrado.");
			return false;
		}
		return true;
	}
}