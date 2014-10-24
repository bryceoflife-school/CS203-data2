package multiset;

public class EmptyBag<D extends Comparable> implements Bag<D> {
    
    public void EmptyBag(){ }
    
    public Bag empty(){
        return this;
    };
    
    public int cardinality(){
        return 0;
    }

    public boolean isEmptyHuh() {
        return true;
    }
    
    public boolean member(D elt){
        return false;
    }
    
    public int getCount(D elt){
        return 0;
    }

    public Bag add(D elt){
        return new NEmptyBag(elt);
    }
    
    public Bag addN(D elt, int n) {
        return new NEmptyBag(elt, n);
    }

    public Bag remove(D elt){
        return this;
    }
    
    public Bag removeN(D elt, int n){
        return this;
    }
    
    public Bag removeAll(D elt){
        return this;
    }

    public Bag union(Bag u){
        return u;
    }
    
    public Bag inter(Bag u){
        return empty();
    }
    
    public Bag diff(Bag u){
        return u;
    }
    
    public boolean equal(Bag u){
        return u.cardinality() == this.cardinality();
    }
    
    public boolean subset(Bag u){
        return true;
     
    }
     
}
