import React, { useState } from "react";
import SelectOption from "../component/SelectOption";

function Searching() {
  const [firstSearch, setFirstSearch] = useState("");
  const [secondSearch, setSecondSearch] = useState("");
  const [input, setInput] = useState("");
  const [type, setType] = useState("");
  const [firstResult, setFirstResult] = useState("");
  const [secondResult, setSecondResult] = useState("");
  const handleSubmit = async () => {
    const payload = {
      firstSearch: firstSearch,
      secondSearch: secondSearch,
      input: input,
      type: type,
    };
    console.log(payload);
  };

  const searchList = [{ name: "LinearSearch" }, { name: "BinarySerach" }];
  const typeList = [{ name: "Integer" }, { name: "Character" }];
  return (
    <div className="min-h-screen bg-gray-100 flex flex-col items-center p-4">
      <div className="bg-white shadow-md rounded-lg p-6 w-full max-w-2xl">
        <h2 className="text-2xl font-semibold mb-4 text-center">
          Searching Tool
        </h2>

        {/* Type Selection */}
        <div className="mb-4">
          <label className="block text-gray-700 font-medium mb-2">
            Select Type
          </label>
          <SelectOption
            search={type}
            setSearch={setType}
            sortingList={typeList}
            filterSearch={""}
            tab={"Searching"}
          />
        </div>

        {/* Input Field */}
        {type && (
          <div className="mb-4">
            <p className="text-sm text-gray-600 mb-1">
              <strong>Note:</strong> Separate each element with a comma (`,`),
              do not add a comma at the end.
            </p>
            <label className="block text-gray-700 font-medium mb-1">
              Insert Your Data
            </label>
            <input
              type="text"
              value={input}
              onChange={(e) => setInput(e.target.value)}
              placeholder="e.g. 1,2,3 or a,b,c"
              className="w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>
        )}
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mt-8 w-full max-w-5xl">
        {/* First Sort Method */}
        <div className="bg-white shadow-md rounded-lg p-4 flex flex-col items-center w-full">
          <h3 className="text-lg font-semibold mb-2 text-center">
            {firstSearch || "Select Searching Method 1"}
          </h3>
          <SelectOption
            search={firstSearch}
            setSearch={setFirstSearch}
            sortingList={searchList}
            filterSearch={secondSearch}
            tab={"Searching"}
          />

          {/* ✅ Show first sorted result */}
          {firstResult && (
            <div className="mt-4 text-sm text-gray-700 w-full break-words">
              <h4 className="font-medium">Searching Result:</h4>
              <pre className="bg-gray-100 p-2 rounded max-h-64 overflow-auto">
                {firstResult}
              </pre>
            </div>
          )}
        </div>

        {/* Second Sort Method */}
        <div className="bg-white shadow-md rounded-lg p-4 flex flex-col items-center w-full">
          <h3 className="text-lg font-semibold mb-2 text-center">
            {secondSearch || "Select Sorting Method 2"}
          </h3>
          <SelectOption
            search={secondSearch}
            setSearch={setSecondSearch}
            sortingList={searchList}
            filterSearch={firstSearch}
            tab={"Searching"}
          />

          {/* ✅ Show second sorted result */}
          {secondResult && (
            <div className="mt-4 text-sm text-gray-700 w-full break-words">
              <h4 className="font-medium">Serching Result:</h4>
              <pre className="bg-gray-100 p-2 rounded max-h-64 overflow-auto">
                {secondResult}
              </pre>
            </div>
          )}
        </div>
      </div>

      {firstSearch && secondSearch && input && type && (
        <div className="flex justify-center mt-6">
          <button
            onClick={handleSubmit}
            className="bg-blue-500 hover:bg-blue-600 text-white px-6 py-2 rounded transition duration-200"
          >
            Submit
          </button>
        </div>
      )}
    </div>
  );
}

export default Searching;
