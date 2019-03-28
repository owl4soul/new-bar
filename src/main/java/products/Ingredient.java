package products;

import instruments.Compositable;
import instruments.Createable;
import instruments.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ingredient extends Product  {

    public static Map<String, Product> map = new HashMap<>();

    public void addToMap() {

        Compositable.compositor(this, map);
    }



    public static final Ingredient SHOT = new Builder().setName("shot").setId(1).setCost(20).build();
    public static final Ingredient MILK = new Builder().setName("milk").setId(2).setCost(30).build();
    public static final Ingredient WATER = new Builder().setName("water").setId(3).setCost(1).build();
    public static final Ingredient SUGAR = new Builder().setName("sugar").setId(4).setCost(3).build();
    public static final Ingredient CINNAMON = new Builder().setName("cinnamon").setId(5).setCost(2).build();
    public static final Ingredient ICE = new Builder().setName("ice").setId(6).setCost(2).build();

    public static int nextFreeId = map.size() + 1;

    public Product createFromCommand(String input) {
        String[] arguments = input.split(" ");
        String name = arguments[0];
        int id = nextFreeId;
        int cost = Integer.parseInt(arguments[1]);
        Product ingredient = new Builder().setName(name).setId(id).setCost(cost).build();
        return ingredient;
    }


    public Product create() throws IOException {
        System.out.println("enter: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Product product = Createable.CREATE_SOMETHING(input);

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Для создания нового ингредиента введите одной строкой его параметры:" +
//                "\"name cost\"");
//        try {
//            String input = reader.readLine();
//            String [] subs = Parser.parseSubstrings(input);
//            if (subs.length > 2) {
//                throw new IOException();
//            }
//            String nameInput = subs[0];
//            int costInput = Integer.parseInt(subs[1]);
//            Product ingredient = new Builder().setName(nameInput).setId(nextFreeId).setCost(costInput).build();
//            ((Ingredient) ingredient).addToMap();
//            return ingredient;
//        } catch (IOException e) {
//            System.out.println("Ошибка ввода.");
//            e.printStackTrace();
//            return null;
//        }
        return product;
    }

    public Ingredient() {
        //private constructor
    }

//    public void putToIngredientTypes() {
//        ingredientTypes.put(this.getName(), this);
//    }


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
//            this.ingredient.addToMap();
            Compositable.compositor(this.ingredient, map);
            return this.ingredient;

//            if (!(ingredient.name == null) && !(ingredient.id >= 0)) {
//                return this.ingredient;
//            } else {
//                System.out.println("Создание объекта невозможно. Проверьте параметры.");
//            }
//            return null;
        }
    }

}
