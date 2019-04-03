package products;

import instruments.InputReader;
import instruments.Parser;

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


    public void addToMap(Recipe recipe) {
        map.put(recipe.getName(), recipe);
    }

    public Recipe() {
    }

    public Recipe createFromCommand(String input) {
        System.out.println("Задать имя рецепта: ");
        String nameRecipe = InputReader.read();
        Recipe rec = new Recipe();
        rec.setName(nameRecipe);
        String[] substrings = Parser.parseSubstrings(input);

        for (int i = 0; i < substrings.length - 1; i = i + 2) {
            String ingredientName = substrings[i];
            int ingredientCount = Integer.parseInt(substrings[i + 1]);
            Product ingredient = Ingredient.map.get(ingredientName);

            rec = new Builder(rec).addToRecipe(ingredient, ingredientCount).build();
        }
        addToMap(rec);

        return rec;
    }

    public Map<Product, Integer> fillRecipe(Product ingredient, int count) {
        HashMap<Product, Integer> tmp = new HashMap<>();
        tmp.put(ingredient, count);
        return tmp;
    }



    public class Builder {
        private Recipe rec;

        public Builder() {
            Recipe rec = new Recipe();
        }

        public Builder(Recipe rec) {
            this.rec = rec;
        }

        public Recipe.Builder addToRecipe(Product ingredient, int count) {
            Map<Product, Integer> tmp = new HashMap<>(fillRecipe(ingredient, count));
            this.rec.recipe.putAll(tmp);
            return this;
        }

        public Recipe build() {
            return this.rec;
        }

}
}
