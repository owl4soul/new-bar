import products.Creator;
import products.Drink;
import products.Ingredient;
import products.Product;

public class MainClass   {
    public static void main(String[] args) {
//        Product p = new Ingredient.Builder().setName("sd").build();
//        System.out.println(p.getName());
//        p = new Ingredient.Builder().setName("sdscs").build();
//        System.out.println(p.getName());
        System.out.println(Ingredient.ingredientTypes.size());

        Product y = Creator.getProduct(new Drink());
        System.out.println(y.getName());

        Product u = Creator.getProduct(new Ingredient());
        System.out.println(u.getName());

        System.out.println(u.getName() + " " + u.getId() + " " + u.getCost());
        System.out.println(Ingredient.ingredientTypes.size());
        System.out.println(Ingredient.ingredientTypes.get(u.getName()).getName());

    }
}
