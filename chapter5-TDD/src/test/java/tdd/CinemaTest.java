//package tdd;
//
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
//
//public class CinemaTest {
//    @Test
//    public void buy() {
//        Cinema cinema3D = new Cinema3D();
//        Account account = new AccountCinema();
//        Calendar date = Calendar.getInstance();
//        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
//        Ticket ticket = cinema3D.buy(account, 1, 1, date);
//        assertThat(ticket, is(new Ticket3D()));
//    }
//
//    @Test
//    public void find() {
//        Cinema cinema3D = new Cinema3D();
//        cinema3D.add(new Session3D());
//        List<Session> sessions = cinema3D.find(session -> true);
//        assertThat(sessions, is(Arrays.asList(new Session3D())));
//    }
//
//    @Test
//    public void add(Session session) {
//        Cinema cinema3D = new Cinema3D();
//        cinema3D.add(session);
//        assertTrue(cinema3D.find(session1 -> true).contains(session));
//    }
//}