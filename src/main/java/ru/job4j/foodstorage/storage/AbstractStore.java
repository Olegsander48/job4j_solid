package ru.job4j.foodstorage.storage;

import ru.job4j.foodstorage.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractStore implements Store {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return foodList.add(food);
    }

    @Override
    public void remove(Food food) {
        foodList.remove(food);
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(foodList);
    }

    @Override
    public List<Food> findBy(Predicate<Food> predicate) {
        return foodList.stream()
                .filter(predicate)
                .toList();
    }

    @Override
    public boolean contains(Food food) {
        return foodList.contains(food);
    }

    protected List<Food> getFoodList() {
        return foodList;
    }
}
