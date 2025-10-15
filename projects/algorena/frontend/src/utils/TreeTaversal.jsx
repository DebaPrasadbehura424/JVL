import React, { useState } from "react";
import axios from "axios";

function TreeTraversal() {
  const [inputValue, setInputValue] = useState("");
  const [traversalType, setTraversalType] = useState("inorder");
  const [resultString, setResultString] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!inputValue.trim()) return;

    const payload = {
      input: inputValue.split(",").map((v) => v.trim()),
      type: traversalType,
    };

    try {
      const res = await axios.post(
        "http://localhost:8080/tree_traversal/calculate1",
        payload
      );

      // Assume backend returns a formatted string like bubbleSort / treeTraversal example
      setResultString(res.data);
    } catch (err) {
      console.error(err);
      setResultString("Error fetching traversal result from backend.");
    }
  };

  return (
    <div className="p-6 max-w-xl mx-auto">
      <h2 className="text-xl font-bold mb-4">Binary Tree Traversal</h2>

      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label className="block mb-1 font-medium">
            Enter Tree Values (comma-separated, use "null" for empty nodes):
          </label>
          <input
            type="text"
            value={inputValue}
            onChange={(e) => setInputValue(e.target.value)}
            placeholder="e.g. 1,2,3,4,null,null,5"
            className="w-full border px-3 py-2 rounded"
          />
        </div>

        <div>
          <label className="block mb-1 font-medium">
            Select Traversal Type:
          </label>
          <select
            value={traversalType}
            onChange={(e) => setTraversalType(e.target.value)}
            className="w-full border px-3 py-2 rounded"
          >
            <option value="inorder">Inorder</option>
            <option value="preorder">Preorder</option>
            <option value="postorder">Postorder</option>
          </select>
        </div>

        <button
          type="submit"
          className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          Submit
        </button>
      </form>

      {resultString && (
        <div className="mt-6 bg-gray-100 p-4 rounded whitespace-pre-line">
          <h3 className="font-bold mb-2">Traversal Result</h3>
          {resultString}
        </div>
      )}
    </div>
  );
}

export default TreeTraversal;
