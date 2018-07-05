package Q1;

public interface CTMap<K, V> {
    V get(Object key);
    boolean isEmpty();
    V put(K key, V value);
    V remove(Object key);
    int size();
}
