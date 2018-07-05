import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class Part1MainTest {

    /**
     * Part 1 Main Test
     */
    @Test
    public void main() {

        final String fileName = "src/testTrees/12itemsTest_2.txt";

        // Read input file and parse lines testing
        CTGeneralTree gt1 = Part1Main.parseLinesAndCreateTree(Part1Main.getItems(fileName));

        // General Tree Iterators Tests
        Iterator<ItemType> gtPostOrderIterator  = gt1.postOrderIterator();
        Iterator<ItemType> gtLevelOrderIterator = gt1.levelOrderIterator();


        // Level order and post order search test
        System.out.print("\nLevelorder Search : ");
        while (gtLevelOrderIterator.hasNext())
        {
            System.out.print(gtLevelOrderIterator.next().getChildItem());
            System.out.print("-");
        }

        System.out.print("\nPostorder  Search : ");
        while (gtPostOrderIterator.hasNext())
        {
            System.out.print(gtPostOrderIterator.next().getChildItem());
            System.out.print("-");
        }


    }
}