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
public class NEmptyBag implements Bag {

    // Define global variables
    int here;
    int count; 
    Bag left;
    Bag right;

    // Constructor that takes root
    public NEmptyBag(int here) {
        this.here = here;
        this.count = 1;
        this.left = empty();
        this.right = empty();
    }

    // Constructor that takes root, left and right
    public NEmptyBag(int here, int count, Bag left, Bag right) {
        this.here = here;
        this.count = 1;
        this.left = left;
        this.right = right;
    }

    // (empty) → finite-set
    // Returns a fresh empty set.
    public static NEmptyBag empty() {
        return new EmptyBag();
    }

    // (cardinality t) → integer
    // t : finite-set
    // Returns the number of elements in set t
    public int cardinality() {
        
    }

    // (isEmptyHuh t) → boolean
    // t : finite-set
    // Determines if t is empty
    public boolean isEmptyHuh() {
        return false;
    }

    // (member t elt) → boolean
    // t : finite-set
    // elt : integer
    // Determines if elt is in t
    public boolean member(int elt) {

    }

    // (add t elt) → finite-set
    // t : finite-set
    // elt : integer
    // Returns a set containing elt and everything in t
    public NEmptyBag add(int elt) {

    }

    // (remove t elt) → finite-set
    // t : finite-set
    // elt : integer
    // Returns a set containing everything in t except elt.
    public Bag remove(int elt) {

    }

    // (union t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in t and u.
    public Bag union(Bag u) {
       
    }

    // (inter t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything that is in both t and u.
    public Bag inter(Bag u) {
        
    }

    //(diff t u) → finite-set
    // t : finite-set
    // u : finite-set
    // Returns a set containing everything in u except those that are in t.
    public Bag diff(Bag u) {
      
    }

    // (equal t u) → boolean
    // t : finite-set
    // u : finite-set
    //Determines if t and u contain the same elements.
    public boolean equal(Bag u) {
    
    }

    //(subset t u) → boolean
    // t : finite-set
    // u : finite-set
    // Determines if t is a subset of u.
    public boolean subset(Bag u) {
        
    }
}
