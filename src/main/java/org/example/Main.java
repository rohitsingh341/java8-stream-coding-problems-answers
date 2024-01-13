package org.example;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Rohit", "Singh", "male", 30, "Engineering", 2, Arrays.asList("+91-1234567891", "+91-2345678912")),
        new Employee("Prachi", "Khurana", "female", 24, "Engineering", 4, Arrays.asList("+91-3234567891", "+91-3345678912")),
        new Employee("Nitesh", "Patel", "male", 38, "Admin", 5, Arrays.asList("+91-4234567891", "+91-4345678912")),
        new Employee("Gaurav", "Sethi", "male", 42, "Accounts", 1, Arrays.asList("+91-5234567891", "+91-5345678912")),
        new Employee("Neha", "Trivedi", "female", 26, "Engineering", 2, Arrays.asList("+91-6234567891", "+91-6345678912")),
        new Employee("Prashant", "Sharma", "male", 30, "IT", 3, Arrays.asList("+91-7234567891", "+91-7345678912")),
        new Employee("Rahul", "Verma", "male", 30, "IT", 7, Arrays.asList("+91-8234567891", "+91-8345678912")),
        new Employee("Neha", "Singh", "female", 35, "HR", 1, Arrays.asList("+91-9234567891", "+91-9345678912")),
        new Employee("Rohit", "Singh", "male", 21, "Admin", 1, Arrays.asList("+91-664567891", "+91-665678912"))
        );

        // find employees whose age is in between 20 and 30

        List<Employee> employeesBetween20And30Age = employees.stream()
                .filter(employee -> employee.getAge() > 20 && employee.getAge() < 30)
                .toList();
        System.out.println(employeesBetween20And30Age);

        // find employees who are in Engineering department and sort them by num of projects allocated

        List<Employee> employeeEngineeringSorted = employees.stream()
                .filter(employee -> "Engineering".equals(employee.getDepartmentName()))
                .sorted(Comparator.comparing(Employee::getNumProjectsAllocated, Comparator.reverseOrder())).toList();

        System.out.println(employeeEngineeringSorted);

        // find all department names

        List<String> deptNames = employees.stream().map(Employee::getDepartmentName).toList();
        System.out.println(deptNames);

        // find unique department names - first way
        System.out.println(employees.stream().map(Employee::getDepartmentName).distinct().toList());

        // find unique department names - second way
        System.out.println(employees.stream().map(Employee::getDepartmentName).collect(Collectors.toSet()));

        // find all the contact numbers - but it prints list of list
        System.out.println(employees.stream().map(Employee::getContacts).toList());

        // find all the contact numbers as string list
        System.out.println(employees.stream().flatMap(employee -> employee.getContacts().stream()).toList());

        System.out.println("\n");

        // Group the employees by department names
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName)));

        // Count employees based on depratment names in a map
        System.out.println("\n");

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting())));

        // find the department with max number of employees

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get());

        // find the average age of male employees

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));

        // find highest age in each department
        System.out.println();
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.maxBy(Comparator.comparingInt(Employee::getAge)))));

    }
}