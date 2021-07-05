package JavaAdvanced.DefiningClasses.Exercise.CompanyRoster_02;

import java.util.ArrayList;
import java.util.List;

public class Department {
    List<Employee> employees;
    String name;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();

    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);

    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageSalary() {
        double avg = 0.0;
        for (Employee employee : this.employees) {
            avg += employee.getSalary();
        }
        return avg / this.employees.size();
    }
}
