package multiset;


public class NEmptyBag<D extends Comparable> implements Bag<D>, Sequenced<D> {

    // Define global variables
//    int color; // 1 is Black, 2 is Red
    boolean isRedHuh;
    
    D here;
    int count;
    Bag left;
    Bag right;
    

    public static Bag empty() {
        return new EmptyBag();
    }

    // Constructor that takes root
    public NEmptyBag(D here) {
        this.here = here;
        this.count = 1;
        this.left = empty();
        this.right = empty();
    }

    // Constructor that takes root, left and right
    public NEmptyBag(D here, int count, Bag<D> left, Bag<D> right) {
        this.here = here;
        this.count = count;
        this.left = left;
        this.right = right;
    }

    public NEmptyBag(D here, int count) {
        // Setting Properties
        this.count = count;
        this.here = here;
        this.isRedHuh = true; 
        this.left = empty();
        this.right = empty();
    }

    public NEmptyBag(D here, Bag<D> left, Bag<D> right) {
        this.count = 1;
        this.here = here;
        this.left = left;
        this.right = right;
    }
    
    public NEmptyBag(D here, int count, boolean isRedHuh, Bag<D> left, Bag<D> right) {
        this.count = count;
        this.here = here;
        this.isRedHuh = isRedHuh;
        this.left = left;
        this.right = right;
    }

    public int cardinality() {
        return count + this.left.cardinality() + this.right.cardinality();
    }

    public boolean isEmptyHuh() {
       if (this.getCount(here) == 0) {
            if (!left.isEmptyHuh()) {
                return right.isEmptyHuh();
            } else {
                return left.isEmptyHuh();
            }
        } else {
            return false;
        }
    }
    

     public boolean member(D elt) {
        if (this.here.compareTo(elt) == 0) {
            return this.count > 0;
        } else if (this.here.compareTo(elt) < 0) {
            return right.member(elt);
        } else {
            return left.member(elt);
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

    public Bag<D> add(D elt) {
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

    public Bag<D> addN(D elt, int n) {
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

    public Bag<D> remove(D elt) {
        if (this.here.compareTo(elt) == 0) {
            return new NEmptyBag(this.here, this.count - 1, this.left, this.right);

        } else if (elt.compareTo(this.here) > 0) {
            return new NEmptyBag(this.here, this.count, this.left, this.right.remove(elt));
        } else {
            return new NEmptyBag(this.here, this.count, this.left.remove(elt), this.right);
        }
    }

    public Bag<D> removeN(D elt, int n) {
        if (this.here.compareTo(elt) == 0) {
            int max = Math.max(0, this.count - n);
            return new NEmptyBag(this.here, max, this.left, this.right);
        } else if (elt.compareTo(this.here) > 0) {
            return new NEmptyBag(this.here, this.count, this.left, this.right.removeN(elt, n));
        } else {
            return new NEmptyBag(this.here, this.count, this.left.removeN(elt, n), this.right);
        }
    }

    public Bag<D> removeAll(D elt) {
        if (this.here.compareTo(elt) == 0) {
            return left.union(right);
        } else if (elt.compareTo(this.here) > 0) {
            return new NEmptyBag(this.here, this.count, this.left, this.right.removeAll(elt));
        } else {
            return new NEmptyBag(this.here, this.count, this.left.removeAll(elt), this.right);
        }
    }

    public Bag<D> union(Bag<D> u) {
        return left.union(right.union(u)).addN(here, this.getCount(here));

    }

    public Bag<D> inter(Bag<D> u) {
        if (u.member(this.here)) {
            int min = Math.min(u.getCount(here), this.getCount(here));
            return new NEmptyBag(this.here, min , this.left.inter(u), this.right.inter(u));
        } else {
            return this.left.inter(u).union(this.right.inter(u));
        }
    }

    public Bag<D> diff(Bag<D> u) {
         Bag rootless = u.removeN(here, this.getCount(here));
        return left.union(right).diff(rootless);
    }

    public boolean equal(Bag<D> u) {
        return this.subset(u) && u.subset(this);
    }

    public boolean subset(Bag<D> u) {
        return (this.getCount(here) <= u.getCount(here) && this.left.union(this.right).subset(u));
    }
    
    // Balancing 
    
    public Bag<D> blacken(){
        return new NEmptyBag(this.here, this.count, false, this.left, this.right);
    }
  
    public Bag<D> balance(){ 
        return null;
    }
  
    public Bag<D> addInner(D elt, int n){
        return null;
    }
    
    
    // Sequences
    
    public Sequence<D> seq() {
        return new NEmptySequence(here, count, (new Sequence_Cat(this.left.seq(), this.right.seq())));
    }
    
    public int countIt() {
        return countItS(this.seq());
    }
    public int countItS(Sequence<D> as) {
        int counter = 0;
        while ( as.notEmpty() ) {
            counter = counter + 1;
            as = as.next();
        }
        return counter;
    }
    
    public String toStringIt() {
        return toStringIts(this.seq());
    }
    
    public String toStringIts(Sequence<D> as){
        StringBuffer string = new StringBuffer("");
        while (as.notEmpty()) {
           string.append(as.next().makeString());
           string.append(" ");
           as = as.next();
        }
        return string.toString();
    }
}
