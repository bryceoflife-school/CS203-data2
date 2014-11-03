package multiset;

public class EmptySequence<D extends Comparable> implements Sequence<D> {
    
    public Sequence<D> seq() {
        return this; 
    }
    public boolean notEmpty() {
        return false; 
    }
    public D here() {
        return null; 
    }
    public Sequence<D> next() { 
        return this; 
    }
}
