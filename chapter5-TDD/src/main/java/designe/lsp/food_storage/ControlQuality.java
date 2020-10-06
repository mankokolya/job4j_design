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
            int benchLifeUsed = benchLife.calculateBenchLife(food.getCreateDate(), food.getExpireDate());
            if (benchLifeUsed >= 75 && benchLifeUsed < 90) {
                food.setDiscount(benchLifeUsed);
            }
            dispatcher.store(food, benchLifeUsed);
        }
    }
}
