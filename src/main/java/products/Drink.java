package products;

public class Drink extends Product{
    public Recipe drinkRecipe;
    static int freeId = Recipe.map.size() + 1 + 100;

    public Drink() {

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

    public Drink(String name, int id, int cost, Recipe drinkRecipe) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.drinkRecipe = drinkRecipe;
    }

    public Product createFromCommand(String input) {
        String[] arguments = input.split(" ");
        Recipe recipe = Recipe.map.get(arguments[0]);
        String name = recipe.getName();
        int id = freeId;
        int cost = Integer.parseInt(arguments[1]);
        Product drink = new Drink(name, id, cost, recipe);
        Stock.addToStockMap(drink); //add new just created drink to stock
        return drink;
    }



    public Product create() {
        return new Drink();
    }
}
