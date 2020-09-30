package design.srp;

import org.apache.commons.text.StringEscapeUtils;

import java.util.List;
import java.util.function.Function;

/**
 * BookkeeperDepartment was designed to hold all information about bookkeepers' department.
 */
public class BookkeeperDepartment {
    /**
     * Used to add to the report all the necessary information. Includes title by default.
     */
    private static StringBuilder build = new StringBuilder()
            .append("Name; Hired; Fired; Salary;")
            .append(System.lineSeparator());

    /**
     * This function is used to retrieve necessary data from the database.
     */
    public static Function<List<Employee>, String> getReport = worker -> {
        worker.forEach(employee -> build.append(employee.getName()).append(";")
                .append(employee.getHired()).append(";")
                .append(employee.getFired()).append(";")
                .append(employee.getSalary() / 28).append(";") //returns the salary in dollars;
                .append(System.lineSeparator()));
        return StringEscapeUtils.escapeHtml4(build.toString());
    };
}
