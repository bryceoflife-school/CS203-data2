
package multiset;

import java.util.Iterator;

interface Sequence<D extends Comparable> {
    
    public D here();
    public boolean notEmpty();   
    public Sequence<D> next();
    
}
// empty, concatonated, duplicates
