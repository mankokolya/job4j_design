package designe.lsp;

import designe.lsp.storage.ControlQuality;
import designe.lsp.storage.benchlife.BenchLifeTest;
import designe.lsp.storage.benchlife.IBenchLife;
import designe.lsp.storage.products.Bread;
import designe.lsp.storage.products.Food;
import designe.lsp.storage.products.Meat;
import designe.lsp.storage.store.Storage;
import designe.lsp.storage.store.Shop;
import designe.lsp.storage.store.Trash;
import designe.lsp.storage.store.Warehouse;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenProductBenchLifeUsedBelow25ThenOnlyWarehouseAdd() {
        Storage shop = new Shop();
        Storage wareHouse = new Warehouse();
        Storage trash = new Trash();
        ControlQuality quality = new ControlQuality(List.of(wareHouse, shop, trash));
        IBenchLife benchLife = new BenchLifeTest();

        Food bread = new Bread("White Bread", LocalDate.of(2020, 10, 7),
                LocalDate.of(2020, 10, 5), 25, benchLife);
        Food meat = new Meat("Pork Fillet", LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 10, 5), 120, benchLife);

        quality.distribute(List.of(bread, meat));

        assertThat(wareHouse.clear().size(), is(2));
        assertThat(trash.clear().size(), is(0));
        assertThat(shop.clear().size(), is(0));
    }

    @Test
    public void whenProductBenchLifeUsedBetween25and75ThenOnlyShopAdd() {
        Storage shop = new Shop();
        Storage wareHouse = new Warehouse();
        Storage trash = new Trash();
        ControlQuality quality = new ControlQuality(List.of(wareHouse, shop, trash));
        IBenchLife benchLife = new BenchLifeTest();

        Food bread = new Bread("White Bread", LocalDate.of(2020, 10, 7),
                LocalDate.of(2020, 10, 4), 25, benchLife);
        Food meat = new Meat("Pork Fillet", LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 10, 3), 120, benchLife);

        quality.distribute(List.of(bread, meat));

        assertThat(shop.clear().size(), is(2));
        assertThat(wareHouse.clear().size(), is(0));
        assertThat(trash.clear().size(), is(0));
    }

    @Test
    public void whenProductBenchLifeUsedBetween75and95ThenOnlyShopAddAndSetDiscount() {
        Storage shop = new Shop();
        Storage wareHouse = new Warehouse();
        Storage trash = new Trash();
        ControlQuality quality = new ControlQuality(List.of(wareHouse, shop, trash));
        IBenchLife benchLife = new BenchLifeTest();

        Food bread = new Bread("White Bread", LocalDate.of(2020, 10, 6),
                LocalDate.of(2020, 10, 1), 25, benchLife);
        Food meat = new Meat("Pork Fillet", LocalDate.of(2020, 10, 6),
                LocalDate.of(2020, 9, 30), 120, benchLife);

        quality.distribute(List.of(bread, meat));

        List<Food> foodList = shop.clear();
        Food food1 = foodList.get(0);
        Food food2 = foodList.get(1);

        assertThat(foodList.size(), is(2));
        assertThat(food1.getDiscount(), is(80));
        assertThat(food2.getDiscount(), is(83));
        assertThat(wareHouse.clear().size(), is(0));
        assertThat(trash.clear().size(), is(0));
    }

    @Test
    public void whenProductBenchLifeUsedMoreThen95ThenOnlyTrash() {
        Storage shop = new Shop();
        Storage wareHouse = new Warehouse();
        Storage trash = new Trash();
        ControlQuality quality = new ControlQuality(List.of(wareHouse, shop, trash));
        IBenchLife benchLife = new BenchLifeTest();

        Food bread = new Bread("White Bread", LocalDate.of(2020, 10, 6),
                LocalDate.of(2020, 10, 22), 25, benchLife);
        Food meat = new Meat("Pork Fillet", LocalDate.of(2020, 10, 6),
                LocalDate.of(2020, 10, 18), 120, benchLife);

        quality.distribute(List.of(bread, meat));

        assertThat(shop.clear().size(), is(0));
        assertThat(wareHouse.clear().size(), is(0));
        assertThat(trash.clear().size(), is(2));
    }
}