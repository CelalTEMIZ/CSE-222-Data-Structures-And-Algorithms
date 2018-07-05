package Q4;

import java.io.IOException;

public class Main {

    public static void main(String args[])throws IOException
    {
        int numberOfTest = 10;

        // Parameters
        // Output File, Test Number, Array Size


        TestArrays.test("src/Q4/Results/TestArray1_Results.txt", numberOfTest, 50);
        TestArrays.test("src/Q4/Results/TestArray2_Results.txt", numberOfTest, 100);
        TestArrays.test("src/Q4/Results/TestArray3_Results.txt", numberOfTest, 200);
        TestArrays.test("src/Q4/Results/TestArray4_Results.txt", numberOfTest, 300);
        TestArrays.test("src/Q4/Results/TestArray5_Results.txt", numberOfTest, 400);
        TestArrays.test("src/Q4/Results/TestArray6_Results.txt", numberOfTest, 500);
        TestArrays.test("src/Q4/Results/TestArray7_Results.txt", numberOfTest, 600);
        TestArrays.test("src/Q4/Results/TestArray8_Results.txt", numberOfTest, 700);
        TestArrays.test("src/Q4/Results/TestArray9_Results.txt", numberOfTest, 800);
        TestArrays.test("src/Q4/Results/TestArray10_Results.txt", numberOfTest, 900);
        TestArrays.test("src/Q4/Results/TestArray11_Results.txt", numberOfTest, 1000);


    }


}
