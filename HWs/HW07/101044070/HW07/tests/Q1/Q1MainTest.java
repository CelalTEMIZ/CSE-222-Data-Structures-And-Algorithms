package Q1;

import org.junit.jupiter.api.Test;

import static Q1.Main.is_acyclic_graph;
import static Q1.Main.is_undirected;
import static Q1.Main.plot_graph;
import static org.junit.jupiter.api.Assertions.*;

public class Q1MainTest {

    @Test
    public void main() {

        try {

            ListGraph g = new ListGraph(10, true);
            g.insert(new Edge(0, 1,10));
            g.insert(new Edge(0, 4,20));
            g.insert(new Edge(0, 5,30));
            g.insert(new Edge(2, 1,170));
            g.insert(new Edge(2, 6,190));
            g.insert(new Edge(3, 2,160));
            g.insert(new Edge(4, 5,40));
            g.insert(new Edge(4, 8,50));
            g.insert(new Edge(9, 7,130));
            g.insert(new Edge(8, 9,60));
            g.insert(new Edge(9, 4,70));
            g.insert(new Edge(9, 5,80));
            g.insert(new Edge(1, 5,90));
            g.insert(new Edge(5, 6,100));
            g.insert(new Edge(6, 7,110));
            g.insert(new Edge(9, 6,120));
            g.insert(new Edge(7, 2,140));
            g.insert(new Edge(7, 3,150));


            g.insert(new Edge(6, 1,180));

            g.insert(new Edge(0, 9,200));

            // Test Methods
            System.out.println("\nTest Method - plot_graph()");
            plot_graph(g);

            assertEquals(false,is_undirected(g));
            System.out.println("\nis_undirected() method successful !!");

            assertEquals(false,is_acyclic_graph(g));
            System.out.println("\n\nis_acyclic_graph() method successful !!");

        }catch(Exception E){
            System.out.println("\nAn Exception Caught : " + E);
        }



    }

}