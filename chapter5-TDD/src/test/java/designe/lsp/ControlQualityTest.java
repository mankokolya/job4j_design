package designe.lsp;

import designe.lsp.products.Bread;
import designe.lsp.products.Food;
import designe.lsp.products.Meat;
import designe.lsp.store.IStore;
import designe.lsp.store.Shop;
import designe.lsp.store.Trash;
import designe.lsp.store.Warehouse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenProductBenchLifeUsedBelow25ThenOnlyWarehouseAdd() {
        IStore shop = new Shop();
        IStore wareHouse = new Warehouse();
        IStore trash = new Trash();
        DispatchStorageBetweenStores dispatcher = new DispatchStorageBetweenStores(shop, wareHouse, trash).init();
        ControlQuality quality = new ControlQuality(dispatcher);

        Food bread = new Bread("White Bread", LocalDate.now().plusDays(2), LocalDate.now(), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.now().plusDays(5), LocalDate.now(), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        quality.controlFood(foods);
        assertThat(wareHouse.getAll().size(), is(2));
        assertThat(trash.getAll().size(), is(0));
        assertThat(shop.getAll().size(), is(0));
    }

    @Test
    public void whenProductBenchLifeUsedBetween25and75ThenOnlyShopAdd() {
        IStore shop = new Shop();
        IStore wareHouse = new Warehouse();
        IStore trash = new Trash();
        DispatchStorageBetweenStores dispatcher = new DispatchStorageBetweenStores(shop, wareHouse, trash).init();
        ControlQuality quality = new ControlQuality(dispatcher);

        Food bread = new Bread("White Bread", LocalDate.now().plusDays(2), LocalDate.now().minusDays(1), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.now().plusDays(5), LocalDate.now().minusDays(2), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        quality.controlFood(foods);
        assertThat(shop.getAll().size(), is(2));
        assertThat(wareHouse.getAll().size(), is(0));
        assertThat(trash.getAll().size(), is(0));
    }

    @Test
    public void whenProductBenchLifeUsedBetween75and95ThenOnlyShopAddAndSetDiscount() {
        IStore shop = new Shop();
        IStore wareHouse = new Warehouse();
        IStore trash = new Trash();
        DispatchStorageBetweenStores dispatcher = new DispatchStorageBetweenStores(shop, wareHouse, trash).init();
        ControlQuality quality = new ControlQuality(dispatcher);

        Food bread = new Bread("White Bread", LocalDate.now().plusDays(1), LocalDate.now().minusDays(4), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.now().plusDays(1), LocalDate.now().minusDays(9), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        quality.controlFood(foods);
        List<Food> foodList = shop.getAll();
        Food food1 = foodList.get(0);
        Food food2 = foodList.get(1);

        assertThat(foodList.size(), is(2));
        assertThat(food1.getDiscount(), is(80));
        assertThat(food2.getDiscount(), is(90));
        assertThat(wareHouse.getAll().size(), is(0));
        assertThat(trash.getAll().size(), is(0));
    }

    @Test
    public void whenProductBenchLifeUsedMoreThen95ThenOnlyTrash() {
        IStore shop = new Shop();
        IStore wareHouse = new Warehouse();
        IStore trash = new Trash();
        DispatchStorageBetweenStores dispatcher = new DispatchStorageBetweenStores(shop, wareHouse, trash).init();
        ControlQuality quality = new ControlQuality(dispatcher);

        Food bread = new Bread("White Bread", LocalDate.now().plusDays(1), LocalDate.now().minusDays(13), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.now().plusDays(1), LocalDate.now().minusDays(17), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        quality.controlFood(foods);

        assertThat(shop.getAll().size(), is(0));
        assertThat(wareHouse.getAll().size(), is(0));
        assertThat(trash.getAll().size(), is(2));
    }


}