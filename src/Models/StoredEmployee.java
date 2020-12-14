package Models;

public class StoredEmployee {

    public String key; // raw key, NOT HASHED VALUE
    public Employee employee;
    public boolean deleted;


    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }


}
