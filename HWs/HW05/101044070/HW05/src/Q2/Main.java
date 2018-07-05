package Q2;

public class Main {

    public static void main(String args[]){

        // Test object
        CTRecursiveHashingSet<Integer> o1 = new CTRecursiveHashingSet<>(50);


        // Test add method
        o1.add(4);
        o1.add(4);
        o1.add(14);
        o1.add(24);
        o1.add(34);

        o1.printHashTable();


    }
}
