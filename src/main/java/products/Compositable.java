package products;

import java.util.Map;

public interface Compositable {

    static void compositor(Product product, Map <String, Product> map) {
        String name = product.getName();
        map.put(name, product);
    }

    static void searchThrowAll(String string) {

    }
}
