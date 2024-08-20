/* 
    Series.java
    (c) Aiden McCormack, 2024. All Rights Reserved.

    Testing constraints for the maximum number of nodes in a connected graph.
*/
import java.util.Random;

public class Series {
    // constants
    private final static int size = 5;
    private final static int TEST_CASES = 100;
    private final static int MAX = 100000;
    private final static int MIN = 1000;

    private final static int[] startValues = {7, 4, 100, 6, 9};
    private final static int[] acceptedValues = {28, 10, 5050, 21, 45};
    private final static Random random = new Random();
    
    public static void main(String[] args) {

        System.out.println("Running Series.java\n");

        // Recursive test
        System.out.println("Summing recursively: ");
        for (int i = 0; i < size; i++) {
            System.out.print("Test " + i + ": \t");
            System.out.print("Accepted: " + acceptedValues[i] + "\t---\t");
            System.out.print("Computed: " + sumRecursively(startValues[i]) + "\n");
        }

        System.out.println();

        // Iterative test
        System.out.println("Summing Iteratively: ");
        for (int i = 0; i < size; i++) {
            System.out.print("Test " + i + ": \t");
            System.out.print("Accepted: " + acceptedValues[i] + "\t---\t");
            System.out.print("Computed: " + sumIteratively(startValues[i]) + "\n");
        }

        System.out.println();

        // Direct test
        System.out.println("Summing Directly: ");
        for (int i = 0; i < size; i++) {
            System.out.print("Test " + i + ": \t");
            System.out.print("Accepted: " + acceptedValues[i] + "\t---\t");
            System.out.print("Computed: " + sumDirectly(startValues[i]) + "\n");
        }

        System.out.println();

        // Intense direct test (assumes iterative is correct)
        System.out.println("INTENSE DIRECT TEST");
        boolean overallResult = testDirectCalculation();
        System.out.println( overallResult ? "ALL TESTS PASSED" : "FAILED");
    }

    /* RESCURSIVE APPROACH O(n) */
    public static long sumRecursively(long value) {
        if (value == 1) {
            return 1;
        }
        return value + sumRecursively(value - 1);
    }

    /* ITERATIVE APPROACH O(n) */
    public static long sumIteratively(long value) {
        long returnMe = value;
        while (value > 0) {
            returnMe += (--value);
        }
        return returnMe;
    }

    /* DIRECT APPROACH O(1) */
    public static long sumDirectly(long value) {
        value++;
        if ( (value) % 2 == 0) {
            return (value - 1) * (value / 2);
        }
        return value * ((value - 1) / 2);
    }

    /* Compare the iterative approach to the direct approach */
    public static boolean testDirectCalculation() {
        boolean returnMe = true;
        System.out.println("TEST\t\tRANDOM VALUE\t\tACCEPTED VALUE\t\t\tCOMPUTED VALUE\t\t\tRESULT");
        for (int i = 0; i < TEST_CASES; i++) {
            long rand = MIN + random.nextInt(MAX - MIN);
            
            long accepted = sumIteratively(rand);
            long computed = sumDirectly(rand);

            System.out.print("Test " + i + ":");
            System.out.print( (i > 9) ? "\t" : "\t\t");
            System.out.print("rand=" + rand + "\t\t");
            System.out.print("acceptedSum=" + accepted + "\t\t");
            System.out.print("computedSum=" + computed + "\t\t");
            System.out.print("result=");
            System.out.println( (accepted == computed) ? "PASS" : "FAIL" );

            if (accepted != computed) returnMe = false;
        }

        return returnMe;
    }
}
