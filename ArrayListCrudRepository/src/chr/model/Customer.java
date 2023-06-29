package chr.model;

public class Customer {
    private Integer id;
    private String name, lastname;

    public Customer(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Customer(String name, String lastname, int id){
        this.name = name;
        this.lastname = lastname;
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
