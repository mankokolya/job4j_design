package designe.lsp.food_storage;

import designe.lsp.food_storage.benchlife.IBenchLife;
import designe.lsp.food_storage.products.Food;

import java.util.List;

public class ControlQuality {
   private final DispatchStorageBetweenStores dispatcher;

    public ControlQuality(DispatchStorageBetweenStores dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void controlFood(List<Food> foods, IBenchLife benchLife) {
        for (Food food : foods) {
            dispatcher.store(food, benchLife);
        }
    }
}
