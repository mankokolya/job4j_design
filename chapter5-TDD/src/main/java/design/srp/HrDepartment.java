package design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * HrDepartment was designed to hold all information about Hrs' department.
 */
public class HrDepartment {
    /**
     * Used to add to the report all the necessary information. Includes title by default.
     */
    private StringBuilder build = new StringBuilder()
            .append("Name; Salary;")
            .append(System.lineSeparator());

    /**
     * This function is used to retrieve necessary data from the database.
     */
    public Function<List<Employee>, String> getReport = worker -> {
        worker.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(employee -> build.append(employee.getName()).append(";")
                        .append(employee.getSalary()).append(";")
                        .append(System.lineSeparator()));
        return build.toString();
    };
}
