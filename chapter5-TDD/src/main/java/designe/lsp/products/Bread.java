package designe.lsp.products;

import java.time.LocalDate;

public class Bread extends Food {

    public Bread(String name, LocalDate expireDate, LocalDate createDate, double price) {
        super(name, expireDate, createDate, price);
    }
}
