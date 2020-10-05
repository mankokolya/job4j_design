package design.lsp.store;

import design.lsp.products.Food;

import java.util.List;

public interface IStore {
    void add(Food food);
    List<Food> getAll();
}
