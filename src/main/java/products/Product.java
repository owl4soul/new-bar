package products;

import java.util.HashMap;
import java.util.Map;

public abstract class Product implements Compositable, Createable {
    //Здесь будут getSimpleClassNames наследников и их перечни
    public final static Map<String, Map<String, Product>> GRAND_MAP = new HashMap<String, Map<String, Product>> (){{
        put()
    }}; //TODO убедиться, что final не создаст проблем



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
