package designe.lsp.store;

import designe.lsp.products.Food;

import java.util.List;

public interface IStore {
    void add(Food food);
    List<Food> getAll();
}
