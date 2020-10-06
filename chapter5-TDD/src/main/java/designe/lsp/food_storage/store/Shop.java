package designe.lsp.food_storage.store;

import designe.lsp.food_storage.products.Food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop implements IStore {
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
