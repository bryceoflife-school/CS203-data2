/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiset;

/**
 *
 * @author BryceDaniel
 */
public class EmptyBag implements Bag {
    
    public void EmptyBag(){ }
    
    
    // (empty) → finite-set
    // Returns a fresh empty set.
    public Bag empty(){
        return this;
    };
    
    
    // (cardinality t) → integer
    // t : finite-set
    // Returns the number of elements in set t
    public int cardinality(){
        return 0;
    }

    // A Leaf() is always empty and therefore will always return true
    public boolean isEmptyHuh() {
        return true;
    }
    
    // A Leaf() is always empty and therefore should not have any members
    // Therefore it should return false
    public boolean member(int elt){
        return false;
    }
    
    // A Leaf() is empty so it should return a new tree
    // With just the added element
    public Bag add(int elt){
        return new NEmptyBag(elt);
    }
    
    // There is nothing to remove in Leaf()
    // so it should just return itself
    public Bag remove(int elt){
        return new EmptyBag();
    }
    
    // The union of anything and the empty set is
    // just the union of u
    public Bag union(Bag u){
        return u;
    }
    
    // The empty set cannot have common elements with another set
    // And therefore should return empty
    public Bag inter(Bag u){
        return empty();
    }
    
    // A Leaf() is empty and therefore every elment in
    // U should be returned
    public Bag diff(Bag u){
        return u;
    }
    
    // Only if both sets are empty can they be equal
    // And can return true
    public boolean equal(Bag u){
        return u.cardinality() == this.cardinality();
    }
    
    // The empty set is a subset of all sets
    public boolean subset(Bag u){
        return true;
     
    }
     
}
}
