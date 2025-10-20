That's a great request. You are absolutely right—a good practice exam should require you to identify the concept being tested without any labels and shouldn't immediately give away the answers.

Here is your full-length, multiple-choice data structures practice midterm exam. It covers all 65 requested subtopics, presented in the non-interactive, listed format, and focuses on the tracing and application style you requested.

***

## Data Structures Practice Midterm Exam

### Questions

**1.** A collection of student records needs to be stored where each record is unique, and the only required operations are adding a new record and retrieving a record using the student's ID number. Which structure best satisfies these requirements?

* A. Array
* B. Stack
* C. Hash Table
* D. Priority Queue

**2.** An algorithm designed to check if a specific element exists in an unsorted array of $N$ integers performs $N$ comparisons in the worst case. How many comparisons would the same algorithm perform if the element were found on the first check?

* A. $0$
* B. $1$
* C. $N/2$
* D. $N$

**3.** You decide to implement a simple dictionary (mapping keys to values) using two parallel arrays: one for keys and one for values. Which ADT did you use to model this structure?

* A. Queue
* B. List
* C. Stack
* D. Graph

**4.** A programmer defines a set of operations: `add`, `remove`, and `contains` for a collection of data. This definition, without specifying whether an array or a linked list is used, is an example of what concept?

* A. Object-Oriented Programming (OOP)
* B. Abstract Data Type (ADT)
* C. Algorithm Complexity
* D. Data Encapsulation

**5.** A system needs to manage pending print jobs, ensuring the most recently submitted job is printed first. Which ADT would be the most suitable for managing the order of these jobs?

* A. Queue
* B. Deque
* C. Priority Queue
* D. Stack

**6.** An algorithm is described by the recurrence relation $T(N) = T(N-1) + O(1)$, where $O(1)$ is the cost of the step that processes the element. What is the overall time complexity of this algorithm?

* A. $O(\log N)$
* B. $O(N)$
* C. $O(N^2)$
* D. $O(2^N)$

**7.** A shopping website uses a search algorithm that checks every item in its database sequentially until a match is found. If the database contains $1,000,000$ items, and the desired item is not present, how many items are checked?

* A. $1$
* B. $500,000$
* C. $1,000,000$
* D. $\log_2(1,000,000)$

**8.** Given the sorted array `A = [11, 22, 33, 44, 55, 66, 77]`, what is the sequence of values checked when searching for $66$ using the binary search algorithm?

* A. $44, 11, 22, 33$
* B. $44, 66$
* C. $44, 55, 66$
* D. $11, 77, 44, 66$

**9.** Consider a Java implementation of a search method that iterates through a data structure. If the method is called on an `ArrayList<String>` of size $N$ to find a target string, and the target is found at index $k$, how many times is the `equals()` method called in a standard linear search?

* A. $1$
* B. $k$
* C. $k+1$
* D. $N$

**10.** In a dynamic array implementation that resizes when full, which operation is **not** typically considered constant time, $O(1)$?

* A. Accessing an element by index.
* B. Getting the size of the array.
* C. Appending an element to the end of the array.
* D. Updating an element at a specific index.

**11.** For a running time described by $T(N) = 10N^3 + 500N^2 + 1000$, which term should be chosen as the most significant term to represent the Big $O$ complexity?

* A. $10N^3$
* B. $N^3$
* C. $N^2$
* D. $1000$

**12.** A developer is analyzing an algorithm with a time complexity of $O(N^2)$ and is asked to classify it in terms of the complexity families taught in the course. Which complexity family best describes $O(N^2)$?

* A. Linear
* B. Logarithmic
* C. Quadratic
* D. Exponential

**13.** You are designing a data structure to implement the List ADT using an array, where insertion at the beginning and end must be possible. Which of the following operations has the worst-case time complexity of $O(N)$?

* A. `get(index)`
* B. `size()`
* C. `insert(0, element)`
* D. `remove(size - 1)`

**14.** A singly-linked list has a `head` and a single node $A$. If a new node $B$ is inserted *after* $A$, how many non-null `next` pointers are in the final list?

* A. $0$
* B. $1$
* C. $2$
* D. $3$

**15.** A singly-linked list consists of nodes $P \rightarrow Q \rightarrow R$. To insert a new node $X$ between $P$ and $Q$, which pointer operation must be executed first to avoid losing the link to the rest of the list?

* A. `P.next = X`
* B. `X.next = Q`
* C. `Q.next = R`
* D. `X.next = P`

**16.** A singly-linked list contains the nodes $A \rightarrow B \rightarrow C \rightarrow D$. If the following operation is performed on the node $B$: `B.next = B.next.next;`, which node is removed from the list?

* A. $A$
* B. $B$
* C. $C$
* D. $D$

**17.** A stack is implemented with the following operations: `push('alpha')`, `push('beta')`, `pop()`, `push('gamma')`, `push('delta')`. What item will be returned by the next `pop()` call?

* A. 'alpha'
* B. 'beta'
* C. 'gamma'
* D. 'delta'

**18.** A queue is implemented with the following operations: `enqueue(1)`, `enqueue(2)`, `dequeue()`, `enqueue(3)`, `dequeue()`, `enqueue(4)`. What is the state of the queue after the final operation?

* A. $[1, 2, 3, 4]$
* B. $[3, 4]$
* C. $[4]$
* D. $[1, 4]$

**19.** A Deque (Double-Ended Queue) is used. The operations are: `addFront(A)`, `addBack(B)`, `removeFront()`, `addFront(C)`, `removeBack()`. What element is currently available to be returned by `removeFront()`?

* A. $A$
* B. $B$
* C. $C$
* D. The Deque is empty.

**20.** In a singly-linked list of $N$ nodes, what is the expected (average-case) time complexity for a successful search for a value that is randomly distributed throughout the list?

* A. $O(1)$
* B. $O(\log N)$
* C. $O(N)$
* D. $O(N^2)$

**21.** A doubly-linked list has a `head` and a `tail`. If the list contains 5 elements, how many non-null `prev` pointers are there?

* A. $1$
* B. $4$
* C. $5$
* D. $10$

**22.** A doubly-linked list has three nodes: $A \leftrightarrow B \leftrightarrow C$. To insert a new node $X$ between $B$ and $C$, which pointer updates must be performed on the node $B$?

* A. `B.next = X`
* B. `B.prev = X`
* C. `B.next = X` and `B.prev = X`
* D. `B.next = X` and `B.prev = C`

**23.** In a doubly-linked list, the node $T$ is the target to be removed. If $T$ is neither the head nor the tail, the two necessary pointer updates to bypass $T$ must involve the `next` pointer of $T$'s predecessor and the `prev` pointer of which node?

* A. $T$ itself.
* B. The node $T$ points to with its `prev` pointer.
* C. The node $T$ points to with its `next` pointer.
* D. The head of the list.

**24.** A loop is used to traverse a linked list until the last node is reached, at which point a new node is inserted. If the list has $N$ nodes, what is the time complexity of the traversal part of this operation?

* A. $O(1)$
* B. $O(\log N)$
* C. $O(N)$
* D. $O(N^2)$

**25.** When implementing a Stack using a singly-linked list, where should the `head` pointer point to achieve $O(1)$ efficiency for both `push` and `pop`?

* A. The middle of the list.
* B. The tail of the list.
* C. The top of the stack (the front of the list).
* D. It requires pointers to both the front and the back.

**26.** To implement a Queue with $O(1)$ enqueue and $O(1)$ dequeue using a singly-linked list, you must use the list's head for the `dequeue` operation and the list's tail for which operation?

* A. `peek`
* B. `enqueue`
* C. `size`
* D. `isEmpty`

**27.** Which of the following is the defining feature of a recursive definition?

* A. It refers only to predefined constants.
* B. It explicitly uses an iterative loop structure.
* C. It refers to a smaller, simpler instance of itself.
* D. It requires a lookup table to resolve values.

**28.** The function $F(N)$ is defined as $F(N) = N \times F(N-1)$ for $N > 0$, with $F(0)=1$. This function is an example of what type of algorithm?

* A. Iterative
* B. Recursive
* C. Dynamic
* D. Linear

**29.** A programmer writes a recursive function to traverse a singly-linked list. If the function is called with the head node, and the print statement is placed *before* the recursive call, in what order will the node data be printed?

* A. Reverse order (from tail to head).
* B. Unpredictable order.
* C. Normal order (from head to tail).
* D. Only the head node will be printed.

**30.** A large dataset is processed to find correlations and patterns. The choice of an appropriate algorithm for this task directly affects which aspect of the computation?

* A. The amount of memory in the computer.
* B. The speed at which results are obtained.
* C. The cost of electricity.
* D. The programming language used.

**31.** Which of the following is a classic example of a **linear** data structure?

* A. Binary Tree
* B. Graph
* C. Hash Table
* D. Linked List

**32.** An algorithm designed to find the smallest element in an unsorted array is classified as which type of algorithm?

* A. Sorting
* B. Searching
* C. Graph Traversal
* D. Recursive

**33.** Which component of a data structure is used to logically define its operations without revealing its internal implementation details?

* A. The compiler
* B. The ADT
* C. The heap memory
* D. The size variable

**34.** In an object-oriented implementation, a `List` class uses private fields (like an array or a head pointer) and public methods (like `add` or `get`) to interact with the data. This principle of hiding the internal state is called:

* A. Inheritance
* B. Abstraction
* C. Encapsulation
* D. Polymorphism

**35.** In Java, if you declare an array `double[] values = new double[10];`, what range of indices can be used to legally access the elements?

* A. $1$ to $10$
* B. $0$ to $9$
* C. $0$ to $10$
* D. $1$ to $9$

**36.** When a large program is divided into distinct classes, and these classes interact only through clearly defined public methods, this adheres to the principle of:

* A. High coupling
* B. Monolithic design
* C. Modular programming
* D. Single responsibility failure

**37.** A Java `interface` defines the contract for a data structure. Which feature of the implementation is explicitly *not* a part of the interface definition?

* A. The method name.
* B. The parameters the method takes.
* C. The time complexity of the method.
* D. The return type of the method.

**38.** If you are using a standard array to implement a sorted list in Java, and you need to insert a new element at index $3$, what will you have to do to the elements starting from index $3$ before placing the new element?

* A. Delete them.
* B. Shift them one position to the left.
* C. Shift them one position to the right.
* D. Overwrite them with the new element.

**39.** An algorithm reduces the search space by half in each step. If the input size is $N$, the number of steps required to complete the task can be expressed using which mathematical function?

* A. $N/2$
* B. $\log_2(N)$
* C. $\sqrt{N}$
* D. $N \times 2$

**40.** In a Java array of custom objects, `Person[] students = new Person[5];`, what is stored in each of the five slots when the array is first initialized?

* A. A copy of the `Person` object.
* B. The primitive data within the `Person` object.
* C. The memory address (reference) to a `Person` object.
* D. The size of the `Person` object in bytes.

**41.** If an algorithm has a running time of $O(N^3)$, and the problem size $N$ is doubled, the running time will increase by a factor of:

* A. $2$
* B. $4$
* C. $8$
* D. $N^3$

**42.** A fixed-size array is used to store data. What is the fundamental disadvantage of this approach when dealing with a dynamic amount of data?

* A. It requires $O(N)$ time to access an element.
* B. Its memory locations are not contiguous.
* C. The size cannot be changed after creation without creating a new array.
* D. It can only store primitive data types.

**43.** After three complete passes of the outer loop in Bubble Sort on the array `[9, 1, 5, 2, 8, 3]`, which three elements are guaranteed to be in their correct, final sorted positions?

* A. $1, 2, 3$
* B. $3, 8, 9$
* C. $8, 9, 3$
* D. $5, 2, 1$

**44.** Given the array `[9, 1, 5, 2, 8]`. After the *second* complete iteration of Selection Sort's outer loop (meaning two smallest elements are in place), what will be the state of the array?

* A. `[1, 2, 5, 9, 8]`
* B. `[1, 9, 5, 2, 8]`
* C. `[2, 1, 5, 9, 8]`
* D. `[1, 2, 5, 8, 9]`

**45.** When using Insertion Sort to sort the array `[8, 2, 4, 1, 3]`, when the algorithm is processing the element $1$ (at index $3$), what is the sorted sub-array to its left?

* A. `[2, 8, 4]`
* B. `[8, 2, 4]`
* C. `[2, 4, 8]`
* D. `[1, 2, 4]`

**46.** To define a custom sort order for a class of objects (e.g., sort people by age then by name), which Java concept must be utilized?

* A. The `equals()` method.
* B. The `hashCode()` method.
* C. The `Comparable` or `Comparator` interfaces.
* D. The `toString()` method.

**47.** When considering Bubble Sort, Selection Sort, and Insertion Sort, which simple sort algorithm typically exhibits the best time performance when the input array is *already* almost sorted?

* A. Bubble Sort
* B. Selection Sort
* C. Insertion Sort
* D. They all perform equally well.

**48.** A process needs to track the history of function calls and return to the previous state when a function completes. Which ADT models the storage and retrieval pattern of these function calls?

* A. Queue
* B. Stack
* C. Deque
* D. Tree

**49.** If an array-based Queue is implemented in a non-circular fashion, what is the primary cause for the `dequeue` operation to become $O(N)$?

* A. Searching for the next available slot.
* B. Shifting all remaining elements to the front after removal.
* C. Checking for an underflow condition.
* D. Resizing the underlying array.

**50.** A Priority Queue is used to manage tasks, where the element with the lowest integer value (e.g., 1 is the highest priority) is always the next to be processed. If the priority queue contains tasks with values $5, 1, 8, 3$, what is the priority of the next task that will be removed?

* A. $8$
* B. $3$
* C. $1$
* D. $5$

**51.** An infix expression $(A+B) \times C$ is converted to a postfix expression $AB+C \times$. During this conversion process, where is the operator $+$ temporarily stored before it is output?

* A. In the output string.
* B. In the operand buffer.
* C. On a Stack.
* D. In a Queue.

**52.** A node in a singly-linked list needs to store an integer and a reference to the next node. If the node is implemented as a class, how many fields must the class define?

* A. $1$
* B. $2$
* C. $3$
* D. $4$

**53.** In a singly-linked list that only maintains a `head` reference, how long does it take, in Big $O$ notation, to insert a new node at the very end of a list of $N$ nodes?

* A. $O(1)$
* B. $O(\log N)$
* C. $O(N)$
* D. $O(N^2)$

**54.** You have a reference to a node $P$ in a singly-linked list. $P$ points to $Q$, and $Q$ points to $R$. You want to delete $Q$. The only way to achieve this is to update which node's `next` pointer?

* A. $Q$'s `next` pointer.
* B. $R$'s `next` pointer.
* C. $P$'s `next` pointer.
* D. The head's `next` pointer.

**55.** A double-ended list includes a `tail` reference in addition to the standard `head` reference. Which operation on the singly-linked list is now guaranteed to be $O(1)$?

* A. Deleting the last node.
* B. Inserting a node *after* the last node.
* C. Deleting a node from the middle.
* D. Searching for a specific value.

**56.** If a doubly-linked list contains $N$ nodes, what is the worst-case time complexity to move a pointer from the head to the tail of the list?

* A. $O(1)$
* B. $O(\log N)$
* C. $O(N)$
* D. $O(N^2)$

**57.** An array is used to implement a List ADT. A linked list is also used to implement a List ADT. Which type of concept are they both implementing?

* A. A Graph
* B. A Tree
* C. An ADT
* D. A Stack

**58.** You have a sorted singly-linked list of $N$ integers. To insert a new integer while maintaining the sorted order, what is the time complexity of the process required to find the correct insertion spot?

* A. $O(1)$
* B. $O(\log N)$
* C. $O(N)$
* D. $O(N^2)$

**59.** A Doubly Linked List node has a `next` pointer and a `prev` pointer. To implement an efficient list **iterator** that can traverse the list both forward and backward, the iterator must internally maintain a reference to which part of the list?

* A. Only the `head` node.
* B. Only the current node.
* C. The list's size.
* D. The list's array index.

**60.** In the recursive calculation of the $N$-th Triangular Number, the base case is $T(1) = 1$. If you trace the call stack for $T(3)$, what value is returned when the call to $T(2)$ is completed?

* A. $1$
* B. $2$
* C. $3$
* D. $6$

**61.** The factorial function, $F(N) = N \times F(N-1)$, is implemented recursively. What essential property of the recursive step guarantees that the function will eventually terminate?

* A. The base case is defined.
* B. The input is increasing.
* C. The recursive call uses a smaller value of $N$.
* D. A loop is used in the function.

**62.** A recursive function is used to generate all possible **anagrams** of the word "CAT". If the word has $N$ letters, how many base cases will the recursion eventually hit?

* A. $N$
* B. $N^2$
* C. $N!$ (Factorial of $N$)
* D. $2^N$

**63.** A recursive version of Binary Search on a sorted array of size $N$ is analyzed. What is the time complexity of the recursive call structure?

* A. $O(N)$
* B. $O(\log N)$
* C. $O(N^2)$
* D. $O(1)$

**64.** The Tower of Hanoi puzzle with $N$ disks requires $2^N - 1$ moves. If a recursive algorithm is used to solve this puzzle, what is the time complexity?

* A. $O(N)$
* B. $O(N^2)$
* C. $O(2^N)$
* D. $O(N \log N)$

**65.** Mergesort is a common recursive sorting algorithm. It breaks a list into halves, sorts the halves recursively, and then combines them. What is the Big $O$ time complexity of the Mergesort algorithm?

* A. $O(N^2)$
* B. $O(N)$
* C. $O(N \log N)$
* D. $O(\log N)$

**66.** Recursion can often be replaced by an iterative structure using an explicit Stack. What is the main benefit of converting a recursive algorithm to an iterative one using a stack?

* A. To eliminate the overhead of function calls and potentially save memory.
* B. To always increase the time complexity for faster execution.
* C. To make the code easier to read for all developers.
* D. To ensure the algorithm can handle larger input sizes.

**67.** What is the primary recursive technique used in algorithms that solve problems like finding a path in a maze or calculating a specific value by simplifying the problem one step at a time?

* A. Divide and Conquer
* B. Backtracking
* C. Greedy approach
* D. Dynamic programming

## Answer Key
Here is the answer key for the practice midterm exam:

## Answer Key

1.  C
2.  B
3.  B
4.  B
5.  D
6.  B
7.  C
8.  C
9.  B
10. C
11. B
12. C
13. C
14. C
15. B
16. C
17. D
18. B
19. C
20. C
21. B
22. A
23. C
24. C
25. C
26. B
27. C
28. B
29. C
30. B
31. D
32. B
33. B
34. C
35. B
36. C
37. C
38. C
39. B
40. C
41. C
42. C
43. B
44. A
45. C
46. C
47. C
48. B
49. B
50. C
51. C
52. B
53. C
54. C
55. B
56. C
57. C
58. C
59. B
60. C
61. C
62. C
63. B
64. C
65. C
66. A
67. B