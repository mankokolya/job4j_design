package design.srp;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StandardReportTest {

    @Test
    public void whenGeneratedForHeadOffice() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee workerIvan = new Employee("Ivan", now, now, 100);
        store.add(workerIvan);
        Report engine = new StandardReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(workerIvan.getName()).append(";")
                .append(workerIvan.getHired()).append(";")
                .append(workerIvan.getFired()).append(";")
                .append(workerIvan.getSalary()).append(";")
                .append(System.lineSeparator());

        assertThat(engine.generate(em -> true, new HeadOffice().getReport), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForProgrammersInHtml() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee workerIvan = new Employee("Ivan", now, now, 100);
        Employee workerNick = new Employee("Nick", now, now, 500);
        store.add(workerIvan);
        store.add(workerNick);
        Report engine = new HtmlReport(store);
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
        assertThat(engine.generate(em -> true, new ProgrammersDepartment().getReport), is(expect));
    }

    @Test
    public void whenGeneratedForProgrammersInJson() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee workerIvan = new Employee("Ivan", now, now, 100);
        Employee workerNick = new Employee("Nick", now, now, 500);
        store.add(workerIvan);
        store.add(workerNick);
        Report engine = new JsonReport(store);
        String expect = StringEscapeUtils.escapeJson(new StringBuilder()
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
        assertThat(engine.generate(em -> true, new ProgrammersDepartment().getReport), is(expect));
    }

    @Test
    public void whenGeneratedForProgrammersInXml() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee workerIvan = new Employee("Ivan", now, now, 100);
        Employee workerNick = new Employee("Nick", now, now, 500);
        store.add(workerIvan);
        store.add(workerNick);
        Report engine = new XmlReport(store);
        String expect = StringEscapeUtils.escapeXml11(new StringBuilder()
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
        assertThat(engine.generate(em -> true, new ProgrammersDepartment().getReport), is(expect));
    }

    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee workerIvan = new Employee("Ivan", now, now, 100);
        Employee workerNick = new Employee("Nick", now, now, 500);
        store.add(workerIvan);
        store.add(workerNick);
        StandardReport engine = new StandardReport(store);
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
        assertThat(engine.generate(em -> true, new HrDepartment().getReport), is(expect));
    }

    @Test
    public void whenGeneratedForBookkeepers() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee workerIvan = new Employee("Ivan", now, now, 100);
        Employee workerNick = new Employee("Nick", now, now, 500);
        store.add(workerIvan);
        store.add(workerNick);
        StandardReport engine = new StandardReport(store);
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
        assertThat(engine.generate(em -> true, new BookkeeperDepartment().getReport), is(expect));
    }

}