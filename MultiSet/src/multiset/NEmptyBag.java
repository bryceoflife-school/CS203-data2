package multiset;

public class NEmptyBag<D extends Comparable> implements Bag<D> {

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
        this.count = count;
        this.left = left;
        this.right = right;
    }

    public NEmptyBag(D here, int count) {
        // Setting Properties
        this.count = count;
        this.here = here;
        this.left = empty();
        this.right = empty();
    }

    public NEmptyBag(D here, Bag left, Bag right) {
        this.count = 1;
        this.here = here;
        this.left = left;
        this.right = right;
    }

    public static Bag empty() {
        return new EmptyBag();
    }

    public int cardinality() {
        return count + this.left.cardinality() + this.right.cardinality();
    }

    public boolean isEmptyHuh() {
        return false;
    }

    public boolean member(D elt) {
        if (this.here.compareTo(elt) == 0) {
            return true;
        } else if (this.here.compareTo(elt) > 0) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }

    public int getCount(D elt) {
        if (this.here.compareTo(elt) == 0) {
            return count;
        } else if (this.here.compareTo(elt) > 0) {
            return left.getCount(elt);
        } else {
            return right.getCount(elt);
        }
    }

    public NEmptyBag add(D elt) {
        if (this.here.compareTo(elt) == 0) {
            return new NEmptyBag(this.here, this.count + 1, this.left, this.right);
        } else {
            if (elt.compareTo(this.here) < 0) {
                return new NEmptyBag(this.here, this.count, this.left.add(elt), this.right);
            } else {
                return new NEmptyBag(this.here, this.count, this.left, this.right.add(elt));
            }
        }
    }
    
   public NEmptyBag addN(D elt, int n) {
        if (this.here.compareTo(elt) == 0) {
            int max = Math.max(0, this.count + n);
            return new NEmptyBag(this.here, max, this.left, this.right);
        } else {
            if (elt.compareTo(this.here) < 0) {
                return new NEmptyBag(this.here, this.count, this.left.addN(elt, n), this.right);
            } else {
                return new NEmptyBag(this.here, this.count, this.left, this.right.addN(elt, n));
            }
        }
    }

    
    public Bag remove(D elt) {
        return null;
    }
    
    public NEmptyBag removeN(D elt, int n) {
        return null;
    }

    public Bag removeAll(D elt) {
        return null;
    }

    public Bag union(Bag u) {
        return left.union(right.union(u)).addN(here, this.getCount(here));
               
    }

    public Bag inter(Bag u) {
        return null;
    }

    //(diff t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in u except those that are in t.
    public Bag diff(Bag u) {
        return null;
    }

    public boolean equal(Bag u) {
        return true;
    }

    public boolean subset(Bag u) {
        return true;
    }
}
