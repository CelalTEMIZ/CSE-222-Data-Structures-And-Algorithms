import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class GTUCENGCoursesUseLinkedListObject {

    private LinkedList<String> courseList ;
    private LinkedList<GTUCENGCourses> courseFileInput;

    /**
     * Constructor
     */
    GTUCENGCoursesUseLinkedListObject()
    {
        courseFileInput = new LinkedList<GTUCENGCourses>();
        courseList = new LinkedList<String>();
    }

    /**
     * Returns all courses which have given course code.
     * @param code Course code
     * @return Course object to given course code
     * @throws Exception if there are no matched course.
     */
    public GTUCENGCourses getByCode (String code) throws Exception
    {

        for(int i=0; i<courseFileInput.size(); ++i)
        {
            if(code.equals(courseFileInput.get(i).getCourseCode()))
            {
                return courseFileInput.get(i);
            }
        }

        throw new Exception("No match found for the given course code !!");
    }

    /**
     *Returns all courses from given start index to last index
     * @param start_index
     * @param last_index
     * @return LinkedList to all courses from given start index to last index
     * @throws Exception if there are no matched course or
     * @throws Exception if the start index is bigger than the last index
     */
    public LinkedList<GTUCENGCourses> getByRange(int start_index, int last_index) throws Exception
    {
        LinkedList<GTUCENGCourses> indexedList = new LinkedList<GTUCENGCourses>();


        if(start_index>last_index)
        {
            throw new Exception("Illegal Start Index !!");
        }

        for(int j=start_index; j<=last_index; ++j)
        {
            indexedList.add(courseFileInput.get(j));
        }

        if(indexedList.size()==0)
        {
            throw new Exception("No match found for the given indexes !!");
        }


        return indexedList;

    }

    /**
     * Returns all courses on given semester.
     * @param semester Integer to semester number
     * @return Linkedlist toall courses on given semester.
     * @throws Exception
     */
    public LinkedList<GTUCENGCourses> listSemesterCourses (int semester) throws Exception
    {

        LinkedList<GTUCENGCourses> semesterList = new LinkedList<GTUCENGCourses>();

        if(courseFileInput.size() == 0)
        {
            throw new Exception("Course list is empty !!");
        }

        if(semester < 1 || semester > 8)
        {
            throw new Exception("Invalid semester !!");
        }


        for(int i=0; i<courseFileInput.size(); ++i)
        {
            if(String.valueOf(semester).equals(courseFileInput.get(i).getSemester()))
            {
                semesterList.add(courseFileInput.get(i));
            }
        }

        return semesterList;
    }

    /**
     * Read all input file data
     * @param fileName String to course input file.
     */
    public void readFile(String fileName)
    {
        String line = null;

        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null)
            {
                courseList.add(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }


        parseFileLines();

    }

    /**
     * Parse input file line according to members
     */
    public void parseFileLines()
    {
        Iterator<String> itr=courseList.iterator();
        int lineNumber = -1;

        while(itr.hasNext()){
            String temp = itr.next();
            lineNumber++;

            String[] tokens = temp.split(",");

            courseFileInput.add(new GTUCENGCourses(lineNumber,tokens[0],tokens[1],tokens[2],
                    tokens[3],tokens[4],tokens[5]));
        }
    }


}

