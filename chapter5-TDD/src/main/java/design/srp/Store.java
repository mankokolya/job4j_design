package design.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Store interface is used to hold the method that all containers that stores the data
 * and implements this interface should implement.
 */
public interface  Store {
    /**
     * findBy - can be used to look for some employee in the database according to passed parameters.
     * @param filter - parameter used to find an employee by some parameter.
     * @return - collections of employees that correspond to the filter.
     */
    List<Employee> findBy(Predicate<Employee> filter);
}
