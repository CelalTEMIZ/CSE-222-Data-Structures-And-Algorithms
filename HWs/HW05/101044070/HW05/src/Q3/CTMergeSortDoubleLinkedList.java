package Q3;

/**
 * Merge Sort with Double Linked List
 * @param <E>
 */
public class CTMergeSortDoubleLinkedList
        <E extends Comparable <E>>
        implements Comparable<CTMergeSortDoubleLinkedList>  {

    // Node Class
    public static class Node<E> {
        // Data Field
        E data;
        Node<E> next = null;
        Node<E> prev = null;

        // Constructors
        public Node(E dataItem) {
            data = dataItem;
        }
        public Node(E dataItem, Node<E> next, Node<E> prev)
        {
            this.data = dataItem;
            this.next = next;
            this.prev = prev;
        }
        // Setters
        public void setNext(Node<E> next){this.next=next;}
        public void setPrev(Node<E> prev){this.prev=prev;}
        public void setData(E data) {this.data=data;}

        // Getters
        public Node<E> getNext() { return this.next; }
        public Node<E> getPrev()
        {
            return this.prev;
        }
        public E getData()
        {
            return this.data;
        }
    }

    // Keep the header to linked list structure
    public Node<E> header;

    public Node<E> divideTheListToTwoPieces(Node<E> head) {

        // Assign list head to left and right nodes
        Node<E> left  = head;
        Node<E> right = head;

        // If head is null or head.next is equal to null
        if(head == null || head.next == null)
        {
            head.prev = null;
            head.next = left;
        }

        // Check the nodes from left nodes to right nodes
        for(; left.next != null && left.next.next != null; left = left.next.next)
            right = right.next;

        // Keep last right node and return node of right.next
        Node<E> old = right.next;
        right.next  = null;

        return old;
    }

    // Sort Operation
    public Node<E> sortOperation(Node<E> node) {

        Node<E> right  = null;
        Node<E> result = null;

        if (node == null ) {
            return node;
        }
        else if(node.next == null)
        {
            return node;
        }

        // Divide the list to two pieces and get the node of right.next
        // Assign to new temporary node
        right = divideTheListToTwoPieces(node);

        // Merge list pieces after the sort operations
        result = mergeOperation(sortOperation(node), sortOperation(right));

        return result;
    }

    /**
     * Merge Operation to two lists
     * @param leftSequence The left list
     * @param rightSequence The right list
     * @return The merged list
     */
    public Node<E> mergeOperation(Node<E> leftSequence, Node<E> rightSequence)
    {
        Node<E> mergedList = null;

        // if the any list is null, return other list to process
        if(leftSequence == null) {
            return rightSequence;

        }else if(rightSequence == null) {
            return leftSequence;
        }

        // if the data is smaller than the right sequence data
        // Assign the leftSequence node to mergedList
        // Then looks at the next nodes of leftSequence and rightSeqeunce nodes again
        if(leftSequence.data.compareTo(rightSequence.data) < 0) {
            mergedList = leftSequence;
            mergedList.next = mergeOperation(leftSequence.next, rightSequence);

        }else{   // Else makes same operation to rightSequence nodes
           mergedList = rightSequence;
           mergedList.next = mergeOperation(leftSequence,rightSequence.next);
        }

        // Return merged list
        return mergedList;
    }

    /**
     * Add element to the linked list
     * @param element The
     */
    public void add(E element)
    {
        Node<E> node = new Node(element);

        node.next = header;

        if(header != null) {
            header.prev = node;
        }
        header = node;
    }

    /**
     * Print sorted list
     * @param head The header of given linked list
     */
    public void printSortedList(Node<E> head)
    {
        while (head != null)
        {
            System.out.print(head.data +" ");
            head = head.next;
        }
    }

    @Override
    public int compareTo(CTMergeSortDoubleLinkedList ctMergeSortDoubleLinkedList) {
        return 0;

    }


}
 