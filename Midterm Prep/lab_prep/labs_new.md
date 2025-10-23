You're absolutely right\! Let's streamline this to include only the **8 distinct and solved** labs, removing the redundancy caused by the comprehensive **Lab 4.23 (Recursive Array Check)**.

Here is the final, consolidated set of **eight** solved labs. Good luck with your exam\! 🍀

-----

## 🚀 Final Consolidated Data Structures Lab Solutions (8 Labs)

### 1\. High Array: Remove Max (Lab 1.9 - `removeMax()`)

| Topic | Complexity |
| :--- | :--- |
| **Unordered Array Deletion** | $O(N)$ |

**Overview:** Finds and removes the largest element by shifting subsequent elements down.

#### Code: `HighArray.java`

```java
class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    // --- insert, find, etc. omitted for brevity ---

    /**
     * Finds and removes the largest element in the array.
     * @return The largest value, or -1 if the array is empty.
     */
    public long removeMax() {
        /* ADD YOUR CODE HERE */
        if (nElems == 0) {
            return -1; // Empty array
        }

        int maxIndex = 0;
        long maxValue = a[0];

        // 1. Find the maximum value and its index
        for (int j = 1; j < nElems; j++) {
            if (a[j] > maxValue) {
                maxValue = a[j];
                maxIndex = j;
            }
        }

        // 2. Shift subsequent elements down to fill the gap (deletion)
        for (int k = maxIndex; k < nElems - 1; k++) {
            a[k] = a[k + 1];
        }

        nElems--;
        return maxValue;
    }
}
```

-----

\<hr\>

### 2\. Ordered Array: Binary Search (Lab 1.10 - `find()`)

| Topic | Complexity |
| :--- | :--- |
| **Ordered Array Search** | $O(\log N)$ |

**Overview:** Finds a value in an ordered array using the efficient **Binary Search** technique.

#### Code: `OrdArray.java`

```java
class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    // --- insert, delete, etc. omitted for brevity ---

    /**
     * Finds a value using Binary Search.
     * @param searchKey The value to search for.
     * @return The index of the value if found, or -1 if not found.
     */
    public int find(long searchKey) {
        /* ADD YOUR CODE HERE */
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            
            // 1. Check if the middle element is the key
            if (a[curIn] == searchKey) {
                return curIn; // Found it!
            } 
            // 2. Check if the search space is exhausted
            else if (lowerBound > upperBound) {
                return -1; // Cannot find it (search space closed)
            } 
            // 3. Adjust the bounds
            else { 
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1; // Key is in the upper half
                } else {
                    upperBound = curIn - 1; // Key is in the lower half
                }
            }
        }
    }
}
```

-----

\<hr\>

### 3\. Queue: Reverse (Lab 3.17 - `reverse()`)

| Topic | Complexity |
| :--- | :--- |
| **Queue/Stack Application** | $O(N)$ |

**Overview:** Demonstrates reversing a **Queue** by temporarily using a **Stack**, showing the complementary nature of FIFO and LIFO.

#### Code: `ArrayQueue.java`

```java
import java.util.Stack;

class ArrayQueue {
    // Simplified circular queue structure
    private int[] queArray;
    private int nItems;
    private int front;
    private int rear;

    public ArrayQueue(int s) {
        queArray = new int[s];
        nItems = 0;
        front = 0;
        rear = -1;
    }
    
    // --- insert/remove/etc. omitted for brevity ---

    /**
     * Reverses the order of all elements in the queue using a Stack.
     */
    public void reverse() {
        /* ADD YOUR CODE HERE */
        if (nItems <= 1) {
            return;
        }

        Stack<Integer> tempStack = new Stack<>();

        // 1. Dequeue all items and push them onto the stack (reverses order)
        int initialSize = nItems; 
        for (int i = 0; i < initialSize; i++) {
            // Assumes a 'remove()' method is defined in this class
            tempStack.push(this.remove()); 
        }

        // 2. Pop all items from the stack and enqueue them back (re-reverses to queue order)
        while (!tempStack.isEmpty()) {
            // Assumes an 'insert()' method is defined in this class
            this.insert(tempStack.pop()); 
        }
    }
    // Assumed dummy methods for compilation
    public void insert(int j) { /* ... */ }
    public int remove() { return 0; /* ... */ } 
}
```

-----

\<hr\>

### 4\. Singly Linked List: Delete All (Lab 4.18 - `removeAll(int n)`)

| Topic | Complexity |
| :--- | :--- |
| **SLL Complex Deletion** | $O(N)$ |

**Overview:** Requires careful two-pointer (`current`, `previous`) management to delete **all** occurrences of a key, including consecutive duplicates and the `first` link.

#### Code: `LinkList.java`

```java
class Link {
    public int dData;
    public Link next;

    public Link(int dd) {
        dData = dd;
    }
}

public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    // --- insertFirst/displayList/etc. omitted for brevity ---

    /**
     * Deletes all occurrences of a link with the given key.
     * @param key The value to delete.
     * @return true if at least one link was removed, false otherwise.
     */
    public boolean removeAll(int key) {
        /* ADD YOUR CODE HERE */
        Link current = first;
        Link previous = null;
        boolean removed = false;

        while (current != null) {
            if (current.dData == key) {
                removed = true;
                
                // Case 1: Node to be deleted is the 'first' link
                if (previous == null) {
                    first = current.next; // New 'first' is the next node
                } 
                // Case 2: Node is in the middle or end
                else {
                    previous.next = current.next; // Bypass 'current'
                    // previous DOES NOT advance here to handle consecutive duplicates (e.g., 5->5)
                }

                // Advance current to the node that was previously current.next
                if (previous == null) {
                     current = first; 
                } else {
                     current = previous.next; 
                }
            } else {
                // Key not found: Advance both pointers
                previous = current;
                current = current.next;
            }
        }
        return removed;
    }
}
```

-----

\<hr\>

### 5\. Doubly Linked List: Priority Insert (Lab 4.19 - `priorityInsert()`)

| Topic | Complexity |
| :--- | :--- |
| **DLL Sorted Insertion** | $O(N)$ |

**Overview:** Uses a DLL to maintain sorted order. Requires finding the position and performing the complex **4-pointer update** for insertion.

#### Code: `LinkList.java` (DLL version)

```java
class Link {
    public long dData;
    public Link next;
    public Link previous;

    public Link(long dd) {
        dData = dd;
    }
}

public class LinkList {
    private Link first;
    private Link last;

    public LinkList() {
        first = null;
        last = null;
    }

    // --- deleteFirst/deleteLast/etc. omitted for brevity ---

    /**
     * Inserts a new link while maintaining sorted order (Priority Queue logic).
     * @param key The key to insert.
     */
    public void priorityInsert(long key) {
        /* ADD YOUR CODE HERE */
        Link newLink = new Link(key);
        Link current = first;

        // 1. Find the link that the new link should come BEFORE
        while (current != null && current.dData < key) {
            current = current.next;
        }

        // 2. Perform the insertion
        
        // Case A: Insertion at the beginning (current is 'first' or list is empty)
        if (current == first) {
            if (first != null) {
                first.previous = newLink;
            }
            newLink.next = first;
            first = newLink;
            if (last == null) {
                last = newLink; // Handle empty list case (newLink is also 'last')
            }
        } 
        // Case B: Insertion at the end (current is null)
        else if (current == null) {
            last.next = newLink;
            newLink.previous = last;
            last = newLink;
        } 
        // Case C: Insertion in the middle (current is the node AFTER newLink)
        else {
            // NewLink's links
            newLink.next = current;
            newLink.previous = current.previous;
            
            // Surrounding links (4-pointer update)
            current.previous.next = newLink;
            current.previous = newLink;
        }
    }
}
```

-----

\<hr\>

### 6\. Recursion: Sum Digits (Lab 4.21 - `sumDigits(int num)`)

| Topic | Complexity |
| :--- | :--- |
| **Recursion (Integer)** | $O(\log_{10}N)$ |

**Overview:** Demonstrates the **recursive pattern for integer manipulation** using modulo (`%`) and division (`/`).

#### Code: `RecursiveMath.java`

```java
public class RecursiveMath {

    /**
     * Recursively calculates the sum of the digits in a non-negative integer.
     * @param num The integer to process.
     * @return The sum of its digits.
     */
    public static int sumDigits(int num) {
        /* ADD YOUR CODE HERE */
        // Base Case: Only one digit left (0-9)
        if (num < 10) {
            return num;
        }

        // Recursive Step:
        // 1. num % 10 isolates the rightmost digit (the digit to add to the sum)
        // 2. num / 10 removes the rightmost digit for the next recursive call
        return (num % 10) + sumDigits(num / 10);
    }
}
```

-----

\<hr\>

### 7\. Recursion: Linked List Reverse Print (Lab 4.22 - `recReversePrint()`)

| Topic | Complexity |
| :--- | :--- |
| **Recursion (Post-Order)** | $O(N)$ |

**Overview:** Uses the **post-order execution** of recursion (action after the recursive call returns) to reverse the order of output without changing pointers.

#### Code: `RecursiveLinkList.java`

```java
class Link {
    public int dData;
    public Link next;

    public Link(int dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}

public class RecursiveLinkList {
    private Link first;

    public RecursiveLinkList() {
        first = null;
    }

    // --- insertFirst/etc. omitted for brevity ---

    /**
     * Public interface to start the recursive reverse print.
     */
    public void recReversePrint() {
        System.out.print("Reverse Print: ");
        recReversePrint(first);
        System.out.println();
    }

    /**
     * Recursive helper to print links in reverse order.
     * @param current The current link being processed.
     */
    private void recReversePrint(Link current) {
        /* ADD YOUR CODE HERE */
        // Base Case: Reached the end of the list
        if (current == null) {
            return;
        }

        // 1. Recursive Call: Go to the NEXT link first. 
        //    This pushes all subsequent calls onto the stack.
        recReversePrint(current.next);

        // 2. Execution Point: Only run AFTER the recursive calls return.
        //    This executes in LIFO order, achieving the reverse print.
        current.displayLink();
    }
}
```

-----

\<hr\>

### 8\. Stack Application: Postfix Evaluation (Lab 3.10)

| Topic | Complexity |
| :--- | :--- |
| **Stack Application (String)** | $O(N)$ |

**Overview:** An iterative application of the **Stack** to evaluate arithmetic expressions written in Postfix Notation (Reverse Polish Notation).

#### Code: `ExpressionEvaluator.java`

```java
import java.util.Stack;

public class ExpressionEvaluator {

    /**
     * Evaluates a space-separated postfix arithmetic expression using a stack.
     * @param expression The postfix string (e.g., "5 2 + 3 *")
     * @return The integer result of the evaluation.
     */
    public static int evaluatePostfix(String expression) {
        /* ADD YOUR CODE HERE */
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            // Check if the token is a number
            if (token.length() > 0 && Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                // Operator Rule: Pop two operands (op2 is first, op1 is second)
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: Too few operands.");
                }
                
                int op2 = stack.pop(); 
                int op1 = stack.pop(); 
                int result;

                // Perform the operation
                switch (token) {
                    case "+": result = op1 + op2; break;
                    case "-": result = op1 - op2; break;
                    case "*": result = op1 * op2; break;
                    case "/": 
                        if (op2 == 0) throw new ArithmeticException("Division by zero.");
                        result = op1 / op2; 
                        break;
                    default: throw new IllegalArgumentException("Invalid operator: " + token);
                }

                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: Too many operands remaining.");
        }
        
        return stack.pop();
    }
}
```