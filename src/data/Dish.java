package data;

import chapter5.Main;

/**
 * Created by shira on 17/11/2018.
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public static Dish UNKNOWN = new Dish("unknown", false, -1, Type.OTHER);

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public static Main.CaloricLevel getCaloricLevel(Dish dish) {
        if (dish.getCalories() <= 400) return Main.CaloricLevel.DIET;
        else if (dish.getCalories() <= 700) return Main.CaloricLevel.NORMAL;
        else return Main.CaloricLevel.FAT;
    }


    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT, FISH, OTHER}
}
