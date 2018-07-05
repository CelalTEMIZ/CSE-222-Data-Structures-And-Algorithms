package Q3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeMainTest {

    @Test
    public void main() {

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

        // These items will change the tree state.

        /*
        tree.root.right.right = new BinaryTree.Node(14);
        tree.root.right.right.left = new BinaryTree.Node(13);
        tree.root.right.right.right = new BinaryTree.Node(15);
        */

        // Create AVL tree object that takes a binary tree
        AVLTree<Integer> t2 = new AVLTree<>(tree);
        boolean checkTreeState = t2.checkBalanceState(tree.root);

        if(checkTreeState)
            System.out.println("\nGiven tree is an AVL tree !!");
        else
            System.out.println("\nGiven tree is not AVL tree !!");

        System.out.println("\nAVL Tree main test is successfull !! ");
    }


}