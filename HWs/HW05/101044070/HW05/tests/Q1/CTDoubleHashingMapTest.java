package Q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CTDoubleHashingMapTest {

    CTDoubleHashingMap<Integer, String> testObject = new CTDoubleHashingMap<>(101);

    /*
    Test size() method
     */
    @Test
    public void size() {

        testObject.put(14, "Ali");              // Assign to 14
        testObject.put(24, "Veli");             // Assign to 24
        assertEquals(2, testObject.size());
        System.out.println("size() method is succesfull !!");
    }

    /**
     * Test isEmpty() method
     */
    @Test
    public void isEmpty() {

        assertEquals(true, testObject.isEmpty());
        System.out.println("isEmpty() method is succesfull !!");
    }

    /**
     * Test get() method
     */
    @Test
    public void get() {

        testObject.put(10, "Ece");              // Assign to 10
        testObject.put(10, "Ege");              // Assign to 59
        testObject.put(10, "Can");              // Assign to 7

        assertEquals("Ece", testObject.get(10));
        assertEquals("Ege", testObject.get(59));
        assertEquals("Can", testObject.get(7));
        System.out.println("get() method is succesfull !!");
    }


    @Test
    public void put() {

        assertEquals("Ece",  testObject.put(10, "Ece") );
        assertEquals("Ege",  testObject.put(10, "Ege") );
        assertEquals("Can",  testObject.put(10, "Can") );
        System.out.println("put() method is succesfull !!");

    }


    /**
     * Test hash1 function
     */
    @Test
    public void hash1Function() {

        int key = 44;
        int tableSize = 101;
        assertEquals(key, key % tableSize);
        System.out.println("hash1Function() method is succesfull !!");
    }

    /**
     * Test hash2 function
     */
    @Test
    public void hash2Function() {

        int key = 44;
        int tableSize = 101;
        int result = 59 - (key % tableSize);

        assertEquals(15, result);
        System.out.println("hash2Function() method is succesfull !!");

    }

    /**
     * Test remove() method
     */

    @Test
    public void remove() {

        testObject.put(10, "Ece");              // Assign to 10
        testObject.put(10, "Ege");              // Assign to 59
        testObject.put(10, "Can");              // Assign to 7

        assertEquals("Ece", testObject.remove(10));
        assertEquals("Ege", testObject.remove(59));
        assertEquals("Can", testObject.remove(7));

        assertEquals(0,testObject.size());
        System.out.println("remove() method is succesfull !!");

    }

}