package designe.lsp.storage.store;

import designe.lsp.storage.products.Food;

public class Trash extends Store {

    @Override
    public boolean accept(Food food) {
        return food.getBenchLifeUsed() >= 90;
    }
}
