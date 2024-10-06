The **Blind 75** list is a popular set of 75 coding problems that cover key data structures and algorithms frequently asked in coding interviews. Solving these problems requires familiarity with various **coding patterns** (not to be confused with design patterns). Here is a breakdown of some of the most common coding patterns that are essential for tackling these problems effectively:

### 1. **Two Pointers Pattern**

- **Description**: This pattern involves using two pointers to solve problems where the array or list needs to be traversed from both ends (either from the start and end or using two pointers moving at different speeds).
- **Common Problems**:
    - Two Sum (Sorted Input)
    - Trapping Rain Water
    - Container with Most Water
    - Palindrome problems
- **Usage**: Useful for arrays, linked lists, or strings where you need to work with pairs or subarrays.

### 2. **Sliding Window Pattern**

- **Description**: This pattern is used for problems that involve subarrays or substrings of a given size. It keeps a window of elements that slides over the input.
- **Common Problems**:
    - Maximum Sum Subarray of Size K
    - Longest Substring Without Repeating Characters
    - Minimum Window Substring
    - Longest Substring with K Distinct Characters
- **Usage**: Efficient for problems involving contiguous subarrays or substrings. Can reduce the time complexity to O(n) from O(n²) in brute force solutions.

### 3. **Fast and Slow Pointers (Tortoise and Hare)**

- **Description**: This pattern involves two pointers that move at different speeds. It is used in cyclic linked lists and arrays.
- **Common Problems**:
    - Linked List Cycle Detection
    - Find the Middle of a Linked List
    - Happy Number
    - Reorder List
- **Usage**: Most useful for detecting cycles in linked lists or arrays and finding middle elements.

### 4. **Merge Intervals Pattern**

- **Description**: This pattern is used for solving problems involving intervals, where you need to merge overlapping intervals or find intersections between them.
- **Common Problems**:
    - Merge Intervals
    - Insert Interval
    - Meeting Rooms II
    - Non-overlapping Intervals
- **Usage**: Works well when you need to process or merge ranges, time slots, or other interval-based data.

### 5. **Cyclic Sort Pattern**

- **Description**: This pattern works with problems involving sorted sequences of consecutive numbers (or those where numbers belong to a certain range). It rearranges the elements in the correct order in-place.
- **Common Problems**:
    - Find Missing Number
    - Find All Duplicates in an Array
    - Find the Duplicate Number
    - First Missing Positive
- **Usage**: Works for problems involving finding missing numbers, duplicates, or where sorting a range of numbers is necessary.

### 6. **In-place Reversal of a Linked List**

- **Description**: This pattern reverses a linked list in-place using constant space and is used in problems that require manipulation of pointers in a linked list.
- **Common Problems**:
    - Reverse a Linked List
    - Reverse Nodes in k-Group
    - Reverse Linked List II
    - Rotate List
- **Usage**: This is efficient for problems where you need to reverse portions of a linked list.

### 7. **Tree Traversal Pattern**

- **Description**: This pattern is about traversing a tree using different techniques: pre-order, in-order, post-order, and level-order traversals.
- **Common Problems**:
    - Binary Tree Inorder Traversal
    - Binary Tree Level Order Traversal
    - Lowest Common Ancestor of a Binary Tree
    - Maximum Depth of Binary Tree
- **Usage**: Important for tree-based problems involving hierarchical data.

### 8. **Binary Search Pattern**

- **Description**: This pattern is used to search for elements in a sorted array or when trying to minimize/maximize a value efficiently.
- **Common Problems**:
    - Binary Search
    - Find Peak Element
    - Search in Rotated Sorted Array
    - Median of Two Sorted Arrays
- **Usage**: Reduces the search space efficiently in O(log n) time by splitting the search range in half.

### 9. **Backtracking Pattern**

- **Description**: This pattern is useful for problems that require exploring all possible options (combinations or permutations) and "backtracking" to try a different option when a path doesn't work.
- **Common Problems**:
    - Subsets
    - Permutations
    - N-Queens Problem
    - Word Search
- **Usage**: Solves combinatorial problems involving decision trees and recursion.

### 10. **Topological Sort / Graph Traversal Pattern**

- **Description**: This pattern is used to solve problems that involve graph traversal (BFS, DFS) or topological sorting in Directed Acyclic Graphs (DAGs).
- **Common Problems**:
    - Course Schedule
    - Alien Dictionary
    - Number of Connected Components in a Graph
    - Clone Graph
- **Usage**: Useful for dependency resolution problems or finding cycles in graphs.

### 11. **Dynamic Programming (DP) Pattern**

- **Description**: This pattern involves breaking down a problem into smaller overlapping subproblems and solving them using recursion or iteration with memoization.
- **Common Problems**:
    - Longest Increasing Subsequence
    - Coin Change
    - Climbing Stairs
    - 0/1 Knapsack
    - Maximum Subarray
- **Usage**: Most effective for optimization problems where brute force is inefficient and subproblems overlap.

### 12. **Greedy Pattern**

- **Description**: This pattern involves making the most optimal choice at each step with the hope of finding a global optimum.
- **Common Problems**:
    - Jump Game
    - Best Time to Buy and Sell Stock
    - Partition Labels
    - Minimum Number of Platforms Required
- **Usage**: Works well when locally optimal choices lead to globally optimal solutions.

### 13. **Flood Fill / BFS-DFS Traversal Pattern**

- **Description**: Used in problems that involve traversing a matrix or grid to explore connected components (regions).
- **Common Problems**:
    - Number of Islands
    - Flood Fill
    - Surrounded Regions
    - Word Ladder
- **Usage**: Common in graph traversal and grid-based problems.

### 14. **Union-Find / Disjoint Set Pattern**

- **Description**: This pattern is used for solving problems involving the union of disjoint sets and efficiently checking connected components.
- **Common Problems**:
    - Number of Connected Components in an Undirected Graph
    - Redundant Connection
    - Graph Valid Tree
- **Usage**: Very useful for problems involving connectivity or merging sets.

---

### Summary of Coding Patterns to Solve Blind 75 Problems:

1. **Two Pointers**
2. **Sliding Window**
3. **Fast and Slow Pointers**
4. **Merge Intervals**
5. **Cyclic Sort**
6. **In-place Linked List Reversal**
7. **Tree Traversals**
8. **Binary Search**
9. **Backtracking**
10. **Topological Sort / Graph Traversal**
11. **Dynamic Programming**
12. **Greedy**
13. **Flood Fill / DFS-BFS**
14. **Union-Find**

These patterns provide a strong foundation for solving the diverse set of problems in the **Blind 75** list. By mastering these, you can approach a variety of algorithmic problems with a structured methodology.