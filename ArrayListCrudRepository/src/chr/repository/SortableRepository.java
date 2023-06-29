package chr.repository;

import chr.model.Customer;

import java.util.List;

public interface SortableRepository {
    List<Customer> sort(String field, Way way);

}
