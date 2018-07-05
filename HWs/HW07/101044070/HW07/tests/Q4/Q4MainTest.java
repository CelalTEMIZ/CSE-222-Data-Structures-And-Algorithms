package Q4;

import org.junit.jupiter.api.Test;

import static Q4.Main.breadthFirstSearch;
import static org.junit.jupiter.api.Assertions.*;

public class Q4MainTest {

    @Test
    public void main() {

        try {

            // Given adjacency matrix to graph.
            ListGraph g = new ListGraph(7, false);
            g.insert(new Edge(0, 1));
            g.insert(new Edge(0, 5));
            g.insert(new Edge(1, 2));
            g.insert(new Edge(2, 4));
            g.insert(new Edge(2, 5));
            g.insert(new Edge(2, 6));
            g.insert(new Edge(3, 4));
            g.insert(new Edge(3, 5));
            g.insert(new Edge(4, 5));


            System.out.println("\n\nBreadth First Search :");
            breadthFirstSearch(g,1);

            DepthFirstSearch dfs = new DepthFirstSearch(g);
            int[] dOrder = dfs.getDiscoveryOrderOrder();
            int[] fOrder = dfs.getFinishOrder();
            System.out.println("\n\nDepth First Search :");
            for (int i = 0; i <g.getNumV(); i++) {
                System.out.printf("%d-",fOrder[i]);
            }
            System.out.println();

        }catch(Exception E){
            System.out.println("\nAn Exception Caught : " + E);
        }

    }
}