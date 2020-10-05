package design.lsp.store;

import design.lsp.products.Food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Warehouse implements IStore {
    List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public List<Food> getAll() {
        return Collections.unmodifiableList(foodList);
    }
}
