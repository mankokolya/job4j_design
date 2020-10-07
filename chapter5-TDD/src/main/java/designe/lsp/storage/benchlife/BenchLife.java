package designe.lsp.storage.benchlife;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BenchLife implements IBenchLife {

    @Override
    public int calculateBenchLife(LocalDate createDate, LocalDate expireDate) {
        long usageDays = ChronoUnit.DAYS.between(createDate, expireDate);
        long daysPassed = ChronoUnit.DAYS.between(createDate, LocalDate.now());
        return (int) ((double) daysPassed / usageDays * 100);
    }
}
