package products;

import instruments.Compositable;
import instruments.Createable;
import instruments.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ingredient extends Product {
    public static Map<String, Product> map = new HashMap<>();

    public static final Ingredient SHOT = new Builder().setName("shot").setId(1).setCost(20).build();
    public static final Ingredient MILK = new Builder().setName("milk").setId(2).setCost(30).build();
    public static final Ingredient WATER = new Builder().setName("water").setId(3).setCost(1).build();
    public static final Ingredient SUGAR = new Builder().setName("sugar").setId(4).setCost(3).build();
    public static final Ingredient CINNAMON = new Builder().setName("cinnamon").setId(5).setCost(2).build();
    public static final Ingredient ICE = new Builder().setName("ice").setId(6).setCost(2).build();

    public static int nextFreeId = map.size() + 1;

    public Ingredient() {
        //CONSTRUCTOR
    }

    //WORKS BY REFLECTION (CALLED BY CREATABLE.CREATE_SOMETHING)
    public Product createFromCommand(String input) {
        String[] arguments = input.split(" ");
        String name = arguments[0];
        int id = nextFreeId;
        int cost = Integer.parseInt(arguments[1]);
        Product ingredient = new Builder().setName(name).setId(id).setCost(cost).build();
        Stock.addToStockMap(ingredient); //add new just created ingredient to stock
        return ingredient;
    }


    //BUILDER
    public static class Builder {

        private Ingredient ingredient;

        public Builder() {
            ingredient = new Ingredient();
        }

        public Builder setName(String name) {
            ingredient.name = name;
            return this;
        }

        public Builder setId(int id) {
            ingredient.id = id;
            return this;
        }

        public Builder setCost(int cost) {
            ingredient.cost = cost;
            return this;
        }

        public Ingredient build() {
            Compositable.compositor(this.ingredient, map);
            return this.ingredient;

        }


    }
}
