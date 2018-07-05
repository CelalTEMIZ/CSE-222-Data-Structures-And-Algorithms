package Q2;

import java.util.Collection;
import java.util.Iterator;

public interface CTSet<E>{
    boolean add(E obj);
    boolean addAll(Collection<E> coll);
    boolean contains(Object obj);
    boolean containsAll(Collection<E> coll);
    boolean isEmpty();
    Iterator<E>  iterator();
    boolean remove(Object obj);
    boolean removeAll(Collection<E> coll);
    boolean retainAll(Collection<E> coll);
    int size();
}
