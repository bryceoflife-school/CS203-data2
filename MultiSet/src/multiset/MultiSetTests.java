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
      Bag B1 = new NEmptyBag(9, 2, new NEmptyBag(7, 3, new NEmptyBag(5, 3, empty, empty),empty),
               new NEmptyBag(11, 1, empty, empty));
      Bag b2 = new NEmptyBag(10, 3, empty, empty);
        
     System.out.println(B1.cardinality());
    }
    
}
