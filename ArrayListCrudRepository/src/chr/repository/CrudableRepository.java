package chr.repository;

import chr.model.Customer;
import java.util.List;

public interface CrudableRepository {
    List<Customer> list();

    Customer findOneById(int id);
    void create(Customer customer);
    void delete(int id);
    void update(Customer customer);
}
