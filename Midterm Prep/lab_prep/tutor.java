//## New Lab Assignment: 4.24 LAB Recursive Counting
private static int countEvens(int[] nums, int index) {
    if (index >= nums.length) {
        return 0;
    }
    
    if (nums[index] % 2 == 0) {
        return 1 + countEvens(nums, index + 1);
    } else {
        //advance it regardless
        return countEvens(nums, index + 1);
    }

}

/*
private static int countEvens(int[] nums, int index) {
    // 1. BASE CASE: Stops the recursion when the entire array is processed.
    // When out of bounds, no more evens can be counted, so return 0.
    if (index >= nums.length) { 
        return 0;
    }
    
    // 2. RECURSIVE STEP (Case 1: Even Number)
    if (nums[index] % 2 == 0) {
        // Count 1 for the current even number, and recursively add the count 
        // from the REST of the array by advancing the index (index + 1).
        return 1 + countEvens(nums, index + 1);
    } 
    
    // 3. RECURSIVE STEP (Case 2: Odd Number)
    else {
        // The current number is 0 (odd), so don't add to the count, 
        // but still move on and recursively check the REST of the array.
        // The fix: You must advance the index (index + 1) to progress toward the base case.
        return 0 + countEvens(nums, index + 1); // 0 + is optional but conceptually clearer
        // return countEvens(nums, index + 1); // Shorthand, also correct
    }
}
*/

//## New Lab Assignment: 3.10 LAB Postfix Expression Evaluation
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
        😊
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            // Logic goes here
            if (token.length() == 1 && Character.isDigit(token.charAt(0))) {
                int tok = Integer.parseInt(token);
                stack.push(tok);
            }

            if (token == '+' || token == '-' || token == '*' || token == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperation(token, operand2, operand1);
                stack.push(result);
            }
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

/*
import java.util.Stack;

public class ExpressionEvaluator {

    // ... (applyOperation helper method is provided) ...
    private static int applyOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/": return operand1 / operand2;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            
            // OPERAND CASE: Check if the token is a single-digit number
            // Note: Using .equals() for string comparison is generally safer than ==
            if (token.length() == 1 && Character.isDigit(token.charAt(0))) {
                int tok = Integer.parseInt(token);
                stack.push(tok);
            } 
            
            // OPERATOR CASE: Check if the token is an operator
            else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Must pop operand2 BEFORE operand1 because of LIFO stack order
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
                // Calculate and store the result
                int result = applyOperation(token, operand1, operand2);
                
                // Push the single integer result back onto the stack
                stack.push(result);
            }
            // (A production version would need an 'else' block here to handle bad input)
        }

        // The final result is the single remaining item on the stack
        return stack.pop();
    }
}
*/

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
        Link current = first;
        while (current != null) {
            //data inside current, not just current itself
            if (current.dData == key) {
                //keep variable 'newLink' same as in other methods^
                Link newLink = new Link(newKey);

                //🚨
                newLink.next = current.next;
                current.next = newLink;

                return true;
            } else {
                current = current.next;
            }
        }
    }

    // Part 2: Insert a new link BEFORE a link with key
    public boolean insertBefore(long key, long newKey) {
        /* YOUR CODE GOES HERE */
        // Use 'current' and 'previous' pointers.
    }
}