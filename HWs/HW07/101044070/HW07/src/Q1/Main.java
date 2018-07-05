
package Q1;

import java.util.*;

public class Main {

        public static void main(String args[])
        {
            try {

                ListGraph g = new ListGraph(10, true);
                g.insert(new Edge(0, 1,10));
                g.insert(new Edge(0, 4,20));
                g.insert(new Edge(0, 8,30));
                g.insert(new Edge(4, 5,40));
                g.insert(new Edge(4, 8,50));
                g.insert(new Edge(8, 9,60));
                g.insert(new Edge(8, 5,70));
                g.insert(new Edge(9, 5,80));
                g.insert(new Edge(1, 5,90));
                g.insert(new Edge(5, 6,100));
                g.insert(new Edge(6, 7,110));
                g.insert(new Edge(9, 3,120));
                g.insert(new Edge(9, 7,130));
                g.insert(new Edge(7, 2,140));
                g.insert(new Edge(7, 3,150));
                g.insert(new Edge(3, 2,160));
                g.insert(new Edge(2, 0,170));
                g.insert(new Edge(5, 2,180));
                g.insert(new Edge(2, 6,190));
                g.insert(new Edge(0, 9,200));

                // Test Methods
                System.out.println("\nTest Method - plot_graph()");
                plot_graph(g);

                if(is_undirected(g)){
                    System.out.println("\nTest Method - is_undirected()");
                }

                if(is_acyclic_graph(g)){
                    System.out.println("\nTest Method - is_acyclic_graph()");
                }

            }catch(Exception E){
                System.out.println("\nAn Exception Caught : " + E);
            }


        }

    /**
     * This function should be able to take any graph object and produce a
     * reasonably attractive visual representation of that graph.
     * Algorithm should make use edge weights to layout the distance between vertices.
     * @param graph The graph object
     */
    public static void plot_graph(ListGraph graph)
    {
        for(int v = 0; v < graph.getNumV(); v++)
        {
            System.out.printf("%d -> ",v);
            for (int i = 0; i < graph.edges[v].size(); ++i) {

                if(i<graph.edges[v].size()-1)
                    System.out.printf("%s -> ", graph.edges[v].get(i).toString());
                else
                    System.out.printf("%s ", graph.edges[v].get(i).toString());

            }
            System.out.println();
        }
    }


    /**
     * Check if the graph object is undirected.
     * @param graph The graph object
     * @return true if all directed edges have
     * a complementary directed edge with the same weight in the opposite direction.
     */
    public static boolean is_undirected(ListGraph graph){

        try {

            int counter=0;

            for (int s = 0; s < graph.getNumV(); ++s) {
                for (int d = 0; d < graph.edges[s].size(); ++d) {
                    if (is_connected(graph, graph.edges[s].get(d).getSource(), graph.edges[s].get(d).getDest())) {
                        ++counter;
                    }
                }
            }

            if((graph.getNumV()-1)*2 == counter){
                return true;
            }

        }catch(Exception E) {
            System.out.println("\nAn Exception Caught : " + E);
        }

        return false;
    }


    /**
     * The graph may or may not have cycles.
     * To check do a graph traversal (BFS or DFS).
     * @param graph The graph object
     * @return ​TRUE​ if ​graph is undirected, ​FALSE​ if not.
     */

    public static boolean is_acyclic_graph(ListGraph graph){

        try {
            int [] bfsParentArray = new int [50];
            int counter=0;

            int visited[] = new int [2];


            bfsParentArray = breadthFirstSearch(graph,0);

            // If two vertexes have same parent and these vertexes are connected

            for(int i=0; i<bfsParentArray.length; ++i){

                for(int v=0; v<graph.edges[i].size(); ++v){

                    if(bfsParentArray[i] == graph.edges[i].get(v).getSource()) {

                        counter++;

                        visited[v] = graph.edges[i].get(v).getSource();

                        if(counter == 2){
                            if (is_undirected(graph) || is_connected(graph, visited[0], visited[1])) {
                                return true;
                            }

                        }
                    }
                }
            }

        }
        catch (Exception E){
            System.out.println("\nAn Exception Caught : " + E);
        }

        return false;

    }


    /**
     * if there is any path between vertex v 1 and vertex ​ v2 in graph ​ g.
     * If v1​ or v2​ are not in graph then throw an error.
     * @param graph The graph object
     * @param v1 a vertex label in ​ graph object
     * @param v2 a vertex label in ​ graph object
     * @return ​TRUE​ if there is a path from ​ v1​ to ​ v2​ in g,​ FALSE​ if not.
     */
    public static boolean is_connected(ListGraph graph,int v1,int v2) throws Exception {

     if(!checkVertexInGraph(graph,v1)){
         throw new Exception("v1 is not in the graph !");
     }
     else if(!checkVertexInGraph(graph,v2)){
         throw new Exception("v2 is not in the graph !");
     }

     if(checkVertexInGraph(graph,v1) && checkVertexInGraph(graph,v2)) {

           for (int i = 0; i < graph.edges[v1].size(); ++i) {

               if (graph.edges[v1].get(i).getDest() == v2)
                   return true;
           }
       }

       return false;
    }



    /**
     * Check the vertex state in the graph.
     * @param graph The graph object
     * @param vertex The vertex
     * @return True if the given vertex is in the given graph,otherwise false.
     */
    public static boolean checkVertexInGraph(ListGraph graph,int vertex)
    {
        for(int v=0; v<graph.getNumV(); ++v){
            for (int i = 0; i < graph.edges[v].size(); ++i) {
                if(graph.edges[v].get(i).getSource() == vertex || graph.edges[v].get(i).getDest() == vertex)
                    return true;
            }
        }

        return false;
    }


    /**
     * Reference : Course Book - Listing 10.3
     *
     * Perform breadth-first search algorithm.
     * post: The array parent will contain the predecessor of each vertex in the breadth-first search tree.
     * @param graph The graph to be searched.
     * @param start The start vertex.
     * @return The array of parents.
     */
    public static int [] breadthFirstSearch(ListGraph graph, int start)
    {
        System.out.println("\nBreadth First Search Result :");
        Queue<Integer> theQueue= new LinkedList<Integer>();
        // Declare array parent and initialize its element to -1
        int[] parent=new int[graph.getNumV()];

        for(int i=0;i<graph.getNumV();i++)
        {
            parent[i]=-1;
        }

        // Declare array identified and
        // initialize its elements to false
        boolean[] identified=new boolean[graph.getNumV()];

        // Mark the start vertex as identified and insert it into the queue
        identified[start]=true;
        theQueue.offer(start);

        // Perform breadth-first search until done
        while(!theQueue.isEmpty()){
            // Take a vertex, current, out of the queue. (Begin visiting current)
            int current= theQueue.remove();
            System.out.printf("%d-",current);
            // Examine each vertex,neighbor, adjacent to current
            Iterator<Edge> itr= graph.edgeIterator(current);
            while (itr.hasNext())
            {
                Edge edge=itr.next();
                int neighbor=edge.getDest();

                // If neighbor has not been identified
                if(!identified[neighbor])
                {
                    //Mark it identified
                    identified[neighbor]=true;
                    //Place it into the queue
                    theQueue.offer(neighbor);
                    //Insert the edge(current,neighbor) into the tree
                    parent[neighbor]=current;
                }
            }

            // Finished visiting current
        }
        return parent;
    }


    /**
     * Dijkstra’s Shortest-Path algorithm.
     * @param graph The weighted graph to be searched
     * @param start The start vertex
     * @param pred Output array to contain the predecessors in the shortest path
     * @param dist Output array to contain the distance in the shortest path
     */
    public static int[] dijkstrasAlgorithm(Graph graph,int start,int[] pred, double[] dist) {

        int numV=graph.getNumV();
        HashSet<Integer> vMinusS=new HashSet <Integer>(numV);
        // Initialize V–S.
        for (int i = 0; i<numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }

        // Initialize pred and dist.
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }

        // Main loop
        while (vMinusS.size() != 0) {

            // Find the value u in V–S with the smallest dist[u].
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }

            // Remove u from vMinusS.
            vMinusS.remove(u);

            // Update the distances.
            for (int v : vMinusS) {
                if (graph.isEdge(u, v)) {
                    double weight = graph.getEdge(u, v).getWeight();
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }

        return pred;
    }



    /**
     * Find the shortest path from vertex v ​ 1 to vertex v ​ 2 using Dijkstra’s algorithm.
     * Note that there may not be a unique solution for any given graph, you are only required
     * to return one path.
     * @param graph The graph object
     * @param v1  a vertex label in ​ graph object
     * @param v2  a vertex label in ​ graph object
     * @return path, a vector of the names of vertices that make up the shortest path, in order.
     * If there is no path between the vertices then return an empty vector; distance​ , total
     * weight of path.
     */
    public static Vector shortest_path(ListGraph graph,int v1, int v2)
    {
        Vector shortestPath = new  Vector();

        return shortestPath;

    }





}
