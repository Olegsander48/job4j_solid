package ru.job4j.foodstorage.auditor;

import ru.job4j.foodstorage.food.Food;
import ru.job4j.foodstorage.storage.*;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void addProduct(Food food) {
        if (!stores.isEmpty()) {
            for (Store store : stores) {
                if (store.add(food)) {
                    return;
                }
            }
        }
    }

    public void resort() {
        List<Food> allFood = new ArrayList<>();
        for (Store store : stores) {
            allFood.addAll(store.getAll());
            store.removeAll();
        }
        for (Food food : allFood) {
            addProduct(food);
        }
    }
}
