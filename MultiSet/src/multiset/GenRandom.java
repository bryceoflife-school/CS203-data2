package multiset;

/**
 * An interface for generating random objects
 * @author BryceDaniel
 * @param <D> A generic type object
 */
public interface GenRandom<D extends Comparable> {
    /**
     * A method for getting the randomObject
     * @return D
     */
    public D getRandomObject();
}
