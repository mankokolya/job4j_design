package designe.lsp;

import designe.lsp.products.Food;

import java.util.List;

public class ControlQuality {
   private final DispatchStorageBetweenStores dispatcher;

    public ControlQuality(DispatchStorageBetweenStores dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void controlFood(List<Food> foods) {
        for (Food food : foods) {
            dispatcher.access(food);
        }
    }
}
