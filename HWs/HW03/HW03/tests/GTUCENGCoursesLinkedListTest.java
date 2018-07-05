import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GTUCENGCoursesLinkedListTest {

    // Sample Generic Type Objects
    GTUCENGCoursesLinkedList<Character> p2CharList= new GTUCENGCoursesLinkedList<Character>();
    GTUCENGCoursesLinkedList<Integer> p2IntegerList= new GTUCENGCoursesLinkedList<Integer>();
    GTUCENGCoursesLinkedList<GTUCENGCourses> p2CourseList=new GTUCENGCoursesLinkedList<GTUCENGCourses>();


    /**
     * Disables any list item
     */
    @Test
    public void disable() {

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

        try {
            // Disable items
            assertEquals(true, p2IntegerList.disable(2));
        }catch (Exception E)
        {
            System.out.println("\nAn Exception Caught : " + E);
        }

        System.out.println("disable() method is succesfull !!");


    }

    /**
     * Enables back any disabled list item
     */
    @Test
    public void enable() {


        GTUCENGCourses c1 = new GTUCENGCourses(29, "5",
                "CSE 343","Software Engineering",
                "8","4","3+2+0");

        GTUCENGCourses c2 = new GTUCENGCourses(30, "5",
                "CSE 341","Programming Languages",
                "6","3","3+0+0");

        GTUCENGCourses c3 = new GTUCENGCourses(31, "5",
                "CSE 331","Computer Organizations",
                "7","4","3+2+0");

        GTUCENGCourses c4 = new GTUCENGCourses(32, "5",
                "CSE 321","Introduction To Algorithm Design",
                "6","6","3+0+0");

        GTUCENGCourses c5 = new GTUCENGCourses(33, "5",
                "XXX XXX","Teknik Olmayan Secmeli (SSA)",
                "3","2","2+0+0");


        try {
            p2CourseList.add(c1);
            p2CourseList.add(c1);
            p2CourseList.add(c2);
            p2CourseList.add(c2);
            p2CourseList.add(c2);
            p2CourseList.add(c3);
            p2CourseList.add(c3);
            p2CourseList.add(c4);
            p2CourseList.add(c5);


            p2CourseList.disable(c2);
            p2CourseList.disable(c4);
            p2CourseList.disable(c5);


            assertEquals(true,p2CourseList.enable(c2));
            assertEquals(true,p2CourseList.enable(c4));
            assertEquals(true,p2CourseList.enable(c5));


        }catch(Exception E){
            System.out.println("\nAn Exception Caught : " + E);
        }

        System.out.println("enable() method is succesfull !!");


    }

    /**
     * Lists all disabled items.
     */
    @Test
    public void showDisabled() {

        String testResult = "Index 3: t\nIndex 4: t\nIndex 11: t\nIndex 15: t";

        p2CharList.add('x');
        p2CharList.add('y');
        p2CharList.add('z');
        p2CharList.add('t');
        p2CharList.add('t');
        p2CharList.add('z');
        p2CharList.add('y');
        p2CharList.add('x');
        p2CharList.add('x');
        p2CharList.add('y');
        p2CharList.add('z');
        p2CharList.add('t');
        p2CharList.add('x');
        p2CharList.add('y');
        p2CharList.add('z');
        p2CharList.add('t');

        try {
            p2CharList.disable('t');

            assertEquals(true , p2CharList.showDisabled());

        }
        catch (Exception E)
        {
            System.out.println("\nAn Exception Caught : " + E);
        }


        System.out.println("showDisabled() method is succesfull !!");

    }
}