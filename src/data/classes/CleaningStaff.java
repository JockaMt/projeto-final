package data.classes;

import java.util.ArrayList;
import java.util.Scanner;

/** Classe do cargo de limpeza.
 * @author Jockson Mateus
 */
public class CleaningStaff extends Employee {
    /** Apenas defini a string do cargo como Limpeza.
     * @param name String - Nome do funcionário.
     * @param sex String - Sexo do funcionário.
     * @param age int - Idade do funcionário.
     * @param wage double - Salário padrão do funcionário.
    */
    public CleaningStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Limpeza", wage);
    }

    /** Imprime no console os quartos limpos.
     * @param scanner Scanner - Scanner para digitar no menu.
     * @param quartos ArrayList - Lista onde está armazenado os quartos.
     * @author Luiz Henrique */
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