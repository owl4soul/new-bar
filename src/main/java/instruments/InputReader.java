package instruments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputReader {

    public static String read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
