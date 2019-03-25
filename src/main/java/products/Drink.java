package products;

public class Drink extends Product{

    public Drink() {
        this.name = "You did it";
    }

    public Product create() {
        return new Drink();
    }
}
