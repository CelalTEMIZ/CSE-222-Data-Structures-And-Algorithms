import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Part1Main
{

    public static void main(String[] args){

        final String fileName = "src/testTrees/7itemsTest.txt";

        CTGeneralTree gt1 = parseLinesAndCreateTree(getItems(fileName));

        // General Tree Iterators
        Iterator<ItemType> gtPostOrderIterator  = gt1.postOrderIterator();
        Iterator<ItemType> gtLevelOrderIterator = gt1.levelOrderIterator();


        System.out.print("\nLevelorder Search : ");
        while (gtLevelOrderIterator.hasNext())
        {
            System.out.print(gtLevelOrderIterator.next().getChildItem());
            System.out.print("-");
        }

        System.out.print("\nPostorder  Search : ");
        while (gtPostOrderIterator.hasNext())
        {
            System.out.print(gtPostOrderIterator.next().getChildItem());
            System.out.print("-");
        }

    }

    /**
     * Read all input file lines
     * @param fileName File name to read tree contents from the given file
     * @return LinkedList to all input file lines
     */
    public static LinkedList<String> getItems(String fileName)
    {

        LinkedList<String> fileLines = new LinkedList<String>();
        String line;

        try {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null)
            {
                fileLines.add(line);
            }

            fileReader.close();

        } catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");

        } catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }

        return fileLines;
    }

    /**
     * Parses the all file lines and creates a tree from their contents
     * @param lines Input file lines
     * @return created tree from the input file contents
     */
    public static CTGeneralTree parseLinesAndCreateTree(LinkedList<String> lines)
    {
        boolean status;
        CTGeneralTree inputTree;

        Iterator<String> itr=lines.iterator();

        // Get first line to being parent item and parse the next lines.
        String rootItem = itr.next();
        inputTree = new CTGeneralTree(rootItem);

        // Parses the lines to tokens as childItem and parentItem
        while(itr.hasNext())
        {
            String temp = itr.next();
            String[] tokens = temp.split(",");
            status = inputTree.add(tokens[0], tokens[1]);

            if(status == false)
            {
                System.out.println("Item insertion error !! ");
            }
        }

        return inputTree;
    }
}
