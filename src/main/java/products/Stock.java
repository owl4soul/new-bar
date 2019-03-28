package products;

import instruments.Agregator;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Stock extends Product{
    public static Map<String, Integer> map; //Product-count

    public static void fillStockMap() {
        Set<String> set = Agregator.getSetKeys(Ingredient.map);
        for (String nameOfProduct : set) {
            map.put(nameOfProduct, 100);
        }
    }


    @Override
    public Product create() throws IOException {
        return null;
    }
}
