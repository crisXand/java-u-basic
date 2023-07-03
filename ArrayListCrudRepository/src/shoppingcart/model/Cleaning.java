package shoppingcart.model;

public class Cleaning extends Product{
    private String components;
    private double liters;

    public Cleaning(String name, Double price, String components, double liters) {
        super(name, price);
        this.components = components;
        this.liters = liters;
    }
}
