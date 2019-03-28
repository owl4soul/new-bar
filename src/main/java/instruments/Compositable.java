package instruments;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import products.Product;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public interface Compositable {
    //Здесь будут getSimpleClassNames наследников и их перечни
    Map<String, Map<String, Product>> GRAND_MAP = new HashMap<String, Map<String, Product>>(); //TODO убедиться, что final не создаст проблем
    Set<Class<? extends Product>> set = new Reflections(
            ClasspathHelper.forClass(Product.class))
            .getSubTypesOf(Product.class)
            .stream()
            .filter(c->c.getPackage().getName().equals("products"))
            .collect(Collectors.toSet());

    static void getGrand(Set<Class<? extends Product>> set) {


        for (Class<? extends Product> c :set) {
            try {
                Field mas = c.getDeclaredField("map");
                Map<String, Product> mp = new HashMap<String, Product>();
                try {
                    mp.putAll((Map<? extends String, ? extends Product>) mas.get("map"));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                GRAND_MAP.put(c.getSimpleName(), mp);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    static void compositor(Product product, Map <String, Product> map) {
        String name = product.getName();
        map.put(name, product);
    }

    static void searchThrowAll(String string) {

    }
}
