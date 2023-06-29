import chr.model.Customer;
import chr.repository.CrudSortPageableRepository;
import chr.repository.CrudableRepository;
import chr.repository.CustomerListRepositorio;
import chr.repository.Way;

public class Main {
    public static void main(String[] args) {
        CrudSortPageableRepository crud = new CustomerListRepositorio();
        Customer customer1 = new Customer("Pedro","nuevo");
        Customer customer2 = new Customer("Antonio", "Zavaleta");
        Customer customer3 = new Customer("Roberto", "Zepeda");

        crud.create(customer1);
        crud.create(customer2);
        crud.create(customer3);
        crud.delete(13);
        Customer editedCustomer = new Customer("Daniel", "Rivera",23);
        crud.update(editedCustomer);
        crud.sort("name", Way.FLL);
        crud.list().forEach(System.out::println);
    }
}