package design.lsp;

import design.lsp.products.Food;
import design.lsp.store.IStore;
import design.lsp.store.Shop;
import design.lsp.store.Trash;
import design.lsp.store.Warehouse;

import java.util.List;

public class ControlQuality {
    private IStore shop = new Shop();
    private IStore wareHouse = new Warehouse();
    private IStore trash = new Trash();
    DispatchStorageBetwStores dispatcher = new DispatchStorageBetwStores(shop, wareHouse, trash).init();

    public void controlFood(List<Food> foods) {
        for (Food food : foods) {
            dispatcher.access(food);
        }
    }
}
