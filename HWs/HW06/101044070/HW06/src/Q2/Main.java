package Q2;

public class Main {

    public static void main(String[]args)
    {
        BTree<Integer> btree = new BTree<Integer>(5);
        btree.add(10);
        System.out.println(btree.toString());
        btree.add(40);
        System.out.println(btree.toString());
        btree.add(30);
        System.out.println(btree.toString());
        btree.add(22);
        System.out.println(btree.toString());


        btree.add(13);
        System.out.println(btree.toString());
        btree.add(20);
        System.out.println(btree.toString());
        btree.add(18);
        System.out.println(btree.toString());
        btree.add(15);
        System.out.println(btree.toString());

    }
}
