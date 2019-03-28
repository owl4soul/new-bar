package instruments;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import products.Product;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Agregator {

    public static Map<String, Map<String, Product>> agregateMap(Class<?> clazz) {
        Map<String, Map<String, Product>> consolidatedMap = new HashMap<>();
        String fieldName = "map"; //this name should be changed if it need to get some other map
        Set<Class<?>> set = getChildrenSubSet(clazz);
        for (Class<?> cls : set) {
            try {
                try {
                    Field field = cls.getDeclaredField(fieldName);
                    Map<String, Product> receivedMap = (Map<String, Product>) field.get(fieldName);
                    consolidatedMap.put(cls.getSimpleName(), receivedMap);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                System.out.println(e.toString());
                System.out.println("Класс " + cls.getSimpleName() +
                        " не содержит поля " + "\"" + fieldName + "\"");
            }
        }
        return consolidatedMap;
    }

    public static <T> Set<Class<? extends T>> getChildrenSubSet(Class<? extends T> cls) {
        String packageName = "products"; //this name should be changed if it need to filter search through other package
        Set<Class<? extends T>> set = new Reflections(
                ClasspathHelper.forClass(cls))
                .getSubTypesOf(cls)
                .stream()
                .filter(c -> c.getPackage().getName().equals("products"))
                .collect(Collectors.toSet());
        return set;
    }

    public static Set<String> getSetKeys(Map<String, Product> map) {
        Set<String> setKeys = map.keySet();
        return setKeys;
    }

}
