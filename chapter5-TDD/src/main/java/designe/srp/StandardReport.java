package designe.srp;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This class is created to generate a report about objects stored in the database
 * on the base of provided filters and functions.
 */
public class StandardReport implements Report {
    /**
     * store - is used to store objects;
     */
    private Store store;

    public StandardReport(Store store) {
        this.store = store;
    }

    /**
     * This method is used to generate report.
     * @param filter - filters the data in the database.
     * @param getReport - function to generate the report necessary for the specified department.
     * @return - return ready report.
     */
    @Override
    public String generate(Predicate<Employee> filter, Function<List<Employee>, String> getReport) {
        return getReport.apply(store.findBy(filter));
    }
}
