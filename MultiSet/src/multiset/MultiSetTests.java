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
        Bag b2 = new NEmptyBag(10, 3, empty, empty);

      // Hardcoded tests
        // Cardinality()
        System.out.println("Should be 9: " + B1.cardinality());

        // member()
        System.out.println("Should be true: " + B1.member(9));
        System.out.println("Should be true: " + B1.member(11));
        System.out.println("Should be false: " + B1.member(3));
        
        // getCount
        System.out.println("Should be 3: " + B1.getCount(7));
        System.out.println("Should be 0: " + B1.getCount(6));
        
        
        // add()
        System.out.println("Cardinality should be 10: " + B1.add(10).cardinality());
    }

}
