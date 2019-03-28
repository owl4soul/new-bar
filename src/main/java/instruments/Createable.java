package instruments;

import instruments.Parser;
import products.Ingredient;
import products.Product;
import products.Recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public interface Createable {
    static Product getProduction(Product type) throws IOException {
        return type.create();
    }

    static void createAbstract() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Для создания нового продукта введите одной строкой его параметры через пробел:" +
                "\"String int\""); //TODO возможно, здесь будет обработака не только Строка-число
        try {
            String input = reader.readLine();
            CREATE_SOMETHING(input);
//            String[] substrings = Parser.parseSubstrings(input);
//
//            if (substrings.length > 2) {
////                createRecipe()
////                createComplex();
//            } else {
////                createPrimitive(substrings);
//            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
            e.printStackTrace();
        }

    }

    default Recipe createRecipe(String[] substrings) {
        Map<String, Integer> subs = Parser.getMapStringInteger(substrings);
        Map<Product, Integer> map = new HashMap<>();
//        Recipe recipe = new Recipe();
//        recipe.put()
        return null;
    }

    default Product createPrimitive(String[] substrings) {

        return null;
    }

    default Product createComplex(String[] substrings) {
        return null;
    }

    default Product createElement(String name) {
        return null;
    }


    static Product CREATE_SOMETHING(String nameOfClassAndParameters) {
        //Get first word with name of class
        Product product = null;
        String nameOfClass = nameOfClassAndParameters.substring(0, nameOfClassAndParameters.indexOf(" "));
        String andParameters = nameOfClassAndParameters.replaceFirst(nameOfClass.concat(" "), "");
        System.out.println(andParameters); //TODO test

        Product.GRAND_MAP = Product.getGRAND_MAP(); //TODO change to setter
        try {
            Class clazz = Class.forName(nameOfClass);
            Object qwer = clazz.newInstance();
//            Map<String, Product> map = Product.GRAND_MAP.get(clazz.getSimpleName());
            Method method = clazz.getDeclaredMethod("createFromCommand", String.class);
            product = (Product) method.invoke(qwer, andParameters);
            return product;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return product;
    }
}
