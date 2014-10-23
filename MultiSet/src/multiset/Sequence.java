
package multiset;

import java.util.Iterator;

/**
 *
 * @author BryceDaniel
 */
public class Sequence<D extends Comparable > implements Iterator {
    D here;
    Sequence<D> next; 
    
    public D here(){
        return null;
    }
    
    public boolean hasNext(){
        return true;
    }
    
    public Sequence<D> next(){
        return null;
    }
    
}
// empty, concatonated, duplicates