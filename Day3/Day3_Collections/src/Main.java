
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        // =========================
        // 1. Create Employee List
        // =========================

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Ahmed", 10000));
        employees.add(new Employee(2, "Mohamed", 15000));
        employees.add(new Employee(3, "Ahmed", 12000));
        employees.add(new Employee(4, "Ali", 8000));


        // =========================
        // 2. Print Employees
        // =========================

        System.out.println("All Employees:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }


        // =========================
        // 3. Comparable
        // Sort by Salary Ascending
        // =========================

        Collections.sort(employees);

        System.out.println("\nSorted by Salary:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }


        // =========================
        // 4. Comparator
        // Sort by Salary Descending
        // =========================

        employees.sort(
                Comparator.comparing(Employee::getSalary)
                        .reversed()
        );

        System.out.println("\nSalary Descending:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }


        // =========================
        // 5. Set
        // Remove Duplicate Names
        // =========================

        Set<String> uniqueNames = new HashSet<>();

        for (Employee employee : employees) {
            uniqueNames.add(employee.getName());
        }

        System.out.println("\nUnique Names:");

        for (String name : uniqueNames) {
            System.out.println(name);
        }


        // =========================
        // 6. Map
        // Employee ID -> Employee
        // =========================

        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        System.out.println("\nEmployee with ID 2:");

        Employee employee = employeeMap.get(2);

        System.out.println(employee);

        // =========================
        // 7. Queue
        // =========================

//        Queue<Employee> employeeQueue = new LinkedList<>();
//
//        employeeQueue.offer(employees.get(0));
//        employeeQueue.offer(employees.get(1));
//        employeeQueue.offer(employees.get(2));
//
//        System.out.println("\nFirst Employee:");
//        System.out.println(employeeQueue.peek());
//
//        System.out.println("\nRemoved Employee:");
//        System.out.println(employeeQueue.poll());
//
//        System.out.println("\nFirst Employee After Poll:");
//        System.out.println(employeeQueue.peek());

        // =========================
        // 8. Top 5 Salaries
        // =========================

        System.out.println("\nTop 5 Salaries:");

        employees.stream()
                .sorted(
                        Comparator.comparing(Employee::getSalary)
                                .reversed()
                )
                .limit(5)
                .forEach(System.out::println);
    }

}