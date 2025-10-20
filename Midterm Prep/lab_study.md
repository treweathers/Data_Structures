That's a very clear overview of your programming labs\! The assignments focus heavily on core data structure manipulations and recursive thinking, often by extending existing class files.

Based on the topics covered (Arrays, Ordered Arrays, Linked Lists, Doubly Linked Lists, Stacks, Queues, and Recursion), I'll generate a new lab assignment focused on **Recursion with Arrays** (which covers your last recursion topic) and follows your format of providing an existing class structure with methods to be completed.

-----

## New Lab Assignment: 4.23 LAB Recursive Array Sorting Check

### Overview

In this lab, you will complete methods in the provided `ArrayUtils` class to recursively determine properties of an array. Unlike the previous recursion labs that used linked lists, this assignment will focus on using **recursion with array indices** to perform checks on standard integer arrays.

The provided `ArrayUtils` class contains a static method, `isSorted`, which you will overload with a recursive helper method. You may **not** use any loops (`for`, `while`, `do-while`) or create any additional arrays.

### Requirements

You will add the following **two** methods to the `ArrayUtils` class.

#### Part 1: Recursive Check for Sorted Order

The goal is to determine if an array is sorted in **non-decreasing** order (i.e., each element is less than or equal to the next element).

1.  **`public static boolean isSorted(int[] nums)`**: This is the public interface method. It should check for edge cases (null or single-element arrays) and call your recursive helper method.
2.  **`private static boolean isSorted(int[] nums, int index)`**: This is the recursive helper method.
      * **Base Case**: The check should stop when the `index` reaches the end of the array, returning `true`.
      * **Recursive Step**: Compare the element at the current `index` with the element at `index + 1`. If the condition for being sorted is met, make a recursive call by advancing the index.

#### Part 2: Recursive Search for Element

The goal is to recursively determine if a specific integer value exists anywhere in the array.

1.  **`public static boolean recursiveSearch(int[] nums, int target)`**: This is the public interface method. It should call your recursive helper method.
2.  **`private static boolean recursiveSearch(int[] nums, int target, int index)`**: This is the recursive helper method.
      * **Base Case**: The check should stop when the `index` reaches the end of the array, returning `false`.
      * **Recursive Step**: Check if the element at the current `index` matches the `target`. If it matches, return `true`. Otherwise, make a recursive call by advancing the index.

### Provided Code Structure (Java)

**File: `ArrayUtils.java`**

```java
public class ArrayUtils {

    // Part 1: Public method to check if the array is sorted
    public static boolean isSorted(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        return isSorted(nums, 0);
    }

    // Part 1: Recursive helper method to check if the array is sorted
    /* ADD YOUR CODE HERE FOR: private static boolean isSorted(int[] nums, int index) */
    
    // Part 2: Public method to recursively search for a target
    public static boolean recursiveSearch(int[] nums, int target) {
        // You must call your recursive helper method from here
        /* ADD YOUR CODE HERE TO CALL HELPER */
    }

    // Part 2: Recursive helper method to search for a target
    /* ADD YOUR CODE HERE FOR: private static boolean recursiveSearch(int[] nums, int target, int index) */

public class ArrayUtils {

    // Part 1: Public method to check if the array is sorted
    public static boolean isSorted(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        return isSorted(nums, 0);
    }

    // Part 1: Recursive helper method to check if the array is sorted
    private static boolean isSorted(int[] nums, int index) {
        // Base Case: If we have reached the last element (or beyond), 
        // all previous comparisons were successful, so the array is sorted.
        if (index >= nums.length - 1) {
            return true;
        }
        
        // Recursive Step: Check the current pair.
        // If the current element is greater than the next one, it's unsorted.
        if (nums[index] > nums[index + 1]) {
            return false; 
        }
        
        // If the current pair is sorted, recursively check the rest of the array
        return isSorted(nums, index + 1);
    }
    
    // Part 2: Public method to recursively search for a target
    public static boolean recursiveSearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        // Pass to the recursive helper, starting at index 0
        return recursiveSearch(nums, target, 0);
    }

    // Part 2: Recursive helper method to search for a target
    private static boolean recursiveSearch(int[] nums, int target, int index) {
        // Base Case 1: Search failed, index is out of bounds
        if (index >= nums.length) {
            return false;
        }
        
        // Base Case 2: Target found at the current index
        if (nums[index] == target) {
            return true;
        }
        
        // Recursive Step: Check the rest of the array
        return recursiveSearch(nums, target, index + 1);
    }

}
}
```

**File: `Main.java` (Driver Program)**

```java
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        // Setup: Read array size and then array elements
        System.out.println("Enter the number of elements for the array:");
        int size = 0;
        if (scnr.hasNextInt()) {
            size = scnr.nextInt();
        }
        
        int[] data = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            if (scnr.hasNextInt()) {
                data[i] = scnr.nextInt();
            }
        }
        
        // --- Part 1 Testing ---
        System.out.println("\n--- Part 1: isSorted Test ---");
        System.out.println("Array: " + Arrays.toString(data));
        boolean sorted = ArrayUtils.isSorted(data);
        System.out.println("Is array sorted? " + sorted);

        // --- Part 2 Testing ---
        System.out.println("\n--- Part 2: recursiveSearch Test ---");
        System.out.println("Enter target value to search for:");
        int target = scnr.nextInt();
        
        boolean found = ArrayUtils.recursiveSearch(data, target);
        System.out.println("Target " + target + " found? " + found);
        
        // Test a non-existent value as well
        int nonTarget = target + 1; 
        System.out.println("Target " + nonTarget + " found? " + ArrayUtils.recursiveSearch(data, nonTarget));
        
        scnr.close();
    }
}
```

### Example Runs

**Example 1: Sorted Array**

| Input | Output |
| :--- | :--- |
| `5` | `Enter the number of elements for the array:` |
| `1 3 5 7 9` | `Enter 5 integers:` |
| `5` | `--- Part 1: isSorted Test ---` |
| | `Array: [1, 3, 5, 7, 9]` |
| | `Is array sorted? true` |
| | `--- Part 2: recursiveSearch Test ---` |
| | `Enter target value to search for:` |
| | `Target 5 found? true` |
| | `Target 6 found? false` |

**Example 2: Unsorted Array**

| Input | Output |
| :--- | :--- |
| `4` | `Enter the number of elements for the array:` |
| `10 20 5 30` | `Enter 4 integers:` |
| `20` | `--- Part 1: isSorted Test ---` |
| | `Array: [10, 20, 5, 30]` |
| | `Is array sorted? false` |
| | `--- Part 2: recursiveSearch Test ---` |
| | `Enter target value to search for:` |
| | `Target 20 found? true` |
| | `Target 21 found? false` |

### **Your Task**

Fill in the required recursive methods in the `ArrayUtils.java` class structure provided above. Remember, **no loops**\!