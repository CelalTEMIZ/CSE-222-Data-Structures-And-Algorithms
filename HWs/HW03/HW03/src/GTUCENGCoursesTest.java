import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class GTUCENGCoursesTest {

    public static void main(String[] args) {

        final String fileName ="src/Courses(CSV)(Updated).csv";

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


            System.out.println("------------- Before disable() Method ------------------");
            for(int i=0; i<p2IntegerList.size(); ++i)
                System.out.println(p2IntegerList.get(i));



            p2IntegerList.disable(1);   // Disable items
            p2IntegerList.disable(8);


            System.out.println("------------- Later disable() Method ------------------");
            Iterator<Integer> itr=p2IntegerList.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next().toString());
            }
            System.out.println("--------------------------------------------------------");

            System.out.println("-------------- showDisabled() --------------------------");
            p2IntegerList.showDisabled();
            System.out.println("--------------------------------------------------------");


            p2IntegerList.enable(1);    // Enable items
            p2IntegerList.enable(8);


            System.out.println("------------- Later enable() Method ------------------");

            for(int i=0; i<p2IntegerList.size(); ++i)
                System.out.println(p2IntegerList.get(i));

            // Part - 1 Test Results

            p1.readFile(fileName);
            System.out.println("\n-------------getByCode() Test Result----------------------------------\n");
            System.out.println(p1.getByCode("EN 111").toString());


            System.out.println("\n-------------listSemesterCourses() Test Result--------------------------\n");
            tempSemestirList = p1.listSemesterCourses(4);

            Iterator<GTUCENGCourses> itrSemestirList=tempSemestirList.iterator();
            while(itrSemestirList.hasNext()){
                System.out.println(itrSemestirList.next().toString());
            }

            System.out.println();


            System.out.println("-------------------getByRange() Test Result-------------------------------\n");
            tempList = p1.getByRange(4,44);
            Iterator<GTUCENGCourses> itrIntegerList=tempList.iterator();

            while(itrIntegerList.hasNext()){
                System.out.println(itrIntegerList.next().toString());
            }
            System.out.println();


            for(int i=0; i<tempSemestirList.size(); ++i)
            {
                p2.add(tempSemestirList.get(i));
            }

            System.out.println("\n----------------------Before disable() Method ------------------------------\n");
            for(int i=0; i<tempSemestirList.size(); ++i)
            {
                System.out.println(p2.get(i).toString());
            }


            p2.disable(tempSemestirList.get(3));
            System.out.println("\n-----------------------Later disable() Method -------------------------------\n");
            for(int i=0; i<p2.size(); ++i)
            {
                System.out.println(p2.get(i).toString());
            }

            p2.enable(tempSemestirList.get(3));
            System.out.println("\n-----------------------Later enable() Method -----------------------------------\n");
            for(int i=0; i<p2.size(); ++i)
            {
                System.out.println(p2.get(i).toString());
            }


        }

        catch (Exception E)
        {
            System.out.println("\nAn Exception Caught : " + E);
        }

    }
}