package org.example;

import java.util.List;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final int age;
    private final String departmentName;
    private final int numProjectsAllocated;
    private final List<String> contacts;

    public Employee(String firstName, String lastName, String gender, int age, String departmentName, int numProjectsAllocated, List<String> contacts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.departmentName = departmentName;
        this.numProjectsAllocated = numProjectsAllocated;
        this.contacts = contacts;
    }


    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getNumProjectsAllocated() {
        return numProjectsAllocated;
    }

    public List<String> getContacts() {
        return contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (numProjectsAllocated != employee.numProjectsAllocated) return false;
        if (!Objects.equals(firstName, employee.firstName)) return false;
        if (!Objects.equals(lastName, employee.lastName)) return false;
        if (!Objects.equals(gender, employee.gender)) return false;
        if (!Objects.equals(departmentName, employee.departmentName))
            return false;
        return Objects.equals(contacts, employee.contacts);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + numProjectsAllocated;
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", departmentName='" + departmentName + '\'' +
                ", numProjectsAllocated=" + numProjectsAllocated +
                ", contacts=" + contacts +
                '}';
    }
}
