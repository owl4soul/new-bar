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


        Recipe.showAllRecipes();

    }
}
