package multiset;

/**
 * An interface that allows something to be sequenced
 * @author BryceDaniel
 * @param <D> A generic type object
 */
public interface Sequenced<D extends Comparable> {
    
    /**
     * A method to turn the object into a sequence
     * Example: {A, B, C}.seq() = [A, B, C]  
     * @return A Sequence
     */
    public Sequence<D> seq();
}
