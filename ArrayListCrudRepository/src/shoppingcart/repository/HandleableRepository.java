package shoppingcart.repository;

import java.util.List;

public interface HandleableRepository<T> {
    void addProduct(T product);
    List<T> getProducts();
}
