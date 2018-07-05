package Q3;

public class Main {

    public static void main(String[] args)
    {
        try {
            // Test Integer List
            CTMergeSortDoubleLinkedList<Integer> Integerlist = new CTMergeSortDoubleLinkedList<Integer>();

            // Add items to integer list
            Integerlist.add(225);
            Integerlist.add(92);
            Integerlist.add(203);
            Integerlist.add(8);
            Integerlist.add(2378);
            Integerlist.add(45);
            Integerlist.add(11);
            Integerlist.add(7493);
            Integerlist.add(3);
            Integerlist.add(100);

            CTMergeSortDoubleLinkedList.Node<Integer> IntegerNode = Integerlist.sortOperation(Integerlist.header);

            System.out.println("Result of Integer List:");
            Integerlist.printSortedList(IntegerNode);

            // Test Character List
            CTMergeSortDoubleLinkedList<Character> Charlist = new CTMergeSortDoubleLinkedList<Character>();

            Charlist.add('g');
            Charlist.add('d');
            Charlist.add('f');
            Charlist.add('s');
            Charlist.add('c');
            Charlist.add('k');
            Charlist.add('h');
            Charlist.add('z');
            Charlist.add('w');
            Charlist.add('a');

            CTMergeSortDoubleLinkedList.Node<Character> characterNode = Charlist.sortOperation(Charlist.header);
            System.out.println("\n\nResult of Character List :");
            Charlist.printSortedList(characterNode);


            // Test Double List
            CTMergeSortDoubleLinkedList<Double> Doublelist = new CTMergeSortDoubleLinkedList<Double>();

            Doublelist.add(243.121);
            Doublelist.add(93.5);
            Doublelist.add(22.4);
            Doublelist.add(54.7);
            Doublelist.add(3.9);
            Doublelist.add(9.58);
            Doublelist.add(71.5);
            Doublelist.add(13.24);
            Doublelist.add(43.124);
            Doublelist.add(243.12);

            CTMergeSortDoubleLinkedList.Node<Double> DoubleNode = Doublelist.sortOperation(Doublelist.header);
            System.out.println("\n\nResult of Double List :");
            Doublelist.printSortedList(DoubleNode);

        } catch(Exception E){

            System.out.println("An Exception Caught : " + E);
        }


    }
}
