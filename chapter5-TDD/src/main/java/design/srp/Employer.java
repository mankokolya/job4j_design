package design.srp;

import java.util.Calendar;
import java.util.Objects;

public class Employer {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    public Employer(String name, Calendar hired, Calendar fires, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fires;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Calendar getHired() {
        return hired;
    }

    public Calendar getFired() {
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
        Employer employer = (Employer) obj;
        return Objects.equals(name, employer.name);
    }

    @Override
    public int hashCode() {
         return Objects.hash(name);
    }
}
