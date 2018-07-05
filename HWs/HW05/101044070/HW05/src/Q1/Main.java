package Q1;


public class Main {

    public static void main(String args[])
    {
        CTDoubleHashingMap<Integer, String> m1 = new CTDoubleHashingMap<>(101);
        System.out.println("**************************** START TEST 1 *************************");
        // isEmpty() method test
        if(m1.isEmpty()) {

            // Put() method test
            m1.put(14, "Ali");              // No Collision - Assign Ali  to 14.slot
            m1.put(24, "Veli");             // No Collision - Assign Veli to 24.slot
            m1.put(34, "Ayşe");             // No Collision - Assign Ayşe to 34.slot
            m1.put(10, "Ece");              // No Collision - Assign Ece to 10.slot
            m1.put(10, "Ege");              // Collision 1  - Assign Ege to 59.slot
            m1.put(10, "Can");              // Collision 2  - Assign Can to 7.slot
            m1.put(10, "Deniz");            // Collision 3  - Assign Deniz to 56.slot
            m1.put(10, "Su");               // Collision 4  - Assign Su to 4.slot
            m1.put(14, "Caner");            // Collision 5  - Assign Caner to 3.slot
            m1.put(3, "Pelin");             // Collision 7  - Assign Pelin to 70.slot
            m1.put(3, "Arda");              // Collision 8  - Assign Arda to 25.slot
            m1.put(25,"Semih");             // Collision 9  - Assign Semih to 93.slot
            m1.put(25,"Berke Can");         // Collision 10 - Assign Berke Can to 26.slot


            // Get() method test
            System.out.println("\n***** get() Method Test - 1 *****");
            System.out.println(m1.get(14));     // Ali
            System.out.println(m1.get(24));     // Veli
            System.out.println(m1.get(34));     // Ayşe
            System.out.println(m1.get(10));     // Ece
            System.out.println(m1.get(59));     // Ege
            System.out.println(m1.get(7));      // Can
            System.out.println(m1.get(56));     // Deniz
            System.out.println(m1.get(4));      // Su
            System.out.println(m1.get(3));      // Caner
            System.out.println(m1.get(70));     // Pelin
            System.out.println(m1.get(25));     // Arda
            System.out.println(m1.get(93));     // Semih
            System.out.println(m1.get(26));     // Berke Can


            // size() method test
            System.out.printf("Initial size of m1 after the put() method calls: %d\n", m1.size());
        }
        // Print hash table
        System.out.println("\n************************** Hash Table - 1 ************************* ");
        m1.printHashTable();

        // Remove() method test
         System.out.println("\n***** remove() Method Test - 1 *****");
        System.out.println(m1.remove(14));
        System.out.println(m1.remove(24));
        System.out.println(m1.remove(34));
        System.out.println(m1.remove(10));
        System.out.println(m1.remove(59));
        System.out.println(m1.remove(7));
        System.out.println(m1.remove(56));
        System.out.println(m1.remove(4));

        System.out.println("\n************************** Hash Table - 1 ************************* ");
        m1.printHashTable();
        System.out.printf("Last size of m1 after the remove() method calls : %d\n", m1.size());
        System.out.println("**************************** END TEST 1 *************************");



        System.out.println("*************************** START TEST 2 *******************************");

        CTDoubleHashingMap<Integer, Integer> m2 = new CTDoubleHashingMap<>(150);

        // isEmpty() method test
        if(m2.isEmpty()) {

            // Put() method test
            m2.put(10, 10);              // No Collision - Assign 10 to 10.slot
            m2.put(20, 20);              // No Collision - Assign 20 to 20.slot
            m2.put(30, 30);              // No Collision - Assign 30 to 30.slot
            m2.put(40, 40);              // No Collision - Assign 40 to 40.slot
            m2.put(40, 100);             // Collision 1  - Assign 100 to 59.slot
            m2.put(59, 150);             // Collision 2  - Assign 150 to 118.slot
            m2.put(59, 300);             // Collision 3  - Assign 300 to 27.slot
            m2.put(27, 444);             // Collision 4  - Assign 444 to 91.slot
            m2.put(27, 55);              // Collision 5  - Assign 55 to 123.slot


            // Get() method test
            System.out.println("\n***** get() Method Test - 2 *****");
            System.out.println(m2.get(10));     // 10
            System.out.println(m2.get(20));     // 20
            System.out.println(m2.get(30));     // 30
            System.out.println(m2.get(40));     // 40
            System.out.println(m2.get(59));     // 100
            System.out.println(m2.get(118));    // 150
            System.out.println(m2.get(27));     // 300
            System.out.println(m2.get(91));     // 444
            System.out.println(m2.get(123));    // 55

            // size() method test
            System.out.printf("Initial size of m2 after the put() method calls: %d\n", m2.size());
        }

        System.out.println("\n************************** Hash Table - 2 ************************* ");
        m2.printHashTable();

        System.out.println("\n***** remove() Method Test - 2 *****");
        System.out.println(m2.remove(10));
        System.out.println(m2.remove(20));     // 20
        System.out.println(m2.remove(30));     // 30
        System.out.println(m2.remove(40));     // 40
        System.out.println(m2.remove(59));     // 100
        System.out.println(m2.remove(118));    // 150
        System.out.println(m2.remove(27));     // 300
        System.out.println(m2.remove(91));     // 444
        System.out.println(m2.remove(123));    // 55

        System.out.println("\n************************** Hash Table - 2 ************************* ");
        m2.printHashTable();
        System.out.printf("Last size of m2 after the remove() method calls : %d\n", m2.size());
        System.out.println("**************************** END TEST 2 *************************");

    }
}
