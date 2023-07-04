package shoppingcart;

import shoppingcart.model.Dairy;
import shoppingcart.model.Fruit;
import shoppingcart.repository.GroceryBagRepository;
import shoppingcart.repository.HandleableRepository;

public class MainProductRepository {

    public static void main(String[] args) {
        Fruit manzana = new Fruit("Manzana", 12.54);
        Fruit banana = new Fruit("Banana", 0.35);
        Fruit orange = new Fruit("Orange", 0.15);

        HandleableRepository<Fruit> fruitGroceryBag = new GroceryBagRepository<>();
        fruitGroceryBag.addProduct(manzana);
        fruitGroceryBag.addProduct(banana);
        fruitGroceryBag.addProduct(orange);
        fruitGroceryBag.getProducts().forEach(System.out::println);

        HandleableRepository<Dairy> dairyBag = new GroceryBagRepository<>();
        Dairy milk = new Dairy(14,2,"Milk", 12.20);
        Dairy cheese = new Dairy(25,4,"Cheese", 2.30);
        Dairy yogurt = new Dairy(12,5,"Yogurt", 2.75);
        Dairy paneer = new Dairy(25,4,"Paneer", 2.30);
        Dairy curd = new Dairy(25,4,"Cheese", 2.30);
        Dairy coffee = new Dairy(25,4,"Cheese", 2.30);
        Dairy iceCream = new Dairy(25,4,"Ice cream", 2.30);

        dairyBag.addProduct(milk);
        dairyBag.addProduct(cheese);
        dairyBag.addProduct(yogurt);
        dairyBag.addProduct(paneer);
        dairyBag.addProduct(curd);
        dairyBag.addProduct(coffee);

        dairyBag.getProducts().forEach(System.out::println);

    }

}
