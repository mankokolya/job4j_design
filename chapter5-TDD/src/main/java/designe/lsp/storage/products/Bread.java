package designe.lsp.storage.products;

import designe.lsp.storage.benchlife.IBenchLife;

import java.time.LocalDate;

public class Bread extends Food {

    public Bread(String name, LocalDate expireDate, LocalDate createDate, double price, IBenchLife benchLifeUsed) {
        super(name, expireDate, createDate, price, benchLifeUsed);
    }
}
