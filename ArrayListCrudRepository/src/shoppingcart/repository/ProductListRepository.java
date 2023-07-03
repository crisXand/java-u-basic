package shoppingcart.repository;

import shoppingcart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListRepository<T> implements HandleableRepository<T> {

    List<T> products;


    public ProductListRepository() {
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
