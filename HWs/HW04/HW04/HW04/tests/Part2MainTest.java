import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Part2MainTest {

    /**
     * Part 2 Main Test
     */
    @Test
    public void main() {

        // CTGeneral Search Tree Objects
        CTGeneralSearchTree cst1 = new CTGeneralSearchTree();
        CTGeneralSearchTree cst2 = new CTGeneralSearchTree();
        CTGeneralSearchTree cst3 = new CTGeneralSearchTree();

        // Node Objects
        MultiDataNode o1 = new MultiDataNode(1,4,7);
        MultiDataNode o2 = new MultiDataNode(3,2,8);
        MultiDataNode o4 = new MultiDataNode(15,9,20);
        MultiDataNode o5 = new MultiDataNode(18,30,35);
        MultiDataNode o3 = new MultiDataNode(45,70,90);

        // Add node objects to tree
        cst1.add(o3);
        cst1.add(o5);
        cst1.add(o2);
        cst1.add(o4);
        cst1.add(o1);
        cst1.display(cst1.root);

        System.out.println();

        // Default number of coordinate is 3.
        // First coordinates will be real number, others will be null.
        MultiDataNode o6 = new MultiDataNode(10);
        MultiDataNode o7 = new MultiDataNode(9);
        MultiDataNode o8 = new MultiDataNode(25);
        MultiDataNode o9 = new MultiDataNode(68);
        MultiDataNode o10 = new MultiDataNode(93);
        MultiDataNode o11 = new MultiDataNode(2);

        cst2.add(o6);
        cst2.add(o7);
        cst2.add(o8);
        cst2.add(o9);
        cst2.add(o10);
        cst2.add(o11);
        cst2.display(cst2.root);


        System.out.println();

        // Character parameters

        MultiDataNode o12 = new MultiDataNode('k','s','t');
        MultiDataNode o13 = new MultiDataNode('h','i','j');
        MultiDataNode o14 = new MultiDataNode('u','v','z');
        MultiDataNode o15 = new MultiDataNode('a','b','d');
        MultiDataNode o16 = new MultiDataNode('s','w','y');
        MultiDataNode o17 = new MultiDataNode('c','m','k');
        MultiDataNode o18 = new MultiDataNode('c','s','e');
        cst3.add(o12);
        cst3.add(o13);
        cst3.add(o14);
        cst3.add(o15);
        cst3.add(o16);
        cst3.add(o17);
        cst3.add(o18);
        cst3.display(cst3.root);


    }
}