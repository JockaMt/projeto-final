package data.classes;

/** Classe do cargo de recepção.
 * @author Jockson Mateus
 */
public class Cliente extends Person {
    private static int count = 0;
    String type = "Normal";

    /** Define o ID.
     * @param name String - Nome do cliente.
     * @param sex String - Sexo do cliente.
     * @param age int - Idade do cliente.*/
    public Cliente(String name, String sex, int age) {
        super(name, sex, age);
        setId(count);
        count ++;
    }

    /** Define o ID e a classificação.
     * @param name String - Nome do cliente.
     * @param sex String - Sexo do cliente.
     * @param age int - Idade do cliente.
     * @param type String - Classificação do cliente.
    */
    public Cliente(String name, String sex, int age, String type) {
        super(name, sex, age);
        setId(count);
        setType(type);
        count ++;
    }

    /** Define a classificação do cliente.
     * @param type String - Classificação do cliente.
    */
    private void setType (String type) {
        this.type = type;
    }

    /** Retorna o timpo de cliente.
     * @return String - Tipo do cliente
    */
    public String getType () {
        return this.type;
    }
}
