package design.srp;

import org.apache.commons.text.StringEscapeUtils;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class XmlReport implements Report {
    /**
     * store - is used to store objects;
     */
    private Store store;

    public XmlReport(Store store) {
        this.store = store;
    }
    /**
     * This method is used to generate report in XML format.
     * @param filter - filters the data in the database.
     * @param getReport - function to generate the report necessary for the specified department.
     * @return - returns ready report in XML format.
     */
    @Override
    public String generate(Predicate<Employee> filter, Function<List<Employee>, String> getReport) {
        return StringEscapeUtils.escapeXml11(getReport.apply(store.findBy(filter)));
    }
}
