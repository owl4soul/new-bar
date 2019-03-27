package products;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Agregator {
    public static Map<String, Map<String, Product>> agregateMap(Class<?> cls) {
        Map<String, Map<String, Product>> GRAND_MAP = new HashMap<String, Map<String, Product>>(); //TODO убедиться, что final не создаст проблем
        Set<Class<?>> set = getChildrenSubSet(cls);
        for (Class<?> c : set) {
            try {
                try {
                    Field mas = c.getDeclaredField("map");
                    Map<String, Product> mp;
                    mp = (Map<String, Product>) mas.get("map");
                    GRAND_MAP.put(c.getSimpleName(), mp);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return GRAND_MAP;
    }

    public static Set<Class<?>> getChildrenSubSet(Class<?> cls) {
        Set<Class<? extends cls>> set = (Set<Class<? extends cls>>) new Reflections(
                ClasspathHelper.forClass(cls))
                .getSubTypesOf(cls)
                .stream()
                .filter(c -> c.getPackage().getName().equals("products"))
                .collect(Collectors.toSet());
        return (Set<Class<?>>) set;
    }
}
