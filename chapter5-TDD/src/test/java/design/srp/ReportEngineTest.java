package design.srp;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineTest {
    private MemStore store = new MemStore();
    private LocalDate now = LocalDate.now();
    private Employee workerIvan = new Employee("Ivan", now, now, 100);
    private Employee workerNick = new Employee("Nick", now, now, 500);

    @Test
    public void whenGeneratedForHeadOffice() {
        store.add(workerIvan);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(workerIvan.getName()).append(";")
                .append(workerIvan.getHired()).append(";")
                .append(workerIvan.getFired()).append(";")
                .append(workerIvan.getSalary()).append(";")
                .append(System.lineSeparator());

        assertThat(engine.generate(em -> true, HeadOffice.getReport), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForProgrammers() {
        store.add(workerIvan);
        store.add(workerNick);
        ReportEngine engine = new ReportEngine(store);
        String expect = StringEscapeUtils.escapeHtml4(new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(workerIvan.getName()).append(";")
                .append(workerIvan.getHired()).append(";")
                .append(workerIvan.getFired()).append(";")
                .append(workerIvan.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerNick.getName()).append(";")
                .append(workerNick.getHired()).append(";")
                .append(workerNick.getFired()).append(";")
                .append(workerNick.getSalary()).append(";")
                .append(System.lineSeparator())
                .toString());
        assertThat(engine.generate(em -> true, ProgrammersDepartment.getReport), is(expect));
    }

    @Test
    public void whenGeneratedForHR() {
        store.add(workerIvan);
        store.add(workerNick);
        ReportEngine engine = new ReportEngine(store);
        String expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(workerNick.getName()).append(";")
                .append(workerNick.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerIvan.getName()).append(";")
                .append(workerIvan.getSalary()).append(";")
                .append(System.lineSeparator())
                .toString();
        assertThat(engine.generate(em -> true, HrDepartment.getReport), is(expect));
    }

    @Test
    public void whenGeneratedForBookkeepers() {
        store.add(workerIvan);
        store.add(workerNick);
        ReportEngine engine = new ReportEngine(store);
        String expect = StringEscapeUtils.escapeHtml4(new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(workerIvan.getName()).append(";")
                .append(workerIvan.getHired()).append(";")
                .append(workerIvan.getFired()).append(";")
                .append(workerIvan.getSalary() / 28).append(";")
                .append(System.lineSeparator())
                .append(workerNick.getName()).append(";")
                .append(workerNick.getHired()).append(";")
                .append(workerNick.getFired()).append(";")
                .append(workerNick.getSalary() / 28).append(";")
                .append(System.lineSeparator())
                .toString());
        assertThat(engine.generate(em -> true, BookkeeperDepartment.getReport), is(expect));
    }

}