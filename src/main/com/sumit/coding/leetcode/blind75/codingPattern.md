The **Blind 75** list is a popular set of 75 coding problems that cover key data structures and algorithms frequently asked in coding interviews. Solving these problems requires familiarity with various **coding patterns** (not to be confused with design patterns). Here is a breakdown of some of the most common coding patterns that are essential for tackling these problems effectively:

### 0. **Substring Problem Pattern**

- **Description**: The Substring Problem Pattern involves finding specific substrings within a larger string based on given criteria. This pattern often requires checking the presence, length, or characteristics of substrings. It frequently employs techniques like the sliding window and two pointers to efficiently explore all possible substrings.
- **Common Problems**:
  - Longest Substring Without Repeating Characters 
  - Find All Anagrams in a String 
  - Minimum Window Substring 
  - Substring with Concatenation of All Words 
  - Count Distinct Substrings
- **Usage**: This pattern is particularly useful when dealing with strings, where the goal is to find substrings that meet certain conditions. It can involve checking for unique characters, specific character counts, or patterns within substrings.
- **Solution Template** : https://leetcode.com/problems/minimum-window-substring/solutions/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems/

### 1. **Two Pointers Pattern**

- **Description**: This pattern involves using two pointers to solve problems where the array or list needs to be traversed from both ends (either from the start and end or using two pointers moving at different speeds).
- **Common Problems**:
    - Two Sum (Sorted Input)
    - Trapping Rain Water
    - Container with Most Water
    - Palindrome problems
- **Usage**: Useful for arrays, linked lists, or strings where you need to work with pairs or subarrays.
- **Solution Template** : https://leetcode.com/discuss/study-guide/1688903/Solved-all-two-pointers-problems-in-100-days

### 2. **Sliding Window Pattern**

- **Description**: This pattern is used for problems that involve subarrays or substrings of a given size. It keeps a window of elements that slides over the input.
- **Common Problems**:
    - Maximum Sum Subarray of Size K
    - Longest Substring Without Repeating Characters
    - Minimum Window Substring
    - Longest Substring with K Distinct Characters
- **Usage**: Efficient for problems involving contiguous subarrays or substrings. Can reduce the time complexity to O(n) from O(n²) in brute force solutions.
- **Solution Template** : https://leetcode.com/problems/frequency-of-the-most-frequent-element/solutions/1175088/C++-Maximum-Sliding-Window-Cheatsheet-Template/

### 3. **Fast and Slow Pointers (Tortoise and Hare)**

- **Description**: This pattern involves two pointers that move at different speeds. It is used in cyclic linked lists and arrays.
- **Common Problems**:
    - Linked List Cycle Detection
    - Find the Middle of a Linked List
    - Happy Number
    - Reorder List
- **Usage**: Most useful for detecting cycles in linked lists or arrays and finding middle elements.
- - **Solution Template**

### 4. **Merge Intervals Pattern**

- **Description**: This pattern is used for solving problems involving intervals, where you need to merge overlapping intervals or find intersections between them.
- **Common Problems**:
    - Merge Intervals
    - Insert Interval
    - Meeting Rooms II
    - Non-overlapping Intervals
- **Usage**: Works well when you need to process or merge ranges, time slots, or other interval-based data.
- **Solution Template**

### 5. **Cyclic Sort Pattern**

- **Description**: This pattern works with problems involving sorted sequences of consecutive numbers (or those where numbers belong to a certain range). It rearranges the elements in the correct order in-place.
- **Common Problems**:
    - Find Missing Number
    - Find All Duplicates in an Array
    - Find the Duplicate Number
    - First Missing Positive
- **Usage**: Works for problems involving finding missing numbers, duplicates, or where sorting a range of numbers is necessary.
- **Solution Template**

### 6. **In-place Reversal of a Linked List**

- **Description**: This pattern reverses a linked list in-place using constant space and is used in problems that require manipulation of pointers in a linked list.
- **Common Problems**:
    - Reverse a Linked List
    - Reverse Nodes in k-Group
    - Reverse Linked List II
    - Rotate List
- **Usage**: This is efficient for problems where you need to reverse portions of a linked list.
- **Solution Template**

### 7. **Tree Traversal Pattern**

- **Description**: This pattern is about traversing a tree using different techniques: pre-order, in-order, post-order, and level-order traversals.
- **Common Problems**:
    - Binary Tree Inorder Traversal
    - Binary Tree Level Order Traversal
    - Lowest Common Ancestor of a Binary Tree
    - Maximum Depth of Binary Tree
- **Usage**: Important for tree-based problems involving hierarchical data.
- **Solution Template** : https://leetcode.com/discuss/study-guide/937307/Iterative-or-Recursive-or-DFS-and-BFS-Tree-Traversal-or-In-Pre-Post-and-LevelOrder-or-Views

### 8. **Binary Search Pattern**

- **Description**: This pattern is used to search for elements in a sorted array or when trying to minimize/maximize a value efficiently.
- **Common Problems**:
    - Binary Search
    - Find Peak Element
    - Search in Rotated Sorted Array
    - Median of Two Sorted Arrays
- **Usage**: Reduces the search space efficiently in O(log n) time by splitting the search range in half.
- **Solution Template** : https://leetcode.com/discuss/study-guide/786126/Python-Powerful-Ultimate-Binary-Search-Template.-Solved-many-problems

### 9. **Backtracking Pattern**

- **Description**: This pattern is useful for problems that require exploring all possible options (combinations or permutations) and "backtracking" to try a different option when a path doesn't work.
- **Common Problems**:
    - Subsets
    - Permutations
    - N-Queens Problem
    - Word Search
- **Usage**: Solves combinatorial problems involving decision trees and recursion.
- **Solution Template 1** : https://medium.com/leetcode-patterns/leetcode-pattern-3-backtracking-5d9e5a03dc26
- **Solution Template 2** : https://leetcode.com/problems/permutations/solutions/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)

### 10. **Topological Sort / Graph Traversal Pattern**

- **Description**: This pattern is used to solve problems that involve graph traversal (BFS, DFS) or topological sorting in Directed Acyclic Graphs (DAGs).
- **Common Problems**:
    - Course Schedule
    - Alien Dictionary
    - Number of Connected Components in a Graph
    - Clone Graph
- **Usage**: Useful for dependency resolution problems or finding cycles in graphs.
- **Solution Template** : https://leetcode.com/discuss/study-guide/655708/Graph-For-Beginners-Problems-or-Pattern-or-Sample-Solutions

### 11. **Dynamic Programming (DP) Pattern**

- **Description**: This pattern involves breaking down a problem into smaller overlapping subproblems and solving them using recursion or iteration with memoization.
- **Common Problems**:
    - Longest Increasing Subsequence
    - Coin Change
    - Climbing Stairs
    - 0/1 Knapsack
    - Maximum Subarray
- **Usage**: Most effective for optimization problems where brute force is inefficient and subproblems overlap.
- **Solution Template 1** : https://leetcode.com/discuss/study-guide/458695/Dynamic-Programming-Patterns
- **Solution Template 2** : https://leetcode.com/discuss/study-guide/1437879/Dynamic-Programming-Patterns

### 12. **Greedy Pattern**

- **Description**: This pattern involves making the most optimal choice at each step with the hope of finding a global optimum.
- **Common Problems**:
    - Jump Game
    - Best Time to Buy and Sell Stock
    - Partition Labels
    - Minimum Number of Platforms Required
- **Usage**: Works well when locally optimal choices lead to globally optimal solutions.
- **Solution Template**

### 13. **Flood Fill / BFS-DFS Traversal Pattern**

- **Description**: Used in problems that involve traversing a matrix or grid to explore connected components (regions).
- **Common Problems**:
    - Number of Islands
    - Flood Fill
    - Surrounded Regions
    - Word Ladder
- **Usage**: Common in graph traversal and grid-based problems.
- **Solution Template 1** : https://medium.com/leetcode-patterns/leetcode-pattern-1-bfs-dfs-25-of-the-problems-part-1-519450a84353
- **Solution Template 2** : https://medium.com/leetcode-patterns/leetcode-pattern-2-dfs-bfs-25-of-the-problems-part-2-a5b269597f52

### 14. **Union-Find / Disjoint Set Pattern**

- **Description**: This pattern is used for solving problems involving the union of disjoint sets and efficiently checking connected components.
- **Common Problems**:
    - Number of Connected Components in an Undirected Graph
    - Redundant Connection
    - Graph Valid Tree
- **Usage**: Very useful for problems involving connectivity or merging sets.
- **Solution Template** : 

### 15. **Monotonic Stack Pattern**

- **Description**: A monotonic stack is a data structure that maintains its elements in a sorted order (either monotonically increasing or decreasing) while allowing efficient access and modification. This pattern is particularly useful for solving problems that require tracking the next or previous greater or smaller elements in a list or array.
- **Common Problems**:
	- Next Greater Element
	- Previous Greater Element
	- Largest Rectangle in Histogram
	- Daily Temperatures
	- Trapping Rain Water
- **Usage**: Monotonic stacks are particularly useful in scenarios where you need to efficiently find elements that satisfy specific ordering conditions relative to others. They allow you to efficiently manage elements as you iterate through an array, reducing the need for nested loops.
- **Solution Template** : https://leetcode.com/discuss/study-guide/2347639/A-comprehensive-guide-and-template-for-monotonic-stack-based-problems



---

### Summary of Coding Patterns to Solve Blind 75 Problems:

0. **Substring Problem**
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
15. **Monotonic Stack Pattern**

These patterns provide a strong foundation for solving the diverse set of problems in the **Blind 75** list. By mastering these, you can approach a variety of algorithmic problems with a structured methodology.

----

Important References :
- String Important Questions: https://leetcode.com/discuss/study-guide/2001789/Collections-of-Important-String-questions-Pattern
- Important Coding patterns: https://hackernoon.com/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed