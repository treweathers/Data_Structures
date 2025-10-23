# ZyLabs Guide
For complex programming assignments, especially those involving pre-existing data structure code, the setup and planning phase is crucial. It's more than just understanding the data structure; it's about understanding the **layers of interaction** between the application logic (`Main` class) and the data structure (`OrdArray`, `LinkList`, etc.) class. Here is a structured guide on how to approach layered programming assignments like the ones you've shared.

Those are excellent points for clarification, especially when dealing with classes and file structures. Let's update the guide with those specific notes.

***

## How to Approach Any Programming Lab (Final Revision)

1.  **Understand the Goal**: What is the **overall purpose** of the code? (e.g., sort an array, implement a queue, calculate a sum recursively).

2.  **Identify Required Methods/Classes (Including Implicit Helpers)**: What specific methods or classes do you need to write or modify, and what are their **full signatures** (name, return type, parameters, and visibility)?

    ### 📝 Signature and Helper Notes (Step 2)
    * **Required Methods**: List the public methods specified in the assignment (e.g., `isSorted(int[] nums)`, `removeLast(int n)`).
    * **Implicit Helpers**: Ask yourself:
        * **Is recursion required?** $\rightarrow$ You **must** create a **private, overloaded helper method** (e.g., `isSorted(int[] nums, int index)` or `recRemoveLast(Link current, int n)`).
        * **Does the logic involve a complex, repeated sub-task?** $\rightarrow$ Consider a **private helper** to keep the main method clean (e.g., a method to shift array elements after a deletion, or a method to apply an operation in a complex loop like in the Postfix Evaluator).
        * **Return Type**: Does it calculate a value? $\rightarrow$ Use `int`, `boolean`, `String`, etc. (e.g., `isSorted` returns `boolean`). Does it just modify an object? $\rightarrow$ Use `void` (e.g., `removeLast` on a linked list).
    * **Parameters**: If it's a **private recursive helper**, it usually takes the original inputs *plus* the **state variable** needed for recursion (e.g., `int index`, `Link current`).
    * **Visibility**: Only methods called by external code should be `public`. Internal-only methods should be `private`.

***

3.  **Determine Constraints**: What are the key **restrictions**? (e.g., no loops, must be recursive, must use a stack, array size limit). These often dictate *how* you must solve the problem.

    ### 📝 Constraint Implementation Notes (Step 3)
    * **No Loops?** $\rightarrow$ **Use Recursion or a Data Structure's built-in iteration/traversal**. For recursion, you must define a **Base Case** and a **Recursive Step**.
    * **Must Use a Stack/Queue?** $\rightarrow$ These are often used to manage state/order when loops are forbidden, or to reverse order (Stack) or maintain FIFO order (Queue).
    * **No New Arrays? (In-Place Modifications)** $\rightarrow$ You must manipulate the existing data structures.
        * **Arrays**: Use **swapping** elements (e.g., in Lab 2.17) or moving/shifting elements to fill gaps (e.g., in Lab 1.9 `removeMax`).
        * **Linked Lists**: Manipulate the **`next` pointers** of the existing nodes to insert, delete, or reorder. You usually need a reference to the node *before* the one you want to change/remove.

***

4.  **Analyze Provided Code**: What code is **already given**? This often includes the public interface methods, class structure, and driver code, which helps you place your new methods correctly.

***

5.  **Formulate Logic (Pseudo Code-Per Method)**: Design the logic for **each required method**, keeping the constraints in mind.

    ### 📝 Logic Formulation (Step 5)
    * **Public Interface Method (The Caller)**: This method's primary jobs are:
        1.  **Error/Edge Checking**: Handle `null` or empty inputs.
        2.  **State Initialization**: Set up initial state variables (e.g., `index = 0`, `current = first`).
        3.  **Initiate Work**: Call the iterative logic (using a loop) OR call the private recursive helper method.
    * **Helper Method (The Workhorse)**:
        * **Iterative Helpers**: Perform a specific, isolated sub-task (e.g., `private void shiftElements(int start)`).
        * **Recursive Helpers**: Must contain exactly two parts:
            1.  **Base Case(s)**: The condition that **stops the recursion** and returns the final result or state (e.g., `index >= length`).
            2.  **Recursive Step**: The logic that performs one step of the work and then **calls itself** with a modified parameter, moving toward the base case (e.g., `return 1 + helper(..., index + 1)`).

***

This revised guide clearly emphasizes the necessity of **private, overloaded recursive helper methods** whenever recursion is required but the initial method signature doesn't include the necessary state parameter (like `index` or a `Link` reference).

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
