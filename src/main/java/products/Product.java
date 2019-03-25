package products;

public abstract class Product {
    protected String name;

    public abstract Product create();

    public String getName() {
        return name;
    }
}
