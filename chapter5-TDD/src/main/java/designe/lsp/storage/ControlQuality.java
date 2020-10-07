package designe.lsp.storage;

import designe.lsp.storage.products.Food;
import designe.lsp.storage.store.Storage;

import java.util.List;

public class ControlQuality {
    private final List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void distribute(List<Food> foods) {
        for (Food food : foods) {
            storages.stream()
                    .filter(storage -> storage.accept(food))
                    .forEach(storage -> storage.add(food));
        }
    }
}
