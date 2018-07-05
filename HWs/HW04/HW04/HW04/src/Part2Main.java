
public class Part2Main
{

    public static void main(String[] args)
    {

        // CTGeneral Search Tree Objects
        CTGeneralSearchTree cst1 = new CTGeneralSearchTree();
        CTGeneralSearchTree cst2 = new CTGeneralSearchTree();
        CTGeneralSearchTree cst3 = new CTGeneralSearchTree();

        // Node Objects
        MultiDataNode o1 = new MultiDataNode(1,2,3);
        MultiDataNode o2 = new MultiDataNode(4,5,6);
        MultiDataNode o4 = new MultiDataNode(10,12,13);
        MultiDataNode o5 = new MultiDataNode(21,22,23);
        MultiDataNode o3 = new MultiDataNode(7,8,9);

        // Add node object to the tree
        cst1.add(o3);
        cst1.add(o5);
        cst1.add(o2);
        cst1.add(o4);
        cst1.add(o1);
        cst1.display(cst1.root);

        System.out.println();

        // Default number of coordinate is 3.
        // First coordinates will be real number, others will be null.

        MultiDataNode o6 = new MultiDataNode(1);
        MultiDataNode o7 = new MultiDataNode(3);
        MultiDataNode o8 = new MultiDataNode(2);
        cst2.add(o6);
        cst2.add(o7);
        cst2.add(o8);
        cst2.display(cst2.root);

        System.out.println();


        // Character parameter test
        MultiDataNode o9 = new MultiDataNode('a','s','d');
        MultiDataNode o10 = new MultiDataNode('c','e','g');
        MultiDataNode o11 = new MultiDataNode('b','f','l');
        MultiDataNode o12 = new MultiDataNode('k','s','t');
        MultiDataNode o13 = new MultiDataNode('h','i','j');
        MultiDataNode o14 = new MultiDataNode('u','v','z');
        cst3.add(o9);
        cst3.add(o10);
        cst3.add(o11);
        cst3.add(o12);
        cst3.add(o13);
        cst3.add(o14);
        cst3.display(cst3.root);



    }


}
