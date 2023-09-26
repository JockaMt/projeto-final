package data.classes;

/** Classe do cargo de Administração.
 * @author Jockson Mateus
 */
public class AdministrationStaff extends Employee {

    /** Apenas defini a string do cargo como Administração.
     * @param name String - Nome do funcionário.
     * @param sex String - Sexo do funcionário.
     * @param age int - Idade do funcionário.
     * @param wage double - Salário padrão do funcionário.
    */
    public AdministrationStaff(String name, String sex, int age, double wage) {
        super(name, sex, age, "Administração", wage);
    }

    /** Imprime no console o valor pago ao funcionário.
     * @param e Employee - Empregado que será pago.
    */
    public void payEmployee (Employee e) {
        e.receiveWage();
    }

    /** Imprime no console o valor pago ao funcionário com o acréscimo de um valor escolhido.
     * @param e Employee - Empregado que será pago.
     * @param aumento double - Aumento do salário.
     * @author Jockson Mateus*/
    public void payEmployee (Employee e, double aumento) {
        e.receiveWage(aumento);
    }
}
