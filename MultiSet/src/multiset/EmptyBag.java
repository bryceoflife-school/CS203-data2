package multiset;

public class EmptyBag<D> implements Bag, Sequenced {
    
    public void EmptyBag(){ }
    
    public Sequence<D> seq(){
        
    }
    
    public Bag empty(){
        return this;
    };
    
    public int cardinality(){
        return 0;
    }

    public boolean isEmptyHuh() {
        return true;
    }
    
    public boolean member(int elt){
        return false;
    }

    public Bag add(int elt){
        return new NEmptyBag(elt);
    }

    public Bag remove(int elt){
        return this;
    }
    
    public Bag removeAll(int elt){
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
