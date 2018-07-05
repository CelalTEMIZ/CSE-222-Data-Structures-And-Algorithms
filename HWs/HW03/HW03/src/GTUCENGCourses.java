import java.io.*;
import java.util.*;

public class GTUCENGCourses {

    private String semester;
    private String courseCode;
    private String courseTitle;
    private String ectsCredits;
    private String gtuCredits;
    private String hourTheoryLaboratory;
    private int indexNumber;

    /**
     * Class constructor without parameters
     */
    GTUCENGCourses()
    {
        this.semester="Unknown";
        this.courseCode="Unknown";
        this.courseTitle="Unknown";
        this.ectsCredits="Unknown";
        this.gtuCredits="Unknown";
        this.hourTheoryLaboratory="Unknown";
        this.indexNumber=0;
    }

    /**
     * Class constructor specifying objects to create
     * @param indexNumber                   Index Number
     * @param semester                      Semester
     * @param courseCode                    Course Code
     * @param courseTitle                   Course Title
     * @param ectsCredits                   ECTS Credits
     * @param gtuCredits                    GTU Credits
     * @param hourTheoryLaboratory          Hour+Theory+Laboratory
     */
    GTUCENGCourses(int indexNumber,String semester, String courseCode, String courseTitle, String ectsCredits,
                   String gtuCredits, String hourTheoryLaboratory)
    {
        this.indexNumber=indexNumber;
        this.semester=semester;
        this.courseCode=courseCode;
        this.courseTitle=courseTitle;
        this.ectsCredits=ectsCredits;
        this.gtuCredits=gtuCredits;
        this.hourTheoryLaboratory=hourTheoryLaboratory;
    }

    /**
     * Sets the indexNumber
     * @param indexNumber indexNumber to set
     */
    public void setIndexNumber(int indexNumber)
    {
        this.indexNumber=indexNumber;
    }

    /**
     * Gets the indexNumber
     * @return current index
     */
    public int getIndexNumber()
    {
        return indexNumber;
    }

    /**
     * Sets the semester
     * @param semester semester to set
     */
    public void setSemester(String semester)
    {
        this.semester=semester;
    }

    /**
     * Gets the semester
     * @return semester
     */
    public String getSemester()
    {
        return semester;
    }

    /**
     * Sets the course code
     * @param courseCode course code to set
     */
    public void setCourseCode(String courseCode)
    {
        this.courseCode=courseCode;
    }

    /**
     * Gets the course code
     * @return course code
     */
    public String getCourseCode()
    {
        return courseCode;
    }

    /**
     * Sets the course title
     * @param courseTitle course title to set
     */
    public void setCourseTitle(String courseTitle)
    {
        this.courseTitle=courseTitle;
    }

    /**
     * Gets the course title
     * @return course title
     */
    public String getCourseTitle()
    {
        return  courseTitle;
    }


    /**
     * Sets the ects credits
     * @param ectsCredits ects credits to set
     */
    public void setEctsCredits(String ectsCredits)
    {
        this.ectsCredits=ectsCredits;
    }

    /**
     * Gets the ects credits
     * @return ects credits
     */
    public String getEctsCredits()
    {
        return ectsCredits;
    }

    /**
     * Sets the GTU credits
     * @param gtuCredits gtu credits to set
     */
    public void setGtuCredits(String gtuCredits)
    {
        this.gtuCredits=gtuCredits;
    }

    /**
     * Gets the Gtu credits
     * @return gtu credits
     */
    public String getGtuCredits()
    {
        return gtuCredits;
    }

    /**
     * Sets the hour+theory+laboratory
     * @param hourTheoryLaboratory Hour Theory Laboratory to set
     */
    public void setHourTheoryLaboratory(String hourTheoryLaboratory)
    {
        this.hourTheoryLaboratory=hourTheoryLaboratory;
    }

    /**
     * Gets the Hour Theory Laboratory
     * @return Hour+Theory+Laboratory
     */
    public String getHourTheoryLaboratory()
    {
        return hourTheoryLaboratory;
    }

    /**
     * toString() method override
     * @return course details
     */

    @Override
    public String toString()
    {
        return  String.format("%d, %s, %s, %s, %s, %s, %s", getIndexNumber(),getSemester(),getCourseCode(),
                getCourseTitle(),getEctsCredits(),getGtuCredits(),getHourTheoryLaboratory() );

    }




}
