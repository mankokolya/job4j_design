package designe.lsp.storage.store;

import designe.lsp.storage.products.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class Store implements Storage {
    List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public abstract boolean accept(Food food);

    @Override
    public List<Food> clear() {
        List<Food> copy = foodList;
        foodList = null;
        return copy;
    }
}
