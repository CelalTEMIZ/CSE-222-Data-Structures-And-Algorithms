package Q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Main JUNIT Test
 */
public class MainTest {

    @Test
    public void main() {

        CTDoubleHashingMap<Integer,String> mainTestObject1 = new CTDoubleHashingMap<>(101);

        // isEmpty() method test
        assertEquals(true,mainTestObject1.isEmpty());
        System.out.println("isEmpty() method is succesfull  !!");

        // put() method test
        assertEquals("Ali",  mainTestObject1.put(14, "Ali"));      // Assign to 14.slot
        assertEquals("Veli", mainTestObject1.put(24, "Veli"));     // Assign to 24.slot
        assertEquals("Ayşe", mainTestObject1.put(34, "Ayşe"));     // Assign to 34.slot
        assertEquals("Ece",  mainTestObject1.put(10, "Ece"));      // Assign to 10.slot
        assertEquals("Ege",  mainTestObject1.put(10, "Ege"));      // Assign to 59.slot
        assertEquals("Can",  mainTestObject1.put(10, "Can"));      // Assign to 7.slot
        assertEquals("Deniz",  mainTestObject1.put(10,"Deniz"));   // Assign to 56.slot
        assertEquals("Su",  mainTestObject1.put(10, "Su"));        // Assign to 4.slot
        System.out.println("put() method is succesfull !!");


        // get() method test
        assertEquals("Ali",mainTestObject1.get(14));
        assertEquals("Veli",mainTestObject1.get(24));
        assertEquals("Ayşe",mainTestObject1.get(34));
        assertEquals("Ece",mainTestObject1.get(10));
        assertEquals("Ege",mainTestObject1.get(59));
        assertEquals("Can",mainTestObject1.get(7));
        assertEquals("Deniz",mainTestObject1.get(56));
        assertEquals("Su",mainTestObject1.get(4));
        System.out.println("get() method is succesfull !!");

        // size() method test
        assertEquals(8,mainTestObject1.size());
        System.out.println("size() method is succesfull !!");

        // Remove() method test
        assertEquals("Ali", mainTestObject1.remove(14));
        assertEquals("Veli", mainTestObject1.remove(24));
        assertEquals("Ayşe", mainTestObject1.remove(34));
        assertEquals("Ece", mainTestObject1.remove(10));
        assertEquals("Ege", mainTestObject1.remove(59));
        assertEquals("Can", mainTestObject1.remove(7));
        assertEquals("Deniz", mainTestObject1.remove(56));
        assertEquals("Su", mainTestObject1.remove(4));
        System.out.println("remove() method is succesfull !!");

        assertEquals(0,mainTestObject1.size());


    }
}