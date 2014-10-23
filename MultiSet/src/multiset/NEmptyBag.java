package multiset;


public class NEmptyBag implements Bag, Sequenced {

    // Define global variables
    D here;
    int count; 
    Bag left;
    Bag right;

    // Constructor that takes root
    public NEmptyBag(D here) {
        this.here = here;
        this.count = 1;
        this.left = empty();
        this.right = empty();
    }

    // Constructor that takes root, left and right
    public NEmptyBag(D here, int count, Bag left, Bag right) {
        this.here = here;
        this.count = 1;
        this.left = left;
        this.right = right;
    }

    public static NEmptyBag empty() {
        return new EmptyBag();
    }

    public Sequence<D> seq() { 
        
    }
    
    public int cardinality() {
        
    }

    public boolean isEmptyHuh() {
        return false;
    }

    public boolean member(D elt) {

    }

    public NEmptyBag add(D elt) {

    }

    public Bag remove(D elt) {

    }
    
    public Bag removeAll(D elt) {
        
    }

    public Bag union(Bag u) {
       
    }

    public Bag inter(Bag u) {
        
    }

    //(diff t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in u except those that are in t.
    public Bag diff(Bag u) {
      
    }

    public boolean equal(Bag u) {
    
    }

    public boolean subset(Bag u) {
        
    }
}
