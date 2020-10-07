package designe.lsp.storage.products;

import designe.lsp.storage.benchlife.IBenchLife;

import java.time.LocalDate;

public class Food {
    private final String name;
    private final LocalDate expireDate;
    private final LocalDate createDate;
    private final double price;
    private int discount;
    private IBenchLife benchLifeUsed;


    public Food(String name, LocalDate expireDate, LocalDate createDate, double price, IBenchLife benchLifeUsed) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.benchLifeUsed = benchLifeUsed;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public int getDiscount() {
        return discount;
    }

    public int getBenchLifeUsed() {
        int benchLifeUsed = this.benchLifeUsed.calculateBenchLife(this.createDate, this.expireDate);
        if (benchLifeUsed >= 75 && benchLifeUsed < 90) {
            discount = benchLifeUsed;
        }
        return benchLifeUsed;
    }

    @Override
    public String toString() {
        return "Food{" + "name='" + name + '\''
                + ", expireDate=" + expireDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount + '}';
    }
}
