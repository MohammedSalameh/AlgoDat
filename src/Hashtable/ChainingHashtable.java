package Hashtable;

import Models.Employee;
import Models.StoredEmployee;

import java.util.*;

public class ChainingHashtable {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainingHashtable() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredEmployee>();
        }

//        Employee janeJones = new Employee("Jane", "Jones", 21);
//        Employee johnDoe = new Employee("John", "Doe", 34);
//        Employee marrySmith = new Employee("Marry", "Smith", 365);
//        Employee mikeWilson = new Employee("Mike", "Wilson", 325);
//
//        this.put("Jones", janeJones);
//        this.put("Doe", johnDoe);
//        this.put("Wilson", mikeWilson);
//        this.put("Smith", marrySmith); // collision
//
//        printHashtable();

//        System.out.println("Retrieve key Smith:" + get("Smith"));
//        this.remove("Wilson");
//        this.remove("Jones");
//        printHashtable();
//        System.out.println("Retrieve key Smith:" + get("Smith"));

        JDKHashtable();

    }

    public void JDKHashtable() {
        // Hashmap based on Map interface
        Employee janeJones = new Employee("Jane", "Jones", 21);
        Employee johnDoe = new Employee("John", "Doe", 34);
        Employee marrySmith = new Employee("Marry", "Smith", 365);
        Employee mikeWilson = new Employee("Mike", "Wilson", 325);

        Map<String, Employee> hashmap = new HashMap<String, Employee>();
        hashmap.put("Jones", janeJones);
        hashmap.put("Doe", johnDoe);
        hashmap.put("Wilson", mikeWilson);
        hashmap.put("Smith", marrySmith);

        //Printing
//        Iterator<Employee> iterator = hashmap.values().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        Employee employee = hashmap.put("Doe", mikeWilson); // returns replaced employee cause its the same key
        // otherwise use putifabsent, if the key is not used insert, else return current key object/employee
        Employee employee = hashmap.putIfAbsent("Doe", mikeWilson);
        System.out.println(employee);

        System.out.println(hashmap.get("someone")); // returns null if no one found
        System.out.println(hashmap.getOrDefault("someone", mikeWilson)); // if no one found, return mikeWilson
        System.out.println(hashmap.remove("Jones"));

        hashmap.forEach((k, v) -> System.out.println("Key = " + k + " Employee = " + v));

//        System.out.println(hashmap.containsKey("Doe"));
//        System.out.println(hashmap.containsValue(janeJones));


    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()) {
            employee = iterator.next();
            if(employee.key.equals(key)) {
                // found employee
                return employee.employee;
            }
        }

        // havent found employee
        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;// so we dont get out of bounds
        while (iterator.hasNext()) {
            employee = iterator.next();
            index++;
            if(employee.key.equals(key)) {
                break;
            }
        }
        // we have traversed the list and not found employee
        // or
        // have found the employee
        if (employee == null) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    private int hashKey (String key) {
        // Key: Jones
        // 5 % 10 = 5
//        return key.length() % hashtable.length;
        // hashing a string can produce negative numbers
        return Math.abs(key.hashCode() % hashtable.length);
        // always mod with the length of the hashtable
        // since you dont want to go out of bounds.
    }
    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
            } else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().employee);
                    System.out.print("->");
                }
                System.out.println("null");
            }
        }
    }
}
