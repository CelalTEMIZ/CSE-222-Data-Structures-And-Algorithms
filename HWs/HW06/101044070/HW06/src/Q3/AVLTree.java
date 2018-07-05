package Q3;

/*<listing chapter="9" section="2">*/

import static java.lang.Math.abs;

/**
 * Self-balancing binary search tree using the algorithm defined
 * by Adelson-Velskii and Landis.
 * @author Koffman and Wolfgan
 */
public class AVLTree<E
        extends Comparable<E>>
        extends BinarySearchTreeWithRotate<E> {

    // Insert nested class AVLNode<E> here.
    /*<listing chapter="9" number="2">*/
    /** Class to represent an AVL Node. It extends the
     * BinaryTree.Node by adding the balance field.
     */
    private static class AVLNode<E> extends Node<E> {

        /** Constant to indicate left-heavy */
        public static final int LEFT_HEAVY = -1;
        /** Constant to indicate balanced */
        public static final int BALANCED = 0;
        /** Constant to indicate right-heavy */
        public static final int RIGHT_HEAVY = 1;
        /** balance is right subtree height - left subtree height */
        private int balance;

        // Methods
        /**
         * Construct a node with the given item as the data field.
         * @param item The data field
         */
        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        /**
         * Return a string representation of this object.
         * The balance value is appended to the contents.
         * @return String representation of this object
         */
        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }
    /*</listing>*/
    // Data Fields
    /** Flag to indicate that height of tree has increased. */
    private boolean increase;

// Insert solution to programming project 5, chapter -1 here


////////////////////////////   HW 06   //////////////////////////////////////////////////////

    // Flag to indicate that height of tree has decreased.
    private boolean decrease;


    private static boolean rotateState = false;
    /**
     * No parameter constructor
     */
    public AVLTree()
    {
        increase=false;
        decrease=false;
    }

    /**
     * Constructor that takes a binary tree and checks whether this tree is AVL tree or not.
     * @param treeObject The binary tree object
     */
    public AVLTree(BinaryTree<E> treeObject) {
        checkBalanceState(treeObject.root);
    }
////////////////////////////   END OF THIS PART   //////////////////////////////////////////////////////

    // Methods
    /**
     * add starter method.
     * @pre the item to insert implements the Comparable interface.
     * @param item The item being inserted.
     * @return true if the object is inserted; false
     *         if the object already exists in the tree
     * @throws ClassCastException if item is not Comparable
     */
    @Override
    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        return addReturn;
    }


    /**
     * Recursive add method. Inserts the given object into the tree.
     * @post addReturn is set true if the item is inserted,
     *       false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root of the subtree with the item
     *         inserted
     */
    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }

        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item < data
            localRoot.left = add((AVLNode<E>) localRoot.left, item);

            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        } else { // item > data


// Insert solution to programming exercise 2, section 2, chapter 9 here

////////////////////////////   HW 06   //////////////////////////////////////////////////////

            localRoot.right=add((AVLNode<E>) localRoot.right, item);

            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    return rebalanceRight(localRoot);
                }
            }
            return localRoot;
        }

////////////////////////////   END OF THIS PART   //////////////////////////////////////////////////////
    }

    /*<listing chapter="9" number="3">*/
    /**
     * Method to rebalance left.
     * @pre localRoot is the root of an AVL subtree that is
     *      critically left-heavy.
     * @post Balance is restored.
     * @param localRoot Root of the AVL subtree
     *        that needs rebalancing
     * @return a new localRoot
     */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {


        // If there is any rotation in the given tree, change the flag to true.
        rotateState = true;


        // Obtain reference to left child.
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child.
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            // Adjust the balances to be their new values after
            // the rotations are performed.
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.left = rotateLeft(leftChild);
        } else { //Left-Left case
            // In this case the leftChild (the new root)
            // and the root (new right child) will both be balanced
            // after the rotation.
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate the local root right.
        return (AVLNode<E>) rotateRight(localRoot);
    }
    /*</listing>*/

// Insert solution to programming exercise 1, section 2, chapter 9 here

/////////////////////////////////// HW 06 /////////////////////////////////////////////////////////////

    /**
     * Method to rebalance right.
     * @param localRoot Root of the AVL subtree that needs rebalancing
     * @return a new localroot
     */
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {

        // If there is any rotation in the given tree, change the flag to true.
        rotateState = true;

        // Obtain reference to right child
        AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
        // See whether right-left heavy.
        if (rightChild.balance < AVLNode.BALANCED) {
            // Obtain reference to right-left child.
            AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
            /** Adjust the balances to be their new values after
             the rotations are performed.
             */
            if (rightLeftChild.balance < AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else if (rightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            } else {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform right rotation.
            localRoot.right = rotateRight(rightChild);
        } else { // Right-right case
      /* In this case both the rightChild (the new root)
         and the root (new left child) will both be balanced
         after the rotation.
       */
            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }

        increase = false; // No increase to balance after the right balance
        decrease = true;  // Opposite the increase state to balance after the right balance
        // Now rotate the local root right.
        return (AVLNode<E>) rotateLeft(localRoot);

/////////////////////////////////// END OF THIS PART ///////////////////////////////////////////////////
    }
    /*</listing>*/


    /**
     * Method to decrement the balance field and to reset the value of
     * increase.
     * @pre The balance field was correct prior to an insertion [or
     *      removal,] and an item is either been added to the left[
     *      or removed from the right].
     * @post The balance is decremented and the increase flags is set
     *       to false if the overall height of this subtree has not
     *       changed.
     * @param node The AVL node whose balance is to be incremented
     */
    private void decrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance--;
        if(node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not increased.
            increase = false;
        }
    }

// Insert solution to programming exercise 3, section 2, chapter 9 here

/////////////////////////////////// HW 06 /////////////////////////////////////////////////////////////

    /**
     * Method to increment the balance
     * @param node The AVL node whose balance is to be incremented
     */
    private void incrementBalance(AVLNode<E> node){
        // increment the balance
        node.balance++;

        // Change the increase and decrease fields from the right rebelance.
        // Otherwise, height will not increased.
        if(node.balance >= AVLNode.BALANCED){
            increase=true;
            decrease=false;
        }

        // If the node's balance is smaller than the balance = 0,
        if(node.balance < AVLNode.BALANCED) {
            increase = false;
            decrease = true;
        }
    }

/////////////////////////////////// END  OF THIS PART ////////////////////////////////////////

////////////////////////////   HW 06    //////////////////////////////////////////////////////
    /**
     * Check the balance state of a given tree
     * @param treeRoot Tree node
     * @return true if the given tree is balanced, otherwise returns false.
     */
    public boolean checkBalanceState(Node<E> treeRoot)
    {
        // if the node is null, the node is balance and balance factor is 0.
        if(treeRoot==null){
            return true;
        }
        // Balance factor has to be less than or equal to 1
        if (abs(heightOfSubtree(treeRoot.left)-heightOfSubtree(treeRoot.right))<=1) {
            // And subtrees have to be balanced.
            if (checkBalanceState(treeRoot.left) && checkBalanceState(treeRoot.right) && rotateState==false)
                return true;
            // Otherwise, return false
        } else {
            return false;
        }

        return false;
    }
    /**
     * Calculate the height of given tree
     * @param treeNode root of the tree
     * @return height of tree
     */
    private int heightOfSubtree(Node<E> treeNode)
    {
        // if the node is null, returns -1
        if (treeNode==null) {
            return -1;
        }else{
            int heightOfLeftSubtree = heightOfSubtree(treeNode.left);
            int heightOfRightSubtree= heightOfSubtree(treeNode.right);
            // add the current node
            if(heightOfLeftSubtree > heightOfRightSubtree )
                return 1+heightOfLeftSubtree;
            else
                return 1+heightOfRightSubtree;
        }
    }

////////////////////////////   END OF THIS PART   //////////////////////////////////////////////////////

// Insert solution to programming project 5, chapter -1 here
}
