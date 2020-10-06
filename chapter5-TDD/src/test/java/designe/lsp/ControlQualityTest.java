package designe.lsp;

import designe.lsp.food_storage.ControlQuality;
import designe.lsp.food_storage.DispatchStorageBetweenStores;
import designe.lsp.food_storage.benchlife.BenchLifeTest;
import designe.lsp.food_storage.benchlife.IBenchLife;
import designe.lsp.food_storage.products.Bread;
import designe.lsp.food_storage.products.Food;
import designe.lsp.food_storage.products.Meat;
import designe.lsp.food_storage.store.IStore;
import designe.lsp.food_storage.store.Shop;
import designe.lsp.food_storage.store.Trash;
import designe.lsp.food_storage.store.Warehouse;
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
        IBenchLife benchLife = new BenchLifeTest();

        Food bread = new Bread("White Bread", LocalDate.of(2020, 10, 7),
                LocalDate.of(2020, 10, 5), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 10, 5), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        quality.controlFood(foods, benchLife);
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
        IBenchLife benchLife = new BenchLifeTest();

        Food bread = new Bread("White Bread", LocalDate.of(2020, 10, 7),
                LocalDate.of(2020, 10, 4), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 10, 3), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        quality.controlFood(foods, benchLife);
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
        IBenchLife benchLife = new BenchLifeTest();

        Food bread = new Bread("White Bread", LocalDate.of(2020, 10, 6),
                LocalDate.of(2020, 10, 1), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.of(2020, 10, 6),
                LocalDate.of(2020, 9, 30), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        quality.controlFood(foods, benchLife);
        List<Food> foodList = shop.getAll();
        Food food1 = foodList.get(0);
        Food food2 = foodList.get(1);

        assertThat(foodList.size(), is(2));
        assertThat(food1.getDiscount(), is(80));
        assertThat(food2.getDiscount(), is(83));
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
        IBenchLife benchLife = new BenchLifeTest();

        Food bread = new Bread("White Bread", LocalDate.of(2020, 10, 6),
                LocalDate.of(2020, 10, 22), 25);
        Food meat = new Meat("Pork Fillet", LocalDate.of(2020, 10, 6),
                LocalDate.of(2020, 10, 18), 120);
        List<Food> foods = new ArrayList<>();
        foods.add(bread);
        foods.add(meat);

        quality.controlFood(foods, benchLife);

        assertThat(shop.getAll().size(), is(0));
        assertThat(wareHouse.getAll().size(), is(0));
        assertThat(trash.getAll().size(), is(2));
    }
}