package multiset;

public class EmptyBag<D extends Comparable> implements Bag<D>, Sequenced<D> {
    
    public void EmptyBag(){ }
    
//    public Bag empty(){
//        return this;
//    };
    
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

    public Bag<D> add(D elt){
        return new NEmptyBag(elt);
    }
    
    public Bag<D> addN(D elt, int n) {
        return new NEmptyBag(elt, n);
    }

    public Bag<D> remove(D elt){
        return this;
    }
    
    public Bag<D> removeN(D elt, int n){
        return this;
    }
    
    public Bag<D> removeAll(D elt){
        return this;
    }

    public Bag<D> union(Bag u){
        return u;
    }
    
    public Bag<D> inter(Bag u){
        return this;
    }
    
    public Bag<D> diff(Bag u){
        return u;
    }
    
    public boolean equal(Bag<D> u){
        return u.cardinality() == this.cardinality();
    }
    
    public boolean subset(Bag<D> u){
        return true;
     
    }
    
    // Balancing
    
    public Bag<D> blacken(){
        return this;
    }
  
//    public Bag balance(){
//        return new EmptyBag();
//    }
  
    public Bag<D> addInner(D elt, int n){
        return new EmptyBag();
    }
    
    public Bag<D> rbInsert(D elt, int n) {
        return this.addInner(elt, n).blacken();
    }
    
    // Sequences
    
    public Sequence<D> seq() {
        return new EmptySequence();
    }
     
    public int countIt(){
        return 0;
    }
    
    public String toStringIt() {
        return toStringIts(this.seq());
    }
    
    public String toStringIts(Sequence<D> as){
        return "";
    }
}
