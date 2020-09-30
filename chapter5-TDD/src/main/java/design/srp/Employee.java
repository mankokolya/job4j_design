package design.srp;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class holds information about employees.
 */
public class Employee {
    private String name;
    private LocalDate hired;
    private LocalDate fired;
    private double salary;

    public Employee(String name, LocalDate hired, LocalDate fires, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fires;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHired() {
        return hired;
    }

    public LocalDate getFired() {
        return fired;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
         return Objects.hash(name);
    }
}
