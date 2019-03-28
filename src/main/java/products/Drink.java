package products;

public class Drink extends Product{
    public Recipe drinkRecipe;
    static int freeId = Recipe.map.size() + 1 + 100;

    public Drink() {

    }

    public Drink(String name, int id, int cost, Recipe drinkRecipe) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.drinkRecipe = drinkRecipe;
    }

    public Product createFromCommand(String input) {
        Recipe recipe = Recipe.map.get(input);
        String[] arguments = input.split(" ");
        String name = arguments[0];
        int id = freeId;
        int cost = Integer.parseInt(arguments[1]);
        Product drink = new Drink(name, id, cost, recipe);
        Stock.addToStockMap(drink); //add new just created drink to stock
        return drink;
    }

    public static void showDrink(Drink drink) {
//        drink.drinkRecipe;
    }


    public Product create() {
        return new Drink();
    }
}
