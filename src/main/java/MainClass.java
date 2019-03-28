import instruments.Compositable;
import instruments.Createable;
import products.*;

import java.io.IOException;

public class MainClass   {
    public static void main(String[] args) throws IOException {
//        Product p = new Ingredient.Builder().setName("sd").build();
//        System.out.println(p.getName());
//        p = new Ingredient.Builder().setName("sdscs").build();
//        System.out.println(p.getName());
        System.out.println(Ingredient.map.size());

        Product y = Createable.getProduction(new Drink());
        System.out.println(y.getName());

        Product u = Createable.getProduction(new Ingredient());
        System.out.println(u.getName());

        System.out.println(u.getName() + " " + u.getId() + " " + u.getCost());
        System.out.println(Ingredient.map.size());
        System.out.println(Ingredient.map.get(u.getName()).getName());

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

        Product.getGRAND_MAP();

        Product a = Createable.getProduction(new Ingredient());
        Product.getGRAND_MAP();


    }
}
