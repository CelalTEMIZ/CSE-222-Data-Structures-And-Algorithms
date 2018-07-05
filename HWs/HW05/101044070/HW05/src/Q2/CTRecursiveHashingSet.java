package Q2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class CTRecursiveHashingSet<E> implements CTSet<E> {

    // The table
    private  Data < E >[] table;
    // The number of elements
    private int numberOfElements;
    // The number of deleted elements
    private int numberOfDeletedElements;
    // The capacity
    private int capacity;
    // The load factor
    private static final double LOAD_THRESOLD = 3.0;

    // Deleted Data Object
    private final Data < E > DELETED = new Data <E > (null);


    public CTRecursiveHashingSet(int capacity)
    {
        table = new Data[capacity];
        this.capacity = capacity;
    }

    public int getCapacity(){ return capacity; }

    public void setCapacity(int capacity) {this.capacity=capacity;}



    static class Data<E>{

        // The data
        private E data;

        /**
         * One parameter constructor
         * @param data
         */
        public Data(E data)
        {
            this.data = data;
        }

        /**
         * Sets the data
         * @param data The data value
         */
        public void setData(E data)
        {
            this.data=data;
        }

        /**
         * Gets the data
         * @return The data value
         */
        public E getData()
        {
            return data;
        }

    }


    /**
     * Increase the table size when the load factor exceeds
     */
    public void rehash(){
        Data<E> [] oldTable = table;
        table = new Data[2 * oldTable.length + 1];
        numberOfElements=0;
        numberOfDeletedElements=0;

        for(int i=0; i<oldTable.length; ++i)
        {
            if(oldTable[i] != null && (oldTable[i] != DELETED)){
                    add(oldTable[i].data);
                }
            }
        }


    /**
     * Add item to hash table
     * @param obj The item to insert
     * @return True if the operation is sucessfull
     */
    @Override
    public boolean add(E obj) {

        int index = obj.hashCode() % table.length;

        // Create a new linked list at table[index].
        if(table[index] == null) {
            table[index] = new Data<E>(obj);
        }else{
            Random rand = new Random();
            int newTableSize = rand.nextInt(100) + 1;
            setCapacity(newTableSize);
        }

        ++numberOfElements;

        // Call rehash to new hash table size
        if(numberOfElements > LOAD_THRESOLD *table.length)
            rehash();

        return true;
    }

    /**
     * Adds all of the elements in the specified collection to this set
     * if they're not already present (optional operation).
     * @param coll The collection
     * @return True
     */
    @Override
    public boolean addAll(Collection<E> coll) {

        for(int i=0; i<coll.size(); ++i)
            add(coll.iterator().next());

        return true;
    }

    /**
     * Returns true if this set contains the specified element.
     * @param obj The object
     * @return true if this set contains the specified element.
     */
    @Override
    public boolean contains(Object obj) {


        for(int i=0; i<table.length; ++i) {
            if (obj.equals(table[i])){

                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this set contains all of the elements of the specified collection.
     * @param coll THe collection
     * @return true if this set contains all of the elements of the specified collection.
     */
    @Override
    public boolean containsAll(Collection<E> coll) {

        for(int i=0; i<table.length; ++i) {
            for (int j = 0; j < coll.size(); ++j) {
                if (!table[i].data.equals(coll.iterator().next())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * isEmpty() method
     * @return true if this set contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return numberOfElements ==0 ;
    }

    /**
     * Iterator
     * @return an iterator over the elements in this set.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Removes the specified element from this set if it is present (optional operation).
     * @param obj The object to remove
     * @return true if the object was removed
     */
    @Override
    public boolean remove(Object obj) {

        int index =(Integer)obj % table.length;

        if(index<0)
            index+=table.length;

        while (table[index] == DELETED || !(((Integer)obj).equals(table[index])))
            break;

        if (table[index] == null)
            return false;

        E oldValue = table[index].data;
        table[index] = DELETED;
        numberOfDeletedElements--;
        return true;

    }

    /**
     * Removes from this set all of
     * its elements that are contained in the specified collection (optional operation).
     * @param coll The collection
     * @return true if this set is changed
     */
    @Override
    public boolean removeAll(Collection<E> coll) {
        return false;
    }

    /**
     * Retains only the elements in this set that are contained
     * in the specified collection (optional operation).
     * @param coll The collection
     * @return true if this set is changed
     */
    @Override
    public boolean retainAll(Collection<E> coll) {
        return false;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    /**
     * Print hash table
     */
    public void printHashTable()
    {
        for (int i = 0; i < table.length; ++i)
        {
            if (table[i] != null)
                System.out.printf("%d\n", i);

        }
    }
}
