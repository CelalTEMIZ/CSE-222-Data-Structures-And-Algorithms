package Q2;

import org.junit.jupiter.api.Test;

import static Q2.Main.*;
import static org.junit.jupiter.api.Assertions.*;

public class Q2MainTest {

    @Test
    public void main() {
        try {
            // Undirected and Acyclic Graph have no weight.
            // Number of vertex is 15.
            ListGraph g = new ListGraph(15, false);
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
            g.insert(new Edge(7, 11));
            g.insert(new Edge(5, 12));
            g.insert(new Edge(5, 13));
            g.insert(new Edge(11, 14));


            // plot_graph()
            System.out.println("\nTest Method - plot_graph()");
            plot_graph(g);

            //is_undirected()
            assertEquals(true,is_undirected(g));
            System.out.println("\nis_undirected() method is successfull !!");


            // is_connected()
            assertEquals(true,is_connected(g, 1, 2));
            assertEquals(true,is_connected(g, 4, 5));
            assertEquals(true,is_connected(g, 11, 14));
            System.out.println("\nis_connected() method is successfull !!");

            // is_acyclic_graph()
            assertEquals(true,is_acyclic_graph(g));
            System.out.println("\n\nis_acyclic_graph() method is successfull !!");


        }catch(Exception E){
            System.out.println("\nAn Exception Caught : " + E);
        }

    }
}