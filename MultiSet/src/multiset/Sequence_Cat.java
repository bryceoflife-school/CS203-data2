package multiset;

public class Sequence_Cat<D extends Comparable> implements Sequence<D> {
    Sequence<D> left;
    Sequence<D> right;

    Sequence_Cat (Sequence l, Sequence r) {
        System.out.println("Alloc");
        this.left = l;
        this.right = r;
    }
    
    public boolean notEmpty() {
        return this.left.notEmpty() || this.right.notEmpty();
    }
    
    public D here() {
        if ( this.left.notEmpty() ) {
            return this.left.here();
        } else {
            return this.right.here();
        }
    }
    
    public Sequence<D> next() {
        if ( this.left.notEmpty() ) {
            return new Sequence_Cat(this.left.next(), this.right );
        } else {
            return this.right.next();
        }
    }
}
