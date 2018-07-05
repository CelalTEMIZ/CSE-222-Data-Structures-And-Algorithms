
import java.io.*;
import java.util.*;

public class GTUCENGCoursesLinkedList<E> extends LinkedList<E>
{
    private ArrayList<E> disableList = new ArrayList<>();
    private ArrayList<Integer> index = new ArrayList<>();
    private int deletedCount=0;

    /**
     * Disables any list item
     * @param item
     * @throws Exception if there is no matched
     */
    public boolean disable(E item) throws Exception
    {
        for(int i=0;i<this.size(); i++)
        {
            if (this.get(i).equals(item))
            {
                disableList.add(this.get(i));
                index.add(i+deletedCount);
                this.remove(i);

                deletedCount++;
                i--;
            }
        }

        if(disableList.size()==0) {
            throw new Exception("No match found for the given item !!");
        }

        return true;
    }


    /**
     * Enables back any disabled list item
     * @param item
     * @throws Exception
     */
    public boolean enable(E item)
    {
        for(int i=0;i<disableList.size();i++)
        {
            if(disableList.get(i).equals(item))
            {
                for (int j = 0; j < index.size(); j++)
                {
                    this.add(index.get(j), item);
                    deletedCount--;

                    index.remove(j);
                    j--;
                    break;
                }
                disableList.remove(i);
                i--;
            }
        }

        return true;
    }

    /**
     * Lists all disabled items
     */
    public boolean showDisabled()
    {

        for(int i=0; i<index.size(); ++i) {
            for (int j = i; j < disableList.size(); ++j) {
                System.out.printf("Index %d: %s\n", index.get(i), disableList.get(j));
                break;
            }
        }

        return true;
    }


}
