package Q2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BTreeMainTest {

    @Test
    public void main()
    {
        // Test 1
        BTree<Integer> btree = new BTree<Integer>(5);
        btree.add(10);
        System.out.println(btree.toString());

        btree.add(39);
        System.out.println(btree.toString());

        btree.add(30);
        System.out.println(btree.toString());

        btree.add(22);
        System.out.println(btree.toString());


        // Test 2
        BTree<Character> btree1 = new BTree<Character>(4);

        btree1.add('k');
        System.out.println(btree1.toString());

        btree1.add('c');
        System.out.println(btree1.toString());

        btree1.add('b');
        System.out.println(btree1.toString());

        btree1.add('a');
        System.out.println(btree1.toString());

        System.out.println("B Tree main test is successfull !! ");
    }

}