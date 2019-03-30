package products;

import instruments.Compositable;

import java.util.HashMap;
import java.util.Map;

public class Drink extends Product {
    public Recipe drinkRecipe;

    public static Map<String, Product> map = new HashMap<>();
    static int nextFreeId;

    private static Integer getNextFreeId() {
            nextFreeId = map.size()+1 + 100;
            return nextFreeId;
    }

    public Drink() {
        //constructor
    }

    public Drink(String name, int id, int cost, Recipe drinkRecipe) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.drinkRecipe = drinkRecipe;
    }

    //WORKS BY REFLECTION (CALLED BY CREATABLE.CREATE_SOMETHING)
    public Product createFromCommand(String input) {
        String[] arguments = input.split(" ");
        Recipe recipe = Recipe.map.get(arguments[0]);
        String name = recipe.getName();
        int id = getNextFreeId();
        int cost = Integer.parseInt(arguments[1]);
        Product drink = new Drink(name, id, cost, recipe);
        Compositable.compositor(drink, map); //add new just created drink to Drink.map
        Stock.addToStockMap(drink); //add new just created drink to Stock.map
        return drink;
    }

    public static void showDrink(Drink drink) {
        String nameDrink = drink.getName();
        Recipe recipe = drink.drinkRecipe;
        String nameRecipe = recipe.getName();
        System.out.println("Состав напитка " + nameDrink);
        System.out.println("Название рецепта, по которому приготовлен напиток: " + nameRecipe);
        System.out.println("Состав: ");
        Recipe.showThisRecipe(recipe);
    }
}
