import java.util.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GTUCENGCoursesUseLinkedListObjectTest {

    final String fileName ="src/Courses(CSV).csv";

    GTUCENGCourses o1 = new GTUCENGCourses(22, "3",
            "EN 111","English For Business Life",
            "2","2","2+0+0");


    GTUCENGCoursesUseLinkedListObject o2 = new GTUCENGCoursesUseLinkedListObject();


    /**
     * Returns all courses which have given course code
     */
    @Test
    public void getByCode() {

        GTUCENGCourses c1 = new GTUCENGCourses();
        String courseDetail = "22, 3, EN 111, English For Business Life, 2, 2, 2+0+0";

        try {
            o2.readFile(fileName);
            c1 = o2.getByCode("EN 111");
            assertEquals(courseDetail,c1.toString());
        }
        catch(Exception E)
        {
            System.out.println("\nAn Exception Caught : " + E);
        }

        System.out.println("getByCode() method is succesfull !");

    }

    /**
     * Returns all courses from given start index to last index.
     */
    @Test
    public void getByRange() {
        GTUCENGCoursesUseLinkedListObject p1 = new GTUCENGCoursesUseLinkedListObject();
        LinkedList<GTUCENGCourses> tempRangeList = new LinkedList<GTUCENGCourses>();
        LinkedList<GTUCENGCourses> semesterList = new LinkedList<GTUCENGCourses>();

        try {
            o2.readFile(fileName);
            // Return 5.semester courses list
            semesterList = o2.listSemesterCourses(5);
            // Return 5.semester courses indexes
            tempRangeList = o2.getByRange(29,34);
            assertEquals(semesterList,tempRangeList);

        } catch(Exception E)
        {
            System.out.println("\nAn Exception Caught : " + E);
        }

        System.out.println("getByRange() method is succesfull !");
    }

    /**
     * Returns all courses on given semester.
     */
    @Test
    public void listSemesterCourses() {

        LinkedList<GTUCENGCourses> semesterList = new LinkedList<GTUCENGCourses>();

        String semester1Courses="1,XXX XXX,Teknik Olmayan Secmeli (SSC),2,1,2+0+0\n" +
                "1,CSE 101,Introduction To Computer Engineering,8,3,3+0+0\n" +
                "1,CSE 107,Introduction To Computer Science Laboratory,2,1,0+0+2\n" +
                "1,MATH 101,Calculus I,7,5,5+0+0\n" +
                "1,PHYS 121,Physics I,6,4,3+0+0\n" +
                "1,PHYS 151,Physics Laboratory I,1,1,0+0+2\n" +
                "1,SSTR 101,Principles Of Ataturk And The History Of Turkish Revolution I,2,2,2+0+0\n" +
                "1,TUR 101,Turkish I,2,2,2+0+0";

        // First item is index number
        String courseDetail = "4, 1, MATH 101, Calculus I, 7, 5, 5+0+0";
        try {
            o2.readFile(fileName);
            semesterList = o2.listSemesterCourses(1);
            assertEquals(courseDetail, semesterList.get(3).toString());
        }
        catch(Exception E)
        {
            System.out.println("\nAn Exception Caught : " + E);
        }

        System.out.println("listSemesterCourses() method is succesfull !");


    }


}