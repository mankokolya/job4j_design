package designe.lsp.storage.store;

import designe.lsp.storage.products.Food;

import java.util.List;

public interface Storage {
    void add(Food food);
    boolean accept(Food food);
    List<Food> clear();
}
