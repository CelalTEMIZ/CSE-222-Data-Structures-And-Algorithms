public class CTGeneralTree extends BinaryTree<ItemType>
{
    /**
     * Initialize root item
     * @param rootName root item
     */
    public CTGeneralTree(String rootName)
    {
        add(new ItemType(rootName,null));
    }

    /**
     * Add method that takes a parentItem and a childItem and inserts the childItem
     * as the last child of the parentItem if the parentItem is already in suach a tree structure.
     *
     * @param childItem child item
     * @param parentItem parent item
     * @return true if insertion is successful and false if the parentItem is not in the tree.
     */
    public boolean add(String childItem, String parentItem)
    {

        boolean status = false;
        ItemType newItem = new ItemType(childItem, parentItem);

        status = addStatus(newItem, root);

        if(status == true)
            return insertItem(newItem, root);
        else
            return false;
    }

    /**
     * The left branch of a node is the first child,
     * and each right branch is connected to the next sibling (if any).
     * @param itemNode item node
     * @param item item object
     * @return true if insertion is successful and false if the parentItem is not in the tree.
     */
    private boolean insertItem(ItemType item, Node<ItemType> itemNode)
    {

        // If the node is null, it won't add item to this node.
        if(itemNode == null)
        {
            return false;
        }

        // If the node is a parent to add item
        if(itemNode.getData().isParent(item))
        {
            Node<ItemType> baseNode = itemNode.getLeft();
            // Insertion Sibling
            if (baseNode != null)
            {
                while (baseNode.getRight() != null) // Right side is  sibling items
                {
                    baseNode = baseNode.getRight();
                }
                baseNode.setRight(new Node<ItemType>(item));
            }
            // Left side is child items
            // Insertion child
            else
            {
                // while (node.getLeft() != null)
                //  node = node.getLeft();

                itemNode.setLeft(new Node<ItemType>(item));
            }
            return true;
        }

        // Insert items as recursive
        return insertItem(item, itemNode.getLeft()) || insertItem(item, itemNode.getRight());
    }

    /**
     * if the status of insertion operation is true, insertion operation will realize.
     * @param item Item
     * @param node Node
     * @return True if the given item is not in the tree, otherwise returns false
     */
    private boolean addStatus(ItemType item, Node<ItemType> node)
    {
        if(node == null)
        {
            return true;
        }
        if(item.equals(node.getData()))
        {
            return false;
        }

        return addStatus(item, node.getLeft()) || addStatus(item, node.getRight());
    }

}
