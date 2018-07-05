package Q3;


public class Main {

    public static void main(String args[]){

        BinaryTree<Integer> tree = new BinaryTree();

        // Root
        tree.root = new BinaryTree.Node(8);

        // Left items
        tree.root.left = new BinaryTree.Node(4);
        tree.root.left.left = new BinaryTree.Node(2);
        tree.root.left.left.left = new BinaryTree.Node(1);
        tree.root.left.left.left = new BinaryTree.Node(3);
        tree.root.left.right = new BinaryTree.Node(6);
        tree.root.left.right.left = new BinaryTree.Node(5);
        tree.root.left.right.right = new BinaryTree.Node(7);

        // Right items
        tree.root.right = new BinaryTree.Node(12);
        tree.root.right.left = new BinaryTree.Node(10);
        tree.root.right.left.left = new BinaryTree.Node(9);
        tree.root.right.left.right = new BinaryTree.Node(11);
        tree.root.right.right = new BinaryTree.Node(14);
        tree.root.right.right.left = new BinaryTree.Node(13);
        tree.root.right.right.right = new BinaryTree.Node(15);

        // Create AVL tree object that takes a binary tree
        AVLTree<Integer> t2 = new AVLTree<>(tree);
        boolean checkTreeState = t2.checkBalanceState(tree.root);

        if(checkTreeState)
            System.out.println("\nGiven tree is an AVL tree !!");
        else
            System.out.println("\nGiven tree is not AVL tree !!");


        // Test avl tree edited add method
        avlTreeTest();

    }


    public static void avlTreeTest()
    {
        System.out.println("\n--------- AVL Tree add() method test -----------------\n");

        AVLTree<Integer> avl1 = new AVLTree<>();
        avl1.add(5);
        System.out.println(avl1.toString());
        avl1.add(10);
        System.out.println(avl1.toString());
        avl1.add(15);
        System.out.println(avl1.toString());
        avl1.add(20);
        System.out.println(avl1.toString());
        avl1.add(25);
        System.out.println(avl1.toString());
    }
}
