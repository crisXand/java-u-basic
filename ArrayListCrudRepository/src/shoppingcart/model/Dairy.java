package shoppingcart.model;

public class Dairy extends Product{
    private int amount, protein;


    public Dairy(int amount, int protein,String name, Double price) {
        super(name, price);
        this.amount = amount;
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "Dairy{" +
                "amount=" + amount +
                ", protein=" + protein +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
