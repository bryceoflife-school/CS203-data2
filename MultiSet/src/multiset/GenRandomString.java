package multiset;

import java.util.Random;

public class GenRandomString implements GenRandom<String> {

    public String getRandomObject() {
        int length = new Random().nextInt(10);
        int randomChar = 65 + new Random().nextInt(25);
        char c[] = Character.toChars(randomChar);
        String stringOutput = "";

        if (length == 0) {
            stringOutput = "";
        } else {
            for (int i = 0; i < length; i++) {
                stringOutput = new StringBuilder("").append(c[0]).toString();
            }
        }
        return stringOutput;

    }
}
