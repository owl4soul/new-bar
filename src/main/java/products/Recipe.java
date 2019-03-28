package products;

import instruments.Compositable;
import instruments.InputReader;
import instruments.Parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Recipe extends Product{
    public Map<Product, Integer> recipe = new HashMap<>(); //Ingredient-Count of it

    public static Map<String, Recipe> map = new HashMap<>(); //All recipes we have

    public static void showAllRecipes() {
        for (Map.Entry<String, Recipe> entry : map.entrySet()) {
            Recipe rec = entry.getValue();
            System.out.println("Состав рецепта " + entry.getKey() + ": ");
            showThisRecipe(rec);

        }
    }

    public static void showThisRecipe(Recipe rec) {
        Map<Product, Integer> recipe = rec.recipe;
        for (Map.Entry rentry : recipe.entrySet()) {
            Product product = (Product) rentry.getKey();
            String nameProduct = product.getName();
            int countProduct = (Integer) rentry.getValue();
            System.out.println(nameProduct + " = " + countProduct + " единиц");
        }
    }


    public Recipe(Map<Product, Integer> recipe) {
        this.recipe = recipe;
    }

    public void addToMap(Recipe recipe) {
        System.out.println("Имя рецепта: ");
        String nameRecipe = InputReader.read();
        map.put(nameRecipe, recipe);
    }

    public Recipe() {
    }

    public Recipe createFromCommand(String input) {
        Recipe rec = new Recipe();
        String[] substrings = Parser.parseSubstrings(input);

        for (int i = 0; i < substrings.length - 1; i = i + 2) {
            String ingredientName = substrings[i];
            int ingredientCount = Integer.parseInt(substrings[i + 1]);
            Product ingredient = Ingredient.map.get(ingredientName);

            rec = new Builder(rec).setName(ingredient, ingredientCount).build();
        }
        addToMap(rec);
        return rec;
    }

    public Map<Product, Integer> fillRecipe(Product ingredient, int count) {
        HashMap<Product, Integer> tmp = new HashMap<>();
        tmp.put(ingredient, count);
        return tmp;
    }



    @Override
    public Product create() throws IOException {
        return null;
    }

    public class Builder {
        private Recipe rec;

        public Builder() {
            Recipe rec = new Recipe();
        }

        public Builder(Recipe rec) {
            this.rec = rec;
        }

        public Recipe.Builder setName(Product ingredient, int count) {
            Map<Product, Integer> tmpp = new HashMap<>(fillRecipe(ingredient, count));
            this.rec.recipe.putAll(tmpp);
            return this;
        }

        public Recipe build() {
            return this.rec;
        }

}
}
