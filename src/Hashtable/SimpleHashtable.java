package Hashtable;

import Models.Employee;
import Models.StoredEmployee;

public class SimpleHashtable {

    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        this.hashtable = new StoredEmployee[10];

        Employee janeJones = new Employee("Jane", "Jones", 21);
        Employee johnDoe = new Employee("John", "Doe", 34);
        Employee marrySmith = new Employee("Marry", "Smith", 365);
        Employee mikeWilson = new Employee("Mike", "Wilson", 325);
        Employee billEnd = new Employee("Bill", "End", 54);

        this.put("Jones", janeJones);
        this.put("Doe", johnDoe);
        this.put("Wilson", mikeWilson);
        this.put("Smith", marrySmith); // collision
        printHashtable();

        System.out.println("Retrieve key Smith:" + get("Smith"));

        this.remove("Wilson");
        this.remove("Jones");
        printHashtable();


    }

    public void put (String key, Employee employee) {
        int hashedKey = hashKey(key);

        if (occupied(hashedKey)) {
            // Linear Probing
            // since we want to loop around the array
            // the stopIndex is the current hashedkey
            // Loop around until we hit stopIndex
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length-1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                // if hashedKey is 9,
                // we dont want to go out of bounds.
                // 9+1=10 % 10 = 0 loop around
                hashedKey = (hashedKey+1) % hashtable.length;
            }
        }

        // redundant to call this twice, but it is O(1) so not too big of a deal.
        if (occupied(hashedKey)) {
            System.out.println("Already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null; // no key with the value we are looking for.
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i = 0; i < hashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }
        return employee;
    }

    private int hashKey (String key) {
        // Key: Jones
        // 5 % 10 = 5
        return key.length() % hashtable.length;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        // if employee was added with the key the were added with
        // ex. "Jones" would hash to 5, index 5 and look at employee value and check employee
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        // else Linear probing
        // since we want to loop around the array
        // the stopIndex is the current hashedkey
        // Loop around until we hit stopIndex
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length-1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }


        // Haven't look through the entire array.
        // the index we are looking at is not the employee with correct key

        // If we hit a null before we have found what we are looking for
        // we can be certain that the item is not in the table
        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            // if hashedKey is 9,
            // we dont want to go out of bounds.
            // 9+1=10 % 10 = 0 loop around
            hashedKey = (hashedKey+1) % hashtable.length;
        }

        // 1. Either we have looked through the entire array
        // 2. We have found the employee
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            // null or not what we are looking for
            return -1;
        }

    }

    private boolean occupied (int index) {
        // if not null, TRUE
        // if null, FALSE (empty spot)
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("Position " + i + ": Empty");
            } else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }


}
