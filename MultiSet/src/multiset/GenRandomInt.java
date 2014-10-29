package multiset;
import java.util.Random;

public class GenRandomInt implements GenRandom<Integer> {
    public Integer getRandomObject(){
        Random rando = new Random();
        int min = 0;
        int max = 100;
        return rando.nextInt((max - min) + 1) + min;
    }
}
