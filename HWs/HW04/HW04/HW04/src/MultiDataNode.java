public class MultiDataNode<E extends Comparable<E>> implements Comparable<MultiDataNode<E>> {


    private E xCoordinate;
    private E yCoordinate;
    private E zCoordinate;
    private int dimensionCount;

    /**
     * One parameter construtor
     * @param xCoordinate x coordinate
     */
    public MultiDataNode(E xCoordinate)
    {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Two parameters constructor
     * @param xCoordinate x coordinate of given item
     * @param yCoordinate y coordinate of given item
     */
    public MultiDataNode(E xCoordinate, E yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Class constructor specifying objects to create.
     * @param xCoordinate x coordinate of given item
     * @param yCoordinate y coordinate of given item
     * @param zCoordinate z coordinate of given item
     */
    public MultiDataNode(E xCoordinate, E yCoordinate, E zCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    /**
     * Gets the x coordinate of given item
     * @return xCoordinate of given item
     */
    public E getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Sets the x coordinate of of given item
     * @param xCoordinate xCoordinate to set
     */
    public void setxCoordinate(E xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Gets the y coordinate of given item
     * @return yCoordinate of given item
     */
    public E getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Sets the y coordinate of given item
     * @param yCoordinate yCoordinate to set
     */
    public void setyCoordinate(E yCoordinate) {
        this.yCoordinate = yCoordinate;
    }


    /**
     * Gets the z coordinate of given item
     * @return zCoordinate of given item
     */
    public E getzCoordinate() {
        return zCoordinate;
    }

    /**
     * Sets the z coordinate to given item
     * @param zCoordinate zCoordinate to set
     */
    public void setzCoordinate(E zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    /**
     * Gets the dimension of given item
     * @return current dimension
     */
    public int getDimensionCount() {
        return dimensionCount;
    }

    /**
     * Sets the dimension number of given item
     * @param dimensionCount dimension number to given item
     */
    public void setDimensionCount(int dimensionCount) {
        this.dimensionCount = dimensionCount;
    }

    /**
     * toString() method override
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s %s",getxCoordinate(), getyCoordinate(),getzCoordinate());
    }

    /**
     * compareTo() method override
     * @param other Other class object
     * @return integer
     */
    @Override
    public int compareTo(MultiDataNode<E> other)
    {
        int cmp = this.getxCoordinate().compareTo(other.getxCoordinate());
        if (cmp == 0)
            cmp = this.getyCoordinate().compareTo(other.getyCoordinate());
        if (cmp == 0)
            cmp = this.getzCoordinate().compareTo(other.getzCoordinate());

        return cmp;

    }

}


