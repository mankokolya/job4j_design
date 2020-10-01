package design.srp;

import org.apache.commons.text.StringEscapeUtils;

import java.util.List;
import java.util.function.Function;
/**
 * ProgrammerDepartment was designed to hold all information about programmers' department.
 */
public class ProgrammersDepartment {
    /**
     * Used to add to the report all the necessary information. Includes title by default.
     */
    private StringBuilder build = new StringBuilder()
            .append("Name; Hired; Fired; Salary;")
            .append(System.lineSeparator());
    /**
     * This function is used to retrieve necessary data from the database.
     */
    public  Function<List<Employee>, String> getReport = worker -> {
       worker.forEach(employee -> build.append(employee.getName()).append(";")
               .append(employee.getHired()).append(";")
               .append(employee.getFired()).append(";")
               .append(employee.getSalary()).append(";")
               .append(System.lineSeparator()));
        return build.toString();
    };
}
