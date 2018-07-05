import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree< E extends Comparable<E>>
{
    // Data Field
    public Node<E> root;
    private boolean addReturn;

    // The Node Class Implementation
    protected class Node<E> implements Serializable
    {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data)
        {
            this.data = data;
            left  = null;
            right = null;
        }

        public E getData()
        {
            return this.data;
        }

        public void setData(E data)
        {
            this.data=data;
        }


        public Node<E> getLeft()
        {
            return left;
        }

        public void setLeft(Node<E> left)
        {
            this.left = left;
        }


        public Node<E> getRight()
        {
            return right;
        }


        public void setRight(Node<E> right)
        {
            this.right = right;
        }

        public String toString()
        {
            return data.toString();
        }

    }


    /**
     * The no-parameter constructor merely sets the data field root to null.
     */
    public BinaryTree()
    {
        root = null;
    }

    /**
     * The constructor takes a Node as a parameter is protected constructor.
     * @param root
     */
    protected BinaryTree(Node <E> root)
    {
        this.root=root;
    }


    /**
     * Constructs a new binary tree with data in its root leftTree
     * as its left subtree and rightTree as its right subtree
     * @param data Data
     * @param leftTree Left Tree
     * @param rightTree Right Tree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
    {
        root = new Node<E>(data);

        if(leftTree!=null)
        {
            root.left=leftTree.root;
        }
        else
        {
            root.left=null;
        }

        if(rightTree!=null)
        {
            root.right=rightTree.root;
        }
        else
        {
            root.right=null;
        }
    }

    /**
     * Return the left subtree.
     * @return The left subtree or null if either the root or the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree()
    {
        if(root!=null && root.left!=null)
        {
            return new BinaryTree<E>(root.left);
        } else {
            return  null;
        }
    }

    /**
     * Return the right subtree.
     * @return The right subtree or null if either the root or the right subtree is null
     */
    public BinaryTree<E> getRightSubtree()
    {
        if(root!=null && root.left!=null){
            return new BinaryTree<E>(root.right);
        } else {
            return  null;
        }
    }

    /**
     * Determine whether this tree is a leaf
     * @return true if the root has no children
     */
    public boolean isLeaf()
    {
        return (root.left==null && root.right==null);
    }


    /** Started method add.
     pre: The object to insert must implement the Comparable interface
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exist in the tree
     */
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    /** Recursive add method.
     *  post: The data field addReturn is set true if the item is added to the tree,
     *  false if the item is already in the tree
     *  @param localRoot The local root of the subtree
     *  @param item The object to be inserted
     *  @return The new local root that now contains the inserted item
     */
    private Node<E> add(Node<E> localRoot, E item)
    {
        if (localRoot == null)
        {
            // item is not in the tree - insert it.
            addReturn = true;
            return new Node<E>(item);
        }

        else if (item.compareTo(localRoot.data) == 0)
        {
            // item is equal to localRot.data
            addReturn = false;
            return localRoot;
        }

        else if (item.compareTo(localRoot.data) < 0)
        {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        else
        {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }

    }


    /**
     * Perform a preorder traversal,
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    public void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
    {
        for(int i=1; i<depth; i++)
        {
            sb.append(" ");
        }

        if(node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth+1, sb);
            preOrderTraverse(node.right, depth, sb);
        }
    }


    /**
     * Level-Order Iterator Implementation
     * @param <E>
     */
    private class LevelOrderIterator<E> implements Iterator<E>
    {
        // Nodes queue to poll the passed nodes
        private Queue<Node<E>> passedNodes = new LinkedList<>();

        /**
         * No parameter constructor
         * Call level order search mehtod when the initialize
         */
        public LevelOrderIterator()
        {
            levelOrderSearch(root,null);
        }

        /**
         * hasNext() method override
         * @return true if the nodes queue has any node.
         */
        @Override
        public boolean hasNext(){return !passedNodes.isEmpty(); }

        /**
         * next() method override
         * @return next node item
         */
        @Override
        public E next() {
            // Remove and return the head of the passedNodes queue.
            Node<E> node = passedNodes.poll();
            return  node.data;
        }

        /**
         * Traverses the tree in level order;
         * First the root node (i.e., the node in the first level),
         * then the children of the root node (i.e., nodes in the second level),
         * then the children of the nodes in the second level (i.e., nodes in the third level), and so on.
         * @param rootNode Root node
         * @param item  item node
         * @return true if the item is in the three. Otherwise, returns false
         */

        private boolean levelOrderSearch(Node rootNode, Node<E> item)
        {

            if(rootNode != null)
            {
                passedNodes.offer(rootNode);
                levelOrderSearch(rootNode.right, item);
                levelOrderSearch(rootNode.left, item);
                return true;
            }
            else {
                return false;
            }

        }

    }

    /**
     * Create new iterator object
     * @return New level order iterator object
     */
    public Iterator<E> levelOrderIterator()
    {
        return new LevelOrderIterator<>();
    }


    ////////// Post Order Iterator Class Implementation ////////////////////


    /**
     * Post-Order Iterator Class Implementation
     * @param <E>
     */
    private class PostOrderIterator<E> implements Iterator<E>
    {
        // Nodes queue to poll the passed nodes
        private Queue<Node<E>> passedNodes = new LinkedList<>();

        /**
         * No parameter constructor
         */
        public PostOrderIterator()
        {
            postOrderSearch(root,null);
        }

        /**
         * hasNext() method override
         * @return true if the nodes queue has any node.
         */
        @Override
        public boolean hasNext()
        {
            return !(passedNodes.isEmpty());
        }

        /**
         * next() method override to iterator
         * @return next node item
         */
        @Override
        public E next()
        {
            // Remove and return the head of the passedNodes queue.
            Node<E> node = passedNodes.poll();
            return  node.data;
        }

        /**
         *
         * @param rootNode  root node
         * @param item item  node
         * @return true if the item is in the three. Otherwise, returns false
         */
        private boolean postOrderSearch(Node rootNode, Node<E> item)
        {
            if(rootNode!=null)
            {
                postOrderSearch(rootNode.left, item);
                passedNodes.offer(rootNode);
                postOrderSearch(rootNode.right, item);
                return true;
            }
            else {
                return false;
            }
        }
    }


    public Iterator<E> postOrderIterator()
    {
        return new PostOrderIterator<>();
    }


}