package chr.repository;

import chr.model.Customer;

import java.util.List;

public interface PageableRepository {

    List<Customer> page(int since, int until);
}
