package Lists;

import Models.Employee;

import java.util.List;
import java.util.Vector;

public class ArrayList {
    // GOOD FOR RANDOM ACCESS

    public ArrayList() {
//        ArrayList();
        Vector();
    }

    public void ArrayList() {
        // default backing array is of 10
        List<Employee> employeeList = new java.util.ArrayList<>();
        employeeList.add(new Employee("Jack", "Noir", 14));
        employeeList.add(new Employee("Jane", "Jones", 21));
        employeeList.add(new Employee("John", "Doe", 34));
        employeeList.add(new Employee("Marry", "Smith", 365));
        employeeList.add(new Employee("Mike", "Wilson", 325));
        System.out.println(employeeList.get(1));
        System.out.println(employeeList.isEmpty());

        employeeList.set(0, new Employee("Mummi", "Snow", 23));//constant time since we are giving a index
        System.out.println(employeeList.size());
        employeeList.add(3, new Employee("Jack", "Noir", 132));// O(n) because we have to shift everything up in the worst case.

//        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for (Employee emp :
//                employeeList) {
//            System.out.println(emp);
//        }

        System.out.println(employeeList.contains(new Employee("Jane", "Jones", 21))); // override class equals method.
        //look up employee and at which index it is (both under and upper statements are dependant on the implementation of the search algorithm)
        System.out.println(employeeList.indexOf(new Employee("Mummi", "Snow", 23)));// override class equals method.

        employeeList.remove(4);
        employeeList.forEach( employee -> System.out.println(employee));
    }

    public void Vector() {
        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Jack", "Noir", 14));
        employeeList.add(new Employee("Jane", "Jones", 21));
        employeeList.add(new Employee("John", "Doe", 34));
        employeeList.add(new Employee("Marry", "Smith", 365));
        employeeList.add(new Employee("Mike", "Wilson", 325));
        System.out.println(employeeList.get(1));
        System.out.println(employeeList.isEmpty());
    }



}
