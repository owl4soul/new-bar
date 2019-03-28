import instruments.Compositable;
import instruments.Createable;
import products.*;

import java.io.IOException;

public class MainClass   {
    public static void main(String[] args) throws IOException {

//        Recipe recipe = (Recipe) Createable.CREATE_SOMETHING("products.Recipe shot 3 milk 4 sugar 5");
//        System.out.println(Recipe.map.get("gto"));

        Product i = Createable.CREATE_SOMETHING("products.Ingredient mandragora 666");
        Product r = Createable.CREATE_SOMETHING("products.Recipe shot 1 milk 8 mandragora 6");
        Product d = Createable.CREATE_SOMETHING("products.Drink MANDRA 890");

        System.out.println(Product.GRAND_MAP);

        System.out.println("_________________");
        System.out.println("_______Stock_____");
        Stock.showStock();

        System.out.println("________________________");
        System.out.println("________All Recipes_____");
        Recipe.showAllRecipes();

        System.out.println("_______________________________");
        System.out.println("_______________________________");
        Drink.showDrink((Drink) d);

        Stock.fillStockMap();

        System.out.println("_____________________");
        System.out.println("_____new stock_______");
        Stock.showStock();

        System.out.println("_____________________");
        System.out.println("_____________________");

        System.out.println(Product.getGRAND_MAP());

    }
}
