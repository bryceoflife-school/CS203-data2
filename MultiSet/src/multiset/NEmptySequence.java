package multiset;

public class NEmptySequence<D extends Comparable> implements Sequenced<D>, Sequence<D> {
    D here;
    int count;
    Sequence<D> next;
    
    NEmptySequence(D here, int count, Sequence<D> next) {

        this.here = here;
        this.count = count;
        this.next = next;
    }

    public Sequence<D> seq() {
        return this;
    }
    public boolean notEmpty() { 
        return true;
    }
    public D here() { 
        return this.here;
    }
    public Sequence<D> next() { 
        if (count > 1){
            return new NEmptySequence(here, count - 1, next);
        } else {
            return next;
        }
    }
    
     public String makeString() {
        return "" + this.here;
    }
}
