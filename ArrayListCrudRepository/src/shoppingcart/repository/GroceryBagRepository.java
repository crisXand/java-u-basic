package shoppingcart.repository;

import java.util.ArrayList;
import java.util.List;

public class GroceryBagRepository<T> implements HandleableRepository<T> {

    List<T> products;


    public GroceryBagRepository() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(T product) {
        if(products.size()<=5){

            products.add(product);
        }else {
            throw new RuntimeException("Max excedido");
        }

    }

    @Override
    public List<T> getProducts() {
        return products;
    }
}
