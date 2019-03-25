package instruments;

import java.util.HashMap;

public class Parser {
    public static HashMap<String, String> getMapStringString(String[] input) {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < input.length - 1; i = i + 2) {
            map.put(input[i], input[i + 1]);
        }
        return map;

    }

    public static String[] parseSubstrings(String input) {
        String[] substrings = input.split(" ");
        return substrings;
    }


}
