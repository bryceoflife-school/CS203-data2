package multiset;

public interface Bag<D extends Comparable> extends Sequenced<D> {

    public int cardinality();

    public boolean isEmptyHuh();

    public boolean member(D elt);

    public int getCount(D elt);

    public Bag<D> add(D elt);

    public Bag<D> addN(D elt, int n);

    public Bag<D> remove(D elt);

    public Bag<D> removeN(D elt, int n);

    public Bag<D> removeAll(D elt);

    public Bag<D> union(Bag<D> u);

    public Bag<D> inter(Bag<D> u);

    public Bag<D> diff(Bag<D> u);

    public boolean equal(Bag<D> u);

    public boolean subset(Bag<D> u);
    
// Balancing Methods
    
    public Bag<D> blacken();

//    public Bag balance();

    public Bag<D> addInner(D elt, int n);
    
    public Bag<D> rbInsert(D elt, int n);
    
// Sequencing Methods

    public Sequence<D> seq();

    public int countIt();

    public String toStringIt();

}
