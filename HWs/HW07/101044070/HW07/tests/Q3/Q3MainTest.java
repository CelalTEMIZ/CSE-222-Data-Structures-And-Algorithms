package Q3;

import org.junit.jupiter.api.Test;

import static Q3.Main.*;
import static org.junit.jupiter.api.Assertions.*;

public class Q3MainTest {

    @Test
    public void main() {
        try {

            ListGraph g = new ListGraph(11, false);
            g.insert(new Edge(0, 1));
            g.insert(new Edge(0, 3));
            g.insert(new Edge(1, 2));
            g.insert(new Edge(1, 4));
            g.insert(new Edge(1, 6));
            g.insert(new Edge(1, 7));
            g.insert(new Edge(2, 8));
            g.insert(new Edge(2, 9));
            g.insert(new Edge(4, 5));
            g.insert(new Edge(6, 10));

            // Test Methods
            System.out.println("\nTest Method - plot_graph()");
            plot_graph(g);


            assertEquals(true,is_undirected(g));
            System.out.println("\nis_undirected() method is successfull !!");

            System.out.println("\n\nBreadth First Search - Spanning Tree");
            assertEquals(false,is_acyclic_graph(g));
            System.out.println("\n\nis_acyclic_graph() method is successfull !!");

            DepthFirstSearch dfs = new DepthFirstSearch(g);
            int[] dOrder = dfs.getDiscoveryOrderOrder();
            int[] fOrder = dfs.getFinishOrder();
            System.out.println("\n\nDepth First Search  - Spanning Tree");
            for (int i = 0; i <g.getNumV(); i++) {
                System.out.printf("%d-",fOrder[i]);
            }
            System.out.println();


        }catch(Exception E){
            System.out.println("\nAn Exception Caught : " + E);
        }


    }
}