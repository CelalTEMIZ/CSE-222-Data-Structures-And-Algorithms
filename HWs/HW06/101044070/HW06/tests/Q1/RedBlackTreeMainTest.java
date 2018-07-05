package Q1;

import org.junit.jupiter.api.Test;

import static Q1.Main.createAndPlot_WorstRedBlackTree;
import static org.junit.jupiter.api.Assertions.*;

public class RedBlackTreeMainTest {

    /**
     * Main test to red black tree.
     */
    @Test
    public void main() {

        System.out.println("------------------------ TEST 1 -------------------------");
        createAndPlot_WorstRedBlackTree();

        System.out.println("------------------------ TEST 2 -------------------------");
        createAndPlot_WorstRedBlackTree();

        System.out.println("------------------------ TEST 3 -------------------------");
        createAndPlot_WorstRedBlackTree();

        System.out.println("Red Black Tree main test is successfull !! ");

    }


}