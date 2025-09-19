package ru.job4j.foodstorage.auditor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.foodstorage.food.*;
import ru.job4j.foodstorage.storage.Shop;
import ru.job4j.foodstorage.storage.Trash;
import ru.job4j.foodstorage.storage.Warehouse;
import ru.job4j.foodstorage.storage.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    private List<Store> stores;

    @BeforeEach
    void setListOfStores() {
        stores = new ArrayList<>();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        stores.add(shop);
        stores.add(warehouse);
        stores.add(trash);
    }

    /**
     * Test case: the food's expiration date has less than 25% remaining, the product should be sent to the warehouse.
     */
    @Test
    void whenAddNewMilkThenGetItInWarehouse() {
        ControlQuality controlQuality = new ControlQuality(stores);
        Milk milk = new Milk("Minskaya marka",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 9, 17, 11, 34),
                3,
                0,
                3.6,
                900);
        controlQuality.addProduct(milk);
        assertThat(stores.get(0).getAll()).isEmpty();
        assertThat(stores.get(1).getAll())
                .isNotEmpty()
                .contains(milk);
        assertThat(stores.get(2).getAll()).isEmpty();
    }

    /**
     * Test case: the food's expiration date has more than 100% remaining, the product should be sent to the trash.
     */
    @Test
    void whenAddExpiredMilkThenGetItInTrash() {
        ControlQuality controlQuality = new ControlQuality(stores);
        Milk milk = new Milk("Minskaya marka",
                LocalDateTime.of(2024, 12, 30, 17, 25),
                LocalDateTime.of(2024, 9, 17, 11, 34),
                3,
                0,
                3.6,
                900);
        controlQuality.addProduct(milk);
        assertThat(stores.get(0).getAll()).isEmpty();
        assertThat(stores.get(1).getAll()).isEmpty();
        assertThat(stores.get(2).getAll())
                .isNotEmpty()
                .contains(milk);
    }

    /**
     * Test case: the food's expiration date has more than 25% and less than 75% remaining, the product should be sent to the shop.
     */
    @Test
    void whenAddMeatThenGetItInShop() {
        ControlQuality controlQuality = new ControlQuality(stores);
        Meat meat = new Meat("neck",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 6, 17, 11, 34),
                34,
                0,
                MeatType.PORK,
                2100);
        controlQuality.addProduct(meat);
        assertThat(stores.get(0).getAll())
                .isNotEmpty()
                .contains(meat);
        assertThat(stores.get(1).getAll()).isEmpty();
        assertThat(stores.get(2).getAll()).isEmpty();
    }

    /**
     * Test case: the food's expiration date has more than 75% remaining, the product should be sent to the shop with 20% discount
     */
    @Test
    void whenAddMeatThenGetItInShopWithDiscount() {
        ControlQuality controlQuality = new ControlQuality(stores);
        Meat meat = new Meat("neck",
                LocalDateTime.of(2025, 9, 30, 17, 25),
                LocalDateTime.of(2025, 6, 17, 11, 34),
                34,
                0,
                MeatType.PORK,
                2100);
        int originalPrice = meat.getPrice();
        controlQuality.addProduct(meat);
        
        assertThat(stores.get(0).getAll())
                .isNotEmpty()
                .contains(meat);
        assertThat(stores.get(1).getAll()).isEmpty();
        assertThat(stores.get(2).getAll()).isEmpty();
        
        assertThat(meat.getPrice()).isEqualTo((int) (originalPrice * 0.8));
        assertThat(meat.getDiscount()).isEqualTo(20);
    }

    /**
     * Test case: checking that if there is no necessary storage, the product will not get anywhere.
     */
    @Test
    void whenAddNewMilkButRemoveWarehouseThenAllStoresEmpty() {
        stores.remove(1);
        ControlQuality controlQuality = new ControlQuality(stores);
        Milk milk = new Milk("Minskaya marka",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 9, 17, 11, 34),
                3,
                0,
                3.6,
                900);
        controlQuality.addProduct(milk);
        assertThat(stores).hasSize(2);
        assertThat(stores.get(0).getAll()).isEmpty();
        assertThat(stores.get(1).getAll()).isEmpty();
    }

    /**
     * Test case: checking that after resort same product stay at the same store
     */
    @Test
    void whenAddNewMilkAndResortThenMilkInWarehouse() {
        ControlQuality controlQuality = new ControlQuality(stores);
        Milk milk = new Milk("Minskaya marka",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 9, 17, 11, 34),
                3,
                0,
                3.6,
                900);
        controlQuality.addProduct(milk);

        controlQuality.resort();
        
        assertThat(stores.get(0).getAll()).isEmpty();
        assertThat(stores.get(1).getAll())
                .isNotEmpty()
                .contains(milk);
        assertThat(stores.get(2).getAll()).isEmpty();
    }

    /**
     * Test case: checking that after resort same product stay at the same store
     */
    @Test
    void whenAddMilkBreadAndAndMeatAndResortThenFoodInSameStores() {
        ControlQuality controlQuality = new ControlQuality(stores);
        Milk milk = new Milk("Minskaya marka",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 9, 17, 11, 34),
                3,
                0,
                3.6,
                900);
        controlQuality.addProduct(milk);

        controlQuality.resort();

        assertThat(stores.get(0).getAll()).isEmpty();
        assertThat(stores.get(1).getAll())
                .isNotEmpty()
                .contains(milk);
        assertThat(stores.get(2).getAll()).isEmpty();
    }

    /**
     * Test case: checking that after resort all products at the same stores
     */
    @Test
    void whenAddNewMilkAndChangeCreationDateToOldAndResortThenMilkInShopWithDiscount() {
        ControlQuality controlQuality = new ControlQuality(stores);
        int originalPrice = 3;
        Milk milk = new Milk("Minskaya marka",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 9, 17, 11, 34),
                originalPrice,
                0,
                3.6,
                900);
        Meat meat = new Meat("neck",
                LocalDateTime.of(2025, 12, 30, 17, 25),
                LocalDateTime.of(2025, 6, 17, 11, 34),
                34,
                0,
                MeatType.PORK,
                2100);
        Bread bread = new Bread("Borodinskiy",
                LocalDateTime.of(2025, 5, 30, 17, 25),
                LocalDateTime.of(2025, 1, 8, 11, 34),
                25,
                0,
                230.50);
        controlQuality.addProduct(milk);
        controlQuality.addProduct(meat);
        controlQuality.addProduct(bread);

        controlQuality.resort();

        assertThat(stores.get(0).getAll())
                .isNotEmpty()
                .contains(meat);
        assertThat(stores.get(1).getAll())
                .isNotEmpty()
                .contains(milk);
        assertThat(stores.get(2).getAll())
                .isNotEmpty()
                .contains(bread);
    }
}