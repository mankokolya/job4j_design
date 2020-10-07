package designe.lsp.storage.benchlife;

import java.time.LocalDate;

public interface IBenchLife {
    int calculateBenchLife(LocalDate createDate, LocalDate expireDate);
}
