package products;

import instruments.Agregator;
import instruments.Compositable;
import instruments.Createable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Product implements Compositable, Createable {
       public static Map<String, Map<String, Product>> GRAND_MAP = new HashMap<>();

    public static Map<String, Map<String, Product>> getGRAND_MAP() {
        GRAND_MAP = Agregator.agregateMap(Product.class);
        System.out.println(GRAND_MAP.size());
        System.out.println(GRAND_MAP.get("Ingredient"));
        return GRAND_MAP;
    }

    public static void setGrandMap() {
        Map<String, Map<String, Product>> grand = getGRAND_MAP();
        GRAND_MAP = grand;
    }

    public static Map<String, Product> map = new HashMap<>();
    protected String name;
    protected int id;
    protected int cost;

    public abstract Product create() throws IOException;


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
