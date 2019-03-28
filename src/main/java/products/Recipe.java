package products;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    public Map<Class<? extends Object>, Class<? extends Object>> map;
    public Map<Object, Object> smdm = new HashMap<>();

    public Recipe(Map<Class<? extends Object>, Class<? extends Object>> map) {
        this.map = map;
    }

    public Map<Class<? extends Object>, Class<? extends Object>> getMap() {
        return map;
    }

    public void setMap(Map<Class<? extends Object>, Class<? extends Object>> map) {
        this.map = map;
    }
}
