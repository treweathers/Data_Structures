# ZyLabs Guide

That's a great approach! For complex programming assignments, especially those involving pre-existing data structure code, the setup and planning phase is crucial. You're right—it's more than just understanding the data structure; it's about understanding the **layers of interaction** between the application logic (`Main` class) and the data structure (`OrdArray`, `LinkList`, etc.) class.

Here is a structured guide on how to approach layered programming assignments like the ones you've shared.

***

## 💡 The Layered Programming Assignment Setup Guide

The key to tackling these labs is to define the **contract** between the **Driver/Main Class** (the application layer) and the **Data Structure Class** (the implementation layer) *before* you write the method logic.

### 1. Analyze the Big Picture & Goal

Start with the lab's main objective.

* **What is the core data structure?** (e.g., `HighArray`, `OrdArray`, `Queue`, `LinkList`, Recursion on an array/list).
* **What is the final state/output?** (e.g., Sorted array, menu simulation, decimal to binary conversion, reversed queue, specific recursive result).

### 2. Deconstruct the Interactions: Method Contracts

For labs like **1.10 LAB: Ord Array** (and similar ones that involve two classes), the most important step is defining **who calls whom** and **what data is passed**.

#### A. Review the Driver/Main Class (The Caller)

The `Main` class shows the **application logic** and the **user interface**. Focus on the `input(int choice)` method.

| Choice | User Input | Action Taken by `Main` | Call to Data Structure Class | Notes on `OrdArray` Method Needed |
| :---: | :---: | :---: | :---: | :--- |
| **1** | Reads `num` (count) | Calls a method with `num` | `arr.fillArray(num)` | **Needs:** `public void fillArray(int n)` in `OrdArray`. |
| **2** | Reads `number` | Calls a method with `number` | `arr.addNumber(number)` | **Needs:** `public void addNumber(int n)` in `OrdArray`. |
| **3** | Reads `numInd` (search key) | Gets a return value (`foundInd`) | `arr.findIndex(numInd)` | **Needs:** `public int findIndex(int num)` in `OrdArray`. |
| **4** | Reads `delete` (index) | Calls a method with `delete` | `arr.removeIndex(delete)` | **Needs:** `public void removeIndex(int idx)` in `OrdArray`. |

**Conclusion for `OrdArray`:** The `Main` class dictates the **signature** (name, parameters, return type) for the four new methods you must implement in the `OrdArray` class.

#### B. Define the Data Structure Class Methods (The Callee)

Now, based on the **required signatures** from the `Main` class and the **lab requirements**, write down exactly what each method in the data structure class is responsible for.

| `OrdArray` Method Signature | Required Action / Description | Key Existing Methods to Use |
| :--- | :--- | :--- |
| `public void fillArray(int n)` | Fill the array with `n` random numbers (1-99). **Must use** the `rnd` object. | `insert(long value)` to maintain order, `rnd.nextInt(99) + 1` for random number. |
| `public void addNumber(int n)` | Insert `n` if there is room. Display "full" if array is at max size (10). | `nElems` and `a.length` for capacity check, `insert(long value)`. |
| `public int findIndex(int num)` | Find and return the index of `num`. | `find(long searchKey)` (which does the binary search). |
| `public void removeIndex(int idx)` | Remove the element at `idx` if valid. Display "error" if invalid. | Direct array manipulation (shifting elements), check `idx >= 0 && idx < nElems`. |

### 3. Layer-Specific Implementation Strategies

Once the method contracts are clear, you can focus on the implementation details, using the existing code as a template.

#### For Array/List Manipulation Labs (e.g., 1.9, 2.17, 4.18, 4.19)

* **Leverage Existing Logic:** For `HighArray` or `OrdArray`, use the existing `insert()` and `delete()` methods as examples for how to manage the `nElems` count and how to shift array elements.
* **The Sorting Trick (1.9 Part 3):** Note that this task requires the sort *not* to modify the `HighArray` class. This means the entire sorting algorithm must live **inside `main()`** using the new `removeMax()` method and a second array.
    * **Logic Flow (in `main`):**
        1.  Create a second array (`sortedArray`).
        2.  Loop while the original array is not empty.
        3.  In each iteration, call `highArray.removeMax()`.
        4.  Store the returned value in the next available slot of `sortedArray`.

#### For Stack/Queue Labs (e.g., 3.9, 3.17)

* **Define the Stack/Queue Contract:** These labs require using a temporary data structure to achieve the goal.
    * **3.9 Decimal to Binary:** The binary conversion logic is naturally recursive (or stack-based). You push the remainder ($\text{decimal} \% 2$) onto a stack, then divide ($\text{decimal} / 2$), and repeat until zero. The stack's pop order (LIFO) is the correct binary sequence.
    * **3.17 Reverse Queue:** To reverse a Queue (FIFO) using a Stack (LIFO), you must:
        1.  Dequeue all elements from the Queue and push them onto the Stack.
        2.  Pop all elements from the Stack and enqueue them back into the Queue.

#### For Recursion Labs (e.g., 4.21, 4.22)

* **The Three Laws of Recursion:**
    1.  **Base Case:** When does the recursion stop? (e.g., `n=0`, `index` is out of bounds, `num=0`, `from > to`).
    2.  **Recursive Call:** How do you break the problem down into a smaller, identical subproblem? (e.g., calling the method with `n-1`, `num/10`, `index+1`).
    3.  **Work:** What do you do with the result of the recursive call to get the final answer? (e.g., `return 3 + bunnyEars2(n-1)`, `return (num % 10) + sumDigits(num/10)`).
* **Recursive Linked Lists (4.22):** The contract is usually between a public non-recursive method and a private recursive helper.
    * `public int recGetLength()` **calls** `private int recGetLength(Link currentLink)`. The public method provides the starting point (`first` Link). The recursive helper handles the actual base case (is the link `null`?) and the recursive step (`1 + recGetLength(currentLink.next)`).

## Consolidated Data Structures Lab Methods Summary (9 Labs)

### 1. High Array (Lab 1.9)

* `insert(long value)`: Add value to the end. $O(1)$.
* `find(long searchKey)`: Sequential (linear) search. $O(N)$.
* **`delete(long value)`**: Find and remove first occurrence, **shift subsequent elements down**. $O(N)$.
* **`getMax()`**: Find (but don't remove) the maximum value. $O(N)$.
* **`removeMax()`**: Find and remove the maximum value, **shift elements down**. $O(N)$.

---

### 2. Ordered Array (Lab 1.10)

* **`insert(long value)`**: Find insertion point and **shift elements up** to maintain order. $O(N)$.
* **`find(long searchKey)`**: **Binary Search** implementation. $O(\log N)$.
* **`delete(long value)`**: Use `find()` to locate, then **shift elements down** to remove. $O(N)$.
* `removeIndex(int idx)`: Delete element at a known index by shifting elements down. $O(N)$.

---

### 3. Two Sorted Arrays (Lab 2.17)

* **`rearrange(int[] A, int[] B)`**: **In-place partition** (swap $A[j]$ with $B[0]$ if $A[j] > B[0]$) and **re-sort $B$** using an Insertion Sort pattern. $O(A \cdot B)$.

---

### 4. Stack (Lab 3.9)

* **`push(int j)`**: Add item to the $\mathbf{top}$ of the array (pre-increment `top`). $O(1)$.
* **`pop()`**: Remove and return item from the $\mathbf{top}$ (post-decrement `top`). $O(1)$.
* `peek()`: View top item without removal. $O(1)$.
* `decimalToBinary(int d)`: Application method: Uses the stack's **LIFO** property to reverse the order of modulo remainders. $O(\log_{2}N)$.

---

### 5. Queue (Lab 3.17)

* **`insert(int j)`**: Add item to the $\mathbf{rear}$ of the **circular array**. $O(1)$.
* **`remove()`**: Remove and return item from the $\mathbf{front}$ of the circular array. $O(1)$.
* **`reverse()`**: Application method: Transfers all items to a **Stack** (inverts order) and then back to the **Queue** (re-inverts). $O(N)$.

---

### 6. Singly Linked List (Lab 4.18)

* `insertFirst(int dd)`: Add a link at the start (`first`). $O(1)$.
* `deleteFirst()`: Remove the first link. $O(1)$.
* **`delete(int key)`**: Find and remove the $\mathbf{first}$ key, requiring a $\mathbf{previous}$ pointer to bypass. $O(N)$.
* **`removeLast(int n)`**: Traverses once to $\mathbf{track}$ the last matching link and its $\mathbf{predecessor}$, then deletes. $O(N)$.
* **`removeAll(int n)`**: Deletes **all** occurrences, requiring dynamic logic to update $\mathbf{first}$ and avoid advancing $\mathbf{previous}$ after a deletion. $O(N)$.

---

### 7. Doubly Linked List / Priority Queue (Lab 4.19)

* `insertFirst/Last(long dd)`: Standard $O(1)$ insertion, updates $\mathbf{next}$ and $\mathbf{previous}$.
* `deleteFirst/Last()`: Standard $O(1)$ deletion, updates $\mathbf{next}$ and $\mathbf{previous}$.
* **`priorityRemove()`**: **Removes the highest priority item** (the $\mathbf{last}$ element) by calling `deleteLast()`. $O(1)$.
* **`priorityInsert(long key)`**: Finds the correct sorted position ($O(N)$) and inserts, requiring a $\mathbf{4-pointer}$ update. $O(N)$.
* `deleteKey(long key)`: Find and remove a key, requiring $\mathbf{4-pointer}$ updates to bypass. $O(N)$.

---

### 8. Recursion (Numeric/Array) (Lab 4.21)

* **`triangle(int rows)`**: Sum of rows (e.g., $1+2+3+\dots+$rows). Base case $\mathbf{rows=0}$. $O(N)$.
* **`sumDigits(int num)`**: Sum of a number's digits using $\mathbf{\% 10}$ and $\mathbf{/ 10}$. Base case $\mathbf{num < 10}$. $O(\log_{10}N)$.
* **`bunnyEars2(int n)`**: Calculates ears based on $\mathbf{n}$'s $\mathbf{parity}$ (odd/even) with $\mathbf{2}$ or $\mathbf{3}$ ears. $O(N)$.
* **`arrayVal(int[] nums, int index, int Val)`**: Recursive $\mathbf{search}$ for $\mathbf{Val}$ starting at $\mathbf{index}$. $O(N)$.
* **`arrayX10(int[] nums, int index)`**: Recursive $\mathbf{pattern}$ $\mathbf{search}$ for $N, 10N$ starting at $\mathbf{index}$. $O(N)$.
* **`array11(int[] nums, int index)`**: Recursive $\mathbf{count}$ of $\mathbf{11}$'s starting at $\mathbf{index}$. $O(N)$.

---

### 9. Recursion (Linked List) (Lab 4.22)

* `recGetLength()`: Recursive $\mathbf{list}$ $\mathbf{length}$ (base case $\mathbf{current = null}$). $O(N)$.
* **`recReversePrint()`**: Recursive $\mathbf{print}$ using the stack's $\mathbf{post-order}$ execution. $O(N)$.
* **`recRemoveFirst(int n)`**: Recursive deletion, returns $\mathbf{current.next}$ if $\mathbf{n}$ is found, stopping the chain. $O(N)$.
* **`recRemoveAll(int n)`**: Recursive $\mathbf{deletion}$ of $\mathbf{all}$ $\mathbf{occurrences}$. Always recurses, returns $\mathbf{current.next}$ if $\mathbf{n}$ is a match. $O(N)$.

That's a fantastic first lab\! It covers core array operations, which are foundational. Here is the bullet-point study guide for Lab 1.9: High Array.

## Lab 1.9: High Array Methods Study Guide 📚

This lab focuses on a simple, unsorted array encapsulated in a `HighArray` class, demonstrating basic data management and a simple, non-in-place sorting technique.

### Core `HighArray` Class Methods

| Method | Description | Data Structure Usefulness |
| :--- | :--- | :--- |
| **`insert(long value)`** | Adds a value to the end of the array. | **Basic Array/List Operation:** Essential for unsorted array/list data structures. Trivial $O(1)$ time complexity if there's space. |
| **`find(long searchKey)`** | Searches for a specific value by iterating from the start. | **Basic Sequential Search:** Illustrates a linear search, $O(N)$ time complexity. Useful for understanding search efficiency limits. |
| **`delete(long value)`** | Finds and removes the *first* occurrence of a value, shifting all subsequent elements down to fill the gap. | **Deletion in Unsorted Array:** The shifting operation is key, as it maintains array contiguity. This is an $O(N)$ operation. |
| **`display()`** | Prints all elements in the array. | **Debugging/Output:** Standard utility method for visualizing the array's contents. |
| **`size()`** | Returns the number of elements currently in the array (`nElems`). | **Utility:** Useful for loop control and checking array state (e.g., if empty). |

-----

### New/Modified Methods for Programming Portions (High-Value Code)

| Method | Description | Data Structure Usefulness |
| :--- | :--- | :--- |
| **`getMax()`** | **Finds the maximum value** in the array. Does *not* remove it. Returns $-1$ if empty. | **Max/Min Search Pattern:** A classic loop pattern for finding the largest/smallest element in an unsorted array. $O(N)$ time. |
| **`removeMax()`** | **Finds and removes the maximum value** from the array. Returns $-1$ if empty. | **Combined Find & Delete:** High-value code for finding the max value ($O(N)$) and then performing the shift operation to delete it ($O(N)$). **Total $O(N)$.** |

-----

### Sorting Technique (Code in `main()`)

  * **Method:** **Selection Sort using an auxiliary array.**
  * **Mechanism:**
    1.  Repeatedly call the `removeMax()` method on the original array.
    2.  Store the value returned by `removeMax()` into a *second, separate array*.
    3.  Because `removeMax()` always returns the largest remaining element, the second array accumulates the elements in descending sorted order.
  * **Usefulness:** Demonstrates a non-in-place sorting technique. While inefficient ($O(N^2)$ time complexity because `removeMax()` is called $N$ times, and each call is $O(N)$), it's a very clear way to *select* the next largest element for sorting.

-----

### $\rightarrow$ Most Helpful Code for Exams:

The most valuable code snippets for your programming exam will be:

1.  **Deletion with Element Shifting:** The logic inside the **`delete()`** and **`removeMax()`** methods showing how to shift elements:

    ```java
    for(int k=j; k < nElems - 1; k++) {
       a[k] = a[k+1];
    }
    nElems--;
    ```

    This is a core operation when manipulating non-linked data (like arrays) where gaps aren't allowed.

2.  **Max/Min Value Search:** The pattern used in **`getMax()`** and **`removeMax()`** for iterating to find a specific value (in this case, the maximum):

    ```java
    long max = a[0];
    for (int j = 1; j < nElems; j++) {
       if (a[j] > max) {
          max = a[j];
       }
    }
    ```

Ready for Lab 2 whenever you are\! 😊


That's an excellent lab that builds directly on the first one, but adds the crucial concept of **order maintenance**. Here is the study guide for Lab 1.10: Ord Array.

## Lab 1.10: Ord Array Methods Study Guide 📚

This lab focuses on the **Ordered Array** (`OrdArray`) data structure, where the elements are kept sorted at all times. This design dramatically improves search efficiency but makes insertion and deletion more complex than in an unsorted array.

### Core `OrdArray` Class Methods (Foundation)

| Method | Description | Data Structure Usefulness |
| :--- | :--- | :--- |
| **`insert(long value)`** | Inserts a value while maintaining sorted order. It first **linearly** finds the correct position, then **shifts elements** up. | **Sorted Insertion:** $O(N)$ time complexity due to the shifting required in the array. This is the trade-off for keeping the data sorted. |
| **`find(long searchKey)`** | **Binary Search** implementation to locate a value. | **Efficient Search:** The most important method in a sorted array. $O(\log N)$ time complexity. This is the primary advantage of this structure over `HighArray`. |
| **`delete(long value)`** | Locates the value using `find()` (binary search) and then **shifts elements** down to close the gap. | **Deletion in Sorted Array:** $O(\log N)$ to find, but $O(N)$ to shift. Total time is dominated by the shift, making it $O(N)$. |
| **`display()`** | Prints all elements in the array. | **Utility/Debugging.** |
| **`size()`** | Returns the number of elements currently in the array (`nElems`). | **Utility.** |

-----

### New/Modified Methods for Programming Portions (High-Value Code)

| Method | Description | Data Structure Usefulness |
| :--- | :--- | :--- |
| **`fillArray(int n)`** | Fills the array with $n$ random numbers. It uses a loop that calls the $O(N)$ **`insert()`** method $N$ times. | **Initialization/Bulk Insertion:** This is an $O(N^2)$ operation overall, highlighting the cost of repeatedly inserting into a sorted array. Useful for initial data setup. |
| **`addNumber(int n)`** | Adds a single number using **`insert()`** if the array is not full. Includes logic for checking max capacity. | **Insertion with Capacity Check:** Standard pattern for bounded array/list data structures. |
| **`findIndex(int num)`** | A simple wrapper that calls the core **`find()`** (binary search) method. | **Search Interface:** Demonstrates how the efficient binary search is leveraged. The returned value is the index, or `nElems` if not found. |
| **`removeIndex(int idx)`** | Removes the element at a specific index by **shifting all subsequent elements down**. Also includes boundary check validation. | **Direct Indexed Deletion:** This is the core logic for array deletion *once the index is known*. It is $O(N)$ because of the shift. |

-----

### $\rightarrow$ Most Helpful Code for Exams:

The most valuable code snippets for your programming exam are related to the efficiency improvements and the required overhead:

1.  **Binary Search Implementation:** The logic in **`find()`** is critical. You must be able to reproduce or adapt this $O(\log N)$ algorithm:

    ```java
    // Binary Search Logic
    while(lowerBound <= upperBound) {
        curIn = (lowerBound + upperBound) / 2;
        if (a[curIn] == searchKey) return curIn;
        else if (a[curIn] < searchKey)
            lowerBound = curIn + 1; // Search upper half
        else
            upperBound = curIn - 1; // Search lower half
    }
    return nElems; // Not found
    ```

2.  **Insertion with Shifting:** The logic in **`insert()`** which first finds the position, then shifts elements *up*:

    ```java
    // Shifting elements to make room for insertion
    for(int k = nElems; k > j; k--)
        a[k] = a[k-1];
    a[j] = value;
    nElems++;
    ```

3.  **Indexed Deletion with Shifting:** The logic in **`removeIndex()`** which shifts elements *down* once the index is known:

    ```java
    // Shifting elements down to close the gap after deletion
    for (int j = idx; j < nElems - 1; j++) {
        a[j] = a[j + 1];
    }
    nElems--;
    ```

Ready for Lab 3\! 😊

That's a very challenging and clever lab\! It's a great example of an "in-place" algorithm problem, which often features heavily in data structures and coding interviews.

Here is your study guide for Lab 2.17: Two Sorted Arrays.

## Lab 2.17: Two Sorted Arrays Methods Study Guide 📚

This lab focuses on a space-constrained algorithm (no extra arrays allowed) for **partitioning** the elements of two arrays while maintaining the sorted order within each.

### Core Logic Method (High-Value Code)

| Method | Description | Algorithm Type & Time Complexity |
| :--- | :--- | :--- |
| **`rearrange(int[] arrayA, int[] arrayB)`** | Partitions elements between two arrays so that all elements in `arrayA` are smaller than all elements in `arrayB`. | **In-Place Partitioning & Sorting.** $O(N^2)$ or $O(A \cdot B)$ complexity in the worst case, due to repeated internal shifting/sorting of array B. |

### Key Mechanisms within `rearrange`

The method relies on two nested operations for its functionality:

#### 1\. The Partitioning Comparison Loop (Outer Loop)

  * **Goal:** Iterate through `arrayA` to find any element that belongs in `arrayB`.
  * **Condition:** `if (arrayA[j] > arrayB[0])`
      * Since `arrayA` is sorted, and `arrayB[0]` is the *smallest* element of the remaining larger set, if any element in `arrayA` is bigger than `arrayB[0]`, it must be swapped out.
  * **Action:** If the condition is met, perform a standard **three-step swap** between `arrayA[j]` and `arrayB[0]`.

#### 2\. The Internal Sorting Loop (Inner Loop)

  * **Goal:** After a swap, the new element at `arrayB[0]` (which came from `arrayA`) violates `arrayB`'s sorted property. This loop immediately re-sorts `arrayB`.
  * **Mechanism:** This is an **Insertion Sort** pattern, where the misplaced element at index 0 bubbles up (or shifts down) to its correct position.
  * **Code Pattern:**
    ```java
    int k = 1;
    while (k < arrayB.length && arrayB[k] < arrayB[k - 1]) {
        // SWAP arrayB[k] and arrayB[k - 1]
        k++; // Move to the next element
    }
    ```
  * **Efficiency Note:** If we used a $O(\log N)$ operation to find the correct insertion point in `arrayB`, the overall complexity could be slightly improved, but the simple sequential shifting makes it easy to implement here.

### Helper Methods

| Method | Description | Usefulness |
| :--- | :--- | :--- |
| **`main()`** | Handles user input (seed, sizes), array initialization, and uses `Random` for filling. | **Testing & Setup:** Shows how to use `java.util.Random(seed)` for deterministic random numbers and `java.util.Arrays.sort()` for fast initial sorting. |
| **`printArray(int[] arr)`** | Utility to print array contents. | **Debugging & Output.** |

-----

### $\rightarrow$ Most Helpful Code for Exams:

This lab is a masterclass in **in-place manipulation without extra memory**. The most valuable patterns are the comparison and the re-sorting step:

1.  **The Partitioning Condition (Outer Loop):** This logic is key for dividing two sorted groups:

    ```java
    // Iterate A. If A's element is larger than B's smallest, they are in the wrong group.
    if (arrayA[j] > arrayB[0]) {
        // 1. SWAP A[j] and B[0]
        // 2. Re-sort B (Inner Loop)
    }
    ```

2.  **In-Place Shifting/Re-Sorting (Inner Loop):** The use of a simple `while` loop to fix the order immediately after a swap. This is essentially an *unoptimized insertion sort* on a single element and is vital when a third array is forbidden.

    ```java
    // Re-sort arrayB (moving arrayB[0] to its correct spot)
    int k = 1;
    while (k < arrayB.length && arrayB[k] < arrayB[k - 1]) {
        // Swap arrayB[k] and arrayB[k - 1]
        int tempSwap = arrayB[k];
        arrayB[k] = arrayB[k - 1];
        arrayB[k - 1] = tempSwap;
        k++; // Continue checking the next element
    }
    ```

Ready for Lab 4\! That's 3 down, 6 to go\! 😊

Excellent choice\! Lab 3.9 shifts us from array manipulation to the fundamental concept of **stacks**—a classic data structure.

Here is the study guide for Lab 3.9: Decimal to Binary.

## Lab 3.9: Decimal to Binary Methods Study Guide 📚

This lab introduces the **Stack** (LIFO - Last-In, First-Out) data structure and uses it to solve a standard computer science problem: base conversion.

### Core `Stack` Class Methods (High-Value Code)

The `Stack` class implements basic stack operations using an underlying array. These four methods are the most critical to understand for any stack-based problem.

| Method | Description | Time Complexity | Usefulness |
| :--- | :--- | :--- | :--- |
| **`push(int j)`** | Inserts an item onto the top of the stack (`top` is pre-incremented). | $O(1)$ | Essential operation for adding data. |
| **`pop()`** | Removes and returns the item from the top of the stack (`top` is post-decremented). | $O(1)$ | Essential operation for retrieving data in LIFO order. |
| **`peek()`** | Returns the item at the top of the stack *without* removing it. | $O(1)$ | Useful for checking the next item without consuming it. |
| **`isEmpty()`** | Checks if the stack has any elements (i.e., if `top == -1`). | $O(1)$ | Crucial for preventing errors (`pop` or `peek` on an empty stack). |
| **`isFull()`** | Checks if the underlying array is at its maximum capacity. | $O(1)$ | Necessary for array-based (bounded) stack implementations. |

-----

### Application Method (`Main` Class)

| Method | Description | Algorithm & Data Structure Usefulness |
| :--- | :--- | :--- |
| **`decimalToBinary(int decimal)`** | Converts a base-10 integer to a base-2 string representation using a stack. | **Base Conversion Algorithm:** This demonstrates how the LIFO property of a stack naturally handles the **"remainder method"** for base conversion, where remainders are generated from least significant to most significant but must be read out in the opposite order. |

### Key Logic within `decimalToBinary`

1.  **Generation (Pushing):** Uses the modulo (`% 2`) and division (`/ 2`) operations.
    ```java
    while (decimal > 0) {
       int remainder = decimal % 2; // remainder (0 or 1) is the next binary digit
       s.push(remainder);          // Pushed in reverse order (LSB first)
       decimal = decimal / 2;
    }
    ```
2.  **Extraction (Popping):** Pops the remainders off the stack, which reverses the order, thus producing the correct binary string (MSB first).
    ```java
    StringBuilder result = new StringBuilder();
    while (!s.isEmpty()) {
       result.append(s.pop()); // Popped out in correct order (MSB first)
    }
    return result.toString();
    ```

-----

### $\rightarrow$ Most Helpful Code for Exams:

For an exam, knowing how to implement the basic **stack array mechanics** and the **base conversion algorithm** using LIFO is vital.

1.  **Stack Operations (Array Implementation):** The simple $O(1)$ implementation of `push` and `pop` is foundational:

    ```java
    // PUSH:
    stackArray[++top] = j;

    // POP:
    return stackArray[top--];
    ```

2.  **Stack-based Base Conversion:** This exact pattern can be adapted for any base conversion (e.g., decimal to octal or hexadecimal, just change the modulo/division value).

    ```java
    // Algorithm pattern for LIFO ordering
    while (input > 0) {
        // Step 1: Calculate the next digit/remainder
        // Step 2: Push the remainder onto the stack
        // Step 3: Prepare for the next iteration (e.g., division)
    }
    // Step 4: Pop and append to reconstruct the result in the correct order
    ```

Ready for Lab 4\!

Another great lab\! Lab 3.17 connects **Queues** (FIFO) and **Stacks** (LIFO) to perform a classic data structure reversal operation.

Here is the study guide for Lab 3.17: Reverse Queue.

## Lab 3.17: Reverse Queue Methods Study Guide 📚

This lab introduces the **Queue** data structure (FIFO - First-In, First-Out), implemented as a circular array, and demonstrates using a Stack to reverse its order.

### Core `Queue` Class Methods (Foundation)

The `Queue` is implemented using a **circular array** (an array where `front` and `rear` indices can wrap around).

| Method | Description | Time Complexity | Usefulness |
| :--- | :--- | :--- | :--- |
| **`insert(int j)`** | Adds an item to the **rear** of the queue. Includes logic for array wraparound. | $O(1)$ | Essential operation (Enqueue). |
| **`remove()`** | Removes and returns the item from the **front** of the queue. Includes logic for array wraparound. | $O(1)$ | Essential operation (Dequeue). |
| **`peekFront()`** | Returns the item at the front *without* removing it. | $O(1)$ | Utility for viewing the next item. |
| **`isEmpty()`/`isFull()`** | Checks the state of the queue using the `nItems` counter. | $O(1)$ | Crucial for preventing underflow/overflow errors. |
| **`display()`** | Prints the elements from the `front` to the `rear`, correctly handling the circular array structure using the modulo operator. | $O(N)$ | Utility for debugging, showcases circular array traversal: `queArray[(front + i) % maxSize]`. |

-----

### New/Modified Method (High-Value Code)

| Method | Description | Algorithm & Data Structure Usefulness |
| :--- | :--- | :--- |
| **`reverse()`** | Reverses the order of the queue elements using a temporary stack. | **Queue Reversal using LIFO/FIFO:** This is a canonical problem demonstrating how to **invert order** using the fundamental property of stacks. $O(N)$ time complexity, as every element is processed twice (once into the stack, once out of the stack back into the queue). |

### Key Logic within `reverse()`

The reversal uses a two-stage process that leverages the stack's LIFO property:

1.  **Stage 1: Queue $\rightarrow$ Stack (Inversion):**

      * Elements are taken out of the queue (FIFO: 1, 2, 3...) using **`remove()`**.
      * They are immediately pushed onto the stack (LIFO: ...3, 2, 1) using **`push()`**.

    <!-- end list -->

    ```java
    while (!this.isEmpty()) {
       stack.push(remove()); // Stack now holds: [10, 9, 8, ..., 1] (top is 10)
    }
    ```

2.  **Stage 2: Stack $\rightarrow$ Queue (Reconstruction):**

      * Elements are popped from the stack (LIFO: 10, 9, 8...) using **`pop()`**.
      * They are inserted back into the queue (FIFO: 10, 9, 8...) using **`insert()`**.

    <!-- end list -->

    ```java
    while (!stack.isEmpty()) {
       insert(stack.pop()); // Queue now holds: [10, 9, 8, ..., 1]
    }
    ```

-----

### $\rightarrow$ Most Helpful Code for Exams:

1.  **Circular Array Queue Mechanics:** Understanding how the `front`, `rear`, and `maxSize` interact with the **modulo operator (`%`)** for wraparound is essential for array-based implementations:

    ```java
    // INSERT (Rear wraparound):
    if(rear == maxSize - 1) rear = -1;
    queArray[++rear] = j;

    // REMOVE (Front wraparound):
    if(front == maxSize) front = 0;
    return queArray[front++];
    ```

2.  **Stack-based Reversal Pattern:** This pattern is fundamental for reversing any sequential structure (Queue, List, String) and is a strong candidate for an exam question:

    ```java
    // Use a stack to invert order
    while (!source.isEmpty()) {
       stack.push(source.extract());
    }
    while (!stack.isEmpty()) {
       source.insert(stack.pop());
    }
    ```

Ready for Lab 5\! 🚀

Excellent. Lab 4.18 moves us into the world of **Linked Lists**, focusing on non-trivial deletion methods. The ability to traverse a list and manipulate pointers (`next`) is fundamental.

Here is the study guide for Lab 4.18: List Remove.

## Lab 4.18: Link List Methods Study Guide 📚

This lab focuses on the **Singly Linked List** structure, particularly on advanced search-and-delete operations that require careful management of `current` and `previous` link references.

### Core `LinkList` Class Methods (Foundation)

| Method | Description | Time Complexity | Usefulness |
| :--- | :--- | :--- | :--- |
| **`insertFirst(int dd)`** | Adds a new link at the beginning of the list. | $O(1)$ | Essential for LIFO behavior or fast insertion. |
| **`deleteFirst()`** | Removes the first link. | $O(1)$ | Essential for FIFO behavior or fast removal. |
| **`find(int key)`** | Searches for a link with a specific key. | $O(N)$ | Standard **sequential search** for linked lists. |
| **`delete(int key)`** | Finds and removes the *first* occurrence of a link with a given key. Requires a `previous` pointer to bypass the deleted link. | $O(N)$ | Standard deletion pattern in a singly linked list. |
| **`isEmpty()`** | Checks if `first` is `null`. | $O(1)$ | Utility. |
| **`displayList()`/`toString()`** | Traverses and prints all elements. | $O(N)$ | Utility for visualization. |

-----

### New/Modified Methods for Programming Portions (High-Value Code)

| Method | Description | Algorithm & Data Structure Usefulness |
| :--- | :--- | :--- |
| **`removeLast(int n)`** | **Deletes the last occurrence** of item `n` in the list. | **Advanced Traversal:** Requires a single full traversal ($O(N)$) to *identify* the last matching link and its *predecessor*, but only $O(1)$ time for the actual deletion. |
| **`removeAll(int n)`** | **Deletes all occurrences** of item `n` from the list. | **Complete Deletion:** Also $O(N)$. Requires careful pointer management to handle deletion at the beginning (`first` must be updated) and in the middle/end of the list. |

### Key Logic within New Methods

#### 1\. `removeLast(int n)`:

This method's brilliance lies in its two sets of pointers: one for the current traversal (`current`, `previous`) and one to **store the position of the last match** (`targetCurrent`, `targetPrevious`).

  * **Traversal Phase:**
    ```java
    while (current != null) {
       if (current.iData == n) {
          // Whenever a match is found, save its position and its predecessor's position
          targetCurrent = current;
          targetPrevious = previous; // This always holds the correct previous link
       }
       // Advance pointers for next loop iteration
       previous = current;
       current = current.next;
    }
    ```
  * **Deletion Phase:** After the loop finishes, the `target` pointers hold the last match. Standard deletion logic is then applied.

#### 2\. `removeAll(int n)`:

This method requires a more dynamic approach to pointer management because the `previous` pointer might not advance if a deletion occurs.

  * **Deletion at Start (`first`):** If the match is the first element, update `first = current.next` and *do not advance* `previous`.
  * **Deletion in Middle/End:** If the match is not `first`, use `previous.next = current.next` (bypassing the match). The **crucial step** is to set `current = current.next` but **not advance `previous`** to handle multiple consecutive matches (e.g., `...7 -> 7 -> 7...`).
  * **No Deletion:** Only if a match is **NOT** found, both `previous` and `current` advance normally.

<!-- end list -->

```java
// Logic from the provided code (with a potential fix for handling first element):
while (current != null) {
    if (current.iData == n) {
        if (previous == null) { // Match at 'first'
            first = current.next;
            current = first; // Current moves to the new first
        } else { // Match in the middle/end
            previous.next = current.next;
            current = current.next; // Current moves, but previous does not.
        }
    } else { // No match, normal advance
        previous = current;
        current = current.next;
    }
}
```

-----

### $\rightarrow$ Most Helpful Code for Exams:

The linked list deletion patterns are the most essential takeaway from this lab:

1.  **Deletion Pattern (Bypassing):** The core mechanism for deletion using a predecessor link:

    ```java
    // Standard deletion where 'current' is the node to delete
    previous.next = current.next;
    ```

2.  **Maintaining `previous` and `current` Pointers:** The pattern for safely traversing a singly linked list for deletion purposes:

    ```java
    Link current = first;
    Link previous = null; // or first
    while (current != null) {
       // ... check condition ...
       previous = current;
       current = current.next;
    }
    ```

3.  **Handling the `first` Link:** Recognizing when the deletion affects the start of the list:

    ```java
    if (previous == null) { // The node to delete is the 'first' node
       first = first.next;
    } else {
       // delete node 'current' in the middle/end
       previous.next = current.next;
    }
    ```

Ready for Lab 6\! 📝

Lab 4.19 is a key lab\! It combines the **Doubly Linked List** structure with the logic of an **Ordered List** (or Priority Queue), making it high-value for understanding complex list manipulation.

Here is the study guide for Lab 4.19: Priority DoublyLinkedList.

## Lab 4.19: Priority DoublyLinkedList Methods Study Guide 📚

This lab focuses on using a **Doubly Linked List (DLL)** to implement a simplified **Priority Queue**, where the list is always kept sorted (ascending order), and the highest priority item (largest key) is at the `last` node.

### Core `DoublyLinkedList` Methods (Foundation)

DLL methods are crucial because they require updating **two** pointers (`next` and `previous`) for every link:

| Method | Description | Time Complexity | Usefulness |
| :--- | :--- | :--- | :--- |
| **`insertFirst(long dd)`** | Adds a link at the beginning, updating `first`, `next`, and `previous` pointers. | $O(1)$ | Standard DLL operation. |
| **`insertLast(long dd)`** | Adds a link at the end, updating `last`, `next`, and `previous` pointers. | $O(1)$ | Standard DLL operation. |
| **`deleteFirst()`** | Removes the first link, handling the case of a single-link list. | $O(1)$ | Standard DLL operation. |
| **`deleteLast()`** | Removes the last link, handling the case of a single-link list. | $O(1)$ | **High-Value:** Used as the core of `priorityRemove()`. |
| **`deleteKey(long key)`** | Finds a link and removes it, requiring four pointer updates (two `next` and two `previous`) to bypass the link. | $O(N)$ | Standard, complex DLL deletion pattern. |
| **`displayForward()`/`displayBackward()`** | Traverses the list from `first` to `last` and vice versa. | $O(N)$ | Showcases bi-directional traversal. |

-----

### New/Modified Methods for Programming Portions (High-Value Code)

| Method | Description | Algorithm & Data Structure Usefulness |
| :--- | :--- | :--- |
| **`priorityInsert(long key)`** | Inserts a key while maintaining the ascending sorted order of the list. | **Ordered Insertion in DLL:** $O(N)$ complexity, dominated by the linear search for the correct insertion point. The actual pointer manipulation is $O(1)$. |
| **`priorityRemove()`** | Dequeues the node with the highest priority (the largest key), which is conveniently located at the `last` link. | **Priority Dequeue:** $O(1)$ complexity, as it simply calls the highly efficient `deleteLast()` method. |

### Key Logic within New Methods

#### 1\. `priorityInsert(long key)`:

This method correctly implements the insertion logic for an ordered DLL, covering three primary cases after finding the insertion point (`current`):

1.  **Empty List:** `first = newLink; last = newLink;`
2.  **Insert at `last` (new largest element):** (`current == null`): **`last.next = newLink; newLink.previous = last; last = newLink;`** (A simple `insertLast` pattern).
3.  **Insert at `first` (new smallest element):** (`current == first`): **`first.previous = newLink; newLink.next = first; first = newLink;`** (A simple `insertFirst` pattern).
4.  **Insert in Middle (general case):** **`newLink.next = current; newLink.previous = current.previous; current.previous.next = newLink; current.previous = newLink;`** (The four-pointer update).

#### 2\. `priorityRemove()`:

This is a simple wrapper method that demonstrates an $O(1)$ removal of the maximum element, making the DLL behave like a Priority Queue:

```java
// Logic: Highest priority is at the end.
return deleteLast();
```

-----

### $\rightarrow$ Most Helpful Code for Exams:

The four-pointer update required for insertion/deletion in a Doubly Linked List is the most critical code pattern:

1.  **General DLL Insertion in the Middle:** This is the most complex pointer manipulation:

    ```java
    // Given 'current' is the node *after* where 'newLink' belongs
    newLink.next = current;
    newLink.previous = current.previous;

    current.previous.next = newLink; // Link predecessor to newLink
    current.previous = newLink;      // Link current to newLink
    ```

2.  **Deletion at the `last` Link:** The $O(1)$ method that makes the priority queue efficient:

    ```java
    // deleteLast() logic (where 'temp' is 'last'):
    last.previous.next = null; // Bypass the last node (prev --> null)
    last = last.previous;      // Update last to the previous node
    ```

3.  **Linear Search for Ordered Insertion:** The general search pattern for an ordered list:

    ```java
    // Find the link whose data is > key
    Link_D current = first;
    while (current != null && current.dData < key) {
       current = current.next;
    }
    // 'current' is now the insertion point (or null if inserting at last)
    ```

Ready for Lab 6\! 📝

Lab 4.19 is a key lab\! It combines the **Doubly Linked List** structure with the logic of an **Ordered List** (or Priority Queue), making it high-value for understanding complex list manipulation.

Here is the study guide for Lab 4.19: Priority DoublyLinkedList.

## Lab 4.19: Priority DoublyLinkedList Methods Study Guide 📚

This lab focuses on using a **Doubly Linked List (DLL)** to implement a simplified **Priority Queue**, where the list is always kept sorted (ascending order), and the highest priority item (largest key) is at the `last` node.

### Core `DoublyLinkedList` Methods (Foundation)

DLL methods are crucial because they require updating **two** pointers (`next` and `previous`) for every link:

| Method | Description | Time Complexity | Usefulness |
| :--- | :--- | :--- | :--- |
| **`insertFirst(long dd)`** | Adds a link at the beginning, updating `first`, `next`, and `previous` pointers. | $O(1)$ | Standard DLL operation. |
| **`insertLast(long dd)`** | Adds a link at the end, updating `last`, `next`, and `previous` pointers. | $O(1)$ | Standard DLL operation. |
| **`deleteFirst()`** | Removes the first link, handling the case of a single-link list. | $O(1)$ | Standard DLL operation. |
| **`deleteLast()`** | Removes the last link, handling the case of a single-link list. | $O(1)$ | **High-Value:** Used as the core of `priorityRemove()`. |
| **`deleteKey(long key)`** | Finds a link and removes it, requiring four pointer updates (two `next` and two `previous`) to bypass the link. | $O(N)$ | Standard, complex DLL deletion pattern. |
| **`displayForward()`/`displayBackward()`** | Traverses the list from `first` to `last` and vice versa. | $O(N)$ | Showcases bi-directional traversal. |

-----

### New/Modified Methods for Programming Portions (High-Value Code)

| Method | Description | Algorithm & Data Structure Usefulness |
| :--- | :--- | :--- |
| **`priorityInsert(long key)`** | Inserts a key while maintaining the ascending sorted order of the list. | **Ordered Insertion in DLL:** $O(N)$ complexity, dominated by the linear search for the correct insertion point. The actual pointer manipulation is $O(1)$. |
| **`priorityRemove()`** | Dequeues the node with the highest priority (the largest key), which is conveniently located at the `last` link. | **Priority Dequeue:** $O(1)$ complexity, as it simply calls the highly efficient `deleteLast()` method. |

### Key Logic within New Methods

#### 1\. `priorityInsert(long key)`:

This method correctly implements the insertion logic for an ordered DLL, covering three primary cases after finding the insertion point (`current`):

1.  **Empty List:** `first = newLink; last = newLink;`
2.  **Insert at `last` (new largest element):** (`current == null`): **`last.next = newLink; newLink.previous = last; last = newLink;`** (A simple `insertLast` pattern).
3.  **Insert at `first` (new smallest element):** (`current == first`): **`first.previous = newLink; newLink.next = first; first = newLink;`** (A simple `insertFirst` pattern).
4.  **Insert in Middle (general case):** **`newLink.next = current; newLink.previous = current.previous; current.previous.next = newLink; current.previous = newLink;`** (The four-pointer update).

#### 2\. `priorityRemove()`:

This is a simple wrapper method that demonstrates an $O(1)$ removal of the maximum element, making the DLL behave like a Priority Queue:

```java
// Logic: Highest priority is at the end.
return deleteLast();
```

-----

### $\rightarrow$ Most Helpful Code for Exams:

The four-pointer update required for insertion/deletion in a Doubly Linked List is the most critical code pattern:

1.  **General DLL Insertion in the Middle:** This is the most complex pointer manipulation:

    ```java
    // Given 'current' is the node *after* where 'newLink' belongs
    newLink.next = current;
    newLink.previous = current.previous;

    current.previous.next = newLink; // Link predecessor to newLink
    current.previous = newLink;      // Link current to newLink
    ```

2.  **Deletion at the `last` Link:** The $O(1)$ method that makes the priority queue efficient:

    ```java
    // deleteLast() logic (where 'temp' is 'last'):
    last.previous.next = null; // Bypass the last node (prev --> null)
    last = last.previous;      // Update last to the previous node
    ```

3.  **Linear Search for Ordered Insertion:** The general search pattern for an ordered list:

    ```java
    // Find the link whose data is > key
    Link_D current = first;
    while (current != null && current.dData < key) {
       current = current.next;
    }
    // 'current' is now the insertion point (or null if inserting at last)
    ```

Ready for Lab 6\! 📝

That is a fantastic format\! It's clear, comprehensive, and perfectly suited for exam review by highlighting the key concepts, time complexity, and most critical code patterns.

I will now reformat the summary for the **4.21 LAB Recursion** methods to match this high-value, organized structure.

-----

## Lab 4.21: Recursion Methods Study Guide 🧠

This lab focuses on applying **recursion** to solve common problems across number manipulation, array processing, and classic sequences (like the Triangle number sequence).

### Core Recursive Methods (Foundation)

| Method | Description | Time Complexity | Base Case / Stopping Condition |
| :--- | :--- | :--- | :--- |
| **`triangle(int rows)`** | Calculates the total blocks in a triangle with a given number of $\mathbf{rows}$. | $O(N)$ | $\mathbf{rows == 0}$ (return 0). |
| **`sumDigits(int num)`** | Calculates the $\mathbf{sum}$ of a number's $\mathbf{digits}$. | $O(\log_{10}N)$ | $\mathbf{num < 10}$ (single digit, return $\mathbf{num}$). |
| **`rangeSum(int from, int to)`** | Calculates the $\mathbf{sum}$ of all integers in the range $[\mathbf{from}, \mathbf{to}]$. | $O(N)$ | $\mathbf{from == to}$ (return $\mathbf{to}$). |
| **`bunnyEars2(int n)`** | Calculates ears for a line of bunnies where **odd** have $\mathbf{2}$ and **even** have $\mathbf{3}$ ears. | $O(N)$ | $\mathbf{n == 0}$ (return 0). |

-----

### Array/List Recursion Methods (High-Value Code)

These methods demonstrate the pattern of **tail recursion** or processing one element at a time by passing an **index** to the next recursive call.

| Method | Description | Algorithm & Data Structure Usefulness | Time Complexity |
| :--- | :--- | :--- | :--- |
| **`arrayVal(int[] nums, int index, int Val)`** | **Search**: Checks if $\mathbf{Val}$ exists in the array starting from $\mathbf{index}$. | Linear Search, demonstrating recursive list traversal. | $O(N)$ |
| **`arrayX10(int[] nums, int index)`** | **Pattern Search**: Checks if any element is immediately followed by that element $\mathbf{\times 10}$. | Sequential pattern matching in an array. | $O(N)$ |
| **`array11(int[] nums, int index)`** | **Counting**: Counts the number of times $\mathbf{11}$ appears from $\mathbf{index}$. | Counting occurrences with a recursive accumulator. | $O(N)$ |

-----

### Key Logic within Recursive Methods

#### 1\. Numeric Recursion (Simplifying the Problem)

| Method | Base Case Logic | Recursive Step Logic |
| :--- | :--- | :--- |
| **`sumDigits`** | `if (num < 10) return num;` | `return (num % 10) + sumDigits(num / 10);` (Peel off the last digit and recurse on the rest). |
| **`rangeSum`** | `if (from == to) return to;` | `return from + rangeSum(from + 1, to);` (Add current value and recurse on the next value). |
| **`bunnyEars2`** | `if (n == 0) return 0;` | `if (n % 2 == 0) return 3 + ... else return 2 + ...` (Handle cases based on $\mathbf{n}$'s parity). |

#### 2\. Array/List Recursion (Traversing with an Index)

The general pattern involves: **Base Case $\rightarrow$ Direct Hit/Calculation $\rightarrow$ Recursive Step $\mathbf{(index + 1)}$**

| Method | Array Base Case | Direct Hit / Check | Recursive Step |
| :--- | :--- | :--- | :--- |
| **`arrayVal`** (Search) | `if (index >= nums.length) return false;` | `if (nums[index] == Val) return true;` | `return arrayVal(nums, index + 1, Val);` |
| **`array11`** (Count) | `if (index >= nums.length) return 0;` | `int count = (nums[index] == 11) ? 1 : 0;` | `return count + array11(nums, index + 1);` |
| **`arrayX10`** (Pattern) | `if (index >= nums.length - 1) return false;` | `if (nums[index + 1] == nums[index] * 10) return true;` | `return arrayX10(nums, index + 1);` |

-----

### $\rightarrow$ Most Helpful Code for Exams:

Understanding the two fundamental patterns of recursion is the most critical takeaway:

1.  **Numeric Recursion:** Breaking down a number by using **mod ($\%$)** to get a part and **division ($\mathbf{/}$) to get the remainder (e.g., `sumDigits`).**

    ```java
    // Example: sumDigits(126)
    return (num % 10) + sumDigits(num / 10); // 6 + sumDigits(12)
    //                                         2 + sumDigits(1)
    //                                         1 (Base Case)
    // Result: 6 + 2 + 1 = 9
    ```

2.  **Array/List Traversal Recursion:** Using an $\mathbf{index}$ to move through the data structure.

    ```java
    // General Recursive Array Traversal Pattern:
    if (index >= nums.length) { // Base Case: Reached end of array
       return final_value;
    }

    // Logic for current nums[index] goes here...

    return operation + recursive_call(nums, index + 1);
    ```

Ready for Lab 6\! 📝

I can definitely format the summary for **4.22 LAB Recursion List** to match your high-value study guide structure. This lab is excellent for demonstrating how recursion is used to traverse and modify a **Linked List**.

-----

## Lab 4.22: Recursion on Linked Lists Study Guide 🔗

This lab applies the principles of **recursion** to the **Singly Linked List** data structure, replacing traditional loops with recursive helper methods that operate on the `Link` nodes.

### Core Recursive Linked List Methods (Foundation)

All these methods require a **non-public helper method** (e.g., `recMethod(Link current)`) to pass the current $\mathbf{Link}$ being processed, while the public method serves as the initial call with `first`.

| Method | Description | Time Complexity | Base Case / Stopping Condition |
| :--- | :--- | :--- | :--- |
| **`recGetLength()`** | Computes the $\mathbf{length}$ of the list. | $O(N)$ | $\mathbf{current == null}$ (return $\mathbf{0}$). |
| **`recPrint()`** | $\mathbf{Prints}$ the list from $\mathbf{first}$ to $\mathbf{last}$. | $O(N)$ | $\mathbf{current == null}$ (return). |
| **`recReversePrint()`** | $\mathbf{Prints}$ the list from $\mathbf{last}$ to $\mathbf{first}$. | $O(N)$ | $\mathbf{current == null}$ (return). |

-----

### Advanced Recursive Linked List Methods (High-Value Code)

These methods demonstrate how recursion can be used for **searching** or, more complexly, **modifying** the list structure by returning the head of the modified sub-list.

| Method | Description | Algorithm & Data Structure Usefulness | Time Complexity |
| :--- | :--- | :--- | :--- |
| **`recSearchFor(int n)`** | **Search**: Finds the $\mathbf{first}$ $\mathbf{Link}$ containing value $\mathbf{n}$. | Recursive linear search in a linked list. | $O(N)$ |
| **`recRemoveFirst(int n)`** | **Deletion**: $\mathbf{Removes}$ the $\mathbf{first}$ $\mathbf{occurrence}$ of $\mathbf{n}$. | Complex recursive list modification by returning the $\mathbf{current}$ $\mathbf{Link}$ or $\mathbf{current.next}$. | $O(N)$ |
| **`recRemoveAll(int n)`** | **Deletion**: $\mathbf{Removes}$ **all** $\mathbf{occurrences}$ of $\mathbf{n}$. | Most complex list modification, as it requires returning the $\mathbf{next}$ $\mathbf{Link}$ whenever a match is found. | $O(N)$ |

-----

### Key Logic within Recursive Methods

The pattern for **List Modification** (`recRemoveFirst`, `recRemoveAll`) is critical: the method must **return the Link** that should be the **new `next` pointer** of the previous node.

| Method | Base Case Logic | Recursive Step (Action/Return) | Modification Logic (If $\mathbf{current.iData == n}$) |
| :--- | :--- | :--- | :--- |
| **`recPrint`** | `if (current == null) return;` | Call `current.displayLink()` $\rightarrow$ `recPrint(current.next);` | N/A (Traversal only) |
| **`recReversePrint`** | `if (current == null) return;` | $\mathbf{recReversePrint(current.next)} \rightarrow$ Call `current.displayLink()`; | N/A (Traversal only, $\mathbf{LIFO}$ order) |
| **`recRemoveFirst`** | `if (current == null) return null;` | `current.next = recRemoveFirst(n, current.next);` $\rightarrow$ `return current;` | `return current.next;` (The recursion stops here, returning the rest of the list $\rightarrow$ bypasses the current link). |
| **`recRemoveAll`** | `if (current == null) return null;` | `current.next = recRemoveAll(n, current.next);` (Always call recursively) | `return current.next;` (Skip current and keep processing the rest) **ELSE** `return current;` |

-----

### $\rightarrow$ Most Helpful Code for Exams:

The most challenging and high-value code is the $\mathbf{recRemoveAll}$ pattern, as it correctly handles deletion **and** propagation of the modified list structure:

1.  **Recursive Deletion Pattern:** The key is setting `current.next` to the result of the recursive call. This establishes the new link structure *on the way back up* the stack.

    ```java
    // Inside private Link recRemoveAll(int n, Link current)
    if (current == null) {
       return null; // Base Case
    }

    // 1. Recursive Call: Process the REST of the list first (Post-order processing)
    current.next = recRemoveAll(n, current.next);

    // 2. Logic: If current link matches, it is REMOVED by returning its NEXT
    if (current.iData == n) {
       // Returning current.next effectively cuts 'current' out of the list
       return current.next;
    } else {
       // If no match, return current to keep it in the list
       return current;
    }
    ```

2.  **Public Wrapper Method (`recRemoveAll`):** The public method must capture the $\mathbf{new}$ $\mathbf{first}$ $\mathbf{Link}$ that may be returned by the recursive process if the head node itself was removed.

    ```java
    // Inside public void recRemoveAll(int n)
    first = recRemoveAll(n, first); // Update the list head reference
    ```


