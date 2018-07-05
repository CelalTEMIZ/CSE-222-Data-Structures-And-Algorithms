package Q1;

/**
 * Implements CTMap interface by using an open addressing hash table.
 * Collisions are resolved by double hashing.
 * @param <K> The key
 * @param <V> The value
 */
public class CTDoubleHashingMap<K,V> implements CTMap<K,V>{

    // Hash Table
    public Entry < K, V > [] table;
    // Initial Hash Table Size
    private int START_CAPACITY ;
    // Threshold value to rehash operation
    private double LOAD_THRESHOLD = 0.75;
    // Number of keys
    private int numKeys;
    // Number of deletes
    private int numDeletes;
    // Deleted Entry Object
    private final Entry < K, V > DELETED = new Entry < K, V > (null, null);

    /**
     * Constructor to initialize hash table according to given table size
     */
    public CTDoubleHashingMap(int START_CAPACITY) {
        table = new Entry[START_CAPACITY];
        this.START_CAPACITY = START_CAPACITY;
    }


    /**
     * Contains key-value pairs for a hash table
     * @param <K> The key
     * @param <V> The value
     */
    static class Entry < K, V > {

        // The key
        private K key;

        // The value
        private V value;

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Gets the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Gets the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    /**
     * @return Returns the number of entries in the hash map.
     */
    public int size() {
        return numKeys;
    }

    /**
     *
     * @return Returns true if the table is empty
     */
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /** Finds either the target key or the first empty slot which in the
     search chain using double hashing.
     pre: The table is not full.
     @param key The key of the target object
     @return The position of the target or first empty slot which corresponding to the second hash function
     */
    private int find(Object key) {

        int index = hash1Function((Integer)key);

        int k=1;

        if (index < 0)
            index += table.length;  // Make it positive.

        while (table[index] != null) {

            // (hash1(key) + k*hash2(key)) % tableSize
            int index2 = hash2Function((Integer) key);
            int nextIndex = (index + (k * index2)) % START_CAPACITY;
            ++k;

            if(table[nextIndex]==null)
                return nextIndex;

        // Check for wraparound.
        if (index >= table.length)
            index = 0; // Wrap around.
        }

        return index;
    }

    /** Method get for class HashtableOpen.
     @param key The key being sought
     @return the value associated with this key if found;
     otherwise, null
     */
    public V get(Object key) {

        if (table[(Integer) key] != null)
            return table[(Integer)key].value;
        else
            return null; // key not found.
    }

    /** Method put for class HashtableOpen.
     post: This key-value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed. If the LOAD_THRESHOLD
     is exceeded, the table is expanded.
     @param key The key of item being inserted
     @param value The value for this key
     @return Old value associated with this key if found;
     otherwise, null
     */
    public V put(K key, V value) {

        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);

        // If an empty element was found, insert new entry.
        if (table[index] == null) {
            table[index] = new Entry <> (key, value);
            numKeys++;
            // Check whether rehash is needed.
            double loadFactor =
                    (double) (numKeys + numDeletes) / table.length;

            if (loadFactor > LOAD_THRESHOLD)
                rehash();
            //return null;
        }

        // assert: table element that contains the key was found.
        // Replace value for this key.
        V oldVal = table[index].value;
        table[index].value = value;
        return oldVal;
    }

    /**
     * First hash function to double hashing
     * @param key The key for hashing operation
     * @return first hash function result
     */
    public int hash1Function(int key)
    {
        return key % START_CAPACITY;
    }

    /**
     * Second hash function to double hashing
     * @param key The key for hashing operation
     * @return second hash function result
     */
    public int hash2Function(int key)
    {
        return 59 - (key % 59);
    }

    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     post: The size of table is doubled and is an odd integer.
     Each nondeleted entry from the original table is
     reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        // Save a reference to oldTable.
        Entry < K, V > [] oldTable = table;
        // Double capacity of this table.
        table = new Entry[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
                // Insert entry in expanded table
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    /** Remove the item with a given key value
     *  @param key The key to be removed
     *  @return The value associated with this key, or null
     *  if the key is not in the table.
     */
    public V remove(Object key) {

        int index = hash1Function((Integer)key);

        if(index<0)
            index+=table.length;

        while (table[index] == DELETED || !(((Integer)key).equals(table[index].getKey())))
            break;

        if (table[index] == null)
            return null;

        V oldValue = table[index].value;
        table[index] = DELETED;
        numKeys--;
        return oldValue;
    }

    /**
     * Print hash table
     */
    public void printHashTable()
    {
        for (int i = 0; i < table.length; ++i)
        {
            if (table[i] != null)
                System.out.printf("%d = %s\n", i, table[i].value);
            else
                System.out.println(i);
        }
    }


}
