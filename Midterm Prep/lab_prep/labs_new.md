## New Lab Assignment: 4.24 LAB Recursive Counting

### Overview

In this lab, you will complete a method in the provided `ArrayCounter` class to recursively count the number of elements in an array that satisfy a specific condition. This assignment reinforces the pattern of using **recursion with array indices** to iterate over an array.

The provided `ArrayCounter` class contains a static method, `countEvens`, which you will overload with a recursive helper method. You may **not** use any loops (`for`, `while`, `do-while`) or create any additional arrays.

### Requirements

You will add the following **two** methods to the `ArrayCounter` class.

#### Part 1: Recursive Count of Even Numbers

The goal is to recursively count how many elements in the array are **even**.

1.  **`public static int countEvens(int[] nums)`**: This is the public interface method. It should check for edge cases (null or empty arrays) and call your recursive helper method.
2.  **`private static int countEvens(int[] nums, int index)`**: This is the recursive helper method.
      * **Base Case**: The recursion should stop when the `index` reaches the end of the array, returning `0` (since no more elements can be counted).
      * **Recursive Step**: Check if the element at the current `index` is even.
          * If it is even, return `1 +` the result of the recursive call by advancing the index.
          * If it is odd, return `0 +` the result of the recursive call by advancing the index.

### Provided Code Structure (Java)

**File: `ArrayCounter.java`**

```java
public class ArrayCounter {

    // Part 1: Public method to count the number of even integers
    public static int countEvens(int[] nums) {
        /* ADD YOUR CODE HERE */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Call the recursive helper, starting at index 0
        return countEvens(nums, 0);
    }

    // Part 1: Recursive helper method to count even integers
    /* ADD YOUR CODE HERE FOR: private static int countEvens(int[] nums, int index) */
    
}
```

**File: `Main.java` (Driver Program)**

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 8, 1, 4, 10}; // Expected: 4 (2, 8, 4, 10)
        int[] arr2 = {1, 3, 5, 7, 9};    // Expected: 0
        int[] arr3 = {6};                // Expected: 1
        int[] arr4 = {};                 // Expected: 0

        System.out.println("Array 1: " + Arrays.toString(arr1) + " -> Evens: " + ArrayCounter.countEvens(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2) + " -> Evens: " + ArrayCounter.countEvens(arr2));
        System.out.println("Array 3: " + Arrays.toString(arr3) + " -> Evens: " + ArrayCounter.countEvens(arr3));
        System.out.println("Array 4: " + Arrays.toString(arr4) + " -> Evens: " + ArrayCounter.countEvens(arr4));
    }
}
```

-----

### Starting the Process

Based on our guide (Step 5: Formulate Logic), we need to focus on the **recursive helper method**:

`private static int countEvens(int[] nums, int index)`

**What should the Base Case be for this method, and what value must it return?**

That's fantastic\! Your confidence is well-earned. Moving to a completely different topic, let's focus on **Stacks and Strings** using the constraint from Lab 3.9 (using a stack to solve a conversion problem).

This lab will require you to combine:

1.  **Iterative Logic** (using loops, since this isn't a recursion lab).
2.  **Stack Usage** (to reverse the order).
3.  **String Building**.

-----

## New Lab Assignment: 3.10 LAB Postfix Expression Evaluation

### Overview

In this lab, you will complete the `evaluatePostfix` method in the provided `ExpressionEvaluator` class. This method takes a **postfix expression** (Reverse Polish Notation) as a string and calculates its result using a **Stack**.

### Background: Postfix Notation

In postfix notation, the operator comes *after* the operands. This eliminates the need for parentheses and complex operator precedence rules.

  * **Example:** The infix expression `(2 + 3) * 4` is written as `2 3 + 4 *` in postfix.

### Requirements

You will add the following **one** method to the `ExpressionEvaluator` class, which must use a `Stack<Integer>`.

#### Part 1: Postfix Evaluation

The goal is to evaluate a postfix expression containing non-negative single-digit integers and the operators `+`, `-`, `*`, and `/`. The input string will have operands and operators separated by a single space (e.g., `"5 2 + 3 *"`).

1.  **`public static int evaluatePostfix(String expression)`**:
      * Initialize an **integer stack**.
      * Iterate through the tokens (operands and operators) in the input string.
      * **If the token is an operand (a number)**, push its integer value onto the stack.
      * **If the token is an operator** (`+`, `-`, `*`, `/`):
          * Pop the **second operand** (`operand2`).
          * Pop the **first operand** (`operand1`).
          * Perform the operation (`operand1 operator operand2`).
          * Push the result back onto the stack.
      * After iterating through all tokens, the **final result** will be the single remaining value on the stack.

### Provided Code Structure (Java)

**File: `ExpressionEvaluator.java`**

```java
import java.util.Stack;

public class ExpressionEvaluator {

    /**
     * Evaluates a postfix expression using a stack.
     * Tokens are separated by a space (e.g., "5 2 + 3 *").
     * Assumes valid input: single digits, standard operators, no division by zero.
     * @param expression The postfix expression string.
     * @return The integer result of the expression.
     */
    public static int evaluatePostfix(String expression) {
        /* ADD YOUR CODE HERE */
        // Hint: You can use String.split(" ") to get an array of tokens.
        // Hint: Character.isDigit(char c) might be useful, or just check the token length.
        // Hint: Integer.parseInt(String s) converts a string to an int.
        
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            // Logic goes here
        }

        // The final result is the single remaining item on the stack
        return stack.pop();
    }

    private static int applyOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/": return operand1 / operand2;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
```

**File: `Main.java` (Driver Program)**

```java
public class Main {
    public static void main(String[] args) {
        // (5 + 2) * 3 = 21
        String exp1 = "5 2 + 3 *"; 
        // 10 / 2 - 1 = 4
        String exp2 = "10 2 / 1 -"; 
        // (1 + 2) * (3 + 4) = 21
        String exp3 = "1 2 + 3 4 + *";

        System.out.println("Expression: " + exp1 + " = " + ExpressionEvaluator.evaluatePostfix(exp1));
        System.out.println("Expression: " + exp2 + " = " + ExpressionEvaluator.evaluatePostfix(exp2));
        System.out.println("Expression: " + exp3 + " = " + ExpressionEvaluator.evaluatePostfix(exp3));
    }
}
```

-----

### Starting the Process

This lab is iterative (uses a loop) but introduces the **Stack** as the key data structure.

Based on our guide (Step 5: Formulate Logic), we are inside the **`for (String token : tokens)`** loop.

The key decision inside the loop is: **Is the current `token` an operand (a number) or an operator (`+`, `-`, `*`, `/`)?**

**What is the logic for handling the token if it is an OPERAND (a number)?** (What should you do with the number and the stack?)

That's a fantastic idea\! Asking focused questions is the best way to solidify your understanding. I'll provide a new lab from a different section—we haven't focused on **Linked List structure modifications (non-recursive)** yet. This will test your understanding of pointers, constraints, and method placement.

Here is your new challenge lab\!

-----

## New Lab Assignment: 4.17 LAB Linked List Insertion

### Overview

In this lab, you will modify the `LinkList` class to implement two new insertion methods. These methods require manipulating the `Link` pointers within the list to insert a new node at specific locations. You will **not** use recursion for these methods; you must use iterative logic (loops or traversal).

The provided `LinkList` class uses a **singly linked list** structure where each `Link` node contains a `long` key and a pointer to the `next` Link. The list maintains a reference to the `first` link.

### Requirements

You will add the following **two** methods to the `LinkList` class.

#### Part 1: Insert After a Specific Link

The goal is to insert a new `Link` with a given key **immediately after** a link containing a specific key value.

1.  **`public boolean insertAfter(long key, long newKey)`**:
      * Traverse the list starting from the `first` link.
      * Search for a link whose key matches the input `key`.
      * If the `key` is found:
          * Create a new `Link` with the `newKey`.
          * Insert the new link immediately after the found link by adjusting the pointers.
          * Return `true`.
      * If the `key` is not found after checking the whole list, return `false`.

#### Part 2: Insert Before a Specific Link

The goal is to insert a new `Link` with a given key **immediately before** a link containing a specific key value.

1.  **`public boolean insertBefore(long key, long newKey)`**:
      * This operation is harder because you need the pointer to the **Link PRECEDING** the target link (`key`) to correctly adjust the chain.
      * Traverse the list using **two pointers**: a `current` pointer and a `previous` pointer that always trails one step behind `current`.
      * Search for a link whose key matches the input `key`.
      * If the `key` is found:
          * Create a new `Link` with the `newKey`.
          * Insert the new link immediately before the found link by adjusting the pointers. Remember to handle the edge case where the target link is the `first` link.
          * Return `true`.
      * If the `key` is not found, return `false`.

### Provided Code Structure (Simplified Java)

**File: `Link.java`**

```java
public class Link {
    public long dData; // data item (key)
    public Link next;  // next link in list

    public Link(long dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }
}
```

**File: `LinkList.java`**

```java
public class LinkList {
    private Link first; // ref to first link on list

    public LinkList() {
        first = null; // list is empty
    }

    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        newLink.next = first;
        first = newLink;
    }

    // Displays the list (omitted for brevity)

    // Part 1: Insert a new link AFTER a link with key
    public boolean insertAfter(long key, long newKey) {
        /* YOUR CODE GOES HERE */
        // Use a single 'current' pointer.
    }

    // Part 2: Insert a new link BEFORE a link with key
    public boolean insertBefore(long key, long newKey) {
        /* YOUR CODE GOES HERE */
        // Use 'current' and 'previous' pointers.
    }
}
```

-----

**Your Turn\!** Start asking questions based on the guide you now have. Which part should we tackle first, and what questions do you have about the constraints or setup?

