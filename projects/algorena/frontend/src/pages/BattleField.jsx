import React, { useState } from "react";
import BattleConnection from "../component/BattleConnection";

function BattleField() {
  const dsaTopics = [
    "Sorting",
    "Searching",
    "Recursion",
    "Bitwise Operations",
    "Tree Traversal",
    "Valid Parenthesis",
    "Expression Evaluation",
    "Polish Notation",
    "Stacks & Queues",
    "Graphs (DFS/BFS)",
    "Dynamic Programming",
    "Backtracking",
  ];

  const [selectedIndex, setSelectedIndex] = useState(0);

  return (
    <div className="flex h-screen">
      {/* Sidebar */}
      <aside className="w-64 bg-gray-900 text-white p-4 overflow-y-auto">
        <div className="flex flex-col gap-2">
          {dsaTopics.map((topic, i) => (
            <div
              key={i}
              className={`px-4 py-2 rounded cursor-pointer transition 
                          ${
                            selectedIndex === i
                              ? "bg-blue-600 font-semibold"
                              : "hover:bg-gray-700"
                          }`}
              onClick={() => setSelectedIndex(i)}
            >
              {topic}
            </div>
          ))}
        </div>
      </aside>

      {/* Main Section */}
      <main className="flex-1 bg-gray-100 p-6 overflow-y-auto">
        <h1 className="text-2xl font-bold mb-4 text-gray-800">
          {dsaTopics[selectedIndex]}
        </h1>
        <BattleConnection selectText={dsaTopics[selectedIndex]} />
      </main>
    </div>
  );
}

export default BattleField;
