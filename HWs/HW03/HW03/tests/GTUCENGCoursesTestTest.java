import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GTUCENGCoursesTestTest {

    @Test
    public void main() {

        final String fileName ="src/Courses(CSV).csv";

        GTUCENGCoursesUseLinkedListObject p1 = new GTUCENGCoursesUseLinkedListObject();
        LinkedList<GTUCENGCourses> tempList = new LinkedList<GTUCENGCourses>();
        LinkedList<GTUCENGCourses> tempSemestirList = new LinkedList<GTUCENGCourses>();

        GTUCENGCoursesLinkedList<Integer> p2IntegerList= new GTUCENGCoursesLinkedList<Integer>();

        GTUCENGCoursesLinkedList<GTUCENGCourses> p2 =
                new GTUCENGCoursesLinkedList<GTUCENGCourses>();

        try {

            p2IntegerList.add(1);
            p2IntegerList.add(1);
            p2IntegerList.add(1);
            p2IntegerList.add(3);
            p2IntegerList.add(4);
            p2IntegerList.add(2);
            p2IntegerList.add(2);
            p2IntegerList.add(1);
            p2IntegerList.add(8);
            p2IntegerList.add(9);
            p2IntegerList.add(5);
            p2IntegerList.add(8);



            assertEquals(true,p2IntegerList.disable(1));   // Disable items
            assertEquals(true,p2IntegerList.disable(8));

            System.out.println("disable() method is succesfull !");

            assertEquals(true,p2IntegerList.enable(1));    // Enable items
            assertEquals(true,p2IntegerList.enable(8));
            System.out.println("enable() method is succesfull !");

            // Part - 1 Test Results

            GTUCENGCourses c1 = new GTUCENGCourses(35,"6",
                    "CSE 396", "Computer Engineering Project","5","2","1+2+0");
            p1.readFile(fileName);
            assertEquals(c1.toString(), p1.getByCode("CSE 396").toString());
            System.out.println("getByCode() method is succesfull !");

            tempSemestirList = p1.listSemesterCourses(6);
            tempList = p1.getByRange(35,40);
            assertEquals(tempList,tempSemestirList);
            System.out.println("listSemesterCourses() method is succesfull !");

            for(int i=0; i<tempSemestirList.size(); ++i)
            {
                p2.add(tempSemestirList.get(i));
            }

            // Part - 2 Test Results


            GTUCENGCourses c2 = new GTUCENGCourses(37,"6","MATH 118","Probability and Statistics","6","3","3+0+0");
            assertEquals(true,p2.disable(tempSemestirList.get(2)));
            System.out.println("disable() method is succesfull !");

            // 37,6,MATH 118,Probability and Statistics,6,3,3+0+0
            p2.showDisabled();

            assertEquals(true,p2.enable(tempSemestirList.get(3)));
            System.out.println("enable() method is succesfull !");

        }

        catch (Exception E)
        {
            System.out.println("\nAn Exception Caught : " + E);
        }

    }

}