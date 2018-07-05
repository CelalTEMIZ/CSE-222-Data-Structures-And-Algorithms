package Q5;

import java.io.IOException;

public class Main {

    public static void main(String args[])throws IOException
    {
        int numberOfTest = 1;

        // Function Parameter Order
        // Output File, Test Number, Array Size

        TestArrays.test("src/Q5/Results/TestArray0_Results.txt", numberOfTest, 10);
        TestArrays.test("src/Q5/Results/TestArray1_Results.txt", numberOfTest, 100);
        TestArrays.test("src/Q5/Results/TestArray2_Results.txt", numberOfTest, 1000);
        TestArrays.test("src/Q5/Results/TestArray3_Results.txt", numberOfTest, 5000);
        TestArrays.test("src/Q5/Results/TestArray4_Results.txt", numberOfTest, 10000);

    }
}
