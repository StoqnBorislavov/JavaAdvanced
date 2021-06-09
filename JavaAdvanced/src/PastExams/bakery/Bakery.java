package PastExams.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee){
        if(isFree(employees, capacity)) {
            employees.add(employee);
        }
    }

    public Employee getOldestEmployee(){
        int max = Integer.MIN_VALUE;
        Employee oldestEmployee = null;
        for (Employee employee : employees) {
            if(employee.getAge() > max){
                max = employee.getAge();
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name){
        Employee searchedEmployee = null;
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                searchedEmployee = employee;
                break;
            }
        }
        return searchedEmployee;
    }

    public int getCount(){
        return this.employees.size();
    }

    public boolean remove(String name){
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Employees working at Bakery ")
                .append(this.name).append(":\n");
        for (Employee employee : employees) {
            stringBuilder.append(employee).append("\n");
        }
        return stringBuilder.toString();
    }


    private boolean isFree(List<Employee> employees, int capacity) {
        return capacity > employees.size();
    }
}
