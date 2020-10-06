package designe.lsp.food_storage;

import designe.lsp.food_storage.products.Food;
import designe.lsp.food_storage.store.IStore;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class DispatchStorageBetweenStores {
    private final IStore shop;
    private final IStore wareHouse;
    private final IStore trash;

    private final Map<Function<Integer, Boolean>, Consumer<Food>> storesDistribution = new LinkedHashMap<>();

    public DispatchStorageBetweenStores(IStore shop, IStore wareHouse, IStore trash) {
        this.shop = shop;
        this.wareHouse = wareHouse;
        this.trash = trash;
    }

    public DispatchStorageBetweenStores init() {
        this.storesDistribution.put(
                integer -> integer < 25,
                wareHouse::add
        );

        this.storesDistribution.put(
                integer -> integer >= 25 && integer < 90,
                shop::add
        );

        this.storesDistribution.put(
                integer -> integer >= 90,
                trash::add
        );
        return this;
    }

    /**
     * Load food and predict.
     *
     * @param predict Predict.
     * @param store   IStore.
     */
    public void load(Function<Integer, Boolean> predict, Consumer<Food> store) {
        this.storesDistribution.put(predict, store);
    }

    /**
     * Check to what store the food must go.
     *
     * @param food Food
     */
    public void store(Food food, int benchLifeUsed) {
        for (Function<Integer, Boolean> predict : this.storesDistribution.keySet()) {

            if (predict.apply(benchLifeUsed)) {
                this.storesDistribution.get(predict).accept(food);
                return;
            }
        }
        throw new IllegalStateException("Could not found a handle for food");
    }
}
