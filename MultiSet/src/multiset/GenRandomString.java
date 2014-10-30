package multiset;

import java.util.Random;

public class GenRandomString implements GenRandom<String> {

    public String getRandomObject() {
        int length = new Random().nextInt(10);
        StringBuilder stringOutput = new StringBuilder("");

        for (int i = 0; i < length; i++) {
            stringOutput.append(Character.toChars(65 + new Random().nextInt(26)));
        }

        return stringOutput.toString();

    }
}
