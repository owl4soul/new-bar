import instruments.Createable;
import products.*;


public class MainClass {
    public static void main(String[] args) {
        Product i = Createable.CREATE_SOMETHING("products.Ingredient mandragora 666");
        Product ii = Createable.CREATE_SOMETHING("products.Ingredient blood 888");
        Product r = Createable.CREATE_SOMETHING("products.Recipe shot 1 milk 8 mandragora 6");
        Product rr = Createable.CREATE_SOMETHING("products.Recipe shot 4 milk 5 blood 4");

        Product d = Createable.CREATE_SOMETHING("products.Drink MANDRA 890");
//        Product dd = Createable.CREATE_SOMETHING("products.Drink VAMP 890");

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
