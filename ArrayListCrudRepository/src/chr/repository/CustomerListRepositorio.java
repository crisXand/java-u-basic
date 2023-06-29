package chr.repository;

import chr.model.Customer;

import java.util.*;

public class CustomerListRepositorio implements CrudSortPageableRepository{
    private List<Customer> customers;

    public CustomerListRepositorio() {
        this.customers = new ArrayList<Customer>(Arrays.asList(
                new Customer("Jan", "Pedro",1),
                new Customer("Diana", "Mendoza", 2)
                ));
    }

    @Override
    public List<Customer> list() {
        return customers;
    }

    @Override
    public Customer findOneById(int id) {
        return customers.stream().filter(customer ->
                id == customer.getId()
                ).findAny().orElse(null);
    }

    @Override
    public void create(Customer customer) {
        List<Integer> ids = this.customers.stream().map(customer1 -> customer1.getId()).toList();
        customer.setId(Collections.max(ids)+1);
        customers.add(customer);
    }

    @Override
    public void delete(int id) {
        this.customers.remove(this.findOneById(id));
    }

    @Override
    public void update(Customer customer) {
        try {
            Customer customerToEdit = findOneById(customer.getId());
            customerToEdit.setName(customer.getName());
            customerToEdit.setLastname(customer.getLastname());
        }catch (Exception e){
            System.out.println("Customer not found");
        }
    }

    @Override
    public List<Customer> sort(String field, Way way) {
        List<Customer> sortedCustomer = customers;
        sortedCustomer.sort( (Customer c1, Customer c2) -> {
                    int result = 0;
                    if(way.equals(Way.UPW)){
                        result = compareCustomer(c1,c2,field);
                    }else if(way.equals(Way.FLL)){
                        result = compareCustomer(c2,c1,field);
                    }
                    return result;
                }
            );
        return sortedCustomer;
    }

    private int compareCustomer(Customer c1, Customer c2, String field){
        int result = 0;
        switch(field){
            case "name" -> result = c1.getName().compareTo(c2.getName());
            case "id" -> result = c1.getId().compareTo(c2.getId());
            case "lastname" -> result = c1.getLastname().compareTo(c2.getLastname());
        }
        return result;
    }

    @Override
    public List<Customer> page(int since, int until) {

        return customers.subList(since, until);
    }
}
