import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

// The Main class contains the primary logic for the program.
// It generates two arrays with random numbers, sorts them, and then
// rearranges the elements between them based on a specific condition.
public class Main {
    // The main method is the entry point for the program.
    public static void main(String[] args) {
        // A Scanner object to read user input from the standard input.
        Scanner scnr = new Scanner(System.in);
        // Reads an integer to be used as a seed for the random number generator.
        int seed = scnr.nextInt();
        // A Random object is initialized with the provided seed to generate a predictable sequence of numbers.
        Random rnd = new Random(seed);
        
        // Reads the desired size for the first array.
        int arraySizeA = scnr.nextInt();
        
        // Reads the desired size for the second array.
        int arraySizeB = scnr.nextInt();

    /* Type your code here. */
        scnr.close();

        // Initializes two integer arrays with the sizes provided by the user.
        int [] arrayA = new int[arraySizeA];
        int [] arrayB = new int[arraySizeB];

        // Fills the first array with random integers between 1 and 99.
        for (int j = 0; j < arraySizeA; j++) {
            arrayA[j] = rnd.nextInt(99) + 1;
        }
        // Fills the second array with random integers between 1 and 99.
        for (int j = 0; j < arraySizeB; j++) {
            arrayB[j] = rnd.nextInt(99) + 1;
        }

        // Sorts both arrays in ascending order using Java's built-in sort method.
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        // Prints the initial state of the arrays to the console.
        System.out.println("Input");
        System.out.print("Array 1\n");
        printArray(arrayA);
        System.out.print("Array 2\n");
        printArray(arrayB);

        // Calls the rearrange method to perform the core logic of the program.
        rearrange(arrayA, arrayB);
        // Prints the final state of the arrays after rearrangement.
        System.out.println("Output");
        System.out.print("Array 1\n");
        printArray(arrayA);
        System.out.print("Array 2\n");
        printArray(arrayB);
    }

    // A utility method to print the contents of an integer array to the console.
    public static void printArray(int[] arr) {
        // Iterates through the array and prints each element followed by a space.
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        // Prints a new line after the array elements for proper formatting.
        System.out.println();
    }
    
    // The core logic of the program. This method rearranges elements between two sorted arrays.
    // It iterates through the first array and checks if any element is greater than the smallest element of the second array.
    public static void rearrange(int[] arrayA, int[] arrayB) {
        // Loops through each element in arrayA.
        for (int j = 0; j < arrayA.length; j++) {
            // Checks if the current element of arrayA is greater than the first (smallest) element of arrayB.
            if (arrayA[j] > arrayB[0]) {
                // Swaps the elements if the condition is met.
                int temp = arrayA[j];
                arrayA[j] = arrayB[0];
                arrayB[0] = temp;

                // After the swap, the first element of arrayB is no longer in its sorted position.
                // This inner while loop re-sorts arrayB to maintain its sorted order.
                int k = 1;
                while (k < arrayB.length && arrayB[k] < arrayB[k - 1]) {
                    int tempSwap = arrayB[k];
                    arrayB[k] = arrayB[k - 1];
                    arrayB[k - 1] = tempSwap;
                    k++;
                }
            }
        }
    }
}