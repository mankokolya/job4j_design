package design.srp;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter, Function<List<Employee>, String> getReport);
}
