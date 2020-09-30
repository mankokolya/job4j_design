package design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * MemStore designed to store and retrieve information about employees.
 */
public class MemStore implements Store {
    /**
     * Collections used to store information about employees.
     */
    private final List<Employee> employees = new ArrayList<>();

    /**
     * This method is used to add new data to the existing database of workers.
     * @param em - new employee.
     */
    public void add(Employee em) {
        employees.add(em);
    }

    /**
     * findBy - is used to look for some employee in the database according to passed parameters.
     * @param filter - parameter used to find an employee by some parameter.
     * @return - collections of employees that correspond to the filter.
     */
    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}
