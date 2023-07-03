package shoppingcart.model;

public class Fruit extends Product{
    public Fruit(String name, Double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
