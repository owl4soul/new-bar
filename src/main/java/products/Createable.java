package products;

import instruments.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public interface Createable {
    static Product getProduction(Product type) {
        return type.create();
    }

    default void createAbstract() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для создания нового продукта введите одной строкой его параметры через пробел:" +
                "\"String int\""); //TODO возможно, здесь будет обработака не только Строка-число
        try {
            String input = reader.readLine();
            String[] substrings = Parser.parseSubstrings(input);

            if (substrings.length > 2) {
//                createRecipe()
                createComplex();
            } else {
                createPrimitive(substrings);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
            e.printStackTrace();
        }
    }

    default Recipe createRecipe(String[] substrings) {
        Map<String, Integer> subs = Parser.getMapStringInteger(substrings);
        Map<Product, Integer> recipe = new HashMap<>();
//        recipe.put()
        return null;
    }

    default Product createPrimitive(String[] substrings) {
        return null;

    }

    default Product createComplex() {
        return null;
    }

    default Product createElement(String name) {
        return null;
    }
}
