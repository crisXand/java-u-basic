package shoppingcart.model;

public class NonPerishable extends Product{
    private int content;
    private int calories;

    public NonPerishable(String name, Double price, int content, int calories) {
        super(name, price);
        this.content = content;
        this.calories = calories;
    }
}
