[![es](https://img.shields.io/badge/lang-es-yellow.svg)](./README.md)

## N-Queens Problem Solver

This project aims to solve the N-Queens problem using two different approaches: Breadth-First Search (BFS) and Local Beam Search. The N-Queens problem is a classic problem in computer science and combinatorial optimization, where the goal is to place N chess queens on an N×N chessboard in such a way that no two queens threaten each other. While BFS systematically explores all possible configurations, Local Beam Search focuses on exploring promising states iteratively. These approaches demonstrate different strategies for solving combinatorial optimization problems.

### NQueensBFS

The NQueensBFS class provides a solution to the N-Queens problem using Breadth-First Search (BFS) algorithm. It systematically explores all possible configurations of queens on the chessboard and checks if each configuration is valid.

### LocalBeamSearch

Local Beam Search initializes with a population where its states are randomly generated. Then, for some number of generations, it will check if each element is a solution. If not, it explores each of its successors. In the case of the queens problem, it will have 8 successors, one for each column of the chess board, and a state will be considered a successor if it decreases the number of threats from its parent. For example, if our population consists of 10 elements, for each generation, they will collectively produce 80 successors, each better than its parent, and only the top 10 will be retained for the next generation. This process iterates until a solution is found.
