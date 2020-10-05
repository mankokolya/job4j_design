package designe.srp;

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

        String expect = "Name; Hired; Fired; Salary;" + System.lineSeparator()
                + workerIvan.getName() + ";" + workerIvan.getHired() + ";"
                + workerIvan.getFired() + ";" + workerIvan.getSalary() + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true, new HeadOffice().getReport), is(expect));
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
        String expect = StringEscapeUtils.escapeHtml4("Name; Hired; Fired; Salary;" + System.lineSeparator()
                + workerIvan.getName() + ";" + workerIvan.getHired() + ";"
                + workerIvan.getFired() + ";" + workerIvan.getSalary() + ";"
                + System.lineSeparator() + workerNick.getName() + ";"
                + workerNick.getHired() + ";" + workerNick.getFired() + ";"
                + workerNick.getSalary() + ";" + System.lineSeparator());
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
        String expect = StringEscapeUtils.escapeJson("Name; Hired; Fired; Salary;" + System.lineSeparator()
                + workerIvan.getName() + ";" + workerIvan.getHired() + ";"
                + workerIvan.getFired() + ";" + workerIvan.getSalary() + ";"
                + System.lineSeparator() + workerNick.getName() + ";"
                + workerNick.getHired() + ";" + workerNick.getFired() + ";"
                + workerNick.getSalary() + ";" + System.lineSeparator());
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
        String expect = StringEscapeUtils.escapeXml11("Name; Hired; Fired; Salary;"
                + System.lineSeparator() + workerIvan.getName() + ";"
                + workerIvan.getHired() + ";" + workerIvan.getFired() + ";"
                + workerIvan.getSalary() + ";" + System.lineSeparator()
                + workerNick.getName() + ";" + workerNick.getHired() + ";"
                + workerNick.getFired() + ";" + workerNick.getSalary() + ";" + System.lineSeparator());
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
        String expect = "Name; Salary;" + System.lineSeparator()
                + workerNick.getName() + ";" + workerNick.getSalary() + ";"
                + System.lineSeparator() + workerIvan.getName() + ";"
                + workerIvan.getSalary() + ";" + System.lineSeparator();
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
        String expect = StringEscapeUtils.escapeHtml4("Name; Hired; Fired; Salary;"
                + System.lineSeparator() + workerIvan.getName() + ";"
                + workerIvan.getHired() + ";" + workerIvan.getFired() + ";"
                + workerIvan.getSalary() / 28 + ";" + System.lineSeparator()
                + workerNick.getName() + ";" + workerNick.getHired() + ";"
                + workerNick.getFired() + ";" + workerNick.getSalary() / 28 + ";"
                + System.lineSeparator());
        assertThat(engine.generate(em -> true, new BookkeeperDepartment().getReport), is(expect));
    }

}