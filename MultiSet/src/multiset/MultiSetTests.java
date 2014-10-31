package multiset;

import java.util.Random;
import static multiset.NEmptyBag.empty;

public class MultiSetTests<D extends Comparable> {

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    GenRandom<D> rex;

    public static Bag empty() {
        return new EmptyBag();
    }

    public MultiSetTests(GenRandom<D> rex) {
        this.rex = rex;
    }

    public Bag<D> randomBag(int count) {
        if (count == 0) {
            return empty();
        } else {
            return randomBag(count - 1).addN(rex.getRandomObject(), randInt(1, 20));
        }
    }

    // Set run time counter to zero 
    static int testEmpty_isEmptyHuh = 0;
    static int testIsEmptyHuh_cardinality = 0;
    static int testCardinality_add = 0;
    static int testCardinality_getCount_remove = 0;
    static int testCardinality_addN = 0;
    static int testAdd_member = 0;
    static int testAdd_remove_getCount_equal = 0;
    static int testSubset_union = 0;
    static int testUnion_cardinality = 0;
    static int testUnion_cardinality_inter = 0;
    static int testEqual_inter = 0;
    
    // Testing begins 
    // Logic: if bag is empty, isEmptyHuh should return true.
    public void testEmpty_isEmptyHuh(int count) throws Exception {
        for (int i = 0; i < 50; i++) {
            if (count == 0) {
                Bag Ebag = empty();
                if (!Ebag.isEmptyHuh()) {
                    throw new Exception("Fail. Empty Bag is not Empty.");
                }
            } else {
                int length = randInt(1, 10);
                Bag NEBag = randomBag(length);
                if (NEBag.isEmptyHuh()) {
                    throw new Exception("Fail. Non-Empty Bag is Empty.");
                }
            }
            testEmpty_isEmptyHuh++;
        }
    }

    // Logic: a set with a cardinality of 0 should result in isEmptyHuh() returning true.
    public void testIsEmptyHuh_cardinality() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            if (bag.isEmptyHuh() && bag.cardinality() != 0) {
                throw new Exception("Fail: Empty bag has cardinality other than zero");
            } else if (!bag.isEmptyHuh() && bag.cardinality() == 0) {
                throw new Exception("Fail: Non-EMpty Bag has cardinaly of zero");
            }
            testIsEmptyHuh_cardinality++;
        }
    }

    // Logic: adding a random number of elements to a tree should result
    // in the cardinality being greater by that number of elements.
    public void testCardinality_add() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            int initialCard = bag.cardinality();
            if (bag.add(rex.getRandomObject()).cardinality() != initialCard + 1) {
                throw new Exception("Fail: Cardinality did not increase by one");
            } else if (bag.add(rex.getRandomObject()).cardinality() == initialCard) {
                throw new Exception("Fail: Not adding RandomObject");
            }
            testCardinality_add++;
        }
    }

    // Logic: adding a random number of elements to a tree should result
    // in the cardinality being greater by that number of elements.
    public void testCardinality_addN(int n) throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            int initialCard = bag.cardinality();
            if (bag.addN(rex.getRandomObject(), n).cardinality() != initialCard + n) {
                throw new Exception("Fail: Cardinality did not increase by one");
            } else if (bag.addN(rex.getRandomObject(), n).cardinality() == initialCard) {
                throw new Exception("Fail: Not adding RandomObject");
            }
            testCardinality_addN++;
        }
    }

    // Logic: removing should decrease cardinality by one
    // or not there to begin with so should remove nothing
    // We use getCount to determine if the element was in fact added
    public void testCardinality_getCount_remove() throws Exception {
        for (int i = 0; i < 50; i++) {
            D randomElt = rex.getRandomObject();
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            int newCard = bag.remove(randomElt).cardinality();
            if (bag.getCount(randomElt) >= 1 && newCard != bag.cardinality() - 1) {
                throw new Exception("Fail: Cardinality did not decrease by 1");
            }
            if (bag.getCount(randomElt) == 0 && newCard != bag.cardinality()) {
                throw new Exception("Fail: Cardinality did not stay the same");
            }
            testCardinality_getCount_remove++;
        }
    }

    // Logic: adding an element to the results in that element being a member of the bag.
    // Therefore member should return true.
    public void testAdd_member() throws Exception {
        for (int i = 0; i < 50; i++) {
            D randomElt = rex.getRandomObject();
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            bag.add(randomElt);
            if (bag.getCount(randomElt) >= 1 && !bag.member(randomElt)) {
                throw new Exception("Fail: Count increased but element not member");
            }
            if (bag.getCount(randomElt) == 0 && bag.member(randomElt)) {
                throw new Exception("Fail: Count not increased but element is member");
            }
            testAdd_member++;
        }
    }

    // Logic: adding and removing the same element should result in equal bags
    public void testAdd_remove_getCount_equal() throws Exception {
        for (int i = 0; i < 50; i++) {
            D randomElt = rex.getRandomObject();
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            Bag bigBag = bag.add(randomElt);
            if (bigBag.getCount(randomElt) - 1 != bag.getCount(randomElt)) {
                throw new Exception("Fail: The count did not increase by one");
            }
            Bag littleBag = bigBag.remove(randomElt);
            if (littleBag.getCount(randomElt) != bag.getCount(randomElt)) {
                throw new Exception("Fail: The count should be as it originally was");
            }
            if (!bag.equal(littleBag)) {
                throw new Exception("Fail: The bags should be equal");
            }
            testAdd_remove_getCount_equal++;
        }
    }
    
     // Logic: Two sets should be subsets of their union
    public void testSubset_union() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            Bag bag2 = randomBag(length);
            if (!bag.subset(bag.union(bag2)) || !bag2.subset(bag.union(bag2))) {     
                throw new Exception("Fail: one of the bags is not a subset of their union");
            }
            testSubset_union++;
        }
    }

    // Logic: | t U u | <= | t | + | u |
    public void testUnion_cardinality() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            Bag bag2 = randomBag(length);
            if (bag.union(bag2).cardinality() > bag.cardinality() + bag2.cardinality()) {
                throw new Exception("Fail: The cardinality of the union cannot be greater" +
                        " than the sum of the cardinalities of both.");
            }
            testUnion_cardinality++;
        }
    }
    
    // Logic: | t U u | = | t | + | u | - | t /inter u|
    public void testUnion_cardinality_inter() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            Bag bag2 = randomBag(length);
//            System.out.println(bag2.union(bag).cardinality());
//            System.out.println(bag.cardinality());
//            System.out.println(bag2.cardinality());
//            System.out.println(bag.cardinality() + bag2.cardinality());
//            System.out.println(bag.inter(bag2).cardinality());
//            System.out.println(bag.cardinality() + bag2.cardinality() - bag.inter(bag2).cardinality());
            if (bag.union(bag2).cardinality() != (bag.cardinality() + bag2.cardinality()) 
                    - bag.inter(bag2).cardinality()) {
                throw new Exception("Fail; The cardinality of the union of two bags" +
                        " should be equal to the sum of both cardinalities less the intersection");
            }
            testUnion_cardinality_inter++;
        }
    }
    
     // Logic: If two sets are equal, then the cardinality of their intersecition will be the same as
    // The cardinality of each set.
    public void testEqual_inter() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randInt(0, 10);
            Bag bag = randomBag(length);
            Bag bag2 = randomBag(length);
            if (bag.union(bag2).equal(bag.inter(bag2)) && !bag.equal(bag2)){
                throw new Exception ("Fail: The intersection and union of two equal sets are equal");
            }
            testEqual_inter++;
        }
    }
    
    public static void main(String[] args) throws Exception {

        // RANDOM TESTS 
        MultiSetTests integerTests = new MultiSetTests(new GenRandomInt());
        MultiSetTests stringTests = new MultiSetTests(new GenRandomString());

        // Tests for empty() and isEmptyHuh()
        System.out.println();
        System.out.println("Tests for Empty() & IsEmptyHuh():");

        int randomInt = randInt(0, 1);
        integerTests.testEmpty_isEmptyHuh(randomInt);
        stringTests.testEmpty_isEmptyHuh(randomInt);
        System.out.println("Test testEmpty_isEmptyHuh run sucessfully " + testEmpty_isEmptyHuh + " times");

        // Tests for isEmptyHuh() and cardinality()
        System.out.println();
        System.out.println("isEmptyHuh() and cardinality():");

        integerTests.testIsEmptyHuh_cardinality();
        stringTests.testIsEmptyHuh_cardinality();
        System.out.println("Test testIsEmptyHuh_Cardinality run sucessfully " + testIsEmptyHuh_cardinality + " times");

        // Tests for cardinality() and add()
        System.out.println();
        System.out.println("cardinality() and add():");

        integerTests.testCardinality_add();
        stringTests.testCardinality_add();
        System.out.println("Test testCardinality_add run sucessfully " + testCardinality_add + " times");

        // Tests for cardinality() and addN()
        System.out.println();
        System.out.println("cardinality() and addN():");

        int randomN = randInt(1, 10);
        integerTests.testCardinality_addN(randomN);
        stringTests.testCardinality_addN(randomN);
        System.out.println("Test testCardinality_addN run sucessfully " + testCardinality_addN + " times");

        // Tests for cardinality() and getCount() and remove()
        System.out.println();
        System.out.println("cardinality() and getCount() and remove():");

        integerTests.testCardinality_getCount_remove();
        stringTests.testCardinality_getCount_remove();
        System.out.println("Test testCardinality_getCount_remove run sucessfully " + testCardinality_getCount_remove + " times");

        // Tests for add() and member()
        System.out.println();
        System.out.println("add() and member():");

        integerTests.testAdd_member();
        stringTests.testAdd_member();
        System.out.println("Test testAdd_Member run sucessfully " + testAdd_member + " times");
        
        // Tests for add() and remove() and getCount() and Equal()
        System.out.println();
        System.out.println("add() and remove() and getCount() and Equal():");

        integerTests.testAdd_remove_getCount_equal();
        stringTests.testAdd_remove_getCount_equal();
        System.out.println("Test testAdd_remove_getCount_equal run sucessfully " + testAdd_remove_getCount_equal + " times");
    
        // Tests for subset() and union()
        System.out.println();
        System.out.println("subset() and union():");

        integerTests.testSubset_union();
        stringTests.testSubset_union();
        System.out.println("Test testSubset_union run sucessfully " + testSubset_union + " times");
        
        // Tests for union() and cardinality()
        System.out.println();
        System.out.println("union() and cardinality():");

        integerTests.testUnion_cardinality();
        stringTests.testUnion_cardinality();
        System.out.println("Test testUnion_cardinality run sucessfully " + testUnion_cardinality + " times");
        
        // Tests for union() and cardinality() and inter()
        System.out.println();
        System.out.println("union() and cardinality() and inter():");

        integerTests.testUnion_cardinality_inter();
        stringTests.testUnion_cardinality_inter();
        System.out.println("Test testUnion_cardinality_inter run sucessfully " + testUnion_cardinality_inter + " times");
        
        // Tests for equal() and inter() and cardinality()
        System.out.println();
        System.out.println("equal() and inter() and cardinality():");

        integerTests.testEqual_inter();
        stringTests.testEqual_inter();
        System.out.println("Test testEqual_inter run sucessfully " + testEqual_inter + " times");
        
    }
    
     

    public void fixedTests() {
        /*
         Bag empty = new EmptyBag();
         Bag B1 = new NEmptyBag(9, 2, new NEmptyBag(7, 3, new NEmptyBag(5, 3, empty, empty), empty),
         new NEmptyBag(11, 1, empty, empty));
         Bag B2 = new NEmptyBag(10, 3, empty, empty);
         Bag B3 = new NEmptyBag(3, 1, empty, empty);
         Bag B4 = new NEmptyBag(5, 10, empty, new NEmptyBag(7, 2, empty, empty));
         Bag B5 = new NEmptyBag(5, 5, empty, new NEmptyBag(7, 1, empty, empty));

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

         // Diff()
         System.out.println();
         System.out.println("Cardinality should be 9: " + B1.cardinality());
         System.out.println("Cardinality should be 4: " + B4.diff(B1).cardinality());
         System.out.println("Cardinality should be 7: " + B1.diff(B4).cardinality());
         System.out.println("Member should be false: " + B1.diff(B4).member(7));

         // Subset()
         System.out.println();
         System.out.println("Subset should be False: " + B4.subset(B5));
         System.out.println("Subset should be True: " + B5.subset(B4));
         System.out.println("Subset should be True: " + B4.subset(B4));

         // equal()
         System.out.println();
         System.out.println("Subset should be False: " + B4.equal(B5));
         System.out.println("Subset should be False: " + B5.equal(B4));
         System.out.println("Subset should be True: " + B4.equal(B4));

         */
    }
}
