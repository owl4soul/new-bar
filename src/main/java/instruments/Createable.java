package instruments;

import products.Product;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public interface Createable {

    //THE MOST IMPORTANT METHOD WICH CREATE ANY KIND OF PRODUCT-SUBCLASSES' OBJECTS
    static Product CREATE_SOMETHING(String nameOfClassAndParameters) {
        //Get first word which should be name of the subclass
        Product product;
        String nameOfClass = nameOfClassAndParameters.substring(0, nameOfClassAndParameters.indexOf(" "));
        String andParameters = nameOfClassAndParameters.replaceFirst(nameOfClass.concat(" "), "");

        Product.GRAND_MAP = Product.getGRAND_MAP(); //initialization of GRAND_MAP/update its data

        try {
            Class clazz = Class.forName(nameOfClass);
            Object instance = clazz.newInstance();
//            Map<String, Product> map = Product.GRAND_MAP.get(clazz.getSimpleName());
            Method method = clazz.getDeclaredMethod("createFromCommand", String.class);
            product = (Product) method.invoke(instance, andParameters);
            return product;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
