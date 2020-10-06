package designe.lsp.food_storage.store;

import designe.lsp.food_storage.products.Food;

import java.util.List;

public interface IStore {
    void add(Food food);
    List<Food> getAll();
}
