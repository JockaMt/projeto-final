package data.classes;

import java.util.Scanner;


public class KitchenStaff extends Employee {

    public KitchenStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Cozinha", wage);
    }

    public void cook(Scanner scanner) {
        System.out.println("Qual refeição deseja servir?\n1. Café da Manhã\n2. Almoço\n3. Janta\n4. Lanche");
        int KitchenChoice = scanner.nextInt();
        switch (KitchenChoice){
            case 1:
                System.out.println("O Café da Manhã foi preparado e servido aos clientes.");
                break;
            case 2:
                System.out.println("O Almoço foi preparado e servido aos clientes.");
                break;
            case 3:
                System.out.println("O Jantar foi preparado e servido aos clientes.");
                break;
            case 4:
                System.out.println("O Lanche foi preparado e servido aos clientes.");
                break;
            default:
                break;
        }
    }
}
