package com;

public class Produto {
    int id;
    String name;
    double price;
    String description;
    int quantidade;

    public Produto () {}

    public Produto (int Id, String Name, double Price, int quantidade) {
        setId(Id);
        setName(Name);
        setPrice(Price);
        setQuantidade(quantidade);
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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return quantidade;
    }
}
