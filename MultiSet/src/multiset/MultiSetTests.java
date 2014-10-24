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
public class MultiSetTests {

    public static void main(String[] args) {
        Bag empty = new EmptyBag();
        Bag B1 = new NEmptyBag(9, 2, new NEmptyBag(7, 3, new NEmptyBag(5, 3, empty, empty), empty),
                new NEmptyBag(11, 1, empty, empty));
        Bag B2 = new NEmptyBag(10, 3, empty, empty);
        Bag B3 = new NEmptyBag(3, 1, empty, empty);
        Bag B4 = new NEmptyBag(5, 10, empty, new NEmptyBag(7, 2, empty, empty));

      // Hardcoded tests
        // Cardinality()
        System.out.println();
        System.out.println("Should be 9: " + B1.cardinality());
        System.out.println("Should be 3: " + B2.cardinality()); 
        
        // member()
        System.out.println();
        System.out.println("Should be true: " + B1.member(9));
        System.out.println("Should be true: " + B1.member(11));
        System.out.println("Should be false: " + B1.member(3));
        
        // getCount
        System.out.println();
        System.out.println("Should be 3: " + B1.getCount(7));
        System.out.println("Should be 0: " + B1.getCount(6));
        
        
        // add()
        System.out.println();
        System.out.println("Cardinality should be 10: " + B1.add(9).cardinality());
        System.out.println("Cardinality should be 11: " + B1.add(1).add(2).cardinality());
        System.out.println("Cardinality should be 4: " + B2.add(1).cardinality());
        
        // addN()
        System.out.println();
        System.out.println("Cardinality should be 14: " + B1.addN(9, 5).cardinality());
        System.out.println("Cardinality should be 9: " + B1.addN(9, 0).cardinality());  
        System.out.println("Cardinality should be 7: " + B2.addN(2, 4).cardinality());
        
        // Union()
        System.out.println();
        System.out.println("Cardinality should be 4: " + B2.union(B3).cardinality());
        System.out.println("Cardinality should be 12: " + B1.union(B2).cardinality());
        
        // remove()
        System.out.println();
        System.out.println("Cardinality should be 9: " + B1.cardinality());
        System.out.println("Cardinality should be 8: " + B1.remove(9).cardinality());
        System.out.println("Cardinality should be 8: " + B1.remove(7).cardinality());
        System.out.println("Member should be False: " + B1.remove(11).member(11));
        System.out.println("Cardinality should be 2: " + B2.remove(10).cardinality());
        System.out.println("Cardinality should be 0: " + B3.remove(3).cardinality());
        
        // removeN()
        System.out.println();
        System.out.println("Cardinality should be 9: " + B1.cardinality());
        System.out.println("Cardinality should be 7: " + B1.removeN(9, 2).cardinality());
        System.out.println("Cardinality should be 6: " + B1.removeN(7, 3).cardinality());
        
        // removeAll()
        System.out.println();
        System.out.println("Cardinality should be 9: " + B1.cardinality());
        System.out.println("Cardinality should be 7: " + B1.removeAll(9).cardinality());
        System.out.println("Cardinality should be 6: " + B1.removeAll(7).cardinality());
        System.out.println("Member should be false: " + B1.removeAll(7).member(7));
        
        // inter()
        System.out.println();
        System.out.println("Cardinality should be 9: " + B1.cardinality());
        System.out.println("Cardinality should be 3: " + B2.cardinality());
        System.out.println("Cardinality should be 9: " + B1.inter(B1).cardinality());
        System.out.println("Cardinality should be 0: " + B1.inter(B2).cardinality());
        System.out.println("Cardinality should be 9: " + B1.cardinality());
        System.out.println("Cardinality should be 12: " + B4.cardinality());
        System.out.println("Cardinality should be 5: " + B1.inter(B4).cardinality());
        System.out.println("Member should be True: " + B1.inter(B4).member(7));
    }

}
