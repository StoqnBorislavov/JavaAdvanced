package JavaAdvanced.DefiningClasses.Exercise.CompanyRoster_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee;
            departments.putIfAbsent(department, new Department(department));
            if(input.length == 5){
                if(Character.isAlphabetic(input[4].charAt(0))){
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(input[4]);
                   employee = new Employee(name, salary, position, department, age);
                }

            } else if(input.length == 6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else {
                employee = new Employee(name, salary, position, department);
            }
            departments.get(department).addEmployee(employee);
        }
        double bestAvgSalary = 0.0;
        String bestDepartment = "";
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            if(entry.getValue().getAverageSalary() > bestAvgSalary){
                bestAvgSalary = entry.getValue().getAverageSalary();
                bestDepartment = entry.getKey();
            }
        }

        System.out.println(String.format("Highest Average Salary: %s", bestDepartment));
        departments.get(bestDepartment).getEmployees()
                .stream()
                .sorted((x, y) ->{
                    return Double.compare(y.getSalary(), x.getSalary());
                })
                .forEach(e-> System.out.println(e));
    }
}
