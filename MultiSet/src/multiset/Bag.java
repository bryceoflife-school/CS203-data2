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
public interface Bag {

    public int cardinality();

    public boolean isEmptyHuh();

    public boolean member(int elt);

    public Bag add(int elt);

    public Bag remove(int elt);
    
    public Bag removeAll(int elt);

    public Bag union(Bag u);

    public Bag inter(Bag u);

    public Bag diff(Bag u);

    public boolean equal(Bag u);

    public boolean subset(Bag u);
    
}
