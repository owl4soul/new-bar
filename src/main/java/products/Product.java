package products;

public abstract class Product {
    protected String name;
    protected int id;
    protected int cost;

    public abstract Product create();

    public String getName() {
        return name;
    }
}
