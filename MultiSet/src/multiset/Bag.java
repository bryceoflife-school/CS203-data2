package multiset;

/**
 * An interface that sets up the Multi-Set Bag
 * @author BryceDaniel
 * @param <D> A generic type object 
 * 
 */
public interface Bag<D extends Comparable> extends Sequenced<D> {

    /**
     * This method returns the size of the multi-set (Bag) / 
     * Example: {A, B, C}.cardinality() = 3.
     * @return An integer representing the number of elements in the multi-set (Bag)
     * 
     */
    public int cardinality();

    /**
     * This method returns true if the multi-set (Bag) is empty/
     * Example: {A, B, C}.isEmptyHuh() = false /
     * Example: {}.isEmptyHuh() = true
     * @return A boolean
     */
    public boolean isEmptyHuh();

    /**
     * A method that returns true if a given element is included in multi-set (Bag) / 
     * Example: {A, B, C}.member(B) = true 
     * @param elt a generic element of the multi-set (Bag)
     * @return A boolean
     */
    public boolean member(D elt);

    /**
     * A method that returns the number of times an element appears in the multi-set (Bag) / 
     * Example: {A, B, B, B, C}.getCount(B) = 3
     * @param elt a generic element of the multi-set (Bag)
     * @return An Integer representing the number of times
     */
    public int getCount(D elt);

    /**
     * A method that adds an element to the multi-set (Bag) and returns a new bag / 
     * Example: {A, B, C}.add(D) = {A, B, C, D}.
     * @param elt a generic element of the multi-set (Bag)
     * @return A Bag
     */
    public Bag<D> add(D elt);

    /**
     * A method that adds an element n number of times to the multi-set (Bag) and returns a new bag / 
     * Example: {A, B, C}.addN(D, 3) = {A, B, C, D, D, D}.
     * @param elt a generic element of the multi-set (Bag)
     * @param n the number of times to add the element
     * @return A Bag
     */
    public Bag<D> addN(D elt, int n);

    /**
     * A method that removes an element from the multi-set (Bag) and returns a new bag / 
     * Example: {A, B, C}.remove(C) = {A, B}.
     * @param elt a generic element of the multi-set (Bag)
     * @return A Bag
     */
    public Bag<D> remove(D elt);

    /**
     * A method that removes an element from the multi-set (Bag) n times and returns a new bag / 
     * Example: {A, B, C, C, C}.removeN(C, 2) = {A, B, C}.
     * @param elt a generic element of the multi-set (Bag)
     * @param n the number of times to remove the element
     * @return A Bag
     */
    public Bag<D> removeN(D elt, int n);

    /**
     * A method that removes all occurrences of an element from the multi-set and returns a new bag / 
     * Example: {A, A, A, A, B, C}.removeAll(A) = {B, C}.
     * @param elt a generic element of the multi-set (Bag)
     * @return A Bag
     */
    public Bag<D> removeAll(D elt);

    /**
     * A method that returns the union of two multi-sets (Bags) /
     * Example: {A, B, C}.union({D, E, F}) = {A, B, C, D, E, F}.
     * @param u A Bag
     * @return A Bag
     */
    public Bag<D> union(Bag<D> u);

    /**
     * A method that returns the intersection of two multi-sets (Bags) / 
     * Example: {A, B, C}.inter({C, D, E}) = {C}.
     * @param u A Bag
     * @return A Bag
     */
    public Bag<D> inter(Bag<D> u);

    /**
     * Example: {A, B, C}.diff({C, E, F}) = {A, B}.
     * A method that returns the difference of two multi-sets (Bags)
     * @param u A Bag
     * @return A Bag
     */
    public Bag<D> diff(Bag<D> u);

    /**
     * A method that returns true if two multi-sets (Bags) are equal /
     * Example: {A, B, C}.equal({D, E, F}) = false /
     * Example: {A, B, C}.equal({A, B, C}) = true
     * @param u A Bag
     * @return A boolean
     */
    public boolean equal(Bag<D> u);

    /**
     * A method that returns true if set u is a subset of the multi-set (Bag) /
     * Example: {A, B, C}.subset({A, B}) = true
     * @param u A Bag
     * @return A boolean
     */
    public boolean subset(Bag<D> u);
    
// Balancing Methods
    
    /**
     * A method that turns the node black for self balancing purposes
     * @return A Bag
     */
    public Bag<D> blacken();
    
    /**
     * A method that adds a new node into the tree
     * @param elt a generic element
     * @param n the count of the element
     * @return A Bag
     */
    public Bag<D> addInner(D elt, int n);
    
    /**
     * A method that calls blacken on addInner
     * @param elt a generic element
     * @param n the count of the element
     * @return A Bag
     * @see blacken
     * @see addInner
     */
    public Bag<D> rbInsert(D elt, int n);
    
    /**
     * A method that determines if the node is red
     * @return A Boolean 
     */
    public boolean isRedHuh();
    
    // Sequencing Methods

    /**
     * A method that turns a multi-set (Bag) into a sequence
     * @return A Generic Sequence
     */
    public Sequence<D> seq();

    /**
     * A method that sums up the sequence
     * @return An int 
     */
    public int countIt();

    /**
     * A method that calls toString on the sequence
     * @return A String
     */
    public String toStringIt();

}
