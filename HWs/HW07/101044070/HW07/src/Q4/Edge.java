
// Insert solution to programming exercise 1, section 2, chapter 10 here

//////////////////////////// HW07 //////////////////////////////////

package Q4;

//
// Reference : Course Book - Table 10.1
// Table 10.1 shows the Edge class.

import java.util.Objects;

/**
 * The Edge class.
 *
 */
public class Edge {

    private int source;         // The source vertex
    private int dest;           // The destination vertex
    private double weight;      // The weight

    /**
     * Constructs an Edge from source to dest.
     * Sets the weight to 1.0.
     * @param source The source vertex
     * @param dest  The destination vertex
     */
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
        weight = 1.0;
    }

    /**
     * Constructs an Edge from source to dest.
     * Sets the weight to w.
     * @param source The source vertex
     * @param dest The destination vertex
     * @param w  The weight
     */
    public Edge(int source, int dest, double w)
    {
        this.source = source;
        this.dest = dest;
        weight = w;
    }

    /**
     * Compares two edges for equality.
     * Edges are equal if their source and destination vertices are the same.
     * The weight is not considered.
     * @param o Object to compare operation
     * @return true if their source and destination vertices are the same.
     */
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;

        if(!(o instanceof Edge)){
            return false;
        }

        Edge edge = (Edge) o;
        return (source==edge.source && dest==edge.dest);
    }

    /**
     * Gets the destination vertex.
     * @return Returns the destination vertex.
     */
    public int getDest()
    {
        return dest;
    }


    /**
     * Gets the source vertex.
     * @return Returns the source vertex.
     */
    public int getSource()
    {
        return source;
    }


    /**
     * Gets the weight.
     * @return Returns the weight.
     */
    public double getWeight()
    {
        return weight;
    }


    /**
     * hashcode() method override.
     * The hash code depends only on the source and destination.
     * @return Returns the hash code for an edge.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(source,dest);
    }


    /** Return a String representation of the edge
     *  @return A String representation of the edge
     */
    @Override
    public String toString()
    {
        return String.format("%d",getDest());
    }

}

/////////////////// END OF HW07 //////////////////////////////////




