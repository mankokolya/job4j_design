package design.lsp;

import design.lsp.benchLife.BenchLife;
import design.lsp.products.Food;
import design.lsp.store.IStore;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class DispatchStorageBetwStores {
    private IStore shop;
    private IStore wareHouse;
    private IStore trash;

    private Map<Function<Integer, Boolean>, Consumer<Food>> storesDistribution = new LinkedHashMap<>();

    public DispatchStorageBetwStores(IStore shop, IStore wareHouse, IStore trash) {
        this.shop = shop;
        this.wareHouse = wareHouse;
        this.trash = trash;
    }

    public DispatchStorageBetwStores init() {
        this.storesDistribution.put(
                integer -> integer < 25,
                food -> wareHouse.add(food)
        );

        this.storesDistribution.put(
                integer -> integer >= 25 && integer < 75,
                food -> shop.add(food)
        );

        this.storesDistribution.put(
                integer -> integer >= 75 && integer < 95,
                food -> shop.add(food.setDiscount(new BenchLife().calculateBenchLife(food.getCreateDate(), food.getExpireDate())))
        );

        this.storesDistribution.put(
                integer -> integer >= 95,
                food -> trash.add(food)
        );
        return this;
    }

    /**
     * Load store and predict.
     * @param predict Predict.
     * @param store IStore.
     */
    public void load(Function<Integer, Boolean> predict, Consumer<Food> store) {
        this.storesDistribution.put(predict, store);
    }

    /**
     * Check access for person by age.
     * @param food Food
     * @return true if access are allowed
     */
    public void access(Food food) {
        for (Function<Integer, Boolean> predict : this.storesDistribution.keySet()) {
            if (predict.apply(new BenchLife().calculateBenchLife(food.getCreateDate(), food.getExpireDate()))) {
                this.storesDistribution.get(predict).accept(food);
                return;
            }
        }
        throw new IllegalStateException("Could not found a handle for food");
    }
}
