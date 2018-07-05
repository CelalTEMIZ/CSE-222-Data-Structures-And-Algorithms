package Q3;

import org.junit.jupiter.api.Test;

public class CTMergeSortDoubleLinkedListTest {

    @Test
    public void main() {

        // Test Integer List
        CTMergeSortDoubleLinkedList<Integer> IList = new CTMergeSortDoubleLinkedList<Integer>();

        IList.add(225);
        IList.add(92);
        IList.add(44);
        IList.add(203);
        IList.add(8);
        IList.add(19);

        CTMergeSortDoubleLinkedList.Node<Integer> IntegerNode =
                IList.sortOperation(IList.header);

        System.out.println("Result of Integer List:");
        IList.printSortedList(IntegerNode);

        // Test Character List
        CTMergeSortDoubleLinkedList<Character> CList = new CTMergeSortDoubleLinkedList<Character>();

        CList.add('e');
        CList.add('r');
        CList.add('q');
        CList.add('w');
        CList.add('a');
        CList.add('h');


        CTMergeSortDoubleLinkedList.Node<Character> characterNode =
                CList.sortOperation(CList.header);

        System.out.println("\n\nResult of Character List :");
        CList.printSortedList(characterNode);

        // Test Double List
        CTMergeSortDoubleLinkedList<Double> Dlist = new CTMergeSortDoubleLinkedList<Double>();

        Dlist.add(1.9);
        Dlist.add(2.121);
        Dlist.add(123.5);
        Dlist.add(13.59);
        Dlist.add(52.44);
        Dlist.add(1.8);

        CTMergeSortDoubleLinkedList.Node<Double> DoubleNode = Dlist.sortOperation(Dlist.header);
        System.out.println("\n\nResult of Double List :");
        Dlist.printSortedList(DoubleNode);

    }



}