import React, { useState } from "react";
import axios from "axios";

function ValidParenthesis() {
  const [valid, setValid] = useState("");
  const [loading, setLoading] = useState(false);
  const [responseMsg, setResponseMsg] = useState("");

  const handleParenthesis = (e) => {
    const { value } = e.target;
    setValid(value);
  };

  const handleSubmit = () => {
    setResponseMsg("");

    if (valid.trim().length === 0) {
      setResponseMsg("⚠️ Please enter some parentheses.");
      return;
    }

    for (let ch of valid) {
      if (ch !== "(" && ch !== ")") {
        setResponseMsg("❌ Invalid input — only '(' and ')' allowed.");
        return;
      }
    }

    let stack = [];
    for (let ch of valid) {
      if (ch === "(") {
        stack.push(ch);
      } else if (ch === ")") {
        if (stack.length === 0) {
          setResponseMsg(
            "❌ Invalid — closing bracket without matching opening."
          );
          return;
        }
        stack.pop();
      }
    }

    if (stack.length === 0) {
      setResponseMsg("✅ Valid parentheses!");
    } else {
      setResponseMsg("❌ Invalid — missing closing parenthesis.");
    }
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gradient-to-br from-blue-50 to-blue-100 p-6">
      <div className="bg-white shadow-2xl rounded-2xl p-8 w-full max-w-md">
        <h2 className="text-2xl font-semibold text-center mb-6 text-gray-800">
          🧮 Valid Parenthesis Checker
        </h2>

        <input
          type="text"
          value={valid}
          onChange={handleParenthesis}
          placeholder="Enter only '(' or ')'"
          className="w-full p-3 border border-gray-300 rounded-xl text-lg focus:outline-none focus:ring-2 focus:ring-blue-500 transition-all"
        />

        <button
          type="submit"
          onClick={handleSubmit}
          disabled={loading}
          className={`mt-5 w-full p-3 rounded-xl text-white font-semibold transition-all ${
            loading
              ? "bg-gray-400 cursor-not-allowed"
              : "bg-blue-600 hover:bg-blue-700"
          }`}
        >
          {loading ? "Checking..." : "Submit"}
        </button>

        {responseMsg && (
          <p
            className={`mt-4 text-center font-medium ${
              responseMsg.includes("✅")
                ? "text-green-600"
                : responseMsg.includes("⚠️")
                ? "text-yellow-600"
                : "text-red-600"
            }`}
          >
            {responseMsg}
          </p>
        )}
      </div>
    </div>
  );
}

export default ValidParenthesis;
