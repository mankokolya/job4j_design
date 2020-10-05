package design.lsp.benchLife;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BenchLife {

    public int calculateBenchLife(LocalDate createDate, LocalDate expireDate) {
        long usageDays = ChronoUnit.DAYS.between(createDate, expireDate);
        long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), expireDate);
        return (int) ((double) daysLeft / usageDays * 100);
    }
}
