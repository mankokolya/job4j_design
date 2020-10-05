package designe.srp;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineTest {
    MemStore store = new MemStore();

    @Test
    public void whenOldGenerated() {
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator() + worker.getName() + ";"
                + worker.getHired() + ";" + worker.getFired() + ";"
                + worker.getSalary() + ";" + System.lineSeparator();
        assertThat(engine.generate(employee -> true), is(expect));
    }

}