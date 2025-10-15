import React from "react";
import Sorting from "../utils/Sorting";
import Searching from "../utils/Searching";
import TreeTaversal from "../utils/TreeTaversal";
import PolishNotation from "../utils/PolishNotation";

function BattleConnection({ selectText }) {
  const renderComponents = (selectedTopic) => {
    switch (selectedTopic) {
      case "Sorting":
        return <Sorting />;

      case "Searching":
        return <Searching />;

      case "Recursion":
        return (
          <p>
            Recursion is when a function calls itself to solve smaller
            subproblems. Key concept: base case and recursive case.
          </p>
        );

      case "Bitwise Operations":
        return (
          <p>
            Bitwise operations allow manipulation of data at the bit level.
            Examples: AND (&), OR (|), XOR (^), NOT (~), shifts (&lt;&lt;,
            &gt;&gt;).
          </p>
        );

      case "Tree Traversal":
        return <TreeTaversal />;
      case "Polish Notation":
        return <PolishNotation />;

      case "Valid Parenthesis":
        return (
          <p>
            Check if a string has valid open-close parentheses using stacks.
            Important in parsing expressions.
          </p>
        );

      case "Expression Evaluation":
        return (
          <p>
            Evaluate arithmetic expressions. Involves infix, postfix (Reverse
            Polish Notation), and prefix notation. Stacks are typically used.
          </p>
        );

      case "Stacks & Queues":
        return (
          <p>
            Stacks are LIFO, Queues are FIFO. Both are abstract data types used
            in many DSA problems like undo-redo, BFS, etc.
          </p>
        );

      case "Graphs (DFS/BFS)":
        return (
          <p>
            Graph traversal techniques: DFS (Depth First Search) and BFS
            (Breadth First Search). Used in shortest path, connected components,
            etc.
          </p>
        );

      case "Dynamic Programming":
        return (
          <p>
            DP involves solving problems by breaking them into subproblems and
            storing results. Example: Fibonacci, Knapsack, LCS.
          </p>
        );

      case "Greedy Algorithms":
        return (
          <p>
            Greedy algorithms make the locally optimal choice at each step.
            Example: Activity Selection, Kruskal's algorithm.
          </p>
        );

      case "Backtracking":
        return (
          <p>
            Backtracking is trying all possibilities and undoing steps when they
            don’t work. Examples: N-Queens, Sudoku Solver.
          </p>
        );

      case "Heap & Priority Queue":
        return (
          <p>
            Heap is a tree-based structure used to implement Priority Queue.
            Applications: Heap Sort, Dijkstra's Algorithm.
          </p>
        );

      default:
        return <p>Please select a topic to see its content.</p>;
    }
  };

  return (
    <div className="topic-description">{renderComponents(selectText)}</div>
  );
}

export default BattleConnection;
