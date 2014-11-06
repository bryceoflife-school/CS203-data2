package multiset;

import java.util.Iterator;

/**
 * Interface that sets up sequences
 *
 * @author BryceDaniel
 * @param <D> a Generic type object
 */
interface Sequence<D extends Comparable> {

    /**
     * A method to return the object where the sequence is located /
     * Example: [A, B, C] where here is A, [A, B, C].here() = A
     * @return D
     */
    public D here();

    /**
     * A method to return a true if the sequence is not empty / 
     * Example: [A, B, C].notEmpty() = true
     * @return A Boolean
     */
    public boolean notEmpty();

    /**
     * A method to return the next after the here in the sequence / 
     * Example: [A, B, C] where here is A, [A, B, C].next() = [B, C].
     * @return A Sequence
     */
    public Sequence<D> next();

    /**
     * A method to return a string version of the sequence
     * Example: [A, B, C].makeString() = "A B C"
     * @return A String
     */
    public String makeString();

}
// empty, concatonated, duplicates
