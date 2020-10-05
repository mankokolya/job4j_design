package designe.lsp.products;

import java.time.LocalDate;

public class Food {
    private final String name;
    private final LocalDate expireDate;
    private final LocalDate createDate;
    private final double price;

    private int discount;


    public Food(String name, LocalDate expireDate, LocalDate createDate, double price) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
    }

    public void setDiscount(int discount) {
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
            return;
        }
        throw new IllegalArgumentException("Wrong value for sale parameter!!!");
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

    @Override
    public String toString() {
        return "Food{" + "name='" + name + '\''
                + ", expireDate=" + expireDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount + '}';
    }
}
