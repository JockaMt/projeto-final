public class Produto {
    int id;
    String name;
    double price;
    String description;

    Produto (int Id, String Name, double Price) {
        setId(Id);
        setName(Name);
        setPrice(Price);
    }

    private void setId(int id) { 
        this.id = id;
    }

    // SetGet Name
    private void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // SetGet Price
    private void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
}
