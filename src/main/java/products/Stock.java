package products;

import instruments.Agregator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Stock extends Product{
    public static Map<String, Integer> map = new HashMap<>(); //Product-count

    public static void fillStockMap() {
        Set<String> set = Agregator.getSetKeys(Ingredient.map);
        for (String nameOfProduct : set) {
            map.put(nameOfProduct, 100);
        }
    }

    public static void addToStockMap(Product product) {
        map.put(product.getName(), 1000); //TODO позже сделать возможность установки кол-ва на складе
    }

    public static void showStock() {
        System.out.println("Результаты инвентаризации складских запасов: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " единиц");
        }
    }


    @Override
    public Product create() throws IOException {
        return null;
    }
}
