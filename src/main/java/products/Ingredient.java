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

    public static final Ingredient MILK = new Builder().addName("milk").addId().addCost(30).build();
    public static final Ingredient SHOT = new Builder().addName("shot").addId().addCost(20).build();
    public static final Ingredient WATER = new Builder().addName("water").addId().addCost(1).build();
    public static final Ingredient SUGAR = new Builder().addName("sugar").addId().addCost(3).build();
    public static final Ingredient CINNAMON = new Builder().addName("cinnamon").addId().addCost(2).build();
    public static final Ingredient ICE = new Builder().addName("ice").addId().addCost(2).build();

    public static int nextFreeId = map.size();

    private static Integer getNextFreeId () {
        nextFreeId = map.size()+1;
        return nextFreeId;
    }

    public Ingredient() {
        //constructor
    }

    public Ingredient(Builder builder) {
        super(builder);
    }



    //WORKS BY REFLECTION (CALLED BY CREATABLE.CREATE_SOMETHING)
    public Product createFromCommand(String input) {
        String[] arguments = input.split(" ");
        String name = arguments[0];
        int id = nextFreeId;
        int cost = Integer.parseInt(arguments[1]);
        Product ingredient = new Builder().addName(name).addId().addCost(cost).build();
        Stock.addToStockMap(ingredient); //add new just created ingredient to stock
        return ingredient;
    }


    //BUILDER
    public static class Builder extends Ingredient {

        public Builder() {

        }

        public Builder addName(String name) {
            this.name = name;
            return this;
        }

        public Builder addId() {
            this.id = Ingredient.getNextFreeId();
            return this;
        }

        public Builder addCost(int cost) {
            this.cost = cost;
            return this;
        }

        public Ingredient build() {
            Ingredient ingredient = new Ingredient(this);
            Compositable.compositor(ingredient, map);
            return ingredient;
        }

//          Compositable.compositor(this.ingredient, map);

    }
}
