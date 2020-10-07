package designe.lsp.storage.store;

import designe.lsp.storage.products.Food;

public class Shop extends Store {

    @Override
    public boolean accept(Food food) {
        return food.getBenchLifeUsed() >= 25 && food.getBenchLifeUsed() < 90;
    }
}
