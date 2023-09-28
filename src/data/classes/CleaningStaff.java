package data.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class CleaningStaff extends Employee {

    public CleaningStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Limpeza", wage);
    }

    public void clearRoom(Scanner scanner, ArrayList<Room> quartos) {
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
    }
}