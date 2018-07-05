package Q4;

import Q3.CTMergeSortDoubleLinkedList;

import java.io.*;
import java.util.Random;

import static Q4.SortingAlgorithms.*;


public class TestArrays {

    public static void test(String filename, int testNumber, int ARRAY_SIZE)  throws IOException
    {
        try {
            // Average running time to 10 execution
            long averageInsertionSort = 0;
            long averageMergeSort = 0;
            long averageQuickSort = 0;
            long averageHeapSort = 0;
            long averageMergeLinkedListSort = 0;

            Random rand = new Random();

            // Object to merge sort algorithm using linked list
            CTMergeSortDoubleLinkedList<Integer> Integerlist = new CTMergeSortDoubleLinkedList<Integer>();
            // Array of random Integer
            Integer arr[] = new Integer[ARRAY_SIZE];


            // Write results to given .txt files
            File dir = new File(".");
            String loc = dir.getCanonicalPath() + File.separator + filename;
            FileWriter fstream = new FileWriter(loc, true);
            BufferedWriter out = new BufferedWriter(fstream);

            // Create array of random integer
            for(int i=0; i<ARRAY_SIZE; ++i) {
                int number = rand.nextInt(10000) + 1;
                arr[i] = number;
                Integerlist.add(number);
            }

            // Run 10 times to each array size
            for(int j=0; j<testNumber; ++j)
            {
/////////////// INSERTION SORT OPERATION ///////////////////////////////////////////////

                System.out.println("Array Before Insertion Sort");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();

                long startTime1 = System.nanoTime();
                insertionSort(arr);
                long endTime1 = System.nanoTime();
                long totalTime1 = endTime1-startTime1;
                averageInsertionSort+=totalTime1;
                out.write("Insertion Sort        : ");
                out.write(String.valueOf(totalTime1));
                out.newLine();
                System.out.println("Running Time : " + totalTime1);


                System.out.println("Array After Insertion Sort");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("\n");

///////////////// MERGE SORT OPERATION ////////////////////////////////////////////////

                System.out.println("Array Before Merge Sort");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();

                long startTime2 = System.nanoTime();
                mergeSort(arr);     //sorting array elements using MERGE sort
                long endTime2 = System.nanoTime();
                long totalTime2 = endTime2 - startTime2;
                averageMergeSort+=totalTime2;
                out.write("Merge Sort\t\t\t  : ");
                out.write(String.valueOf(totalTime2));
                out.newLine();

                System.out.println("Running Time : " + totalTime2);
                System.out.println("Array After Merge Sort");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("\n");

///////////////// QUICK SORT OPERATION ///////////////////////////////////////////////////

                System.out.println("Array Before Quick Sort");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();

                long startTime3 = System.nanoTime();
                QuickSort(arr);//sorting array elements using QUICK sort
                long endTime3 = System.nanoTime();
                long totalTime3 = endTime3 - startTime3;
                averageQuickSort+=totalTime3;
                out.write("Quick Sort\t\t\t  : ");
                out.write(String.valueOf(totalTime3));
                out.newLine();

                System.out.println("Running Time : " + totalTime3);
                System.out.println("Array After Quick Sort");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("\n");

////////////// Heap SORT OPERATION ///////////////////////////////////////////////////////

                System.out.println("Array Before Heap Sort");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();

                long startTime4 = System.nanoTime();
                heapSort(arr);
                long endTime4 = System.nanoTime();
                long totalTime4 = endTime4 - startTime4;
                averageHeapSort+=totalTime4;
                out.write("Heap Sort\t\t\t  : ");
                out.write(String.valueOf(totalTime4));
                out.newLine();
                System.out.println("Running Time : " + totalTime4);


                System.out.println("Array After Heap Sort");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("\n");

////////////// Linked list merge sort Operation ////////////////////////////////////////////

                CTMergeSortDoubleLinkedList.Node<Integer> IntegerNode = Integerlist.sortOperation(Integerlist.header);
                System.out.println("\nResult of Merge Sort Integer LinkedList:");
                long startTime5 = System.nanoTime();
                Integerlist.printSortedList(IntegerNode);
                long endTime5 = System.nanoTime();
                long totalTime5 = endTime5 - startTime5;
                averageMergeLinkedListSort+=totalTime5;
                out.write("Merge Sort LinkedList : ");
                out.write(String.valueOf(totalTime5));
                out.write("\n\n\n");
                System.out.println("\nRunning Time : " + totalTime5);
            }
                // Write average running times
                out.write("*** Average Running Times ***\n");
                out.write("Insertion Sort        : ");
                out.write(String.valueOf(averageInsertionSort/ARRAY_SIZE));
                out.write("\nMerge Sort\t\t\t  : ");
                out.write(String.valueOf(averageMergeSort/ARRAY_SIZE));
                out.write("\nQuick Sort\t\t\t  : ");
                out.write(String.valueOf(averageQuickSort/ARRAY_SIZE));
                out.write("\nHeap Sort\t\t\t  : ");
                out.write(String.valueOf(averageHeapSort/ARRAY_SIZE));
                out.write("\nMerge Sort LinkedList : ");
                out.write(String.valueOf(averageMergeLinkedListSort/ARRAY_SIZE));
                out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
