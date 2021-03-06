package designe.lsp.storage;

import designe.lsp.storage.products.Food;
import designe.lsp.storage.store.Storage;

import java.util.List;
import java.util.stream.Collectors;

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

    public void resort() {
        List<Food> foodsToResort = storages.stream()
                .map(Storage::clear)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        distribute(foodsToResort);
    }
}
