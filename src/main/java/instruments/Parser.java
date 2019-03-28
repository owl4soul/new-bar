package instruments;

import java.util.HashMap;

public class Parser {
    public static HashMap<String, String> getMapStringString(String[] substrings) {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < substrings.length - 1; i = i + 2) {
            map.put(substrings[i], substrings[i + 1]);
        }
        return map;

    }

    public static HashMap<String, Integer> getMapStringInteger(String[] substrings) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < substrings.length - 1; i = i + 2) {
            try {
                int num = Integer.parseInt(substrings[i + 1]);
                map.put(substrings[i], num);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Невозможно идентифицировать число!");
            }
        }
        return map;

    }


    public static String[] parseSubstrings(String input) {
        String[] substrings = input.split(" ");
        return substrings;
    }


}
