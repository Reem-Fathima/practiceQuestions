package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList= Arrays.asList(
                new Employee(1,"Reema",25,10000,"It",Arrays.asList(
                        new Task(1,"Task A",4),new Task(2,"Task B",2)
                )),
                new Employee(2,"Manjima",23,15000,"HR",Arrays.asList(
                        new Task(3,"Task C",2)
                )),
                new Employee(3,"Bob",28,40000,"It",Arrays.asList(
                        new Task(4,"Task D",4),
                        new Task(5,"Task E",2)
                )));
        //Sorted the Employees by Name
        List<Employee> sortedByName=employeeList.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
        sortedByName.forEach(e-> System.out.println(e.getName()));

    //Group By Department
        Map<String,List<Employee>>employeesByDepartment=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        //Print Employees in Each Department
        employeesByDepartment.forEach((department, employees) -> {
            System.out.println(department + ":");
            employees.forEach(e -> System.out.println("  " + e.getName()));
        });

        //Calculating Average Salary
        Map<String,Double>averageSalaryByDepartment=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingInt(Employee::getSalary)));

        //Print average salary
        averageSalaryByDepartment.forEach((department,averageSalary)->{
            System.out.println(department+":"+averageSalary);
        });

        // Find the top salaried employee in each department
        Map<String, Optional<Employee>> topSalariedEmployeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                ));

        // Print the top salaried employee for each department
        topSalariedEmployeesByDepartment.forEach((department, employee) -> {
            employee.ifPresent(e -> System.out.println(department + ": " + e.getName() + " with salary " + e.getSalary()));
        });


        List<Task> allTasks = employeeList.stream()
                .flatMap(e -> e.getTasks().stream())
                .collect(Collectors.toList());

        // Print all tasks
        allTasks.forEach(task -> System.out.println("Task ID: " + task.getId() + ", Name: " + task.getName() + ", Hours: " + task.getHrsToComplete()));


        // Find employees with salary > 10,000 and return their names in uppercase
        List<String> namesInUpperCase = employeeList.stream()
                .filter(e -> e.getSalary() > 10000)
                .map(e -> e.getName().toUpperCase())
                .collect(Collectors.toList());

        // Print the names in uppercase
        namesInUpperCase.forEach(System.out::println);
        Map<String, Long> employeeCountByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        // Print the number of employees in each department
        employeeCountByDepartment.forEach((department, count) ->
                System.out.println(department + ": " + count));t

        // Find the total number of tasks
        long totalTasks = employeeList.stream()
                .flatMap(e -> e.getTasks().stream())
                .count();

        // Print the total number of tasks
        System.out.println("Total number of tasks: " + totalTasks);
    }
    }




