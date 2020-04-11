/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mohamad
 */
public class Q3 {

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee(1, "Ahmad", "IT", 1201),
            new Employee(2, "Hani", "Sales", 950.8),
            new Employee(5, "Huda", "IT", 1010.5),
            new Employee(7, "Ali", "Marketing", 1300),
            new Employee(4, "Hani", "Sales", 1050)
        };

        List<Employee> listEmployees = Arrays.asList(employees);
        listEmployees.stream()
                //returns elements between 800&1200 
                .filter(e -> e.getSalary() >= 800 && e.getSalary() < 1200)
                //transforms a stream’s elements to new values  
                .map(e -> new Employee(e.getId(), e.getName(), e.getMajor(), e.getSalary() * 1.02))
                //grouping the element By the department & count the number of department 
                .collect(Collectors.groupingBy(Employee::getMajor, Collectors.counting()))
                //printing the department and the count of its 
                .forEach((d, c) -> System.out.println("Dept: " + d + ", Count: " + c));
    }
}
