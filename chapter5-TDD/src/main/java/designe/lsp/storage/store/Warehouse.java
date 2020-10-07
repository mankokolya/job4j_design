package designe.lsp.storage.store;

import designe.lsp.storage.products.Food;

public class Warehouse extends Store {
    @Override
    public boolean accept(Food food) {
        return food.getBenchLifeUsed() >= 0 && food.getBenchLifeUsed() < 25;
    }
}
