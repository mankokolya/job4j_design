package designe.lsp.food_storage.benchlife;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BenchLifeTest implements IBenchLife {

    @Override
    public int calculateBenchLife(LocalDate createDate, LocalDate expireDate) {
        long usageDays = ChronoUnit.DAYS.between(createDate, expireDate);
        long daysPassed = ChronoUnit.DAYS.between(createDate, LocalDate.of(2020, 10, 5));
        return (int) ((double) daysPassed / usageDays * 100);
    }
}