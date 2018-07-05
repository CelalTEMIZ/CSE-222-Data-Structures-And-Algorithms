/**
 * ItemType Class
 */
public class ItemType implements Comparable<ItemType> {

    private String childItem;
    private String parentItem;

    /**
     * No parameter constructor
     */
    public ItemType()
    {
        this.childItem  = "Unknown";
        this.parentItem = "Unknown";
    }

    /**
     * Class constructor specifying objects to create.
     * @param childItem childItem
     * @param parentItem parent name
     */
    public ItemType(String childItem, String parentItem)
    {
        this.childItem = childItem;
        this.parentItem = parentItem;
    }

    /**
     * Gets the childItem
     * @return current childItem
     */
    public String getChildItem()
    {
        return childItem;
    }

    /**
     * Sets the childItem
     * @param childItem childItem to set
     */
    public void setChildItem(String childItem)
    {
        this.childItem = childItem;
    }

    /**
     * Gets the parentItem
     * @return current parentItem
     */
    public String getParentItem()
    {
        return parentItem;
    }

    /**
     * Sets the parentItem
     * @param parentItem parentItem to set
     */
    public void setParentItem(String parentItem)
    {
        this.parentItem = parentItem;
    }

    /**
     * Given item is parent item ?
     * @param item
     * @return true if the given item is parent
     */
    public boolean isParent(ItemType item)
    {
        return getChildItem().equals(item.getParentItem());
    }

    /**
     * equals() method override
     * @param other Object Type
     * @return true it the objects are same,otherwise false
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == null)
            return false;

        if (other == this)
            return true;

        if (!(other instanceof ItemType))
            return false;

        return false;
    }

    /**
     * CompareTo() method override
     * @param other
     * @return integer
     */
    @Override
    public int compareTo(ItemType other)
    {
        return new String(this.getChildItem()).compareTo(other.getParentItem());

    }

}
