package multiset;

public interface Bag<D extends Comparable>  {
    public int cardinality();
    public boolean isEmptyHuh();
    public boolean member(D elt);
    public int getCount(D elt);
    public Bag add(D elt);
    public Bag remove(D elt);
    public Bag removeAll(D elt);
    public Bag union(Bag u);
    public Bag inter(Bag u);
    public Bag diff(Bag u);
    public boolean equal(Bag u);
    public boolean subset(Bag u);
    
}
