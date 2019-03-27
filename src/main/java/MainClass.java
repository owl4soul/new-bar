import products.*;

import java.util.Map;

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

//        Compositable comp = new Compositable() {
//        };
//        comp.addToMap((Ingredient)u, Product.map);
//        System.out.println((Ingredient)Product.map.get(u.getName()));
//
//        Ingredient ada = new Ingredient();
//        ada.addToMap(u);
//
//        ((Ingredient) u).addToMap(u);

        System.out.println("current test: " + Ingredient.map.get(u.getName()));

        Product drinkk = Createable.getProduction(new Drink());
        Compositable comp = new Compositable() {
        };
        Compositable.compositor(drinkk, Product.map);
        System.out.println(Product.map.size());


    }
}
