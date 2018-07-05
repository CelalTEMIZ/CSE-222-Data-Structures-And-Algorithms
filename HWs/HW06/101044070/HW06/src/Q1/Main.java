package Q1;

import java.util.Random;


public class Main {

    public static void main(String args[]){

        System.out.println("------------------------ TEST 1 -------------------------");
        createAndPlot_WorstRedBlackTree();

        System.out.println("------------------------ TEST 2 -------------------------");
        createAndPlot_WorstRedBlackTree();
    }


    public static void createAndPlot_WorstRedBlackTree()
    {
        // Integer Red Black tree
        RedBlackTree<Integer> t1 = new RedBlackTree<Integer>();

        // Small node item is between 0 and 100
        int smallNum = getRandomNumber(0,100);
        System.out.printf("New Item :%d\n\n",smallNum);
        t1.add(smallNum);   // Add item to the red black tree

        System.out.println(t1.toString());  // Print red black tree

        // Large node number is between small number and 500
        int largeNum = getRandomNumber(smallNum, 500);
        System.out.printf("New Item :%d\n\n",largeNum);
        t1.add(largeNum);   // Add item to the red black tree

        System.out.println(t1.toString());  // Print red black tree

        // Medium number is between small number and large number
        int middleNum = getRandomNumber(smallNum, largeNum);

        t1.add(middleNum);  // Add item to the red black tree
        System.out.printf("New Item :%d\n\n",middleNum);
        System.out.println(t1.toString());


        /**
         * In this way, first item will be between previous large number and
         * new upper bound.
         * And the second number will be large number and previous item.
         *
         * Therefore, the red black tree will be make double rotation, when the second item add to tree.
         * Height of tree will be 6 in the end of this loop iteration.
         */
        int k=7; // To upper bound
        for (int i = 1; i<=10; i++) {

            // First
            int tempNum1 = getRandomNumber(largeNum,k*100);
            t1.add(tempNum1);
            System.out.printf("New 1.Item :%d - ",tempNum1);

            // Second
            int tempNum2 = getRandomNumber(largeNum, tempNum1);
            t1.add(tempNum2);

            largeNum = tempNum1;
            System.out.printf("New 2.Item: %d\n\n",tempNum2);

            k+=1;

            System.out.println(t1.toString());
            System.out.println("---------------------------------------------------");

        }

        System.out.println(t1.toString());
    }


    /**
     * Get the random number.
     * @param lower The lower bound for the random number.
     * @param upper The upper bound for the random number.
     * @return The random number between lower and upper bound.
     */
    public static int getRandomNumber(int lower, int upper)
    {
        Random rand = new Random();
        return (int) (Math.random() * (upper - lower)) + lower;
    }
}
