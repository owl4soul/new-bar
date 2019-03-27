package products;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Product implements Compositable, Createable {
        static Map<String, Map<String, Product>> GRAND_MAP = new HashMap<String, Map<String, Product>>(); //TODO убедиться, что final не создаст проблем

    public static void getGRAND_MAP() {
        GRAND_MAP = Agregator.agregateMap(Product.class);
        System.out.println(GRAND_MAP.size());
        System.out.println(GRAND_MAP.get(Ingredient.class));
    }


    public static Map<String, Product> map = new HashMap<>();
    protected String name;
    protected int id;
    protected int cost;

    public abstract Product create();


    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    protected void setCost(int cost) {
        this.cost = cost;
    }
}
